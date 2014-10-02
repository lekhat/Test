package com.microsoft.cisl.skute.server;

import com.microsoft.cisl.skute.SkuteHttpServer;
import com.microsoft.cisl.skute.SkuteHttpServerBuilder;
import com.microsoft.cisl.skute.filesystem.SkuteFileSystem;
import com.microsoft.cisl.skute.filesystem.SkuteResult;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;
import static org.mockito.Mockito.*;

public class SkuteServerTest {
  private static final Log LOG = LogFactory.getLog(SkuteServerTest.class);

  final public String PREFIX = "/webhdfs/v1";

  @BeforeClass
  static public void beforeClass() {
    LogManager.getLogger("com.microsoft.cisl.skute").setLevel(Level.TRACE);
  }

  @Test
  public void mkdirSucceedsWhenExpected() throws Exception {
    SkuteFileSystem sfs = when(mock(SkuteFileSystem.class)
        .mkdir("/howdy", (short) 0755))
        .thenReturn(SkuteResult.OK)
        .getMock();


    SkuteHttpServer shs = new SkuteHttpServerBuilder()
        .setPort(SkuteServer.DEFAULT_PORT)
        .setServerPackage(SkuteServer.class.getPackage())
        .setSkuteFileSystem(sfs)
        .build();

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

//  @Test
//  @Ignore
//  public void cheat() throws URISyntaxException, IOException {
//    FileSystem fs = FileSystem.get(new URI("webhdfs://localhost:8000"), new Configuration());
//
//    fs.mkdirs(new Path("/howdy"));
//  }
}