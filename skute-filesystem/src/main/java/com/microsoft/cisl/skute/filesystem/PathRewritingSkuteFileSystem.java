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

/**
 * Rewrite each Path access via the provided {@link com.microsoft.cisl.skute.filesystem.PathRewriter},
 * allowing accesses to the underlying file system to be modified transparently.
 */
public abstract class PathRewritingSkuteFileSystem extends WrappedSkuteFileSystem {
  private final PathRewriter pathRewriter;

  public PathRewritingSkuteFileSystem(SkuteFileSystem wrapped, PathRewriter pathRewriter) {
    super(wrapped);
    this.pathRewriter = pathRewriter;
  }

  private String rewrite(String path) {
    return pathRewriter.rewrite(path);
  }
  @Override
  public void start() throws Exception {
    wrapped.start();
  }

  @Override
  public void stop() throws Exception {
    wrapped.stop();
  }

  @Override
  public SkuteResult mkdir(String path, short permission) throws Exception {
    return wrapped.mkdir(rewrite(path), permission);
  }

  @Override
  public SkuteResult rename(String path, String newPath) throws Exception {
    return wrapped.rename(rewrite(path), rewrite(newPath));
  }

  @Override
  public SkuteResult setReplication(String path, short replication) throws Exception {
    return wrapped.setReplication(rewrite(path), replication);
  }

  @Override
  public SkuteResult setOwner(String path, String owner, String group) throws Exception {
    return wrapped.setOwner(rewrite(path), owner, group);
  }

  @Override
  public SkuteResult setPermission(String path, short permission) throws Exception {
    return wrapped.setPermission(rewrite(path), permission);
  }

  @Override
  public SkuteResult setTimes(String path, Long modificationTime, Long accessTime) throws Exception {
    return wrapped.setTimes(rewrite(path), modificationTime, accessTime);
  }

  @Override
  public SkuteResult open(String path) throws Exception {
    return wrapped.open(rewrite(path));
  }

  @Override
  public SkuteResult open(String path, int bufferSize) throws Exception {
    return wrapped.open(rewrite(path), bufferSize);
  }

  @Override
  public SkuteResult getBlockLocations(String path, long start, Long len) throws Exception {
    return wrapped.getBlockLocations(rewrite(path), start, len);
  }

  @Override
  public SkuteResult getFileStatus(String path) throws Exception {
    return wrapped.getFileStatus(rewrite(path));
  }

  @Override
  public SkuteResult listStatus(String path) throws Exception {
    return wrapped.listStatus(rewrite(path));
  }

  @Override
  public SkuteResult getContentSummary(String path) throws Exception {
    return wrapped.getContentSummary(rewrite(path));
  }

  @Override
  public SkuteResult getFileChecksum(String path) throws Exception {
    return wrapped.getContentSummary(rewrite(path));
  }

  @Override
  public SkuteResult getHomeDirectory(String user) throws Exception {
    return wrapped.getHomeDirectory(user);
  }

  @Override
  public SkuteResult delete(String path, boolean recursive) throws Exception {
    return wrapped.delete(rewrite(path), recursive);
  }
}
