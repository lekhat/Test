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
import com.microsoft.cisl.skute.filesystem.SkuteResult;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.permission.FsPermission;

import java.io.IOException;

/**
 * An instance of a SkuteFileSystem backed by an org.apache.hadoop.FileSystem.
 * This allows the SkuteServer to be backed by an Hadoop filesystem.
 */
public class SkuteHadoopFileSystem implements SkuteFileSystem {
  private static final Log LOG = LogFactory.getLog(SkuteHadoopFileSystem.class);
  private final FileSystem fs;

  public SkuteHadoopFileSystem(FileSystem fs) {
    this.fs = fs;
  }

  @Override
  public void start() throws Exception { /* Nothing to do */ }

  @Override
  public void stop() throws Exception {
    fs.close();
  }

  @Override
  public SkuteResult mkdir(String p, short permission) {
    Path path = new Path(p);
    try {
      fs.mkdirs(path, new FsPermission(permission));
    } catch (IOException e) {
      if (LOG.isWarnEnabled()) {
        LOG.warn(String.format("Exception while processing mkdirs (path = %s, permission = %04d) from %s", path, permission));
      }

      return SkuteResult.ERR;
    }
    return SkuteResult.OK;
  }
}
