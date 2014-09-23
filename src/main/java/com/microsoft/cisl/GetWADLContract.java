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
package com.microsoft.cisl;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hdfs.MiniDFSCluster;

import java.io.InputStream;
import java.net.URI;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class GetWADLContract {
  private static Path getOutputPath(String [] args) throws Exception {
    switch(args.length) {
      case 0: return FileSystems.getDefault().getPath("src/main/resources/wadl", "webhdfs.wadl");
      case 1: return FileSystems.getDefault().getPath(args[0]);
      default:
        throw new Exception("Usage: GetWADLContract <optional path to write wadl file>");
    }
  }
  public static void main(String[] args) throws Exception {
    Path output = getOutputPath(args);

    Configuration config = new Configuration();

    MiniDFSCluster miniDFSCluster = new MiniDFSCluster.Builder(config).build();

    try {
      URI wadl = URI.create(miniDFSCluster.getHttpUri(0) + "/webhdfs/v1/application.wadl");

      InputStream is  = wadl.toURL().openStream();
      if(Files.exists(output)) {
        System.out.println("Deleting prior " + output);

        Files.delete(output);
      }
      Files.copy(is, output);


    } finally {
      System.out.println("Shutting down minidfscluster.");
      miniDFSCluster.shutdown(true);
    }
  }
}
