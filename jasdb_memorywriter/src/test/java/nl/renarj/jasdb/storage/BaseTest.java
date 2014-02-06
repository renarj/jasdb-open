package nl.renarj.jasdb.storage;

import junit.framework.Assert;

import java.io.File;

public abstract class BaseTest {
	protected static File tmpDir = new File(System.getProperty("java.io.tmpdir"));
	
	protected static void assertDelete(File deleteFile) {
		if(deleteFile.exists()) {
			Assert.assertTrue(deleteFile.delete());
		}
	}
}
