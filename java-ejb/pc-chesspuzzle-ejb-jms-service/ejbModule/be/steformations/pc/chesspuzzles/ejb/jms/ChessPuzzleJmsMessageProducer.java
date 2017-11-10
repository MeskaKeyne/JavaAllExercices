package be.steformations.pc.chesspuzzles.ejb.jms;

import be.steformations.pc.chesspuzzles.dto.ChessPuzzleDto;

@javax.ejb.Singleton // Ejb singleton
public class ChessPuzzleJmsMessageProducer {

	@javax.annotation.Resource(mappedName="jms/ChessPuzzleTopicConnectionFactory")
	private javax.jms.ConnectionFactory connectionFactory;
	@javax.annotation.Resource(mappedName="jms/ChessPuzzleTopic")
	private javax.jms.Topic topic;
	
	public void broadcastNewChessPuzzle(ChessPuzzleDto dto) {
		System.out.println("ChessPuzzleJmsMessageProducer.broadcastNewChessPuzzle()");
		try {
			javax.jms.Connection connection = this.connectionFactory.createConnection();
			javax.jms.Session session = connection.createSession();
			javax.jms.MessageProducer messageProducer = session.createProducer(topic);
			javax.jms.Message message = session.createObjectMessage(dto);
			messageProducer.send(message);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
