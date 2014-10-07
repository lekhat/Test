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

import java.util.EnumMap;
import java.util.Map;

import static com.codahale.metrics.MetricRegistry.name;

public class MetricsSkuteFileSystem implements SkuteFileSystem {

  static final MetricRegistry metrics = new MetricRegistry();

  private final SkuteFileSystem fs;

  private enum CountersEnum {
    START_COUNT("start_count"),
    STOP_COUNT("stop_count"),
    MKDIR_COUNT("mkdir_count"),
    RENAME_COUNT("rename_count"),
    SET_REPLICATION_COUNT("set_replication_count"),
    SET_OWNER_COUNT("set_owner_count"),
    SET_PERMISSION_COUNT("set_permission_count"),
    SET_TIMES_COUNT("set_times_count"),
    OPEN_COUNT("open_count"),
    GET_BLOCK_LOCATIONS_COUNT("get_block_locations_count"),
    GET_FILE_STATUS_COUNT("get_file_status_count"),
    LIST_STATUS_COUNT("list_status_count"),
    GET_CONTENT_SUMMARY_COUNT("get_content_summary_count"),
    GET_FILE_CHECKSUM_COUNT("get_file_checksum_count"),
    GET_HOME_DIRECTORY_COUNT("get_home_directory_count"),
    DELETE_COUNT("delete_count");

    private String counterName;

    CountersEnum(String counterName) {
      this.counterName = counterName;
    }
  }

  private final Map<CountersEnum, Counter> counters = new EnumMap(CountersEnum.class);

  public MetricsSkuteFileSystem(SkuteFileSystem skuteFileSystem) {
    this.fs = skuteFileSystem;

    for(CountersEnum c: CountersEnum.values()) {
      counters.put(c, getCounter(c.counterName));
    }
  }

  private Counter getCounter(String name) {
    return metrics.counter(name(MetricsSkuteFileSystem.class, fs.toString() + "-" + name));
  }

  @Override
  public void start() throws Exception {
    counters.get(CountersEnum.START_COUNT).inc();
    fs.start();
  }

  @Override
  public void stop() throws Exception {
    counters.get(CountersEnum.STOP_COUNT).inc();
    fs.stop();
  }

  @Override
  public SkuteResult mkdir(String path, short permission) throws Exception {
    counters.get(CountersEnum.MKDIR_COUNT).inc();
    return fs.mkdir(path, permission);
  }

  @Override
  public SkuteResult rename(String path, String newPath) throws Exception {
    counters.get(CountersEnum.RENAME_COUNT).inc();
    return fs.rename(path, newPath);
  }

  @Override
  public SkuteResult setReplication(String path, short replication) throws Exception {
    counters.get(CountersEnum.SET_REPLICATION_COUNT).inc();
    return fs.setReplication(path, replication);
  }

  @Override
  public SkuteResult setOwner(String path, String owner, String group) throws Exception {
    counters.get(CountersEnum.SET_OWNER_COUNT).inc();
    return fs.setOwner(path, owner, group);
  }

  @Override
  public SkuteResult setPermission(String path, short permission) throws Exception {
    counters.get(CountersEnum.SET_PERMISSION_COUNT).inc();
    return fs.setPermission(path, permission);
  }

  @Override
  public SkuteResult setTimes(String path, Long modificationTime, Long accessTime) throws Exception {
    counters.get(CountersEnum.SET_TIMES_COUNT).inc();
    return fs.setTimes(path, modificationTime, accessTime);
  }

  @Override
  public SkuteResult open(String path) throws Exception {
    counters.get(CountersEnum.OPEN_COUNT).inc();
    return fs.open(path);
  }

  @Override
  public SkuteResult open(String path, int bufferSize) throws Exception {
    counters.get(CountersEnum.OPEN_COUNT).inc();
    return fs.open(path, bufferSize);
  }

  @Override
  public SkuteResult getBlockLocations(String path, long start, Long len) throws Exception {
    counters.get(CountersEnum.GET_BLOCK_LOCATIONS_COUNT).inc();
    return fs.getBlockLocations(path, start, len);
  }

  @Override
  public SkuteResult getFileStatus(String path) throws Exception {
    counters.get(CountersEnum.GET_FILE_STATUS_COUNT).inc();
    return fs.getFileStatus(path);
  }

  @Override
  public SkuteResult listStatus(String path) throws Exception {
    counters.get(CountersEnum.LIST_STATUS_COUNT).inc();
    return fs.listStatus(path);
  }

  @Override
  public SkuteResult getContentSummary(String path) throws Exception {
    counters.get(CountersEnum.GET_CONTENT_SUMMARY_COUNT).inc();
    return fs.getContentSummary(path);
  }

  @Override
  public SkuteResult getFileChecksum(String path) throws Exception {
    counters.get(CountersEnum.GET_FILE_CHECKSUM_COUNT).inc();
    return fs.getFileChecksum(path);
  }

  @Override
  public SkuteResult getHomeDirectory(String user) throws Exception {
    counters.get(CountersEnum.GET_HOME_DIRECTORY_COUNT).inc();
    return fs.getHomeDirectory(user);
  }

  @Override
  public SkuteResult delete(String path, boolean recursive) throws Exception {
    counters.get(CountersEnum.DELETE_COUNT).inc();
    return fs.delete(path, recursive);
  }
}
