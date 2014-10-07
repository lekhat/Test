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

import com.microsoft.cisl.skute.UserGroupInformationPlaceHolder;
import com.microsoft.cisl.skute.Utils;
import com.microsoft.cisl.skute.filesystem.SkuteFileSystem;
import com.microsoft.cisl.skute.filesystem.SkuteResult;
import com.sun.jersey.spi.container.ResourceFilters;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.hdfs.web.JsonUtil;
import org.apache.hadoop.hdfs.web.ParamFilter;
import org.apache.hadoop.hdfs.web.resources.*;

import javax.servlet.ServletContext;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;

@Path("")
@ResourceFilters(ParamFilter.class)
public class SkuteServer {
  private static final Log LOG = LogFactory.getLog(SkuteServer.class);

  private @Context ServletContext context;

  private static final UriFsPathParam ROOT = new UriFsPathParam("");

  public static final String SKUTE_FILESYSTEM_ATTRIBUTE = "skute.filesystem";

  public static final int DEFAULT_PORT = 7552;

  public static void main(String[] args) throws Exception {
    Package pckg = SkuteServer.class.getPackage();

    Utils.runServer(pckg, args);
  }

  private SkuteFileSystem getFileSystem() {
    return (SkuteFileSystem)context.getAttribute(SKUTE_FILESYSTEM_ATTRIBUTE);
  }

  /** Handle HTTP DELETE request for the root. */
  @DELETE
  @Path("/")
  @Produces(MediaType.APPLICATION_JSON)
  public Response deleteRoot(
      @Context final UserGroupInformationPlaceHolder ugi,
      @QueryParam(DelegationParam.NAME) @DefaultValue(DelegationParam.DEFAULT)
          final DelegationParam delegation,
      @QueryParam(UserParam.NAME) @DefaultValue(UserParam.DEFAULT)
          final UserParam username,
      @QueryParam(DoAsParam.NAME) @DefaultValue(DoAsParam.DEFAULT)
          final DoAsParam doAsUser,
      @QueryParam(DeleteOpParam.NAME) @DefaultValue(DeleteOpParam.DEFAULT)
          final DeleteOpParam op,
      @QueryParam(RecursiveParam.NAME) @DefaultValue(RecursiveParam.DEFAULT)
          final RecursiveParam recursive,
      @QueryParam(SnapshotNameParam.NAME) @DefaultValue(SnapshotNameParam.DEFAULT)
          final SnapshotNameParam snapshotName
      ) throws IOException, InterruptedException {
    return delete(ugi, delegation, username, doAsUser, ROOT, op, recursive,
        snapshotName);
  }

  /** Handle HTTP DELETE request. */
  @DELETE
  @Path("{" + UriFsPathParam.NAME + ":.*}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response delete(
      @Context final UserGroupInformationPlaceHolder ugi,
      @QueryParam(DelegationParam.NAME) @DefaultValue(DelegationParam.DEFAULT)
          final DelegationParam delegation,
      @QueryParam(UserParam.NAME) @DefaultValue(UserParam.DEFAULT)
          final UserParam username,
      @QueryParam(DoAsParam.NAME) @DefaultValue(DoAsParam.DEFAULT)
          final DoAsParam doAsUser,
      @PathParam(UriFsPathParam.NAME) final UriFsPathParam path,
      @QueryParam(DeleteOpParam.NAME) @DefaultValue(DeleteOpParam.DEFAULT)
          final DeleteOpParam op,
      @QueryParam(RecursiveParam.NAME) @DefaultValue(RecursiveParam.DEFAULT)
          final RecursiveParam recursive,
      @QueryParam(SnapshotNameParam.NAME) @DefaultValue(SnapshotNameParam.DEFAULT)
          final SnapshotNameParam snapshotName
      ) throws IOException, InterruptedException {
    // @TODO: Implement me!
    if (LOG.isTraceEnabled()) {
      LOG.trace(String.format("DELETE: path = %s, recursive = %b", path, recursive.getValue()));
    }

    try {
      SkuteResult result = getFileSystem().delete(path.getAbsolutePath(), recursive.getValue());
      String js = JsonUtil.toJsonString("boolean", result == SkuteResult.OK);
      Response response = Response.ok(js).type(MediaType.APPLICATION_JSON).build();

      if (LOG.isDebugEnabled()) {
        LOG.debug("DELETE response = "  + response);
      }

      return response;
    }catch (Exception e) {
      if (LOG.isWarnEnabled()) {
        LOG.warn(String.format("Exception while processing delete (path = %s, recursive = %b), exception = %s", path, recursive.getValue(), e.getMessage()));
      }
      return Response.serverError().build(); // @TODO: Verify error behavior between us and webhdfs
    }
  }

