package be.steformations.javaweb.servlet_jsp.contacts.pc.dao;

import be.steformations.pc.java_data.contacts.dto.ContactDto;
import be.steformations.pc.java_data.contacts.dto.CountryDto;
import be.steformations.pc.java_data.contacts.dto.TagDto;
import be.steformations.pc.service.contacts.rest.ContactRestClient;

public class ContactsWebDao {

	private ContactRestClient contactRestClient;
	
	private java.util.List<TagDto> tags;
	private java.util.List<CountryDto> countries;
	private java.util.List<ContactDto> contacts;
	
	public ContactsWebDao() {
		super();
		this.contactRestClient = new ContactRestClient();
	}
	
	public java.util.List<TagDto> selectTags() {
		if (this.tags == null) {
			this.tags = this.contactRestClient.getAllTags();
		}
		return tags;
	};
	
	public boolean insertTag(String valeur) {
		boolean ok = false;
		if (this.contactRestClient.createAndSaveTag(valeur) != null) {
			ok = true;
			this.tags = this.contactRestClient.getAllTags();
		} 
		return ok;
	}
	
	public java.util.List<TagDto> deleteTag(int id) {
		this.contactRestClient.removeTag(id);
		this.tags = this.contactRestClient.getAllTags();
		this.contacts = this.contactRestClient.getAllContacts();
		return this.tags;
	}
	
	public java.util.List<CountryDto> selectCountries() {
		if (this.countries == null) {
			this.countries = this.contactRestClient.getAllCountries();
		}
		return this.countries;
	}
	
	public boolean insertCountry(String abreviation, String nom) {
		boolean ok = false;
		if (this.contactRestClient.createAndSaveCountry(abreviation, nom) != null) {
			ok = true;
			this.countries = this.contactRestClient.getAllCountries();
		} 
		return ok;
	}
	
	public java.util.List<ContactDto> selectContacts() {
		if (this.contacts == null) {
			this.contacts = this.contactRestClient.getAllContacts();
		}
		return this.contacts;
	}
	
	public boolean insertContact(String prenom, String nom, String email,
			String abreviationPays, java.util.List<String> tags) {
		boolean ok = false;
		if (prenom != null && nom != null && email != null
			&& this.contactRestClient.createAndSaveContact(prenom, nom, email, abreviationPays, tags) != null) {
				ok = true;
			this.contacts = this.contactRestClient.getAllContacts();
		}
		return ok;
	
	}
	
	public java.util.List<ContactDto> deleteContact(int id) {
		ContactDto c = this.contactRestClient.removeContact(id);
		if (c != null) {
			this.contacts = this.contactRestClient.getAllContacts();
		} 
		return this.contacts;
	}
}
