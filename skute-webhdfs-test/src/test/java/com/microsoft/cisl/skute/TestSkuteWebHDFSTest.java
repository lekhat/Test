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

import com.microsoft.cisl.skute.hadoop.filesystem.SkuteWebHDFSFileSystemFactory;
import com.microsoft.cisl.skute.server.SkuteServer;
import com.typesafe.config.Config;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.Test;

import java.net.URI;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestSkuteWebHDFSTest {

  // Let's get circular.  We're going to create a WebHDFS-backed Skute server
  // that we'll then interact with via the WebHDFS client.
  @Test
  public void letUsConnect() throws Exception {
    Config conf = mock(Config.class);
    int port = 4545;
    when(conf.getString("skute.fs.factory")).thenReturn(SkuteWebHDFSFileSystemFactory.class.getCanonicalName().toString());
    when(conf.getInt("skute.http.server.port")).thenReturn(port);
    SkuteHttpServer httpServer = Utils.getSkuteHttpServer(SkuteServer.class.getPackage(), conf);

    httpServer.start();

    Configuration hadoopConfiguration = new Configuration();
    URI uri = new URI("webhdfs://localhost:" + port);
    FileSystem webhdfsClient = FileSystem.get(uri, hadoopConfiguration);

    assertTrue(webhdfsClient.mkdirs(new Path("/howdy")));
    assertTrue(webhdfsClient.delete(new Path("/howdy"), false));

    httpServer.getSkuteFileSystem().stop();

    httpServer.stop();

  }
}
