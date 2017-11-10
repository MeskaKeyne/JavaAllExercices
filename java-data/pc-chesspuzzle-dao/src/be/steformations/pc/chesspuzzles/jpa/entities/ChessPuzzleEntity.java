package be.steformations.pc.chesspuzzles.jpa.entities;

import be.steformations.pc.chesspuzzles.beans.ChessPuzzle;

@javax.persistence.Entity(name="ChessPuzzle")
@javax.persistence.Table(name="ChessPuzzles")
@javax.persistence.NamedQueries({
	@javax.persistence.NamedQuery(name="findAllRanks", query="select c.rank from ChessPuzzle c order by c.rank"),
})
public class ChessPuzzleEntity implements ChessPuzzle {

	private static final long serialVersionUID = 6325191033970196912L;

	@javax.persistence.Id protected Integer rank;
	protected String san;
	protected String fen;
	
	public Integer getRank() {
		return rank;
	}
	
	public void setRank(Integer rank) {
		this.rank = rank;
	}
	
	public String getSan() {
		return san;
	}
	
	public void setSan(String san) {
		this.san = san;
	}
	
	public String getFen() {
		return fen;
	}
	
	public void setFen(String fen) {
		this.fen = fen;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fen == null) ? 0 : fen.hashCode());
		result = prime * result + ((rank == null) ? 0 : rank.hashCode());
		result = prime * result + ((san == null) ? 0 : san.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChessPuzzleEntity other = (ChessPuzzleEntity) obj;
		if (fen == null) {
			if (other.fen != null)
				return false;
		} else if (!fen.equals(other.fen))
			return false;
		if (rank == null) {
			if (other.rank != null)
				return false;
		} else if (!rank.equals(other.rank))
			return false;
		if (san == null) {
			if (other.san != null)
				return false;
		} else if (!san.equals(other.san))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ChessPuzzleEntity [rank=" + rank + ", san=" + san + ", fen=" + fen + "]";
	}
}
