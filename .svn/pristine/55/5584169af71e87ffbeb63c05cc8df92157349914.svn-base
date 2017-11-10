package be.steformations.pc.jacula.io.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import be.steformations.pc.jacula.io.client.StorageClient;
import be.steformations.pc.jacula.io.service.StorageService;

public class TestBackupThenRestore {

	private java.util.Random random = new java.util.Random();
	private StorageClient storageClient;
	
	@Before
	public void setUp() throws Exception {
		java.net.URL backupBasePath = this.getClass().getResource("/data/backups");
		StorageService storageService = new StorageService(backupBasePath.getFile());
		this.storageClient = new StorageClient(storageService);
	}

	@Test
	public void testBackupThenRestore() throws Exception {
		String sourceFilePath = this.getClass().getResource("/data/source/test.txt").getFile();
		int clientId = this.random.nextInt(Short.MAX_VALUE);
		int jobId = this.random.nextInt(Short.MAX_VALUE);
		assertTrue(this.storageClient.save(clientId, jobId, sourceFilePath));
		assertTrue(this.storageClient.restore(clientId, jobId, sourceFilePath));
	}

}
