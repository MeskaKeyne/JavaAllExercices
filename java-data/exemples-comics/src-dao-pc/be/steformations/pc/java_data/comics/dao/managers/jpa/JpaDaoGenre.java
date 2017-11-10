package be.steformations.pc.java_data.comics.dao.managers.jpa;

import java.util.List;

import be.steformations.java_data.comics.interfaces.dao.beans.Genre;
import be.steformations.java_data.comics.interfaces.dao.beans.Personnage;
import be.steformations.java_data.comics.interfaces.dao.managers.GenreManager;
import be.steformations.pc.java_data.comics.dao.beans.GenreImpl;
import be.steformations.pc.java_data.comics.dao.beans.PersonnageImpl;

public class JpaDaoGenre implements GenreManager {

	private javax.persistence.EntityManager entitymanager;
	
	public JpaDaoGenre(javax.persistence.EntityManager entitymanager) {
		super();
		this.entitymanager = entitymanager;
	}
	
	@Override
	public GenreImpl getGenre(String nom) {
		GenreImpl genre = null;
		
		javax.persistence.TypedQuery<GenreImpl> query
			= this.entitymanager.createNamedQuery("GetGenreByName", GenreImpl.class);
		query.setParameter(1, nom);
		
		try {
			genre = query.getSingleResult();
		} catch(javax.persistence.NoResultException e) {}
		
		return genre;
	}

	@Override
	public List<? extends Personnage> getPersonnages(String nom) {
		// return this.getPersonnagesJpql(nom);
		return this.getPersonnagesProperty(nom);
	}
	
	private List<PersonnageImpl> getPersonnagesProperty(String nom) {
		GenreImpl genre = this.getGenre(nom);
		if (genre == null) {
			return java.util.Collections.emptyList();
		} else {
			return genre.getComics();
		}
	}
	
	private List<PersonnageImpl> getPersonnagesJpql(String nom) {
		java.util.List<PersonnageImpl> list = null;
		
		String jpql = "select p from Comic p where p.genre.nom = ?1";
		javax.persistence.TypedQuery<PersonnageImpl> query
			= this.entitymanager.createQuery(jpql, PersonnageImpl.class);
		query.setParameter(1, nom);
		list = query.getResultList();
		
		return list;
	}

}
