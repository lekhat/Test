package com.microsoft.cisl.skute.hadoop.filesystem;

import com.microsoft.cisl.skute.filesystem.SkuteFileSystem;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hdfs.MiniDFSCluster;
import org.junit.Test;

import java.net.URI;
import java.util.Properties;

import static org.junit.Assert.assertTrue;

public class SkuteHadoopFileSystemTest {

  @Test
  public void mkdirsWorks() throws Exception {
    Configuration conf = new Configuration();
    final MiniDFSCluster cluster = new MiniDFSCluster.Builder(conf).build();

    URI uri = cluster.getURI();

    Properties props = new Properties();
    props.setProperty(SkuteHadoopFileSystemFactory.URI_KEY, uri.toString());

    SkuteFileSystem fs = new SkuteHadoopFileSystemFactory().getSkuteFileSystem(props);

    fs.start();

    fs.mkdir("/a", (short) 0456);

    assertTrue("Directory was created on HDFS", cluster.getFileSystem().isDirectory(new Path("/a")));
    fs.stop();
    cluster.shutdown(true);
  }
}