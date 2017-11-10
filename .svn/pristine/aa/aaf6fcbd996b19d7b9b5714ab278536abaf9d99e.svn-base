package be.steformations.java_data.pc.conjugaison_fr.dao.jpa.entities;

import be.steformations.java_data.pc.conjugaison_fr.beans.VerbeImpl;

public class VerbeEntity extends VerbeImpl{

	private static final long serialVersionUID = 5489404948093058404L;

	protected Integer id;
	protected VerbeEntity modeleAsEntity;
	
	public VerbeEntity() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@Override
	public VerbeImpl getModele() {
		if (this.modeleAsEntity == null) {
			return this;
		}
		return this.modeleAsEntity;
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
		VerbeEntity other = (VerbeEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VerbeEntity [id=" + id + ", infinitif=" + infinitif + ", radical=" + radical + ", participe="
				+ participe + ", auxiliaire=" + auxiliaire + ", modele=" + modele + "]";
	}
}
