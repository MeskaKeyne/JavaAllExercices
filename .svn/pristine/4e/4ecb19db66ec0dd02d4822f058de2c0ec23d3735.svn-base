package be.steformations.pc.chesspuzzles.ejb.jobs;

import be.steformations.pc.chesspuzzles.dto.ChessPuzzleDto;
import be.steformations.pc.chesspuzzles.ejb.ChesspuzzleEjbService;
import be.steformations.pc.chesspuzzles.ejb.mail.ChessPuzzleMailSender;

@javax.ejb.Singleton
@javax.ejb.Startup
public class ChessPuzzleDailyJob {

	@javax.ejb.EJB
	private ChesspuzzleEjbService chesspuzzleEjbService;
	@javax.ejb.EJB
	private ChessPuzzleMailSender chessPuzzleMailSender;
	
	@javax.ejb.Schedule(hour="11", minute="22", second="1")
	public void execute(javax.ejb.Timer timer) {
		System.out.println("ChessPuzzleDailyJob.execute()");
		ChessPuzzleDto dto = this.chesspuzzleEjbService.random();
		this.chessPuzzleMailSender.sendmail("pascal.cornet@uliege.be", dto);
	}
}
