package be.steformations.pc.chesspuzzles.soap;

import be.steformations.pc.chesspuzzles.dto.ChessPuzzleDto;

@javax.jws.WebService
public interface ChessPuzzleSoapService {

	String wsdl = "/ws/ChessPuzzleSoapService?wsdl";
	String targetNamespace = "be.steformations.pc.chesspuzzles";
	String serviceName = "ChessPuzzleSoapService";
	String endpointInterface = "be.steformations.pc.chesspuzzles.soap.ChessPuzzleSoapService";
	
	ChessPuzzleDto findOneByRank(int rank);
	ChessPuzzleDto findOneRandom();
	ChessPuzzleDto createAndSave(String san, String fen);
	ChessPuzzleDto update(int rank, String san);
	ChessPuzzleDto remove(int rank);
}
