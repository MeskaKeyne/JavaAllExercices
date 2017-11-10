package be.steformations.pc.chesspuzzles.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import be.steformations.pc.chesspuzzles.beans.ChessPuzzle;
import be.steformations.pc.chesspuzzles.dao.ChessPuzzleDao;
import be.steformations.pc.chesspuzzles.jpa.repositories.JpaChessPuzzleRepository;

public class TestJpaChessPuzzleRepository {

	private ChessPuzzleDao dao;
	
	@Before
	public void setUp() throws Exception {
		javax.persistence.EntityManager em
			= javax.persistence.Persistence.createEntityManagerFactory("chesspuzzle_sqlite3")
				.createEntityManager();
		this.dao = new JpaChessPuzzleRepository(em);
	}

	@Test
	public void testFindOneByRank() {
		int rank = 100;
		String fen = "1K6/1pn5/k7/1p6/2N5/4B2Q/8/8 w - - 0 1";
		String san = "1. Qd7 1-0";
		ChessPuzzle puzzle = this.dao.findOneByRank(rank);
		assertNotNull(puzzle);
		assertEquals(new Integer(rank), puzzle.getRank());
		assertEquals(fen, puzzle.getFen());
		assertEquals(san, puzzle.getSan());
	}

	@Test
	public void testFindOneRandom() {
		ChessPuzzle puzzle = this.dao.findOneRandom();
		assertNotNull(puzzle);
		assertNotNull(puzzle.getRank());
		assertNotNull(puzzle.getFen());
		assertNotNull(puzzle.getSan());
		assertEquals(puzzle, this.dao.findOneByRank(puzzle.getRank()));
	}

	@Test
	public void testUpdate() {
		int rank = 100;
		String fen = "1K6/1pn5/k7/1p6/2N5/4B2Q/8/8 w - - 0 1";
		String san = "1. Qd7 1-0";
		ChessPuzzle puzzle = this.dao.findOneByRank(rank);
		assertNotNull(puzzle);
		assertEquals(new Integer(rank), puzzle.getRank());
		assertEquals(fen, puzzle.getFen());
		assertEquals(san, puzzle.getSan());
		
		String updatedSan = "1. Qd8 1-0";
		ChessPuzzle updated = this.dao.update(rank, updatedSan);
		assertNotNull(updated);
		assertEquals(new Integer(rank), updated.getRank());
		assertEquals(fen, updated.getFen());
		assertEquals(updatedSan, updated.getSan());
		
		updated = this.dao.update(rank, san);
		assertEquals(puzzle, updated);
	}
	
	@Test
	public void testCreateAndSaveAndRemove() {
		String fen = "1K6/1pn5/k7/1p6/2N5/4B2Q/8/8 w - - 0 1";
		String san = "1. Qd7 1-0";
		ChessPuzzle puzzle = this.dao.createAndSave(san, fen);
		assertNotNull(puzzle);
		assertNotNull(puzzle.getRank());
		assertEquals(fen, puzzle.getFen());
		assertEquals(san, puzzle.getSan());
		assertEquals(puzzle, this.dao.findOneByRank(puzzle.getRank()));
		assertEquals(puzzle, this.dao.remove(puzzle.getRank()));
		assertNull(this.dao.findOneByRank(puzzle.getRank()));
	}

}
