package be.steformations.java_data.pc.conjugaison_fr.dao.jpa;

import be.steformations.java_data.conjugaison_fr.interfaces.Auxiliaire;
import be.steformations.java_data.conjugaison_fr.interfaces.Conjugaison;
import be.steformations.java_data.conjugaison_fr.interfaces.Mode;
import be.steformations.java_data.conjugaison_fr.interfaces.Personne;
import be.steformations.java_data.conjugaison_fr.interfaces.Temps;
import be.steformations.java_data.conjugaison_fr.interfaces.Verbe;
import be.steformations.java_data.pc.conjugaison_fr.beans.ConjugaisonImpl;
import be.steformations.java_data.pc.conjugaison_fr.beans.VerbeImpl;
import be.steformations.java_data.pc.conjugaison_fr.dao.AbstractConjugueur;
import be.steformations.java_data.pc.conjugaison_fr.dao.jpa.entities.ConjugaisonEntity;

public class JpaConjugueur extends AbstractConjugueur{

	protected javax.persistence.EntityManager em;
	
	public JpaConjugueur(javax.persistence.EntityManager em) {
		super();
		this.em = em;
	}
	
	@Override
	public VerbeImpl getVerbe(String infinitif) {
		VerbeImpl verbe = null;
		try {
			verbe = this.em.createQuery("select v from Verbe as v where lower(v.infinitif) = lower(?1)", VerbeImpl.class)
						.setParameter(1, infinitif)
						.getSingleResult();
		} catch(javax.persistence.NoResultException ignored) {}
		return verbe;
	}

	@Override
	public ConjugaisonImpl conjuguer(Verbe verbe, Mode mode, Temps temps, Personne personne) {
		ConjugaisonImpl co = null;
		if (! this.isComposed(mode, temps)) {
			try {
				co = this.em.createQuery(
						"select c from Conjugaison as c where c.verbeEntity.infinitif = ?1 and c.mode = ?2 and c.temps = ?3 and c.personne = ?4", 
						ConjugaisonEntity.class)
						.setParameter(1, verbe.getInfinitif()).setParameter(2, mode).setParameter(3, temps).setParameter(4, personne)
						.getSingleResult();
			} catch(javax.persistence.NoResultException ignored) {}
		} else {
			try {
				String auxiliary 
					= this.em.createQuery(
						"select c.valeur from Conjugaison as c where c.verbeEntity.infinitif = ?1 and c.mode = ?2 and c.temps = ?3 and c.personne = ?4", 
						String.class)
							.setParameter(1, verbe.getAuxiliaire() == Auxiliaire.AVOIR ? "avoir" : "être")
							.setParameter(2, mode)
							.setParameter(3, this.getComposedTense(mode, temps))
							.setParameter(4, personne)
							.getSingleResult();
				co = new ConjugaisonImpl();
				co.setMode(mode);
				co.setTemps(temps);
				co.setPersonne(personne);
				co.setVerbe(verbe);
				co.setValeur(String.format("%s %s%s", auxiliary, verbe.getParticipe(), 
						(verbe.getAuxiliaire() == Auxiliaire.ETRE && personne.ordinal() > 2 ? "s" : "")));
			} catch(javax.persistence.NoResultException ignored) {}
		}
		return co;
	}

	@Override
	public java.util.List<Conjugaison> conjuguer(Verbe verbe, Mode mode, Temps temps) {
		java.util.List<Conjugaison> list = new java.util.ArrayList<>();
		if (! this.isComposed(mode, temps)) {
			list.addAll(
				this.em.createQuery(
						"select c from Conjugaison as c where c.verbeEntity.infinitif = ?1 and c.mode = ?2 and c.temps = ?3 order by c.personne", 
						ConjugaisonEntity.class)
						.setParameter(1, verbe.getInfinitif()).setParameter(2, mode).setParameter(3, temps)
						.getResultList()
			);
		} else {
			java.util.List<String> auxiliaries 
				= this.em.createQuery(
					"select c.valeur from Conjugaison as c where c.verbeEntity.infinitif = ?1 and c.mode = ?2 and c.temps = ?3 order by c.personne", 
					String.class)
						.setParameter(1, verbe.getAuxiliaire() == Auxiliaire.AVOIR ? "avoir" : "être")
						.setParameter(2, mode)
						.setParameter(3, this.getComposedTense(mode, temps))
						.getResultList();
			for (int i = 0; i < auxiliaries.size(); i++) {
				ConjugaisonImpl co = new ConjugaisonImpl();
				co.setMode(mode);
				co.setTemps(temps);
				co.setPersonne(Personne.values()[i]);
				co.setVerbe(verbe);
				co.setValeur(String.format("%s %s%s", auxiliaries.get(i), verbe.getParticipe(), 
						(verbe.getAuxiliaire() == Auxiliaire.ETRE && i > 2 ? "s" : "")));
				list.add(co);
			}
		}
		return list;
	}
}
