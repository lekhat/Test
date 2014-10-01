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
package com.microsoft.cisl.skute.filesystem;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Files;

public class LocalSkuteFileSystem implements SkuteFileSystem {
  private static final Log LOG = LogFactory.getLog(LocalSkuteFileSystem.class);
  final Path root;

  public LocalSkuteFileSystem(Path root) {
    this.root = root;
  }

  @Override
  public void start() { /* Nothing to do */ }

  @Override
  public void stop() { /* Nothing to do */ }

  @Override
  public SkuteResult mkdir(String path, short permission) {
    Path result = FileSystems.getDefault().getPath(root.toString(), path);
    try {
      Files.createDirectory(result);
    } catch (IOException e) {
      if (LOG.isWarnEnabled()) {
        LOG.warn(String.format("Exception while processing mkdirs (path = %s, permission = %04d) from %s", path, permission));
      }
      return SkuteResult.ERR;
    }
    return SkuteResult.OK;
  }
}
