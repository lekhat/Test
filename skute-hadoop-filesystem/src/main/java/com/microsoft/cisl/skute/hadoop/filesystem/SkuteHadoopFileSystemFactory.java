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
package com.microsoft.cisl.skute.hadoop.filesystem;

import com.microsoft.cisl.skute.filesystem.SkuteFileSystem;
import com.microsoft.cisl.skute.filesystem.SkuteFileSystemFactory;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

public class SkuteHadoopFileSystemFactory implements SkuteFileSystemFactory {
  final static public String URI_KEY = "oah.filesystem.uri";
  @Override
  public SkuteFileSystem getSkuteFileSystem(Properties properties) throws Exception {
    try {
    if(!properties.containsKey(URI_KEY)) {
      throw new IllegalArgumentException("No Hadoop filesystem URI");
    }


      URI uri = new URI(properties.getProperty(URI_KEY));

      Configuration conf = new Configuration();
      FileSystem fs = FileSystem.get(uri, conf);

      return new SkuteHadoopFileSystem(fs);

    } catch (URISyntaxException e) {
      throw new Exception(e);
    }
  }
}
