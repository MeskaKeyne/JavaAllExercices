package be.steformations.pc.chesspuzzles.soap;

public class ChessPuzzleSoapServicePublisher {

	public static void main(String[] args) {
		ChessPuzzleSoapService service = new ChessPuzzleSoapServiceImpl();
		javax.xml.ws.Endpoint.publish(
				"http://localhost:8080/chesspuzzle-soap" + ChessPuzzleSoapService.wsdl, 
				service);
		System.out.println("ChessPuzzleSoapServicePublisher.main(): service ready");
	}
}
