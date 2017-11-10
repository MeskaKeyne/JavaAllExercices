package be.steformations.pc.chesspuzzles.jsf.actions;

import be.steformations.pc.chesspuzzles.beans.ChessPuzzle;
import be.steformations.pc.chesspuzzles.ejb.ChesspuzzleEjbService;

@javax.faces.bean.ManagedBean
@javax.faces.bean.RequestScoped
public class Read {

	@javax.ejb.EJB
	private ChesspuzzleEjbService dao;
	@javax.faces.bean.ManagedProperty("#{result}")
	private Result result;
	private int rank;
	
	public void setResult(Result result) {
		this.result = result;
	}
	
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	public int getRank() {
		return rank;
	}
	
	public String execute() {
		ChessPuzzle puzzle = this.dao.read(this.rank);
		this.result.setPuzzle(puzzle);
		return null;
	}
}
