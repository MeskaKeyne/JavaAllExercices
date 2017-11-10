package be.steformations.pc.chesspuzzles.ejb.jobs;

import be.steformations.pc.chesspuzzles.dto.ChessPuzzleDto;
import be.steformations.pc.chesspuzzles.ejb.mail.ChessPuzzleMailSender;

@javax.ejb.Singleton
public class ChessPuzzleDelayedSendmailJob {

	@javax.annotation.Resource
	private javax.ejb.TimerService timerService;
	@javax.ejb.EJB
	private ChessPuzzleMailSender chessPuzzleMailSender;
	
	public void programSend(ChessPuzzleDto dto) {
		System.out.println("ChessPuzzleDelayedSendmailJob.programSend()");
		java.util.Calendar c = java.util.GregorianCalendar.getInstance();
		c.add(java.util.Calendar.SECOND, 20);
		int hour = c.get(java.util.Calendar.HOUR_OF_DAY);
		int minute = c.get(java.util.Calendar.MINUTE);
		int second = c.get(java.util.Calendar.SECOND);
		System.out.println(String.format("sending mail at %s hour %s minutes %s seconds", hour, minute, second));
		javax.ejb.ScheduleExpression scheduleExpression 
			= new javax.ejb.ScheduleExpression();
		scheduleExpression.hour(hour).minute(minute).second(second);
		javax.ejb.TimerConfig timerConfig = new javax.ejb.TimerConfig(dto, true);
		this.timerService.createCalendarTimer(scheduleExpression, timerConfig);
	}
	
	@javax.ejb.Timeout
	public void send(javax.ejb.Timer timer) {
		ChessPuzzleDto dto = (ChessPuzzleDto) timer.getInfo();
		this.chessPuzzleMailSender.sendmail("pascal.cornet@uliege.be", dto);
		timer.cancel();
	}
}
