package be.steformations.pc.chesspuzzles.dao;

import be.steformations.pc.chesspuzzles.beans.ChessPuzzle;

public interface ChessPuzzleDao {

	ChessPuzzle findOneByRank(int rank);
	ChessPuzzle findOneRandom();
	ChessPuzzle createAndSave(String san, String fen);
	ChessPuzzle update(int rank, String san);
	ChessPuzzle remove(int rank);
}
