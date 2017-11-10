package be.steformations.pc.chesspuzzles.soap;

import be.steformations.pc.chesspuzzles.beans.ChessPuzzle;
import be.steformations.pc.chesspuzzles.dao.ChessPuzzleDao;
import be.steformations.pc.chesspuzzles.dto.ChessPuzzleDto;
import be.steformations.pc.chesspuzzles.jpa.repositories.JpaChessPuzzleRepository;

@javax.jws.WebService(		
		targetNamespace=ChessPuzzleSoapService.targetNamespace, 
		serviceName=ChessPuzzleSoapService.serviceName,
		endpointInterface=ChessPuzzleSoapService.endpointInterface)
public class ChessPuzzleSoapServiceImpl implements ChessPuzzleSoapService {

	protected ChessPuzzleDao dao;
	
	public ChessPuzzleSoapServiceImpl() {
		super();
		this.dao = new JpaChessPuzzleRepository(
						javax.persistence.Persistence
							.createEntityManagerFactory("chesspuzzle")
								.createEntityManager());
	}
	
	@Override
	public ChessPuzzleDto findOneByRank(int rank) {
		return this.createDto(this.dao.findOneByRank(rank));
	}

	@Override
	public ChessPuzzleDto findOneRandom() {
		return this.createDto(this.dao.findOneRandom());
	}

	@Override
	public ChessPuzzleDto createAndSave(String san, String fen) {
		return this.createDto(this.dao.createAndSave(san, fen));
	}

	@Override
	public ChessPuzzleDto update(int rank, String san) {
		return this.createDto(this.dao.update(rank, san));
	}

	@Override
	public ChessPuzzleDto remove(int rank) {
		return this.createDto(this.dao.remove(rank));
	}

	protected ChessPuzzleDto createDto(ChessPuzzle puzzle) {
		ChessPuzzleDto dto = null;
		if (puzzle != null) {
			dto = new ChessPuzzleDto(
					puzzle.getRank(), puzzle.getFen(), puzzle.getSan());
		}
		return dto;
	}
}
