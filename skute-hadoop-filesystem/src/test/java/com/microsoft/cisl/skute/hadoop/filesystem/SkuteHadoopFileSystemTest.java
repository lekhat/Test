package com.microsoft.cisl.skute.hadoop.filesystem;

import com.microsoft.cisl.skute.filesystem.SkuteFileSystem;
import com.typesafe.config.Config;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hdfs.MiniDFSCluster;
import org.junit.Test;

import java.net.URI;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SkuteHadoopFileSystemTest {

  @Test
  public void mkdirsWorks() throws Exception {
    Configuration conf = new Configuration();
    final MiniDFSCluster cluster = new MiniDFSCluster.Builder(conf).build();

    URI uri = cluster.getURI();

    Config config = mock(Config.class);
    when(config.getString(SkuteHadoopFileSystemFactory.URI_KEY)).thenReturn(uri.toString());

    SkuteFileSystem fs = new SkuteHadoopFileSystemFactory().getSkuteFileSystem(config);

    fs.start();

    fs.mkdir("/a", (short) 0456);

    assertTrue("Directory was created on HDFS", cluster.getFileSystem().isDirectory(new Path("/a")));
    fs.stop();
    cluster.shutdown(true);
  }
}