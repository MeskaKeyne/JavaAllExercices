package be.steformations.pc.java_data.contacts.beans;

import be.steformations.java_data.contacts.interfaces.beans.Country;

public class CountryImpl implements Country {

	protected Integer id;
	protected String abbreviation;
	protected String name;
	
	@Override
	public Integer getId() {
		return id;
	}
	
	@Override
	public String getAbbreviation() {
		return abbreviation;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((abbreviation == null) ? 0 : abbreviation.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		CountryImpl other = (CountryImpl) obj;
		if (abbreviation == null) {
			if (other.abbreviation != null)
				return false;
		} else if (!abbreviation.equals(other.abbreviation))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", abbreviation=" + abbreviation + ", name=" + name + "]";
	}
}
