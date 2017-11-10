package be.steformations.pc.chesspuzzles.ejb.client;

import be.steformations.pc.chesspuzzles.dto.ChessPuzzleDto;
import be.steformations.pc.chesspuzzles.ejb.ChesspuzzleEjbService;

public class ChessPuzzleEjbServiceClient {

	private String jndi 
		= "java:global/pc-chesspuzzle-ear/pc-chesspuzzle-ejb-service/ChesspuzzleEjbServiceImpl";

	private ChesspuzzleEjbService service;
	
	public ChessPuzzleEjbServiceClient() throws Exception {
		super();
		java.util.Properties properties = new java.util.Properties();
		properties.put("java.naming.provider.url", "localhost:3700");
		javax.naming.InitialContext cxt = new javax.naming.InitialContext(properties);
		this.service = (ChesspuzzleEjbService) cxt.lookup(jndi);
	}

	public void ping() {
		this.service.ping();
	}

	public ChessPuzzleDto random() {
		return service.random();
	}

	public ChessPuzzleDto create(String fen, String san) {
		return service.create(fen, san);
	}

	public ChessPuzzleDto read(int id) {
		return service.read(id);
	}

	public ChessPuzzleDto update(int id, String san) {
		return service.update(id, san);
	}

	public ChessPuzzleDto delete(int id) {
		return service.delete(id);
	}
	
	
}
