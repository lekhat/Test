package com.microsoft.cisl.skute.server;

import com.microsoft.cisl.skute.SkuteHttpServer;
import com.microsoft.cisl.skute.SkuteHttpServerBuilder;
import com.microsoft.cisl.skute.filesystem.SkuteFileSystem;
import com.microsoft.cisl.skute.filesystem.SkuteResult;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import static com.jayway.restassured.RestAssured.given;
import static org.mockito.Mockito.*;

public class SkuteServerTest {
  private static final Log LOG = LogFactory.getLog(SkuteServerTest.class);

  final public String PREFIX = "/webhdfs/v1";

  @BeforeClass
  static public void beforeClass() {
    LogManager.getLogger("com.microsoft.cisl.skute").setLevel(Level.TRACE);
  }

  private SkuteHttpServer getSkuteHttpServer(SkuteFileSystem sfs) throws Exception {
    return new SkuteHttpServerBuilder()
          .setPort(SkuteServer.DEFAULT_PORT)
          .setServerPackage(SkuteServer.class.getPackage())
          .setSkuteFileSystem(sfs)
          .build();
  }

  @Test
  public void mkdirSucceedsWhenExpected() throws Exception {
    SkuteFileSystem sfs = when(mock(SkuteFileSystem.class)
        .mkdir("/howdy", (short) 0755))
        .thenReturn(SkuteResult.OK)
        .getMock();


    SkuteHttpServer shs = getSkuteHttpServer(sfs);

    LOG.info("SkuteHttpServer = " + shs);

    shs.start();

    try {
      given()
          .port(SkuteServer.DEFAULT_PORT)
          .param("op", "mkdirs")
          .put(PREFIX + "/howdy")
          .then()
          .statusCode(200);
    } finally {
      shs.stop();
    }
    verify(sfs).mkdir("/howdy", (short) 0755);
  }

  @Test
  public void deleteRecursiveSucceedsWhenExpected() throws Exception {
    testSuccessfulDelete(true);
  }

  @Test
  public void deleteNonRecursiveSucceedsWhenExpected() throws Exception {
    testSuccessfulDelete(false);
  }

  private void testSuccessfulDelete(boolean recursive) throws Exception {
    final String PATH = "/deleteme";
    SkuteFileSystem sfs = when(mock(SkuteFileSystem.class)
        .delete(PATH, recursive))
        .thenReturn(SkuteResult.OK)
        .getMock();


    SkuteHttpServer shs = getSkuteHttpServer(sfs);

    LOG.info("SkuteHttpServer = " + shs);

    shs.start();

    try {
      given()
          .port(SkuteServer.DEFAULT_PORT)
          .param("op", "delete")
          .param("recursive", recursive ? "true" : "false")
          .delete(PREFIX + PATH)
          .then()
          .statusCode(200);
    } finally {
      shs.stop();
    }
    verify(sfs).delete(PATH, recursive);
  }

  // When run against a local web server, this is a very good quick way of seeing
  // exactly what WebHDFSFileSystem is requesting...
  @Test
  @Ignore
  public void cheat() throws URISyntaxException, IOException {
    FileSystem fs = FileSystem.get(new URI("webhdfs://localhost:8000"), new Configuration());

    fs.delete(new Path("/howdy"), true);
  }
}