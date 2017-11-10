package be.steformations.pc.chesspuzzles.ejb;

import be.steformations.pc.chesspuzzles.beans.ChessPuzzle;
import be.steformations.pc.chesspuzzles.dto.ChessPuzzleDto;
import be.steformations.pc.chesspuzzles.ejb.jms.ChessPuzzleJmsMessageProducer;
import be.steformations.pc.chesspuzzles.ejb.jobs.ChessPuzzleDelayedSendmailJob;
import be.steformations.pc.chesspuzzles.ejb.mail.ChessPuzzleMailSender;
import be.steformations.pc.chesspuzzles.jpa.repositories.JpaChessPuzzleRepository;

@javax.ejb.Stateless // EJB géré par le serveur JEE
@javax.ejb.Remote(ChesspuzzleEjbService.class)
public class ChesspuzzleEjbServiceImpl implements ChesspuzzleEjbService {

	@javax.persistence.PersistenceContext(unitName="chesspuzzle")
	javax.persistence.EntityManager em;
	@javax.ejb.EJB
	private ChessPuzzleJmsMessageProducer chessPuzzleJmsMessageProducer;
	@javax.ejb.EJB
	private ChessPuzzleMailSender chessPuzzleMailSender;
	@javax.ejb.EJB
	private ChessPuzzleDelayedSendmailJob chessPuzzleDelayedSendmailJob;
	
	private JpaChessPuzzleRepository dao;
	
	public ChesspuzzleEjbServiceImpl() {
		super();
		System.out.println("ChesspuzzleEjbServiceImpl.ChesspuzzleEjbServiceImpl()");
	}
	
	@javax.annotation.PostConstruct // méthode invoquée directement après l'instanciation et les injections
	private void init() {
		System.out.println("ChesspuzzleEjbServiceImpl.init()");
		this.dao = new JpaChessPuzzleRepository(this.em);
	}
	
	@Override
	public void ping() {
		System.out.println("ChesspuzzleEjbServiceImpl.ping() => " + this.em);
	}

	@Override
	public ChessPuzzleDto random() {
		System.out.println("ChesspuzzleEjbServiceImpl.random()");
		return this.create(this.dao.findOneRandom());
	}

	@Override
	public ChessPuzzleDto create(String fen, String san) {
		System.out.println("ChesspuzzleEjbServiceImpl.create()");
		ChessPuzzleDto dto = this.create(this.dao.createAndSave(san, fen));
		//this.chessPuzzleJmsMessageProducer.broadcastNewChessPuzzle(dto);
		//this.chessPuzzleMailSender.sendmail("pascal.cornet@uliege.be", dto);
		this.chessPuzzleDelayedSendmailJob.programSend(dto);
		return dto;
	}

	@Override
	public ChessPuzzleDto read(int id) {
		System.out.println("ChesspuzzleEjbServiceImpl.read()");
		return this.create(this.dao.findOneByRank(id));
	}

	@Override
	public ChessPuzzleDto update(int id, String san) {
		System.out.println("ChesspuzzleEjbServiceImpl.update()");
		return this.create(this.dao.update(id, san));
	}

	@Override
	public ChessPuzzleDto delete(int id) {
		System.out.println("ChesspuzzleEjbServiceImpl.delete()");
		return this.create(this.dao.remove(id));
	}

	private ChessPuzzleDto create(ChessPuzzle puzzle) {
		ChessPuzzleDto dto = null;
		if (puzzle != null) {
			dto = new ChessPuzzleDto(puzzle.getRank(), 
					puzzle.getFen(), puzzle.getSan());
		}
		return dto;
	}
}