  /** Handle HTTP PUT request for the root. */
  @PUT
  @Path("/")
  @Consumes({"*/*"})
  @Produces({MediaType.APPLICATION_OCTET_STREAM, MediaType.APPLICATION_JSON})
  public Response putRoot(
      @Context final UserGroupInformationPlaceHolder ugi,
      @QueryParam(DelegationParam.NAME) @DefaultValue(DelegationParam.DEFAULT)
          final DelegationParam delegation,
      @QueryParam(UserParam.NAME) @DefaultValue(UserParam.DEFAULT)
          final UserParam username,
      @QueryParam(DoAsParam.NAME) @DefaultValue(DoAsParam.DEFAULT)
          final DoAsParam doAsUser,
      @QueryParam(PutOpParam.NAME) @DefaultValue(PutOpParam.DEFAULT)
          final PutOpParam op,
      @QueryParam(DestinationParam.NAME) @DefaultValue(DestinationParam.DEFAULT)
          final DestinationParam destination,
      @QueryParam(OwnerParam.NAME) @DefaultValue(OwnerParam.DEFAULT)
          final OwnerParam owner,
      @QueryParam(GroupParam.NAME) @DefaultValue(GroupParam.DEFAULT)
          final GroupParam group,
      @QueryParam(PermissionParam.NAME) @DefaultValue(PermissionParam.DEFAULT)
          final PermissionParam permission,
      @QueryParam(OverwriteParam.NAME) @DefaultValue(OverwriteParam.DEFAULT)
          final OverwriteParam overwrite,
      @QueryParam(BufferSizeParam.NAME) @DefaultValue(BufferSizeParam.DEFAULT)
          final BufferSizeParam bufferSize,
      @QueryParam(ReplicationParam.NAME) @DefaultValue(ReplicationParam.DEFAULT)
          final ReplicationParam replication,
      @QueryParam(BlockSizeParam.NAME) @DefaultValue(BlockSizeParam.DEFAULT)
          final BlockSizeParam blockSize,
      @QueryParam(ModificationTimeParam.NAME) @DefaultValue(ModificationTimeParam.DEFAULT)
          final ModificationTimeParam modificationTime,
      @QueryParam(AccessTimeParam.NAME) @DefaultValue(AccessTimeParam.DEFAULT)
          final AccessTimeParam accessTime,
      @QueryParam(RenameOptionSetParam.NAME) @DefaultValue(RenameOptionSetParam.DEFAULT)
          final RenameOptionSetParam renameOptions,
      @QueryParam(CreateParentParam.NAME) @DefaultValue(CreateParentParam.DEFAULT)
          final CreateParentParam createParent,
      @QueryParam(TokenArgumentParam.NAME) @DefaultValue(TokenArgumentParam.DEFAULT)
          final TokenArgumentParam delegationTokenArgument,
      @QueryParam(AclPermissionParam.NAME) @DefaultValue(AclPermissionParam.DEFAULT)
          final AclPermissionParam aclPermission,
      @QueryParam(XAttrNameParam.NAME) @DefaultValue(XAttrNameParam.DEFAULT)
          final XAttrNameParam xattrName,
      @QueryParam(XAttrValueParam.NAME) @DefaultValue(XAttrValueParam.DEFAULT)
          final XAttrValueParam xattrValue,
      @QueryParam(XAttrSetFlagParam.NAME) @DefaultValue(XAttrSetFlagParam.DEFAULT)
          final XAttrSetFlagParam xattrSetFlag,
      @QueryParam(SnapshotNameParam.NAME) @DefaultValue(SnapshotNameParam.DEFAULT)
          final SnapshotNameParam snapshotName,
      @QueryParam(OldSnapshotNameParam.NAME) @DefaultValue(OldSnapshotNameParam.DEFAULT)
          final OldSnapshotNameParam oldSnapshotName
          )throws IOException, InterruptedException {
    return put(ugi, delegation, username, doAsUser, ROOT, op, destination,
        owner, group, permission, overwrite, bufferSize, replication,
        blockSize, modificationTime, accessTime, renameOptions, createParent,
        delegationTokenArgument, aclPermission, xattrName, xattrValue,
        xattrSetFlag, snapshotName, oldSnapshotName);
  }

