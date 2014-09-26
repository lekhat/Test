package com.microsoft.cisl.skute.filesystem;

import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.Properties;

import static org.junit.Assert.*;

public class LocalSkuteFileSystemTest {

  SkuteFileSystem fs = null;

  Path rootFolder = null;
  private SkuteFileSystem getFS() {
    if(fs == null) {
      fail("SkuteFileSystem has not been initialized!");
    }

    return fs;
  }

  private Path getPath(String s) {
    return FileSystems.getDefault().getPath(s);
  }

  @Before
  public void setUp() throws Exception {
    TemporaryFolder tf = null;
    if (System.getProperty("test.build.dir") == null) {
      tf = new TemporaryFolder();
    } else {
      tf = new TemporaryFolder(new File(System.getProperty("test.build.dir")));
    }
    tf.create();

    rootFolder = getPath(tf.getRoot().toString());

    Properties properties = new Properties();
    properties.put(LocalSkuteFileSystemFactory.ROOT, rootFolder.toString());

    fs = new LocalSkuteFileSystemFactory().getSkuteFileSystem(properties);

    fs.start();
  }

  @After
  public void tearDown() throws Exception {
    fs.stop();
  }

  @Test
  public void testMkdir() throws Exception {
    getFS().mkdir("/a", (short)0755);

    Path p = getPath(rootFolder + "/a");

    assertTrue("Directory does not exist.", Files.exists(p));
  }
}