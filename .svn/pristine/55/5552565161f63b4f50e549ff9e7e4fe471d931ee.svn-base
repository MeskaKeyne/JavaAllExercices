package be.steformations.pc.java_data.biblio.beans;

import be.steformations.java_data.biblio.interfaces.Emprunteur;

public class EmprunteurImpl implements Emprunteur{

	private static final long serialVersionUID = -6273242158789293922L;

	protected Integer id;
	protected String prenom;
	protected String nom;
	protected java.util.Date dateDeNaissance;
	protected String email;
	protected String telephone;
	
	public EmprunteurImpl() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public java.util.Date getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(java.util.Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateDeNaissance == null) ? 0 : dateDeNaissance.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		result = prime * result + ((telephone == null) ? 0 : telephone.hashCode());
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
		EmprunteurImpl other = (EmprunteurImpl) obj;
		if (dateDeNaissance == null) {
			if (other.dateDeNaissance != null)
				return false;
		} else if (!dateDeNaissance.equals(other.dateDeNaissance))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		if (telephone == null) {
			if (other.telephone != null)
				return false;
		} else if (!telephone.equals(other.telephone))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EmprunteurImpl [id=" + id + ", prenom=" + prenom + ", nom=" + nom + ", dateDeNaissance="
				+ dateDeNaissance + ", email=" + email + ", telephone=" + telephone + "]";
	}
}
