package be.steformations.pc.chesspuzzles.jsf.actions;

import be.steformations.pc.chesspuzzles.beans.ChessPuzzle;
import be.steformations.pc.chesspuzzles.ejb.ChesspuzzleEjbService;

@javax.faces.bean.ManagedBean
@javax.faces.bean.RequestScoped
public class Update {

	@javax.ejb.EJB
	private ChesspuzzleEjbService dao;
	@javax.faces.bean.ManagedProperty("#{result}")
	private Result result;
	private int rank;
	private String san;
	
	public void setResult(Result result) {
		this.result = result;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getSan() {
		return san;
	}

	public void setSan(String san) {
		this.san = san;
	}
	
	public String execute() {
		ChessPuzzle puzzle = this.dao.update(this.rank, this.san);
		this.result.setPuzzle(puzzle);
		return null;
	}
}
