package be.steformations.pc.chesspuzzles.dto;

import be.steformations.pc.chesspuzzles.beans.ChessPuzzle;

@javax.xml.bind.annotation.XmlRootElement(name="chesspuzzle")
@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
public class ChessPuzzleDto implements ChessPuzzle {

	private static final long serialVersionUID = -1009840492453251691L;
	private Integer rank;
	private String fen;
	private String san;
	
	public ChessPuzzleDto() {
		super();
	}
	
	public ChessPuzzleDto(String fen, String san) {
		super();
		this.fen = fen;
		this.san = san;
	}

	public ChessPuzzleDto(Integer rank, String fen, String san) {
		super();
		this.rank = rank;
		this.fen = fen;
		this.san = san;
	}

	public Integer getRank() {
		return rank;
	}
	
	public void setRank(Integer rank) {
		this.rank = rank;
	}
	
	public String getFen() {
		return fen;
	}
	
	public void setFen(String fen) {
		this.fen = fen;
	}
	
	public String getSan() {
		return san;
	}
	
	public void setSan(String san) {
		this.san = san;
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
		ChessPuzzleDto other = (ChessPuzzleDto) obj;
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
		return "ChessPuzzleDto [rank=" + rank + ", fen=" + fen + ", san=" + san + "]";
	}
	
}
