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

public interface SkuteFileSystem {

  public static String ROOT = "/";

  public void start() throws Exception;

  public void stop() throws Exception;

  public SkuteResult mkdir(String path, short permission) throws Exception;

  public SkuteResult rename(String path, String newPath) throws Exception;

  // @TODO: Implement
  //public SkuteResult createSymlink

  public SkuteResult setReplication(String path, short replication) throws Exception;

  public SkuteResult setOwner(String path, String owner, String group) throws Exception;

  public SkuteResult setPermission(String path, short permission) throws Exception;

  public SkuteResult setTimes(String path, Long modificationTime, Long accessTime) throws Exception;

  // @TODO Implement
  //public SkuteResult renewDelegationToken
  //public SkuteResult cancelDelegationToken
  //public SkuteResult modifyACLEntries
  //public SkuteResult removeACLEntries
  //public SkuteResult removeDefaultACL
  //public SkuteResult removeACL
  //public SkuteResult setACL
  //public SkuteResult setXAttr
  //public SkuteResult removeXAttr
  //public SkuteResult createSnapshot
  //public SkuteResult renameSnapshot

  //public SkuteResult append
  //public SkuteResult concat

  public SkuteResult open(String path) throws Exception;

  public SkuteResult open(String path, int bufferSize) throws Exception;

  public SkuteResult getBlockLocations(String path, long start, Long len) throws Exception;

  public SkuteResult getFileStatus(String path) throws Exception;

  public SkuteResult<SkuteFileStatus []> listStatus(String path) throws Exception;

  public SkuteResult getContentSummary(String path) throws Exception;

  public SkuteResult getFileChecksum(String path) throws Exception;

  //public SkuteResult getDelegationToken

  public SkuteResult getHomeDirectory(String user) throws Exception;

  //public SkuteResult getAclStatus
  //public SkuteResult getXAttrs
  //public SkuteResult listXAttrs

  public SkuteResult delete(String path, boolean recursive) throws Exception;

  //public SkuteResult deleteSnapshot
}
