package be.steformations.pc.chesspuzzles.jpa.repositories;

import be.steformations.pc.chesspuzzles.dao.ChessPuzzleDao;
import be.steformations.pc.chesspuzzles.jpa.entities.ChessPuzzleEntity;

public class JpaChessPuzzleRepository implements ChessPuzzleDao {

	protected javax.persistence.EntityManager em;
	protected java.util.Random random;
	protected java.util.List<Integer> orderedRanks;
	
	public JpaChessPuzzleRepository(javax.persistence.EntityManager em) {
		super();
		this.em = em;
		this.random = new java.util.Random();
		this.orderedRanks = this.em.createNamedQuery("findAllRanks", Integer.class).getResultList();
	}

	@Override
	public ChessPuzzleEntity findOneByRank(int rank) {
		ChessPuzzleEntity entity = null;
		if (rank > 0) {
			entity = this.em.find(ChessPuzzleEntity.class, rank);
		}
		return entity;
	}

	@Override
	public ChessPuzzleEntity findOneRandom() {
		ChessPuzzleEntity entity = null;
		if (! this.orderedRanks.isEmpty()) {
			entity 
				= this.findOneByRank(
					this.orderedRanks.get(
						this.random.nextInt(
							this.orderedRanks.size())));
		}
		return entity;
	}

	@Override
	public ChessPuzzleEntity createAndSave(String san, String fen) {
		ChessPuzzleEntity entity = null;
		if (san != null && fen != null && !san.isEmpty() && !fen.isEmpty()) {
			int rank = 0;
			if (this.orderedRanks.isEmpty()) {
				rank = 1;
			} else {
				rank = this.orderedRanks.get(this.orderedRanks.size()-1) + 1;
			}
			entity = new ChessPuzzleEntity();
			entity.setRank(rank);
			entity.setFen(fen);
			entity.setSan(san);
			if (this.em.isJoinedToTransaction()) {
				this.em.persist(entity);
				this.em.flush();
			} else {
				this.em.getTransaction().begin();
				this.em.persist(entity);
				this.em.getTransaction().commit();
			}
			this.orderedRanks.add(rank);
		}
		return entity;
	}

	@Override
	public ChessPuzzleEntity update(int rank, String san) {
		ChessPuzzleEntity entity = this.findOneByRank(rank);
		if (entity != null) {
			entity.setSan(san);
			if (this.em.isJoinedToTransaction()) {
				this.em.persist(entity);
				this.em.flush();
			} else {
				this.em.getTransaction().begin();
				this.em.persist(entity);
				this.em.getTransaction().commit();
			}
		}
		return entity;
	}

	@Override
	public ChessPuzzleEntity remove(int rank) {
		ChessPuzzleEntity entity = this.findOneByRank(rank);
		if (entity != null) {
			if (this.em.isJoinedToTransaction()) {
				this.em.remove(entity);
			} else {
				this.em.getTransaction().begin();
				this.em.remove(entity);
				this.em.getTransaction().commit();
			}
		}
		return entity;
	}

}
