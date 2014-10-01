/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.microsoft.cisl.skute.server;

import com.microsoft.cisl.skute.filesystem.SkuteFileSystem;
import com.microsoft.cisl.skute.filesystem.SkuteFileSystemFactory;
import org.apache.commons.cli.*;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ServerProperties;
import org.glassfish.jersey.servlet.ServletContainer;

import java.util.Properties;

public class SkuteHttpServer {
  public static void main(String[] args) throws Exception {
    // TODO: Go back and make this property file based.
    // Handle common line options
    Option portOption = OptionBuilder
        .withArgName("port")
        .hasArg()
        .withDescription("Port to start server on.")
        .create("port");
    Option sleepOption = OptionBuilder
        .withArgName("sleepsecs")
        .hasArg()
        .withDescription("Time in seconds to let server run before exiting. If not specified, server will run forever.")
        .create("sleepsecs");
    Option skutefsFactoryOption = OptionBuilder
        .withArgName("skutefsFactory")
        .hasArg()
        .withDescription("Factory to create the backing SkuteFilesystem")
        .create("skutefsFactory");


    Options options = new Options();

    options.addOption(portOption)
        .addOption(sleepOption)
        .addOption(skutefsFactoryOption);

    CommandLineParser parser = new BasicParser();
    CommandLine commandLine = parser.parse(options, args);
    int port = SkuteServer.DEFAULT_PORT;
    if(commandLine.hasOption("port")) {
      port = Integer.parseInt(commandLine.getOptionValue("port"));
    }

    int sleepSecs = Integer.MAX_VALUE;

    if(commandLine.hasOption("sleepsecs")) {
      sleepSecs = Integer.parseInt(commandLine.getOptionValue("sleepsecs"));
    }

    SkuteFileSystem fs = getSkuteFileSystem(commandLine);

    SkuteHttpServer shp = new SkuteHttpServer(port, fs);

    shp.start();

    Thread.sleep(sleepSecs * 1000);

    shp.stop();
  }

  private static SkuteFileSystem getSkuteFileSystem(CommandLine commandLine) throws Exception {
    if(!commandLine.hasOption("skutefsFactory")) {
      throw new IllegalArgumentException("Must specify skutefsFactory");
    }

    String factoryString = commandLine.getOptionValue("skutefsFactory");
    SkuteFileSystemFactory factory = Utils.instantiateObject(factoryString);
    return factory.getSkuteFileSystem(new Properties());
  }

  private final Server server;

  public SkuteHttpServer(int port, SkuteFileSystem filesystem) {
    server = new Server(port);
    ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
    context.setContextPath("/");

    context.setAttribute(SkuteServer.SKUTE_FILESYSTEM_ATTRIBUTE, filesystem);

    server.setHandler(context);
    ServletHolder h = new ServletHolder(new ServletContainer());
    h.setInitParameter(ServerProperties.PROVIDER_PACKAGES, SkuteServer.class.getPackage().toString());
    h.setInitOrder(1);
    context.addServlet(h, "/webhdfs/v1/*");
    server.setDumpAfterStart(false);
  }

  public void start() throws Exception {
    server.start();
  }

  public void stop() throws Exception {
    server.stop();
  }
}
