package com.microsoft.cisl.skute.hadoop.filesystem;

import com.microsoft.cisl.skute.filesystem.SkuteFileSystem;
import com.typesafe.config.Config;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hdfs.DistributedFileSystem;
import org.apache.hadoop.hdfs.MiniDFSCluster;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SkuteHadoopFileSystemTest {
  static Configuration conf = null;
  static MiniDFSCluster cluster = null;
  static SkuteFileSystem fs = null;
  @BeforeClass
  static public void setUpMiniCluster() throws Exception {
    conf = new Configuration();
    cluster = new MiniDFSCluster.Builder(conf).build();

    URI uri = cluster.getURI();

    Config config = mock(Config.class);
    when(config.getString(SkuteHadoopFileSystemFactory.URI_KEY)).thenReturn(uri.toString());

    fs = new SkuteHadoopFileSystemFactory().getSkuteFileSystem(config);
    fs.start();
  }

  @Test
  public void mkdirsWorks() throws Exception {
    fs.mkdir("/a", (short) 0456);

    assertTrue("Directory was created on HDFS", getMiniDFSFileSystem().isDirectory(new Path("/a")));

    getMiniDFSFileSystem().delete(new Path("/a"), false);
  }

  @Test
  public void deleteWorks() throws Exception {

    // Write through the minidfs, but delete through SkuteFileSystem
    String file = "tobedeleted";

    FSDataOutputStream os = getMiniDFSFileSystem().create(new Path(file));
    os.write(42);
    os.close();

    assertTrue(getMiniDFSFileSystem().exists(new Path(file)));

    fs.delete(file, false);

    assertFalse(getMiniDFSFileSystem().exists(new Path(file)));
  }

  private DistributedFileSystem getMiniDFSFileSystem() throws IOException {
    return cluster.getFileSystem();
  }

  @AfterClass
  static public void shutDownMiniCluster() throws Exception {
    if(fs != null) {
      fs.stop();
    }

    if(cluster != null) {
      cluster.shutdown(true);
    }
  }
}