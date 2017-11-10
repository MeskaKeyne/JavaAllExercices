package be.steformations.javaweb.servlet_jsp.contacts.pc.dao;

import be.steformations.java_data.contacts.interfaces.beans.Contact;
import be.steformations.java_data.contacts.interfaces.beans.Country;
import be.steformations.java_data.contacts.interfaces.beans.Tag;
import be.steformations.java_data.contacts.interfaces.dao.ContactDao;
import be.steformations.java_data.contacts.interfaces.dao.CountryDao;
import be.steformations.java_data.contacts.interfaces.dao.TagDao;
import be.steformations.javaweb.servlet_jsp.contacts.pc.beans.WebContact;
import be.steformations.pc.java_data.contacts.spring_jdbc.managers.ContactsManager;
import be.steformations.pc.java_data.contacts.spring_jdbc.managers.CountryManager;
import be.steformations.pc.java_data.contacts.spring_jdbc.managers.TagManager;

public class ContactsWebDao {

	private ContactDao contactDao;
	private CountryDao countryDao;
	private TagDao tagDao;
	
	private java.util.List<? extends Tag> tags;
	private java.util.List<? extends Country> countries;
	private java.util.List<WebContact> contacts;
	
	public ContactsWebDao(String url, String username, String password) throws Exception {	
		javax.sql.DataSource datasource
			= new org.springframework.jdbc.datasource.SingleConnectionDataSource(url, username, password, true);
		
		this.tagDao = new TagManager(datasource);
		this.countryDao = new CountryManager(datasource);
		this.contactDao = new ContactsManager(datasource, this.countryDao, this.tagDao);
	}
	
	public java.util.List<? extends Tag> selectTags() {
		if (this.tags == null) {
			this.tags = this.tagDao.getAllTags();
		}
		return tags;
	};
	
	public boolean insertTag(String valeur) {
		boolean ok = false;
		if (this.tagDao.createAndSaveTag(valeur) != null) {
			ok = true;
			this.tags = this.tagDao.getAllTags();
		} 
		return ok;
	}
	
	public java.util.List<? extends Tag> deleteTag(int id) {
		this.tagDao.removeTag(id);
		this.tags = this.tagDao.getAllTags();
		this.contacts = this.getWebContacts(); 
		return this.tags;
	}
	
	public java.util.List<? extends Country> selectCountries() {
		if (this.countries == null) {
			this.countries = this.countryDao.getAllCountries();
		}
		return this.countries;
	}
	
	public boolean insertCountry(String abreviation, String nom) {
		boolean ok = false;
		if (this.countryDao.createAndSaveCountry(abreviation, nom) != null) {
			ok = true;
			this.countries = this.countryDao.getAllCountries();
		} 
		return ok;
	}
	
	public java.util.List<WebContact> selectContacts() {
		if (this.contacts == null) {
			this.contacts = this.getWebContacts(); 
		}
		return this.contacts;
	}
	
	public boolean insertContact(String prenom, String nom, String email,
			String abreviationPays, java.util.List<String> tags) {
		boolean ok = false;
		if (prenom != null && nom != null && email != null
			&& this.contactDao.createAndSaveContact(prenom, nom, email, abreviationPays, tags) != null) {
				ok = true;
			this.contacts = this.getWebContacts();
		}
		return ok;
	
	}
	
	public java.util.List<WebContact> deleteContact(int id) {
		Contact c = this.contactDao.getContactById(id);
		if (c != null) {
			if (this.contactDao.removeContact(c.getId())) {
				this.contacts = this.getWebContacts();
			}
		} 
		return this.contacts;
	}
	
	protected java.util.List<WebContact> getWebContacts() {
		java.util.List<WebContact> list = new java.util.ArrayList<>();
		for (Contact source : this.contactDao.getAllContacts()) {
			WebContact wc = new WebContact(source);
			wc.getTags().addAll(this.contactDao.getTagsByContact(wc.getId()));
			list.add(wc);
		}
		return list;
	}
}
