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
package com.microsoft.cisl.skute;

import com.microsoft.cisl.skute.filesystem.SkuteFileSystem;
import com.microsoft.cisl.skute.filesystem.SkuteFileSystemFactory;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Properties;

public class Utils {
  private static final Log LOG = LogFactory.getLog(Utils.class);

  @SuppressWarnings("unchecked")
  static<T> T instantiateObject(String classname) throws Exception {
    try {
      Class klass = Class.forName(classname);

      return (T)klass.newInstance();
    } catch (ClassNotFoundException e) {
      throw new Exception(e);
    }
  }

  public static SkuteFileSystem getSkuteFileSystem(Config config) throws Exception {
    String factoryString = config.getString("skute.fs.factory");
    if(factoryString == null) {
      throw new IllegalArgumentException("Must specify Skute filesystem factory (skute.fs.factory)");
    }

    SkuteFileSystemFactory factory = Utils.instantiateObject(factoryString);
    return factory.getSkuteFileSystem(new Properties());
  }

  public static void runServer(Package pckg, String [] args) throws Exception {
    Config conf = ConfigFactory.load();
    if (LOG.isDebugEnabled()) {
      LOG.debug("Conf = " + conf.toString());
    }

    SkuteFileSystem fs = Utils.getSkuteFileSystem(conf);

    if (LOG.isInfoEnabled()) {
      LOG.info("Starting with Skute Filesystem = " + fs);
    }

    int port = conf.getInt("skute.http.server.port");

    if (LOG.isInfoEnabled()) {
      LOG.info("Skute HTTP server port = " + port);
    }


    SkuteHttpServer shs = new SkuteHttpServerBuilder()
        .setPort(port)
        .setServerPackage(pckg)
        .setSkuteFileSystem(fs)
        .build();

    if (LOG.isInfoEnabled()) {
      LOG.info("Starting Skute HTTP server.");
    }

    shs.start();

    try {
      if (LOG.isInfoEnabled()) {
        LOG.info("Putting main thread to sleep. Nighty night.");
      }

      Thread.sleep(Long.MAX_VALUE);
    } catch(InterruptedException ie) {
      if (LOG.isInfoEnabled()) {
        LOG.info("Caught interrupted exception. Exiting.", ie);
        shs.stop();
        return;
      }
    }

  }
}
