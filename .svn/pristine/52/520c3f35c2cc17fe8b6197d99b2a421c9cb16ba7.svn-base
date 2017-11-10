package be.steformations.java_data.pc.conjugaison_fr.beans;

import be.steformations.java_data.conjugaison_fr.interfaces.Conjugaison;
import be.steformations.java_data.conjugaison_fr.interfaces.Mode;
import be.steformations.java_data.conjugaison_fr.interfaces.Personne;
import be.steformations.java_data.conjugaison_fr.interfaces.Temps;
import be.steformations.java_data.conjugaison_fr.interfaces.Verbe;

public class ConjugaisonImpl implements Conjugaison {

	protected Mode mode;
	protected Temps temps;
	protected Personne personne;
	protected Verbe verbe;
	protected String valeur;
	
	public ConjugaisonImpl() {
		super();
	}

	public Mode getMode() {
		return mode;
	}

	public void setMode(Mode mode) {
		this.mode = mode;
	}

	public Temps getTemps() {
		return temps;
	}

	public void setTemps(Temps temps) {
		this.temps = temps;
	}

	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	public Verbe getVerbe() {
		return verbe;
	}

	public void setVerbe(Verbe verbe) {
		this.verbe = verbe;
	}

	public String getValeur() {
		return valeur;
	}

	public void setValeur(String valeur) {
		this.valeur = valeur;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mode == null) ? 0 : mode.hashCode());
		result = prime * result + ((personne == null) ? 0 : personne.hashCode());
		result = prime * result + ((temps == null) ? 0 : temps.hashCode());
		result = prime * result + ((valeur == null) ? 0 : valeur.hashCode());
		result = prime * result + ((verbe == null) ? 0 : verbe.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConjugaisonImpl other = (ConjugaisonImpl) obj;
		if (mode != other.mode)
			return false;
		if (personne != other.personne)
			return false;
		if (temps != other.temps)
			return false;
		if (valeur == null) {
			if (other.valeur != null)
				return false;
		} else if (!valeur.equals(other.valeur))
			return false;
		if (verbe == null) {
			if (other.verbe != null)
				return false;
		} else if (!verbe.equals(other.verbe))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ConjugaisonImpl [mode=" + mode + ", temps=" + temps + ", personne=" + personne + ", verbe=" + verbe
				+ ", valeur=" + valeur + "]";
	}
}
