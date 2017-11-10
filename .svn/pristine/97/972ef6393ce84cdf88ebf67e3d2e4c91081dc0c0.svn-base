package be.steformations.pc.java_data.biblio.dao.jpa;

import be.steformations.java_data.biblio.interfaces.GestionnaireBibliotheque;
import be.steformations.pc.java_data.biblio.beans.AuteurImpl;
import be.steformations.pc.java_data.biblio.beans.CollectionImpl;
import be.steformations.pc.java_data.biblio.beans.EmprunteurImpl;
import be.steformations.pc.java_data.biblio.beans.LivreImpl;
import be.steformations.pc.java_data.biblio.beans.ReservationImpl;

public class JpaGestionnaireBibliotheque implements GestionnaireBibliotheque {

	protected javax.persistence.EntityManager em;
	
	public JpaGestionnaireBibliotheque(javax.persistence.EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public AuteurImpl getAuteurByPrenomAndNom(String prenom, String nom) {
		AuteurImpl entity = null;
		try {
			entity = this.em.createNamedQuery("getAuteurByPrenomAndNom", AuteurImpl.class)
						.setParameter("prenom", prenom).setParameter("nom", nom)
						.getSingleResult();
		} catch(javax.persistence.NoResultException ignored) {}
		return entity;
	}

	@Override
	public AuteurImpl getAuteurByCode(int code) {
		return this.em.find(AuteurImpl.class, code);
	}

	@Override
	public java.util.List<AuteurImpl> getAllAuteurs() {
		return this.em.createNamedQuery("getAllAuteurs", AuteurImpl.class).getResultList();
	}

	@Override
	public AuteurImpl addAuteur(String prenom, String nom) {
		AuteurImpl auteur = null;
		if (prenom != null && ! prenom.isEmpty() && nom != null && ! nom.isEmpty()
				&& this.getAuteurByPrenomAndNom(prenom, nom) == null) {
			auteur = new AuteurImpl();
			auteur.setPrenom(prenom);
			auteur.setNom(nom);
			if (this.em.isJoinedToTransaction()) {
				this.em.persist(auteur);
			} else {
				this.em.getTransaction().begin();
				this.em.persist(auteur);
				this.em.getTransaction().commit();
			}
		}
		return auteur;
	}

	@Override
	public void removeAuteur(int code) {
		AuteurImpl auteur = this.getAuteurByCode(code);
		if (auteur != null) {
			if (this.em.isJoinedToTransaction()) {
				this.em.remove(auteur);
			} else {
				this.em.getTransaction().begin();
				this.em.remove(auteur);
				this.em.getTransaction().commit();				
			}
		}
	}

	@Override
	public CollectionImpl getCollectionByNom(String nom) {
		CollectionImpl collection = null;
		try {
			collection = this.em.createNamedQuery("getCollectionByNom", CollectionImpl.class)
							.setParameter("nom", nom)
							.getSingleResult();
		} catch(javax.persistence.NoResultException ignored) {}
		return collection;
	}

	@Override
	public CollectionImpl getCollectionByCode(int code) {
		return this.em.find(CollectionImpl.class, code);
	}

	@Override
	public java.util.List<CollectionImpl> getAllCollections() {
		return this.em.createNamedQuery("getAllCollections", CollectionImpl.class).getResultList();
	}

	@Override
	public CollectionImpl addCollection(String nom) {
		CollectionImpl collection = null;
		if (nom != null && ! nom.isEmpty() 
				&& this.getCollectionByNom(nom) == null) {
			collection = new CollectionImpl();
			collection.setNom(nom);
			if (this.em.isJoinedToTransaction()) {
				this.em.persist(collection);
			} else {
				this.em.getTransaction().begin();
				this.em.persist(collection);
				this.em.getTransaction().commit();
			}
		}
		return collection;
	}

	@Override
	public void removeCollection(int code) {
		CollectionImpl collection = this.getCollectionByCode(code);
		if (collection != null) {
			if (this.em.isJoinedToTransaction()) {
				this.em.remove(collection);
			} else {
				this.em.getTransaction().begin();
				this.em.remove(collection);
				this.em.getTransaction().commit();
			}
		}
	}

	@Override
	public LivreImpl getLivreByCode(String code) {
		LivreImpl livre = null;
		if (code != null) {
			livre = this.em.find(LivreImpl.class, code);
		}
		return livre;
	}

	@Override
	public java.util.List<LivreImpl> getAllLivres() {
		return this.em.createNamedQuery("getAllLivres", LivreImpl.class).getResultList();
	}

	@Override
	public java.util.List<LivreImpl> searchLivres(Integer auteurId, Integer collectionId, String partieDuTitre) {
		// return this.searchLivresByNativeSql(auteurId, collectionId, partieDuTitre);
		return this.searchLivresJpql(auteurId, collectionId, partieDuTitre);
	}
	
	protected java.util.List<LivreImpl> searchLivresByNativeSql(Integer auteurId, Integer collectionId, String partieDuTitre) {
		String titre = partieDuTitre == null ? "%" : "%" + partieDuTitre + "%";
		String auteur = auteurId == null ? "%" : String.valueOf(auteurId);
		String collection = collectionId == null ? "%" : String.valueOf(collectionId);
		
		return this.em.createNamedQuery("searchLivresNativeSql", LivreImpl.class)
				.setParameter(1, titre).setParameter(2, collection).setParameter(3, auteur)
				.getResultList();
	}
	
	protected java.util.List<LivreImpl> searchLivresJpql(Integer auteurId, Integer collectionId, String titre) {
		java.util.List<LivreImpl> list = null;
		if (auteurId != null) {
			AuteurImpl auteur = this.getAuteurByCode(auteurId);
			if (auteur != null) {
				if (collectionId != null) {
					if (titre != null && ! titre.isEmpty()) {
						list = this.em.createNamedQuery("findAllByAuteurAndCollectionIdAndTitreContainsIgnoreCase", LivreImpl.class)
								.setParameter("auteur", auteur).setParameter("collection", collectionId).setParameter("titre", "%" + titre + "%")
								.getResultList();
					} else {
						list = this.em.createNamedQuery("findAllByAuteurAndCollectionId", LivreImpl.class)
								.setParameter("auteur", auteur).setParameter("collection", collectionId)
								.getResultList();
					}
				} else if (titre != null && ! titre.isEmpty()) {
					list = this.em.createNamedQuery("findAllByAuteurAndTitreContainsIgnoreCase", LivreImpl.class)
							.setParameter("auteur", auteur).setParameter("titre", "%" + titre + "%")
							.getResultList();
				} else {
					list = this.em.createNamedQuery("findAllByAuteur", LivreImpl.class)
							.setParameter("auteur", auteur)
							.getResultList();
				}
			} else {
				list = java.util.Collections.emptyList(); 
			}
		} else if (collectionId != null) {
			if (titre != null && ! titre.isEmpty()) {
				list = this.em.createNamedQuery("findAllByCollectionIdAndTitreContainsIgnoreCase", LivreImpl.class)
							.setParameter("collection", collectionId).setParameter("titre", "%" + titre + "%")
							.getResultList();
			} else {
				list = this.em.createNamedQuery("findAllByCollectionId", LivreImpl.class)
						.setParameter("collection", collectionId)
						.getResultList();
			}
		} else if (titre != null && ! titre.isEmpty()) {
			list = this.em.createNamedQuery("findAllByTitreContainsIgnoreCase", LivreImpl.class)
					.setParameter("titre", "%" + titre + "%")
					.getResultList();
		} else {
			list = this.em.createNamedQuery("findAll", LivreImpl.class)
					.getResultList();
		}
		return list;
	}

	@Override
	public LivreImpl addLivre(String titre, short nombreDePages, java.util.Date dateDeParution, int idCollection, short numeroEdition,
			java.util.List<Integer> auteurs) {
		LivreImpl livre = null;
		CollectionImpl collection = null;
		System.out.println(this.searchLivres(null, idCollection, titre) == null);
		if (titre != null && (collection = this.getCollectionByCode(idCollection)) != null 
				&& this.searchLivres(null, idCollection, titre).isEmpty()) {
			String code = this.generateCodeLivre();
			System.out.println("code = " + code);
			if (code != null) {
				livre = new LivreImpl();
				livre.setCode(code);
				livre.setTitre(titre);
				livre.setDateDeParution(dateDeParution);
				livre.setNombreDePages(nombreDePages);
				livre.setNumeroEdition(numeroEdition);
				livre.setCollection(collection);
				boolean insert = true;
				if (auteurs != null && ! auteurs.isEmpty()) {
					int index = 0;
					while(insert && index < auteurs.size()) {
						int id = auteurs.get(index);
						AuteurImpl auteur = this.getAuteurByCode(id);
						if (auteur != null) {
							livre.getAuteurs().add(auteur);
						} else {
							insert = false;
						}
						index++;
					}
				}
				if (insert) {
					if (this.em.isJoinedToTransaction()) {
						this.em.persist(livre);
					} else {
						this.em.getTransaction().begin();
						this.em.persist(livre);
						this.em.getTransaction().commit();
					}
				} else {
					livre = null;
				}
			}
		}
		
		return livre;
	}

	@Override
	public void removeLivre(String code) {
		LivreImpl livre = this.getLivreByCode(code);
		if (livre != null) {
			if (this.em.isJoinedToTransaction()) {
				this.em.remove(livre);
			} else {
				this.em.getTransaction().begin();
				this.em.remove(livre);
				this.em.getTransaction().commit();
			}
		}
	}

	@Override
	public EmprunteurImpl getEmprunteurByEmail(String email) {
		EmprunteurImpl emprunteur = null;
		try {
			emprunteur = this.em.createNamedQuery("getEmprunteurByEmail", EmprunteurImpl.class)
							.setParameter("email", email)
							.getSingleResult();
		} catch(javax.persistence.NoResultException ignored) {}
		return emprunteur;
	}

	@Override
	public EmprunteurImpl addEmprunteur(String prenom, String nom, String email, java.util.Date ddn, String telephone) {
		EmprunteurImpl emprunteur = null;
		if (prenom != null && ! prenom.isEmpty() && nom != null && ! nom.isEmpty() && email != null && ! email.isEmpty() 
				&& this.getEmprunteurByEmail(email) == null 
		) {
			try {
				this.em.createNamedQuery("getEmprunteurByPrenomAndNomAndDdn", EmprunteurImpl.class)
					.setParameter("prenom", prenom).setParameter("nom", nom).setParameter("ddn", ddn)
					.getSingleResult();
			} catch(javax.persistence.NoResultException ok) {
				emprunteur = new EmprunteurImpl();
				emprunteur.setPrenom(prenom);
				emprunteur.setNom(nom);
				emprunteur.setDateDeNaissance(ddn);
				emprunteur.setEmail(email);
				emprunteur.setTelephone(telephone);
				if (this.em.isJoinedToTransaction()) {
					this.em.persist(emprunteur);
				} else {
					this.em.getTransaction().begin();
					this.em.persist(emprunteur);
					this.em.getTransaction().commit();
				}
			}
		}
		return emprunteur;
	}

	@Override
	public java.util.List<ReservationImpl> getReservationsByEmprunteurCode(int code) {
		return this.em.createNamedQuery("getReservationsByEmprunteurCode", ReservationImpl.class)
				.setParameter("code", code)
				.getResultList();
	}

	@Override
	public java.util.List<ReservationImpl> getReservationsByLivreCode(String code) {
		return this.em.createNamedQuery("getReservationsByLivreCode", ReservationImpl.class)
				.setParameter("code", code)
				.getResultList();
	}

	@Override
	public ReservationImpl getReservationByCode(int code) {
		return this.em.find(ReservationImpl.class, code);
	}

	@Override
	public ReservationImpl addReservation(int emprunteurId, String livreId) {
		ReservationImpl reservation = null;
		EmprunteurImpl emprunteur = null;
		LivreImpl livre = null;
		if ((emprunteur = this.em.find(EmprunteurImpl.class, emprunteurId)) != null
				&& (livre = this.getLivreByCode(livreId)) != null
				&& this.getReservationsByLivreCode(livreId).isEmpty()) {
			reservation = new ReservationImpl();
			reservation.setLivre(livre);
			reservation.setEmprunteur(emprunteur);
			reservation.setDateDeReservation(new java.util.Date(System.currentTimeMillis()));
			if (this.em.isJoinedToTransaction()) {
				this.em.persist(reservation);
			} else {
				this.em.getTransaction().begin();
				this.em.persist(reservation);
				this.em.getTransaction().commit();
			}
		}
		return reservation;
	}

	@Override
	public void removeReservation(int code) {
		ReservationImpl reservation = this.getReservationByCode(code);
		if (reservation != null) {
			if (this.em.isJoinedToTransaction()) {
				this.em.remove(reservation);
			} else {
				this.em.getTransaction().begin();
				this.em.remove(reservation);
				this.em.getTransaction().commit();
			}
		}
	}
	
	protected String generateCodeLivre() {
		String newcode = null, current = null;
		char lastFirstLetter = 'A', currentFirstLetter = '\0';
		int lastNumber = 0, currentNumber = 0;
		java.util.List<LivreImpl> list = this.getAllLivres(); // ordered by code
		int index = 0;
		while(newcode == null && index < list.size()) {
			current = list.get(index).getCode();
			currentFirstLetter = current.charAt(0);
			currentNumber = Integer.parseInt(current.substring(1));
			if (currentFirstLetter != lastFirstLetter) {
				if (lastNumber < 999) {
					newcode = String.format("%s%03d", lastFirstLetter, lastNumber+1);
				} else if (currentFirstLetter > lastFirstLetter + 1) {
					newcode = String.format("%s%03d", lastFirstLetter + 1, 1);
				} else if (currentNumber > 1) {
					newcode = String.format("%s%03d", currentFirstLetter, 1);
				}
			} else if (currentNumber > lastNumber + 1) {
				newcode = String.format("%s%03d", currentFirstLetter, lastNumber+1);
			}
			lastFirstLetter = currentFirstLetter;
			lastNumber = currentNumber;
			index++;
		}
		return newcode;
	}
}
