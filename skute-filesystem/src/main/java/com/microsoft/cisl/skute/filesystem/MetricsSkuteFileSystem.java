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


import com.microsoft.cisl.skute.filesystem.metrics.Metrics;

public class MetricsSkuteFileSystem implements SkuteFileSystem {

  private final Metrics metrics;
  private final SkuteFileSystem fs;

  public MetricsSkuteFileSystem(Metrics metrics, SkuteFileSystem skuteFileSystem) {
    this.metrics = metrics;
    this.fs = skuteFileSystem;

  }

  public static final String START_COUNT = "start_count";
  public static final String STOP_COUNT = "stop_count";
  public static final String MKDIR_COUNT = "mkdir_count";
  public static final String MKDIR_SUCCEED_COUNT = "mkdir_succeed_count";


  @Override
  public void start() throws Exception {
    metrics.incCounter(START_COUNT);
    fs.start();
  }

  @Override
  public void stop() throws Exception {
    metrics.incCounter(STOP_COUNT);
    fs.stop();
  }

  @Override
  public SkuteResult mkdir(String path, short permission) throws Exception {
    metrics.incCounter(MKDIR_COUNT);
    SkuteResult result = fs.mkdir(path, permission);

    if(result == SkuteResult.OK) metrics.incCounter(MKDIR_SUCCEED_COUNT);

    return result;
  }
}
