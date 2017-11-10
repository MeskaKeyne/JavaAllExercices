package be.steformations.pc.chesspuzzles.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import be.steformations.pc.chesspuzzles.dto.ChessPuzzleDto;
import be.steformations.pc.chesspuzzles.soap.ChessPuzzleSoapClient;

public class TestChessPuzzleSoapClient {

	private ChessPuzzleSoapClient client;
	
	@Before
	public void setUp() throws Exception {
		this.client = new ChessPuzzleSoapClient("http://localhost:8080/chesspuzzle-soap");
	}

	@Test
	public void testFindOneByRank() {
		int rank = 100;
		String fen = "1K6/1pn5/k7/1p6/2N5/4B2Q/8/8 w - - 0 1";
		String san = "1. Qd7 1-0";
		ChessPuzzleDto puzzle = this.client.findOneByRank(rank);
		assertNotNull(puzzle);
		assertEquals(new Integer(rank), puzzle.getRank());
		assertEquals(fen, puzzle.getFen());
		assertEquals(san, puzzle.getSan());
	}

	@Test
	public void testFindOneRandom() {
		ChessPuzzleDto puzzle = this.client.findOneRandom();
		assertNotNull(puzzle);
		assertNotNull(puzzle.getRank());
		assertNotNull(puzzle.getFen());
		assertNotNull(puzzle.getSan());
		assertEquals(puzzle, this.client.findOneByRank(puzzle.getRank()));
	}

	@Test
	public void testUpdate() {
		int rank = 100;
		String fen = "1K6/1pn5/k7/1p6/2N5/4B2Q/8/8 w - - 0 1";
		String san = "1. Qd7 1-0";
		ChessPuzzleDto puzzle = this.client.findOneByRank(rank);
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
		ChessPuzzleDto puzzle = this.client.createAndSave(san, fen);
		assertNotNull(puzzle);
		assertNotNull(puzzle.getRank());
		assertEquals(fen, puzzle.getFen());
		assertEquals(san, puzzle.getSan());
		assertEquals(puzzle, this.client.findOneByRank(puzzle.getRank()));
		assertEquals(puzzle, this.client.remove(puzzle.getRank()));
		assertNull(this.client.findOneByRank(puzzle.getRank()));
	}

}
