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

import com.codahale.metrics.Counter;
import com.codahale.metrics.MetricRegistry;

import static com.codahale.metrics.MetricRegistry.name;

public class MetricsSkuteFileSystem implements SkuteFileSystem {

  static final MetricRegistry metrics = new MetricRegistry();

  private final SkuteFileSystem fs;

  public static final String START_COUNT = "start_count";
  public static final String STOP_COUNT = "stop_count";
  public static final String MKDIR_COUNT = "mkdir_count";
  public static final String MKDIR_SUCCEED_COUNT = "mkdir_succeed_count";

  private final Counter startCount;
  private final Counter stopCount;
  private final Counter mkdirCount;
  private final Counter mkdirSucceedCount;

  public MetricsSkuteFileSystem(SkuteFileSystem skuteFileSystem) {
    this.fs = skuteFileSystem;

    startCount = getCounter(START_COUNT);
    stopCount = getCounter(STOP_COUNT);
    mkdirCount = getCounter(MKDIR_COUNT);
    mkdirSucceedCount = getCounter(MKDIR_SUCCEED_COUNT);
  }

  private Counter getCounter(String name) {
    return metrics.counter(name(MetricsSkuteFileSystem.class, fs.toString() + "-" + name));
  }

  @Override
  public void start() throws Exception {
    startCount.inc();
    fs.start();
  }

  @Override
  public void stop() throws Exception {
    stopCount.inc();
    fs.stop();
  }

  @Override
  public SkuteResult mkdir(String path, short permission) throws Exception {
    mkdirCount.inc();
    SkuteResult result = fs.mkdir(path, permission);

    if(result == SkuteResult.OK) mkdirSucceedCount.inc();

    return result;
  }
}
