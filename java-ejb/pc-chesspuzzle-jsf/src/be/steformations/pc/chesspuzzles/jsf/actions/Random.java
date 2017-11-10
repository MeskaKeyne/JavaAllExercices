package be.steformations.pc.chesspuzzles.jsf.actions;

import be.steformations.pc.chesspuzzles.beans.ChessPuzzle;
import be.steformations.pc.chesspuzzles.ejb.ChesspuzzleEjbService;

@javax.faces.bean.ManagedBean
@javax.faces.bean.RequestScoped
public class Random {
	
	@javax.ejb.EJB
	private ChesspuzzleEjbService dao;
	@javax.faces.bean.ManagedProperty("#{result}")
	private Result result;
	
	public void setResult(Result result) {
		this.result = result;
	}
	
	public String execute() {
		ChessPuzzle puzzle = this.dao.random();
		this.result.setPuzzle(puzzle);
		return null;
	}
}
