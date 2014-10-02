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
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.hdfs.web.resources.UriFsPathParam;

import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

public class SkuteStreamer {
  private static final Log LOG = LogFactory.getLog(SkuteStreamer.class);

  private @Context
  ServletContext context;

  private static final UriFsPathParam ROOT = new UriFsPathParam("");

  public static final String SKUTE_FILESYSTEM_ATTRIBUTE = "skute.filesystem";

  public static final int DEFAULT_PORT = 7552;

  public static void main(String[] args) throws Exception {
    Package pckg = SkuteStreamer.class.getPackage();

    Utils.runServer(pckg, args);
  }

  private SkuteFileSystem getFileSystem() {
    return (SkuteFileSystem)context.getAttribute(SKUTE_FILESYSTEM_ATTRIBUTE);
  }

  public Response notYetImplemented() {
    throw new UnsupportedOperationException("Not yet supported");
  }
}
