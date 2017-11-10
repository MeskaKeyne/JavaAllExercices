package be.steformations.pc.jacula.io.client;

import be.steformations.pc.jacula.io.service.StorageService;

public class StorageClient {

	private StorageService storageService;
	
	public StorageClient(StorageService storageService) {
		super();
		this.storageService = storageService;
	}

	public boolean save(int clientId, int jobId, String filePath) {
		boolean saved = false;
		
		try {
			java.nio.file.Path path = java.nio.file.Paths.get(filePath);
			System.out.println("StorageClient.save() => " + path);
			if (path.toFile().exists() && path.toFile().canRead()) {
				java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
				java.nio.file.Files.copy(path, out);
				this.storageService.saveBackup(clientId, jobId, filePath, out.toByteArray());			
				saved = true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return saved;
	}
	
	public boolean restore(int clientId, int jobId, String filePath) {
		boolean restored = false;
		
		try {
			java.nio.file.Path path = java.nio.file.Paths.get(filePath);
			System.out.println("StorageClient.restore() => " + path);
			java.nio.file.Files.createDirectories(path.getParent());
			byte[] backupContent = this.storageService.getBackup(clientId, jobId, filePath);
			java.io.ByteArrayInputStream in = new java.io.ByteArrayInputStream(backupContent);
			java.nio.file.Files.copy(in, path, java.nio.file.StandardCopyOption.REPLACE_EXISTING);
			restored = true;

		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return restored;
	}

}