  /** Handle HTTP PUT request. */
  @PUT
  @Path("{" + UriFsPathParam.NAME + ":.*}")
  @Consumes({"*/*"})
  @Produces({MediaType.APPLICATION_OCTET_STREAM, MediaType.APPLICATION_JSON})
  public Response put(
      @Context final UserGroupInformationPlaceHolder ugi,
      @QueryParam(DelegationParam.NAME) @DefaultValue(DelegationParam.DEFAULT)
          final DelegationParam delegation,
      @QueryParam(UserParam.NAME) @DefaultValue(UserParam.DEFAULT)
          final UserParam username,
      @QueryParam(DoAsParam.NAME) @DefaultValue(DoAsParam.DEFAULT)
          final DoAsParam doAsUser,
      @PathParam(UriFsPathParam.NAME) final UriFsPathParam path,
      @QueryParam(PutOpParam.NAME) @DefaultValue(PutOpParam.DEFAULT)
          final PutOpParam op,
      @QueryParam(DestinationParam.NAME) @DefaultValue(DestinationParam.DEFAULT)
          final DestinationParam destination,
      @QueryParam(OwnerParam.NAME) @DefaultValue(OwnerParam.DEFAULT)
          final OwnerParam owner,
      @QueryParam(GroupParam.NAME) @DefaultValue(GroupParam.DEFAULT)
          final GroupParam group,
      @QueryParam(PermissionParam.NAME) @DefaultValue(PermissionParam.DEFAULT)
          final PermissionParam permission,
      @QueryParam(OverwriteParam.NAME) @DefaultValue(OverwriteParam.DEFAULT)
          final OverwriteParam overwrite,
      @QueryParam(BufferSizeParam.NAME) @DefaultValue(BufferSizeParam.DEFAULT)
          final BufferSizeParam bufferSize,
      @QueryParam(ReplicationParam.NAME) @DefaultValue(ReplicationParam.DEFAULT)
          final ReplicationParam replication,
      @QueryParam(BlockSizeParam.NAME) @DefaultValue(BlockSizeParam.DEFAULT)
          final BlockSizeParam blockSize,
      @QueryParam(ModificationTimeParam.NAME) @DefaultValue(ModificationTimeParam.DEFAULT)
          final ModificationTimeParam modificationTime,
      @QueryParam(AccessTimeParam.NAME) @DefaultValue(AccessTimeParam.DEFAULT)
          final AccessTimeParam accessTime,
      @QueryParam(RenameOptionSetParam.NAME) @DefaultValue(RenameOptionSetParam.DEFAULT)
          final RenameOptionSetParam renameOptions,
      @QueryParam(CreateParentParam.NAME) @DefaultValue(CreateParentParam.DEFAULT)
          final CreateParentParam createParent,
      @QueryParam(TokenArgumentParam.NAME) @DefaultValue(TokenArgumentParam.DEFAULT)
          final TokenArgumentParam delegationTokenArgument,
      @QueryParam(AclPermissionParam.NAME) @DefaultValue(AclPermissionParam.DEFAULT)
          final AclPermissionParam aclPermission,
      @QueryParam(XAttrNameParam.NAME) @DefaultValue(XAttrNameParam.DEFAULT)
          final XAttrNameParam xattrName,
      @QueryParam(XAttrValueParam.NAME) @DefaultValue(XAttrValueParam.DEFAULT)
          final XAttrValueParam xattrValue,
      @QueryParam(XAttrSetFlagParam.NAME) @DefaultValue(XAttrSetFlagParam.DEFAULT)
          final XAttrSetFlagParam xattrSetFlag,
      @QueryParam(SnapshotNameParam.NAME) @DefaultValue(SnapshotNameParam.DEFAULT)
          final SnapshotNameParam snapshotName,
      @QueryParam(OldSnapshotNameParam.NAME) @DefaultValue(OldSnapshotNameParam.DEFAULT)
          final OldSnapshotNameParam oldSnapshotName
      ) throws IOException, InterruptedException {

    switch(op.getValue()) {
      case CREATE:
      {
        // @TODO: Implement me!
        return notYetImplemented();
      }
      case CREATESYMLINK:
      {
        // @TODO: Implement me!
        return notYetImplemented();
      }
      case RENAME:
      {
        // @TODO: Implement me!
        return notYetImplemented();
      }
      case SETREPLICATION:
      {
        // @TODO: Implement me!
        return notYetImplemented();
      }
      case SETOWNER:
      {
        // @TODO: Implement me!
        return notYetImplemented();
      }
      case SETPERMISSION:
      {
        // @TODO: Implement me!
        return notYetImplemented();
      }
      case SETTIMES:
      {
        // @TODO: Implement me!
        return notYetImplemented();
      }
      case RENEWDELEGATIONTOKEN:
      {
        // @TODO: Implement me!
        return notYetImplemented();
      }
      case CANCELDELEGATIONTOKEN:
      {
        // @TODO: Implement me!
        return notYetImplemented();
      }
      case MODIFYACLENTRIES: {
        // @TODO: Implement me!
        return notYetImplemented();
      }
      case REMOVEACLENTRIES: {
        // @TODO: Implement me!
        return notYetImplemented();
      }
      case REMOVEDEFAULTACL: {
        // @TODO: Implement me!
        return notYetImplemented();
      }
      case REMOVEACL: {
        // @TODO: Implement me!
        return notYetImplemented();
      }
      case SETACL: {
        // @TODO: Implement me!
        return notYetImplemented();
      }
      case SETXATTR: {
        // @TODO: Implement me!
        return notYetImplemented();
      }
      case REMOVEXATTR: {
        // @TODO: Implement me!
        return notYetImplemented();
      }
      case CREATESNAPSHOT: {
        // @TODO: Implement me!
        return notYetImplemented();
      }
      case RENAMESNAPSHOT: {
        // @TODO: Implement me!
        return notYetImplemented();
      }
      case MKDIRS:
      {
        if (LOG.isTraceEnabled()) {
          LOG.trace(String.format("MKDIRS: path = %s, permission = %04d", path, permission.getFsPermission().toShort()));
        }

        try {
          SkuteResult result = getFileSystem().mkdir(path.getAbsolutePath(), permission.getFsPermission().toShort());
          String js = JsonUtil.toJsonString("boolean", result == SkuteResult.OK);
          Response response = Response.ok(js).type(MediaType.APPLICATION_JSON).build();

          if (LOG.isDebugEnabled()) {
            LOG.debug("MKDIRS response = "  + response);
          }

          return response;
        }catch (Exception e) {
          if (LOG.isWarnEnabled()) {
            LOG.warn(String.format("Exception while processing mkdirs (path = %s, permission = %04d) from %s", path, permission.getFsPermission().toShort()));
          }
          return Response.serverError().build(); // @TODO: Verify error behavior between us and webhdfs
        }

      }
      default:
      {
        throw new UnsupportedOperationException(op + " is not supported");
      }
    }

  }

