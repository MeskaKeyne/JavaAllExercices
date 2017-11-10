package be.steformations.java_data.pc.conjugaison_fr.dao.spring_jdbc.mappings;

import be.steformations.java_data.conjugaison_fr.interfaces.Auxiliaire;
import be.steformations.java_data.pc.conjugaison_fr.beans.VerbeImpl;

public class VerbeRowMapper implements org.springframework.jdbc.core.RowMapper<VerbeImpl>{

	public final static String VERBE_ID = "verbeId";
	public final static String VERBE_INFINITIF = "verbeInfinitif";
	public final static String VERBE_AUXILIAIRE = "verbeAuxiliaire";
	public final static String VERBE_RADICAL = "verbeRadical";
	public final static String VERBE_PARTICIPE = "verbeParticipe";
	public final static String MODELE_ID = "modeleId";
	public final static String MODELE_INFINITIF = "modeleInfinitif";
	public final static String MODELE_AUXILIAIRE = "modeleAuxiliaire";
	public final static String MODELE_RADICAL = "modeleRadical";
	public final static String MODELE_PARTICIPE = "modeleParticipe";
	
	@Override
	public VerbeImpl mapRow(java.sql.ResultSet rs, int rowId) throws java.sql.SQLException {
		VerbeImpl verbe = new VerbeImpl();
		verbe.setInfinitif(rs.getString(VERBE_INFINITIF));
		verbe.setAuxiliaire(Auxiliaire.values()[rs.getInt(VERBE_AUXILIAIRE)]);
		verbe.setRadical(rs.getString(VERBE_RADICAL));
		verbe.setParticipe(rs.getString(VERBE_PARTICIPE));
		rs.getInt(MODELE_ID);
		if (rs.wasNull()) {
			verbe.setModele(verbe);
		} else {
			VerbeImpl modele = new VerbeImpl();
			modele.setInfinitif(rs.getString(MODELE_INFINITIF));
			modele.setAuxiliaire(Auxiliaire.values()[rs.getInt(MODELE_AUXILIAIRE)]);
			modele.setRadical(rs.getString(MODELE_RADICAL));
			modele.setParticipe(rs.getString(MODELE_PARTICIPE));
			modele.setModele(modele);
			verbe.setModele(modele);
		}
		return verbe;
	}

}
