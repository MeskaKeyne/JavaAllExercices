package be.steformations.pc.java_data.biblio.beans;

import be.steformations.java_data.biblio.interfaces.Livre;

public class LivreImpl implements Livre {

	private static final long serialVersionUID = 7371190798200805621L;

	protected String code;
	protected String titre;
	protected java.util.Date dateDeParution;
	protected short nombreDePages;
	protected short numeroEdition;
	protected CollectionImpl collection;
	protected java.util.List<AuteurImpl> auteurs;
	
	public LivreImpl() {
		super();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public java.util.Date getDateDeParution() {
		return dateDeParution;
	}

	public void setDateDeParution(java.util.Date dateDeParution) {
		this.dateDeParution = dateDeParution;
	}

	public short getNombreDePages() {
		return nombreDePages;
	}

	public void setNombreDePages(short nombreDePages) {
		this.nombreDePages = nombreDePages;
	}

	public short getNumeroEdition() {
		return numeroEdition;
	}

	public void setNumeroEdition(short numeroEdition) {
		this.numeroEdition = numeroEdition;
	}

	public CollectionImpl getCollection() {
		return collection;
	}

	public void setCollection(CollectionImpl collection) {
		this.collection = collection;
	}

	public java.util.List<AuteurImpl> getAuteurs() {
		if (this.auteurs == null) {
			this.auteurs = new java.util.ArrayList<>();
		}
		return auteurs;
	}

	public void setAuteurs(java.util.List<AuteurImpl> auteurs) {
		this.auteurs = auteurs;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((collection == null) ? 0 : collection.hashCode());
		result = prime * result + ((titre == null) ? 0 : titre.hashCode());
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
		LivreImpl other = (LivreImpl) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (collection == null) {
			if (other.collection != null)
				return false;
		} else if (!collection.equals(other.collection))
			return false;
		if (titre == null) {
			if (other.titre != null)
				return false;
		} else if (!titre.equals(other.titre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LivreImpl [code=" + code + ", titre=" + titre + ", dateDeParution=" + dateDeParution
				+ ", nombreDePages=" + nombreDePages + ", numeroEdition=" + numeroEdition + ", collection=" + collection
				+ ", auteurs=" + auteurs + "]";
	}
}
