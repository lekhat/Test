Skute is a prototype WebHDFS proxy designed to demonstrate how to build a performant interface for existing WebHDFS clients to non-HDFS backing stores. It's being developed in Java using proven technology with a reasonable compromise between over- and under-engineering.

Skute structure-

* skute-filesystem: Yet another file system abstraction.  Used by Skute-server as its file system API.

* skute-server: REST endpoints that mirror entire WebHDFS APIs.
  ** Serve metadata requests.
  ** Redirect streaming requests to Skute-streamer.
  ** Interacts with backing store via skue-filesystem.
  ** Currently directly dependent on Hadoop jars, but this can be removed.

* skute-streamer: REST endpoints that mirror subset of WebHDFS APIs.
  ** Receive read/write requests, stream the data to the backing file store.
  ** Currently directly dependent on Hadoop jars, but this can be removed.

* skute-hadoop-filesystem: Skute-filesystem implemented against org.apache.hadoop.FileSystem.
  ** Allows skute-server to run against an existing Hadoop system, specifically HDFS or Chris' Shim layer.

* skute-webhdfs-test: The above four projects should allow everything to tie together directly.
  ** This project tests the correctness of the skute-server/streamer classes against minidfs clusters.

* (possible): skute-was-shim-layer: Implementation of skute-filesystem backed directly by Chris' JNI code.
  ** This would remove the intermediate org.apache.hadoop.FileSystem interface.
  ** May be useful for performance reasons.

* (possible): skute-client-net: .NET client for the WebHDFS protocols.
  ** May be necessary if current community implementations are not up to snuff.


CFE -> Skute-server (over REST/WebHDFS)[oah.FileSystem/Chris Shim Layer-> Secure store] -> Skute-streamer (over REST/WebHDFS)[oah.FileSystem/Chris Shim Layer -> Secure store]

Work estimates (1x - 1.5x multiplier):
* Initial code complete, 4 wks.
* WAS integration testing, 2 wks.
* Perf testing, 2-4 wks.
* Hand-off (what does this mean?) - 3 wks.

Open source points:
* Less-HDFS specific REST endpoints would be helpful.
* If performance is an issue, may take a look at Netty-backed frameworks. If these end up being helpful, should be backported.
* WADL-based client generation.

Questions:
* What is the final product? What is the WAS team going to do with it? Is this a prototype that will be re-implemented in .NET? Existing code to be built on?

Note:
* Am OOO Oct. 15 - Nov 1.