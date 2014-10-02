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

public class SkuteHttpServerBuilder {
  private int port = 7552;

  private SkuteFileSystem skuteFileSystem;

  private Package serverPackage;

  public SkuteHttpServerBuilder() { /* nothing to do */ }

  public SkuteHttpServerBuilder setPort(int port) {
    this.port = port;

    return this;
  }

  public SkuteHttpServerBuilder setServerPackage(Package serverPackage) {
    this.serverPackage = serverPackage;
    return this;
  }

  public SkuteHttpServerBuilder setSkuteFileSystem(SkuteFileSystem skuteFileSystem) {
    this.skuteFileSystem = skuteFileSystem;

    return this;
  }

  public SkuteHttpServer build() throws Exception {
    if(serverPackage == null) {
      throw new IllegalArgumentException("Must specify server package");
    }

    if(skuteFileSystem == null) {
      throw new IllegalArgumentException("Must specify skute filesystem");
    }

    return new SkuteHttpServer(port, serverPackage, skuteFileSystem);
  }
}
