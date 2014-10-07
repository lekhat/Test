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
import com.typesafe.config.Config;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.hdfs.MiniDFSCluster;

/**
 * Crate a SkuteFileSystem backed by a local WebHDFS instance; intended for testing
 * and demonstration.
 */
public class SkuteWebHDFSFileSystemFactory implements SkuteFileSystemFactory {
  private static final Log LOG = LogFactory.getLog(SkuteWebHDFSFileSystemFactory.class);

  @Override
  public SkuteFileSystem getSkuteFileSystem(Config config) throws Exception {
    Configuration hadoopConf = new Configuration();
    final MiniDFSCluster cluster = new MiniDFSCluster.Builder(hadoopConf).build();

    final FileSystem fs = cluster.getFileSystem();

    LOG.info("WebHDFS URI= " + fs.getUri());

    return new SkuteHadoopFileSystem(fs);
  }
}
