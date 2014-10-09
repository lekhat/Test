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

import com.microsoft.cisl.skute.filesystem.SkuteFileStatus;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.Path;

/**
 * Wrap an Hadoop FileStatus in a SkuteFileStatus... sigh.
 */
public class SkuteHadoopFileStatus implements SkuteFileStatus {

  private final FileStatus fileStatus;

  public SkuteHadoopFileStatus(FileStatus fileStatus) {
    this.fileStatus = fileStatus;
  }
  @Override
  public long getLen() {
    return fileStatus.getLen();
  }

  @Override
  public boolean isFile() {
    return fileStatus.isFile();
  }

  @Override
  public boolean isDirectory() {
    return fileStatus.isDirectory();
  }

  @Override
  public boolean isSymlink() {
    return fileStatus.isSymlink();
  }

  @Override
  public long getBlockSize() {
    return fileStatus.getBlockSize();
  }

  @Override
  public short getReplication() {
    return fileStatus.getReplication();
  }

  @Override
  public long getModificationTime() {
    return fileStatus.getModificationTime();
  }

  @Override
  public long getAccessTime() {
    return fileStatus.getAccessTime();
  }

  @Override
  public short getPermission() {
    return fileStatus.getPermission().toShort();
  }

  @Override
  public String getOwner() {
    return fileStatus.getOwner();
  }

  @Override
  public String getGroup() {
    return fileStatus.getGroup();
  }

  @Override
  public String getPath() {
    return fileStatus.getPath().toString();
  }

  @Override
  public void setPath(String p) {
    fileStatus.setPath(new Path(p));
  }
}
