package be.steformations.pc.chesspuzzles.ejb.client.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import be.steformations.pc.chesspuzzles.ejb.client.ChessPuzzleEjbServiceClient;

public class TestPing {

	private ChessPuzzleEjbServiceClient client;
	
	@Before
	public void setUp() throws Exception {
		this.client = new ChessPuzzleEjbServiceClient();
	}

	@Test
	public void testPing() {
		this.client.ping();
	}

}
