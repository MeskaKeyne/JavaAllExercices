package be.steformations.pc.chesspuzzles.ejb.mail;

import be.steformations.pc.chesspuzzles.dto.ChessPuzzleDto;

@javax.ejb.Singleton
public class ChessPuzzleMailSender {

	@javax.annotation.Resource(mappedName="mail/chesspuzzle")
	private javax.mail.Session session;
	
	public void sendmail(String recepient, ChessPuzzleDto dto) {
		System.out.println("ChessPuzzleMailSender.sendmail()");
		try {
			javax.mail.internet.MimeMessage email
				= new javax.mail.internet.MimeMessage(this.session);
			email.setSender(
				new javax.mail.internet.InternetAddress(
					this.session.getProperty("mail.from")));
			email.setFrom(this.session.getProperty("mail.from"));
			email.setSubject("new chess puzzle !");
			email.setSentDate(new java.util.Date());
			email.setContent(dto.toString(), "text/plain");
			email.setRecipient(
				javax.mail.Message.RecipientType.TO, 
				new javax.mail.internet.InternetAddress(recepient));
			javax.mail.Transport.send(email);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
