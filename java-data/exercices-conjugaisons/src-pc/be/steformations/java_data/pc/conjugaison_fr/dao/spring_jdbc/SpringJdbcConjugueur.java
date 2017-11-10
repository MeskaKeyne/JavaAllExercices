package be.steformations.java_data.pc.conjugaison_fr.dao.spring_jdbc;

import be.steformations.java_data.conjugaison_fr.interfaces.Auxiliaire;
import be.steformations.java_data.conjugaison_fr.interfaces.Conjugaison;
import be.steformations.java_data.conjugaison_fr.interfaces.Mode;
import be.steformations.java_data.conjugaison_fr.interfaces.Personne;
import be.steformations.java_data.conjugaison_fr.interfaces.Temps;
import be.steformations.java_data.conjugaison_fr.interfaces.Verbe;
import be.steformations.java_data.pc.conjugaison_fr.beans.ConjugaisonImpl;
import be.steformations.java_data.pc.conjugaison_fr.beans.VerbeImpl;
import be.steformations.java_data.pc.conjugaison_fr.dao.AbstractConjugueur;
import be.steformations.java_data.pc.conjugaison_fr.dao.spring_jdbc.mappings.ConjugaisonRowMapper;
import be.steformations.java_data.pc.conjugaison_fr.dao.spring_jdbc.mappings.VerbeRowMapper;

public class SpringJdbcConjugueur extends AbstractConjugueur {
	
	protected final String VERBE_QUERY 
		= String.format("select v.id as %s, v.infinitif as %s, v.auxiliaire as %s, v.radical as %s, v.participe as %s, "
					  + "		m.id as %s, m.infinitif as %s, m.auxiliaire as %s, m.radical as %s, m.participe as %s "
					  + "from verbe_view v left join verbe_view m on v.modele = m.id "
					  + "where v.infinitif = ?", 
					  VerbeRowMapper.VERBE_ID, VerbeRowMapper.VERBE_INFINITIF, VerbeRowMapper.VERBE_AUXILIAIRE, VerbeRowMapper.VERBE_RADICAL, VerbeRowMapper.VERBE_PARTICIPE,
					  VerbeRowMapper.MODELE_ID, VerbeRowMapper.MODELE_INFINITIF, VerbeRowMapper.MODELE_AUXILIAIRE, VerbeRowMapper.MODELE_RADICAL, VerbeRowMapper.MODELE_PARTICIPE);
	
	protected final String CONJUGAISON_QUERY
		= String.format("select cv.mode as %s, cv.temps as %s, cv.personne as %s, cv.valeur as %s "
					  + "from conjugaison_view as cv join verbes as v on cv.verbe = v.id "
					  + "where v.infinitif = ? and cv.mode= ? and cv.temps = ? and cv.personne = ?",
					  ConjugaisonRowMapper.MODE, ConjugaisonRowMapper.TEMPS, ConjugaisonRowMapper.PERSONNE, ConjugaisonRowMapper.VALEUR);
	
	protected final String CONJUGAISON_LIST_QUERY
		= String.format("select cv.mode as %s, cv.temps as %s, cv.personne as %s, cv.valeur as %s "
					  + "from conjugaison_view as cv join verbes as v on cv.verbe = v.id "
					  + "where v.infinitif = ? and cv.mode= ? and cv.temps = ? "
					  + "order by cv.personne",
					  ConjugaisonRowMapper.MODE, ConjugaisonRowMapper.TEMPS, ConjugaisonRowMapper.PERSONNE, ConjugaisonRowMapper.VALEUR);
	
	protected org.springframework.jdbc.core.JdbcTemplate jdbcTemplate;
	protected VerbeRowMapper verbeRowMapper;	
	protected ConjugaisonRowMapper conjugaisonRowMapper;
	
	public SpringJdbcConjugueur(org.springframework.jdbc.core.JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
		this.verbeRowMapper = new VerbeRowMapper();
		this.conjugaisonRowMapper = new ConjugaisonRowMapper();
	}
	
	@Override
	public VerbeImpl getVerbe(String infinitif) {
		VerbeImpl verbe = null;
		try {
			verbe = this.jdbcTemplate.queryForObject(this.VERBE_QUERY, this.verbeRowMapper, infinitif);
		} catch(org.springframework.dao.EmptyResultDataAccessException ignored) {}
		
		return verbe;
	}

	@Override
	public ConjugaisonImpl conjuguer(Verbe verbe, Mode mode, Temps temps, Personne personne) {
		ConjugaisonImpl co = null;
		this.conjugaisonRowMapper.setVerbe(verbe);
		if (! this.isComposed(mode, temps)) {
			try {
				co = this.jdbcTemplate.queryForObject(CONJUGAISON_QUERY, this.conjugaisonRowMapper, 
						verbe.getInfinitif(), mode.ordinal(), temps.ordinal(), personne.ordinal());
			} catch(org.springframework.dao.EmptyResultDataAccessException ignored) {}
		} else {
			Temps tps = this.getComposedTense(mode, temps);
			if (tps != null) {
				ConjugaisonImpl auxiliary 
					= this.jdbcTemplate.queryForObject(CONJUGAISON_QUERY, this.conjugaisonRowMapper,
							(verbe.getAuxiliaire() == Auxiliaire.AVOIR ? "avoir" : "être"), 
							mode.ordinal(), tps.ordinal(), personne.ordinal());
				co = new ConjugaisonImpl();
				co.setMode(mode);
				co.setTemps(temps);
				co.setPersonne(personne);
				co.setVerbe(verbe);
				co.setValeur(String.format("%s %s%s", auxiliary.getValeur(), verbe.getParticipe(), 
						(verbe.getAuxiliaire() == Auxiliaire.ETRE && personne.ordinal() > 2 ? "s" : "")));
			}
		}
		return co;
	}

	@Override
	public java.util.List<Conjugaison> conjuguer(Verbe verbe, Mode mode, Temps temps) {
		java.util.List<Conjugaison> list = new java.util.ArrayList<>();
		this.conjugaisonRowMapper.setVerbe(verbe);
		if (! this.isComposed(mode, temps)) {
			list.addAll(
				this.jdbcTemplate.query(CONJUGAISON_LIST_QUERY, this.conjugaisonRowMapper, verbe.getInfinitif(), mode.ordinal(), temps.ordinal())
			);
		} else {
			Temps tps = this.getComposedTense(mode, temps);
			if (tps != null) {
				java.util.List<ConjugaisonImpl> auxiliaries 
					= this.jdbcTemplate.query(CONJUGAISON_LIST_QUERY, this.conjugaisonRowMapper,
							(verbe.getAuxiliaire() == Auxiliaire.AVOIR ? "avoir" : "être"), 
							mode.ordinal(), tps.ordinal());
				for (int i = 0; i < auxiliaries.size(); i++) {
					ConjugaisonImpl co = new ConjugaisonImpl();
					co.setMode(mode);
					co.setTemps(temps);
					co.setPersonne(Personne.values()[i]);
					co.setVerbe(verbe);
					co.setValeur(String.format("%s %s%s", auxiliaries.get(i).getValeur(), verbe.getParticipe(), 
							(verbe.getAuxiliaire() == Auxiliaire.ETRE && i > 2 ? "s" : "")));
					list.add(co);
				}
			}
		}
		return list;
	}

}
