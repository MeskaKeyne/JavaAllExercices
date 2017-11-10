package be.steformations.java_data.pc.conjugaison_fr.dao.jpa.entities;

import be.steformations.java_data.pc.conjugaison_fr.beans.ConjugaisonImpl;
import be.steformations.java_data.pc.conjugaison_fr.beans.VerbeImpl;

public class ConjugaisonEntity extends ConjugaisonImpl {

	protected Integer id;
	protected VerbeEntity verbeEntity;
	
	public ConjugaisonEntity() {
		super();
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Override
	public VerbeImpl getVerbe() {
		return verbeEntity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConjugaisonEntity other = (ConjugaisonEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ConjugaisonEntity [id=" + id + ", mode=" + mode + ", temps=" + temps + ", personne=" + personne
				+ ", verbe=" + verbe + ", valeur=" + valeur + "]";
	}
}
