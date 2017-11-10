package be.steformations.pc.chesspuzzles.soap;

import be.steformations.pc.chesspuzzles.dto.ChessPuzzleDto;
import be.steformations.pc.chesspuzzles.ejb.ChesspuzzleEjbService;

@javax.ejb.Stateless
@javax.jws.WebService(		
		targetNamespace=ChessPuzzleSoapService.targetNamespace, 
		serviceName=ChessPuzzleSoapService.serviceName,
		endpointInterface=ChessPuzzleSoapService.endpointInterface)
public class ChessPuzzleSoapServiceImpl implements ChessPuzzleSoapService {

	@javax.ejb.EJB // injection par le serveur JEE
	private ChesspuzzleEjbService ejbService;
	
	@Override
	public ChessPuzzleDto findOneByRank(int rank) {
		return this.ejbService.read(rank);
	}

	@Override
	public ChessPuzzleDto findOneRandom() {
		return this.ejbService.random();
	}

	@Override
	public ChessPuzzleDto createAndSave(String san, String fen) {
		return this.ejbService.create(san, fen);
	}

	@Override
	public ChessPuzzleDto update(int rank, String san) {
		return this.ejbService.update(rank, san);
	}

	@Override
	public ChessPuzzleDto remove(int rank) {
		return this.ejbService.delete(rank);
	}
}
