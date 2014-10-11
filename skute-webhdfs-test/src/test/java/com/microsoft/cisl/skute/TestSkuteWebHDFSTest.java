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

import com.microsoft.cisl.skute.hadoop.filesystem.SkuteMiniDFSClusterFileSystemFactory;
import com.microsoft.cisl.skute.server.SkuteServer;
import com.typesafe.config.Config;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.Test;

import java.net.URI;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestSkuteWebHDFSTest {

  // We're going to create a MiniDFSCluster-backed Skute server
  // that we'll then interact with via the WebHDFS client.
  @Test
  public void letUsConnect() throws Exception {
    Config conf = mock(Config.class);
    int port = 4545;
    when(conf.getString("skute.fs.factory")).thenReturn(SkuteMiniDFSClusterFileSystemFactory.class.getCanonicalName().toString());
    when(conf.getInt("skute.http.server.port")).thenReturn(port);
    SkuteHttpServer httpServer = Utils.getSkuteHttpServer(SkuteServer.class.getPackage(), conf);

    httpServer.start();
    System.out.println("Started Skute Server at " + httpServer);

    Configuration hadoopConfiguration = new Configuration();
    URI uri = new URI("webhdfs://localhost:" + port);
    FileSystem webhdfsClient = FileSystem.get(uri, hadoopConfiguration);

    System.out.println("Connected to SkuteServer over " + webhdfsClient);
    assertTrue(webhdfsClient.mkdirs(new Path("/howdy")));
    System.out.println("Created new directory: /howdy");

    FileStatus[] z = webhdfsClient.listStatus(new Path("/"));

    assertEquals(1, z.length);

    assertEquals("howdy", z[0].getPath().getName());
    assertTrue(z[0].isDirectory());
    System.out.println("Verified howdy is correct via listStatus");

    assertTrue(webhdfsClient.delete(new Path("/howdy"), false));
    System.out.println("Deleted /howdy");

    httpServer.getSkuteFileSystem().stop();
    System.out.println("Stopped SkuteFileSystem");

    httpServer.stop();
    System.out.println("Stopped SkuteServer");

  }
}
