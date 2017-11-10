package be.steformations.pc.java_data.contacts.dto;

/*
 
 <tag>
 	<id>1</id>
 	<value>vamp</value>
 </tag>
 
 */

@javax.xml.bind.annotation.XmlRootElement(name="tag")
public class TagDto {
	
	private Integer id;
	private String value;
	
	// nécessaire pour Jaxb
	public TagDto() {
		super();
	}

	// nécessaire pour Jaxb
	public Integer getId() {
		return id;
	}

	// nécessaire pour Jaxb
	public void setId(Integer id) {
		this.id = id;
	}

	// nécessaire pour Jaxb
	public String getValue() {
		return value;
	}

	// nécessaire pour Jaxb
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
		TagDto other = (TagDto) obj;
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
		return "TagDto [id=" + id + ", value=" + value + "]";
	}
}
