package be.steformations.pc.chesspuzzles.ejb.jms;

import be.steformations.pc.chesspuzzles.dto.ChessPuzzleDto;

public class ChessPuzzleJmsMessageConsumer {

	public static void main(String[] args) throws Exception {
		java.util.Properties properties = new java.util.Properties();
		properties.put("java.naming.provider.url", "localhost:3700");
		javax.naming.InitialContext cxt = new javax.naming.InitialContext(properties);
		
		javax.jms.ConnectionFactory connectionFactory
			= (javax.jms.ConnectionFactory) cxt.lookup("jms/ChessPuzzleTopicConnectionFactory");
		javax.jms.Topic topic
			= (javax.jms.Topic) cxt.lookup("jms/ChessPuzzleTopic");
		
		javax.jms.Connection connection = connectionFactory.createConnection();
		javax.jms.Session session = connection.createSession();
		javax.jms.MessageConsumer messageConsumer = session.createConsumer(topic);
		
		connection.start();
		
		while(true) {
			System.out.println("ChessPuzzleJmsMessageConsumer en attente");
			javax.jms.Message message = messageConsumer.receive(); // attente bloquante
			javax.jms.ObjectMessage objectMessage 
				= (javax.jms.ObjectMessage) message;
			java.io.Serializable serializable = objectMessage.getObject();
			ChessPuzzleDto dto = (ChessPuzzleDto) serializable;
			System.out.println("ChessPuzzleJmsMessageConsumer a reçu " + dto.toString());
		}
		
	}
}
