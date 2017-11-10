package be.steformations.java_data.pc.conjugaison_fr.dao.spring_jdbc.mappings;

import be.steformations.java_data.conjugaison_fr.interfaces.Mode;
import be.steformations.java_data.conjugaison_fr.interfaces.Personne;
import be.steformations.java_data.conjugaison_fr.interfaces.Temps;
import be.steformations.java_data.conjugaison_fr.interfaces.Verbe;
import be.steformations.java_data.pc.conjugaison_fr.beans.ConjugaisonImpl;

public class ConjugaisonRowMapper implements org.springframework.jdbc.core.RowMapper<ConjugaisonImpl>{

	public static final String MODE = "conjugaisonMode";
	public static final String TEMPS = "conjugaisonTemps";
	public static final String PERSONNE = "conjugaisonPersonne";
	public static final String VALEUR = "conjugaisonValeur";
	
	protected Verbe verbe;
	
	public void setVerbe(Verbe verbe) {
		this.verbe = verbe;
	}
	
	@Override
	public ConjugaisonImpl mapRow(java.sql.ResultSet rs, int rowId) throws java.sql.SQLException {
		ConjugaisonImpl co = new ConjugaisonImpl();
		co.setVerbe(this.verbe);
		co.setMode(Mode.values()[rs.getInt(MODE)]);
		co.setTemps(Temps.values()[rs.getInt(TEMPS)]);
		co.setPersonne(Personne.values()[rs.getInt(TEMPS)]);
		co.setValeur(rs.getString(VALEUR));
		return co;
	}

	
}
