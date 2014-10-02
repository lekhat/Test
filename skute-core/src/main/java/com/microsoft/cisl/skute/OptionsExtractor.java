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

import org.apache.commons.cli.*;

import java.util.HashMap;
import java.util.Map;

public class OptionsExtractor {


  // Dead simple options
  public static Map<String, String> buildOptions(String [] args) throws Exception {
        // Handle common line options
    Option portOption = OptionBuilder
        .withArgName("port")
        .hasArg()
        .withDescription("Port to start server on.")
        .create("port");
    Option sleepOption = OptionBuilder
        .withArgName("sleepsecs")
        .hasArg()
        .withDescription("Time in seconds to let server run before exiting. If not specified, server will run forever.")
        .create("sleepsecs");
    Option skutefsFactoryOption = OptionBuilder
        .withArgName("skutefsFactory")
        .hasArg()
        .withDescription("Factory to create the backing SkuteFilesystem")
        .create("skutefsFactory");

    Options options = new Options();

    options.addOption(portOption)
        .addOption(sleepOption)
        .addOption(skutefsFactoryOption);

    CommandLineParser parser = new BasicParser();
    CommandLine commandLine = null;
    try {
      commandLine = parser.parse(options, args);
    } catch (ParseException e) {
      throw new Exception(e);
    }

    HashMap<String, String> optionsMap = new HashMap<>();

    optionsMap.put("skutefsFactory", commandLine.getOptionValue("skutefsFactory"));
    optionsMap.put("port", commandLine.getOptionValue("port", "7552"));
    optionsMap.put("sleepsecs", commandLine.getOptionValue("sleepsecs", Integer.toString(Integer.MAX_VALUE)));

    return optionsMap;
  }
}
