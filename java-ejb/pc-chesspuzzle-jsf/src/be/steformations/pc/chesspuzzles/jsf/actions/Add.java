package be.steformations.pc.chesspuzzles.jsf.actions;

import be.steformations.pc.chesspuzzles.beans.ChessPuzzle;
import be.steformations.pc.chesspuzzles.ejb.ChesspuzzleEjbService;

@javax.faces.bean.ManagedBean
@javax.faces.bean.RequestScoped
public class Add {

	@javax.ejb.EJB
	private ChesspuzzleEjbService dao;
	@javax.faces.bean.ManagedProperty("#{result}")
	private Result result;
	private String fen;
	private String san;
	
	public void setResult(Result result) {
		this.result = result;
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
	
	public String execute() {
		ChessPuzzle puzzle = this.dao.create(this.fen, this.san);
		this.result.setPuzzle(puzzle);
		return null;
	}
}
