package be.steformations.pc.java_data.contacts.spring_jdbc;

import be.steformations.java_data.contacts.interfaces.dao.ContactDao;
import be.steformations.java_data.contacts.interfaces.dao.CountryDao;
import be.steformations.java_data.contacts.interfaces.dao.DaoFactory;
import be.steformations.java_data.contacts.interfaces.dao.TagDao;
import be.steformations.pc.java_data.contacts.spring_jdbc.managers.ContactsManager;
import be.steformations.pc.java_data.contacts.spring_jdbc.managers.CountryManager;
import be.steformations.pc.java_data.contacts.spring_jdbc.managers.TagManager;

public class SpringJdbcFactory implements DaoFactory {

	private static SpringJdbcFactory instance;

	protected javax.sql.DataSource dataSource;
	protected TagManager tagManager;
	protected CountryManager countryManager;
	protected ContactsManager contactsManager;

	public static SpringJdbcFactory getInstance() {
		if (instance == null) {
			try {
				javax.sql.DataSource dataSource 
					= new org.springframework.jdbc.datasource.SingleConnectionDataSource(
						"jdbc:postgresql://localhost/contacts_jdbc",
						"postgres",
						"postgres", true);
				instance = new SpringJdbcFactory(dataSource);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return instance;
	}

	protected SpringJdbcFactory(javax.sql.DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	@Override
	public ContactDao getContactDao() {
		if (this.contactsManager == null) {
			this.contactsManager = new ContactsManager(this.dataSource,
					this.getCountryDao(), this.getTagDao());
		}
		return this.contactsManager;
	}

	@Override
	public CountryDao getCountryDao() {
		if (this.countryManager == null) {
			this.countryManager = new CountryManager(this.dataSource);
		}
		return this.countryManager;
	}

	@Override
	public TagDao getTagDao() {
		if (this.tagManager == null) {
			this.tagManager = new TagManager(this.dataSource);
		}
		return this.tagManager;
	}

}
