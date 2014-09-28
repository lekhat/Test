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

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ServerProperties;
import org.glassfish.jersey.servlet.ServletContainer;

public class SkuteHttpServer {
  public static void main(String[] args) {
    Server server = new Server(8112);
    ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
    context.setContextPath("/");
    server.setHandler(context);
    ServletHolder h = new ServletHolder(new ServletContainer());
    h.setInitParameter(ServerProperties.PROVIDER_PACKAGES, SkuteServer.class.getPackage().toString());
    h.setInitOrder(1);
    context.addServlet(h, "/*");
    server.setDumpAfterStart(true);

    try  {

        server.start();
      Thread.sleep(100 * 1000);
    }catch(Exception ex) {
       ex.printStackTrace();
    }
  }
}
