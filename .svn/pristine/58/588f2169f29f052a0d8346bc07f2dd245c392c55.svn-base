package be.steformations.java_data.pc.conjugaison_fr.beans;

import be.steformations.java_data.conjugaison_fr.interfaces.Auxiliaire;
import be.steformations.java_data.conjugaison_fr.interfaces.Verbe;

public class VerbeImpl implements Verbe{

	private static final long serialVersionUID = 6825499221307810914L;

	protected String infinitif;
	protected String radical;
	protected String participe;
	protected Auxiliaire auxiliaire;
	protected VerbeImpl modele;
	
	public VerbeImpl() {
		super();
	}
	
	public String getInfinitif() {
		return infinitif;
	}

	public void setInfinitif(String infinitif) {
		this.infinitif = infinitif;
	}

	public String getRadical() {
		return radical;
	}

	public void setRadical(String radical) {
		this.radical = radical;
	}

	public String getParticipe() {
		return participe;
	}

	public void setParticipe(String participe) {
		this.participe = participe;
	}

	public Auxiliaire getAuxiliaire() {
		return auxiliaire;
	}

	public void setAuxiliaire(Auxiliaire auxiliaire) {
		this.auxiliaire = auxiliaire;
	}

	public VerbeImpl getModele() {
		return modele;
	}

	public void setModele(VerbeImpl modele) {
		this.modele = modele;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((auxiliaire == null) ? 0 : auxiliaire.hashCode());
		result = prime * result + ((infinitif == null) ? 0 : infinitif.hashCode());
		result = prime * result + ((modele == null) ? 0 : modele.hashCode());
		result = prime * result + ((participe == null) ? 0 : participe.hashCode());
		result = prime * result + ((radical == null) ? 0 : radical.hashCode());
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
		VerbeImpl other = (VerbeImpl) obj;
		if (auxiliaire != other.auxiliaire)
			return false;
		if (infinitif == null) {
			if (other.infinitif != null)
				return false;
		} else if (!infinitif.equals(other.infinitif))
			return false;
		if (modele == null) {
			if (other.modele != null)
				return false;
		} else if (!modele.equals(other.modele))
			return false;
		if (participe == null) {
			if (other.participe != null)
				return false;
		} else if (!participe.equals(other.participe))
			return false;
		if (radical == null) {
			if (other.radical != null)
				return false;
		} else if (!radical.equals(other.radical))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VerbeImpl [infinitif=" + infinitif + ", radical=" + radical + ", participe=" + participe
				+ ", auxiliaire=" + auxiliaire + ", modele=" + modele + "]";
	}
}
