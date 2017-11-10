package be.steformations.pc.chesspuzzles.ejb.client.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import be.steformations.pc.chesspuzzles.dto.ChessPuzzleDto;
import be.steformations.pc.chesspuzzles.ejb.client.ChessPuzzleEjbServiceClient;

public class TestChessPuzzleEjbClient {

	private ChessPuzzleEjbServiceClient client;
	
	@Before
	public void setUp() throws Exception {
		this.client = new ChessPuzzleEjbServiceClient();
	}

	@Test
	public void testFindOneByRank() {
		int rank = 100;
		String fen = "1K6/1pn5/k7/1p6/2N5/4B2Q/8/8 w - - 0 1";
		String san = "1. Qd7 1-0";
		ChessPuzzleDto puzzle = this.client.read(rank);
		assertNotNull(puzzle);
		assertEquals(new Integer(rank), puzzle.getRank());
		assertEquals(fen, puzzle.getFen());
		assertEquals(san, puzzle.getSan());
	}

	@Test
	public void testFindOneRandom() {
		ChessPuzzleDto puzzle = this.client.random();
		assertNotNull(puzzle);
		assertNotNull(puzzle.getRank());
		assertNotNull(puzzle.getFen());
		assertNotNull(puzzle.getSan());
		assertEquals(puzzle, this.client.read(puzzle.getRank()));
	}

	@Test
	public void testUpdate() {
		int rank = 100;
		String fen = "1K6/1pn5/k7/1p6/2N5/4B2Q/8/8 w - - 0 1";
		String san = "1. Qd7 1-0";
		ChessPuzzleDto puzzle = this.client.read(rank);
		assertNotNull(puzzle);
		assertEquals(new Integer(rank), puzzle.getRank());
		assertEquals(fen, puzzle.getFen());
		assertEquals(san, puzzle.getSan());
		
		String updatedSan = "1. Qd8 1-0";
		ChessPuzzleDto updated = this.client.update(rank, updatedSan);
		assertNotNull(updated);
		assertEquals(new Integer(rank), updated.getRank());
		assertEquals(fen, updated.getFen());
		assertEquals(updatedSan, updated.getSan());
		
		updated = this.client.update(rank, san);
		assertEquals(puzzle, updated);
	}
	
	@Test
	public void testCreateAndSaveAndRemove() {
		String fen = "1K6/1pn5/k7/1p6/2N5/4B2Q/8/8 w - - 0 1";
		String san = "1. Qd7 1-0";
		ChessPuzzleDto puzzle = this.client.create(fen, san);
		assertNotNull(puzzle);
		assertNotNull(puzzle.getRank());
		assertEquals(fen, puzzle.getFen());
		assertEquals(san, puzzle.getSan());
		assertEquals(puzzle, this.client.read(puzzle.getRank()));
		assertEquals(puzzle, this.client.delete(puzzle.getRank()));
		assertNull(this.client.read(puzzle.getRank()));
	}

}