  /** Handle HTTP POST request for the root. */
  @POST
  @Path("/")
  @Consumes({"*/*"})
  @Produces({MediaType.APPLICATION_OCTET_STREAM, MediaType.APPLICATION_JSON})
  public Response postRoot(
      @Context final UserGroupInformationPlaceHolder ugi,
      @QueryParam(DelegationParam.NAME) @DefaultValue(DelegationParam.DEFAULT)
          final DelegationParam delegation,
      @QueryParam(UserParam.NAME) @DefaultValue(UserParam.DEFAULT)
          final UserParam username,
      @QueryParam(DoAsParam.NAME) @DefaultValue(DoAsParam.DEFAULT)
          final DoAsParam doAsUser,
      @QueryParam(PostOpParam.NAME) @DefaultValue(PostOpParam.DEFAULT)
          final PostOpParam op,
      @QueryParam(ConcatSourcesParam.NAME) @DefaultValue(ConcatSourcesParam.DEFAULT)
          final ConcatSourcesParam concatSrcs,
      @QueryParam(BufferSizeParam.NAME) @DefaultValue(BufferSizeParam.DEFAULT)
          final BufferSizeParam bufferSize
      ) throws IOException, InterruptedException {
    return post(ugi, delegation, username, doAsUser, ROOT, op, concatSrcs, bufferSize);
  }

