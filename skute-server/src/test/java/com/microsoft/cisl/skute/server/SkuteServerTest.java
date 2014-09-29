package com.microsoft.cisl.skute.server;

import com.microsoft.cisl.skute.filesystem.SkuteFileSystem;
import com.sun.net.httpserver.HttpServer;
import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.*;
import static com.jayway.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class SkuteServerTest {


  @Test
  public void sanityCheck() throws Exception {
    SkuteFileSystem sfs = new ChattySkuteFileSystem();
    SkuteHttpServer shs = new SkuteHttpServer(SkuteServer.DEFAULT_PORT, sfs);

    shs.start();

    try {
      given()
          .port(SkuteServer.DEFAULT_PORT).
          get("/lotto").then().body("lotto.lottoId", equalTo(5));

    } finally {
      shs.stop();
    }
  }
}