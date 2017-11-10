package be.steformations.pc.java_data.contacts.beans;

import be.steformations.java_data.contacts.interfaces.beans.Tag;

public class TagImpl implements Tag {

	protected Integer id;
	protected String value;
	
	public TagImpl() {
		super();
	}

	@Override
	public Integer getId() {
		return id;
	}
	
	@Override
	public String getValue() {
		return value;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		TagImpl other = (TagImpl) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tag [id=" + id + ", value=" + value + "]";
	}
}
