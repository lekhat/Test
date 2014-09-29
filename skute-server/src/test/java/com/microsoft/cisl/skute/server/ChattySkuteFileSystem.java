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

import com.microsoft.cisl.skute.filesystem.SkuteFileSystem;
import com.microsoft.cisl.skute.filesystem.SkuteResult;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ChattySkuteFileSystem implements SkuteFileSystem {
  private final static Log LOG = LogFactory.getLog(ChattySkuteFileSystem.class);

  @Override
  public void start() throws Exception {
    LOG.info("Starting!");
  }

  @Override
  public void stop() throws Exception {
    LOG.info("Stopping!");
  }

  @Override
  public SkuteResult mkdir(String path, short permission) {
    LOG.info(String.format("mkdir: path = %s, permission = %o", path, permission));
    return SkuteResult.OK;
  }

  @Override
  public String toString() {
    return "ChattySkuteFileSystem";
  }
}
