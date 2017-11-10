package be.steformations.pc.chesspuzzles.soap;

import be.steformations.pc.chesspuzzles.dto.ChessPuzzleDto;

public class ChessPuzzleSoapClient {

	protected ChessPuzzleSoapService service;
	
	public ChessPuzzleSoapClient(String server) {
		try {
			java.net.URL wsdl = new java.net.URL(server + ChessPuzzleSoapService.wsdl);
			javax.xml.namespace.QName qname
				= new javax.xml.namespace.QName(
						ChessPuzzleSoapService.targetNamespace, 
						ChessPuzzleSoapService.serviceName);
			this.service = javax.xml.ws.Service.create(wsdl, qname)
							.getPort(ChessPuzzleSoapService.class);
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public ChessPuzzleDto findOneByRank(int rank) {
		return this.service.findOneByRank(rank);
	}

	public ChessPuzzleDto findOneRandom() {
		return this.service.findOneRandom();
	}

	public ChessPuzzleDto update(int rank, String san) {
		return this.service.update(rank, san);
	}

	public ChessPuzzleDto createAndSave(String san, String fen) {
		return this.service.createAndSave(san, fen);
	}

	public Object remove(Integer rank) {
		return this.service.remove(rank);
	}

}
