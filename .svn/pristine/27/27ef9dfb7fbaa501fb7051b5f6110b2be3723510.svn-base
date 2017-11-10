package be.steformations.javaweb.servlet_jsp.contacts.pc.beans;

import be.steformations.java_data.contacts.interfaces.beans.Contact;
import be.steformations.java_data.contacts.interfaces.beans.Country;
import be.steformations.java_data.contacts.interfaces.beans.Tag;

public class WebContact implements Contact {

	protected final Contact source;
	protected java.util.List<Tag> tags;
	
	public WebContact(Contact source) {
		super();
		this.source = source;
	}

	public java.util.List<Tag> getTags() {
		if (this.tags == null) {
			this.tags = new java.util.ArrayList<Tag>();
		}
		return this.tags;
	}

	public Integer getId() {
		return source.getId();
	}

	public String getName() {
		return source.getName();
	}

	public String getFirstname() {
		return source.getFirstname();
	}

	public String getEmail() {
		return source.getEmail();
	}

	public Country getCountry() {
		return source.getCountry();
	}
}
