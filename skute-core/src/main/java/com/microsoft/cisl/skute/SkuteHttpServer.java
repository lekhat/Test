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
import com.sun.jersey.spi.container.servlet.ServletContainer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.servlet.Context;
import org.mortbay.jetty.servlet.ServletHolder;
import static com.sun.jersey.api.core.PackagesResourceConfig.PROPERTY_PACKAGES;

public class SkuteHttpServer {
  private static final Log LOG = LogFactory.getLog(SkuteHttpServer.class);

  public static final String SKUTE_FILESYSTEM_ATTRIBUTE = "skute.filesystem";

  private final Server server;

  private final SkuteFileSystem skuteFileSystem;

  protected SkuteHttpServer(int port, Package serverPackage, SkuteFileSystem fs) throws Exception {
    this.skuteFileSystem = fs;

    server = new Server(port);
    Context context = new Context(Context.SESSIONS);
    context.setContextPath("/");

    context.setAttribute(SKUTE_FILESYSTEM_ATTRIBUTE, fs);
    server.setHandler(context);

    ServletHolder h = new ServletHolder(ServletContainer.class);

    h.setInitParameter(PROPERTY_PACKAGES, serverPackage.toString());
    h.setInitOrder(1);

    context.addServlet(h, "/webhdfs/v1/*");
    if (LOG.isInfoEnabled()) {
      LOG.info("Server = " + server);
    }

  }

  public SkuteFileSystem getSkuteFileSystem() {
    return skuteFileSystem;
  }

  public void start() throws Exception {
    server.start();
  }

  public void stop() throws Exception {
    server.stop();
  }
}