  /** Handle HTTP POST request. */
  @POST
  @Path("{" + UriFsPathParam.NAME + ":.*}")
  @Consumes({"*/*"})
  @Produces({MediaType.APPLICATION_OCTET_STREAM, MediaType.APPLICATION_JSON})
  public Response post(
      @Context final UserGroupInformationPlaceHolder ugi,
      @QueryParam(DelegationParam.NAME) @DefaultValue(DelegationParam.DEFAULT)
          final DelegationParam delegation,
      @QueryParam(UserParam.NAME) @DefaultValue(UserParam.DEFAULT)
          final UserParam username,
      @QueryParam(DoAsParam.NAME) @DefaultValue(DoAsParam.DEFAULT)
          final DoAsParam doAsUser,
      @PathParam(UriFsPathParam.NAME) final UriFsPathParam path,
      @QueryParam(PostOpParam.NAME) @DefaultValue(PostOpParam.DEFAULT)
          final PostOpParam op,
      @QueryParam(ConcatSourcesParam.NAME) @DefaultValue(ConcatSourcesParam.DEFAULT)
          final ConcatSourcesParam concatSrcs,
      @QueryParam(BufferSizeParam.NAME) @DefaultValue(BufferSizeParam.DEFAULT)
          final BufferSizeParam bufferSize
      ) throws IOException, InterruptedException {
    switch(op.getValue()) {
    case APPEND:
    {
      // @TODO: Implement me!
      return notYetImplemented();
    }
    case CONCAT:
    {
      // @TODO: Implement me!
      return notYetImplemented();
    }
    default:
      throw new UnsupportedOperationException(op + " is not supported");
    }
  }

  /** Handle HTTP GET request for the root. */
  @GET
  @Path("/")
  @Produces({MediaType.APPLICATION_OCTET_STREAM, MediaType.APPLICATION_JSON})
  public Response getRoot(
      @Context final UserGroupInformationPlaceHolder ugi,
      @QueryParam(DelegationParam.NAME) @DefaultValue(DelegationParam.DEFAULT)
          final DelegationParam delegation,
      @QueryParam(UserParam.NAME) @DefaultValue(UserParam.DEFAULT)
          final UserParam username,
      @QueryParam(DoAsParam.NAME) @DefaultValue(DoAsParam.DEFAULT)
          final DoAsParam doAsUser,
      @QueryParam(GetOpParam.NAME) @DefaultValue(GetOpParam.DEFAULT)
          final GetOpParam op,
      @QueryParam(OffsetParam.NAME) @DefaultValue(OffsetParam.DEFAULT)
          final OffsetParam offset,
      @QueryParam(LengthParam.NAME) @DefaultValue(LengthParam.DEFAULT)
          final LengthParam length,
      @QueryParam(RenewerParam.NAME) @DefaultValue(RenewerParam.DEFAULT)
          final RenewerParam renewer,
      @QueryParam(BufferSizeParam.NAME) @DefaultValue(BufferSizeParam.DEFAULT)
          final BufferSizeParam bufferSize,
      @QueryParam(XAttrNameParam.NAME) @DefaultValue(XAttrNameParam.DEFAULT)
          final List<XAttrNameParam> xattrNames,
      @QueryParam(XAttrEncodingParam.NAME) @DefaultValue(XAttrEncodingParam.DEFAULT)
          final XAttrEncodingParam xattrEncoding
      ) throws IOException, InterruptedException {
    return get(ugi, delegation, username, doAsUser, ROOT, op, offset, length,
        renewer, bufferSize, xattrNames, xattrEncoding);
  }

