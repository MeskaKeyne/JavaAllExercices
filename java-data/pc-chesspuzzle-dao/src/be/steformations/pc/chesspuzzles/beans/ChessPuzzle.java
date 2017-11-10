package be.steformations.pc.chesspuzzles.beans;

public interface ChessPuzzle extends java.io.Serializable {

	Integer getRank();
	String getSan();
	String getFen();
}
