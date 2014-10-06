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
package com.microsoft.cisl.skute;

import com.microsoft.cisl.skute.filesystem.SkuteFileSystem;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ServerProperties;
import org.glassfish.jersey.servlet.ServletContainer;

public class SkuteHttpServer {
  public static final String SKUTE_FILESYSTEM_ATTRIBUTE = "skute.filesystem";

  private final Server server;

  protected SkuteHttpServer(int port, Package serverPackage, SkuteFileSystem fs) throws Exception {
    server = new Server(port);
    ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
    context.setContextPath("/");

    context.setAttribute(SKUTE_FILESYSTEM_ATTRIBUTE, fs);

    server.setHandler(context);
    ServletHolder h = new ServletHolder(new ServletContainer());
    h.setInitParameter(ServerProperties.PROVIDER_PACKAGES, serverPackage.toString());
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
