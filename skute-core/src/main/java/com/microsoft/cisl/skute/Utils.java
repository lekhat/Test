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

import java.util.Map;
import java.util.Properties;

public class Utils {
  @SuppressWarnings("unchecked")
  static<T> T instantiateObject(String classname) throws Exception {
    try {
      Class klass = Class.forName(classname);

      return (T)klass.newInstance();
    } catch (ClassNotFoundException e) {
      throw new Exception(e);
    }
  }

  public static SkuteFileSystem getSkuteFileSystem(String factoryString) throws Exception {
    if(factoryString == null) {
      throw new IllegalArgumentException("Must specify skutefsFactory");
    }

    SkuteFileSystemFactory factory = Utils.instantiateObject(factoryString);
    return factory.getSkuteFileSystem(new Properties());
  }

  public static void runServer(Package pckg, String [] args) throws Exception {
    Map<String, String> options = OptionsExtractor.buildOptions(args);

    int sleepSecs = Integer.valueOf(options.get("sleepsecs"));
    SkuteFileSystem fs = Utils.getSkuteFileSystem(options.get("skutefsFactory"));
    int port = Integer.valueOf(options.get("port"));

    SkuteHttpServer shs = new SkuteHttpServerBuilder()
        .setPort(port)
        .setServerPackage(pckg)
        .setSkuteFileSystem(fs)
        .build();

    shs.start();

    Thread.sleep(sleepSecs);

    shs.stop();
  }
}
