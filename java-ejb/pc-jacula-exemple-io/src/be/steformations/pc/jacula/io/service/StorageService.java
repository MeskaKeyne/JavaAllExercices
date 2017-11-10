package be.steformations.pc.jacula.io.service;

public class StorageService {

	private String backupsBaseDirectoryPath;
	
	public StorageService(String backupsBaseDirectoryPath) {
		super();
		this.backupsBaseDirectoryPath = backupsBaseDirectoryPath;
	}

	public void saveBackup(int clientId, int jobId, String filePath, byte[] fileContent) 
			throws Exception {
		java.nio.file.Path path = java.nio.file.Paths.get(
				backupsBaseDirectoryPath, String.valueOf(clientId), String.valueOf(jobId), filePath);
		System.out.println("StorageService.saveBackup() => " + path);
		java.nio.file.Files.createDirectories(path.getParent());
		java.io.ByteArrayInputStream in = new java.io.ByteArrayInputStream(fileContent, 0, fileContent.length);
		java.nio.file.Files.copy(in, path);
	}
	
	public byte[] getBackup(Integer clientId, Integer jobId, String filePath) 
			throws Exception {
		java.nio.file.Path path = java.nio.file.Paths.get(
				backupsBaseDirectoryPath, String.valueOf(clientId), String.valueOf(jobId), filePath);
		System.out.println("StorageService.getBackup() => " + path);
		java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
		java.nio.file.Files.copy(path, out);
		
		return out.toByteArray();
	}
}