  /** Handle HTTP GET request. */
  @GET
  @Path("{" + UriFsPathParam.NAME + ":.*}")
  @Produces({MediaType.APPLICATION_OCTET_STREAM, MediaType.APPLICATION_JSON})
  public Response get(
      @Context final UserGroupInformationPlaceHolder ugi,
      @QueryParam(DelegationParam.NAME) @DefaultValue(DelegationParam.DEFAULT)
          final DelegationParam delegation,
      @QueryParam(UserParam.NAME) @DefaultValue(UserParam.DEFAULT)
          final UserParam username,
      @QueryParam(DoAsParam.NAME) @DefaultValue(DoAsParam.DEFAULT)
          final DoAsParam doAsUser,
      @PathParam(UriFsPathParam.NAME) final UriFsPathParam path,
      @QueryParam(GetOpParam.NAME) @DefaultValue(GetOpParam.DEFAULT)
          final GetOpParam op,
      @QueryParam(OffsetParam.NAME) @DefaultValue(OffsetParam.DEFAULT)
          final OffsetParam offset,
      @QueryParam(LengthParam.NAME) @DefaultValue(LengthParam.DEFAULT)
          final LengthParam length,
      @QueryParam(RenewerParam.NAME) @DefaultValue(RenewerParam.DEFAULT)
          final RenewerParam renewer,
      @QueryParam(BufferSizeParam.NAME) @DefaultValue(BufferSizeParam.DEFAULT)
          final BufferSizeParam bufferSize,
      @QueryParam(XAttrNameParam.NAME) @DefaultValue(XAttrNameParam.DEFAULT)
          final List<XAttrNameParam> xattrNames,
      @QueryParam(XAttrEncodingParam.NAME) @DefaultValue(XAttrEncodingParam.DEFAULT)
          final XAttrEncodingParam xattrEncoding
      ) throws IOException, InterruptedException {

    switch(op.getValue()) {
      case OPEN:
      {
        // @TODO: Implement me!
        return notYetImplemented();
      }
      case GET_BLOCK_LOCATIONS:
      {
        // @TODO: Implement me!
        return notYetImplemented();
      }
      case GETFILESTATUS:
      {
        // @TODO: Implement me!
        return notYetImplemented();
      }
      case LISTSTATUS:
      {
        // @TODO: Implement me!
        return notYetImplemented();
      }
      case GETCONTENTSUMMARY:
      {
        // @TODO: Implement me!
        return notYetImplemented();
      }
      case GETFILECHECKSUM:
      {
        // @TODO: Implement me!
        return notYetImplemented();
      }
      case GETDELEGATIONTOKEN:
      {
        // @TODO: Implement me!
        return notYetImplemented();
      }
      case GETHOMEDIRECTORY:
      {
        // @TODO: Implement me!
        return notYetImplemented();
      }
      case GETACLSTATUS: {
        // @TODO: Implement me!
        return notYetImplemented();
      }
      case GETXATTRS: {
        // @TODO: Implement me!
        return notYetImplemented();
      }
      case LISTXATTRS: {
        // @TODO: Implement me!
        return notYetImplemented();
      }
//      case CHECKACCESS: {
//        // @TODO: Implement me!
//        return notYetImplemented();
//      }
      default: {
         throw new UnsupportedOperationException(op + " is not supported");
      }
    }
  }

  public Response notYetImplemented() {
    throw new UnsupportedOperationException("Not yet supported");
  }
}
