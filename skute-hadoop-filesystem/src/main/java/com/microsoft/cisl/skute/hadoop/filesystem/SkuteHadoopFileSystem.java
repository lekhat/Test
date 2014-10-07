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
import org.apache.hadoop.fs.*;
import org.apache.hadoop.fs.permission.FsPermission;

import static com.microsoft.cisl.skute.filesystem.SkuteResult.ERR;
import static com.microsoft.cisl.skute.filesystem.SkuteResult.OK;

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

  private SkuteResult booleanToResult(boolean b) {
    return b ? OK : ERR;
  }

  @Override
  public SkuteResult mkdir(String p, short permission) throws Exception {
    Path path = new Path(p);
    return booleanToResult(fs.mkdirs(path, new FsPermission(permission)));
  }

  @Override
  public SkuteResult rename(String path, String newPath) throws Exception {
    return booleanToResult(fs.rename(new Path(path), new Path(newPath)));
  }

  @Override
  public SkuteResult setReplication(String path, short replication) throws Exception {
    return booleanToResult(fs.setReplication(new Path(path), replication));
  }

  @Override
  public SkuteResult setOwner(String path, String owner, String group) throws Exception {
    fs.setOwner(new Path(path), owner, group);

    return OK;
  }

  @Override
  public SkuteResult setPermission(String path, short permission) throws Exception {
    fs.setPermission(new Path(path), FsPermission.createImmutable(permission));

    return OK;
  }

  @Override
  public SkuteResult setTimes(String path, Long modificationTime, Long accessTime) throws Exception {
    fs.setTimes(new Path(path), modificationTime, accessTime);

    return OK;
  }

  @Override
  public SkuteResult open(String path) throws Exception {
    // @TODO Implement me!
    throw new RuntimeException("Not yet implemented!");
  }

  @Override
  public SkuteResult open(String path, int bufferSize) throws Exception {
    // @TODO Implement me!
    throw new RuntimeException("Not yet implemented!");
  }

  @Override
  public SkuteResult<BlockLocation[]> getBlockLocations(final String path, final long start, final Long len) throws Exception {
    return new SkuteResult<BlockLocation[]>() {
      @Override
      public BlockLocation[] getResult() throws Exception {
        return fs.getFileBlockLocations(new Path(path), start, len != null ? len : Long.MAX_VALUE);
      }
    };
  }

  @Override
  public SkuteResult<FileStatus> getFileStatus(final String path) throws Exception {
    return new SkuteResult<FileStatus>() {
      @Override
      public FileStatus getResult() throws Exception {
        return fs.getFileStatus(new Path(path));
      }
    };
  }

  @Override
  public SkuteResult<FileStatus []> listStatus(final String path) throws Exception {
    return new SkuteResult<FileStatus[]>() {
      @Override
      public FileStatus[] getResult() throws Exception {
        return fs.listStatus(new Path(path));
      }
    };
  }

  @Override
  public SkuteResult<ContentSummary> getContentSummary(final String path) throws Exception {
    return new SkuteResult<ContentSummary>() {
      @Override
      public ContentSummary getResult() throws Exception {
        return fs.getContentSummary(new Path(path));
      }
    };
  }

  @Override
  public SkuteResult<FileChecksum> getFileChecksum(final String path) throws Exception {
    return new SkuteResult<FileChecksum>() {
      @Override
      public FileChecksum getResult() throws Exception {
        return fs.getFileChecksum(new Path(path));
      }
    };
  }

  @Override
  public SkuteResult<Path> getHomeDirectory(String user) throws Exception {
    // TODO: Good time to figure out how we're passing the user credentials
    return new SkuteResult<Path>() {
      @Override
      public Path getResult() throws Exception {
        return fs.getHomeDirectory();
      }
    };
  }

  @Override
  public SkuteResult delete(String path, boolean recursive) throws Exception {
    return booleanToResult(fs.delete(new Path(path), recursive));
  }
}
