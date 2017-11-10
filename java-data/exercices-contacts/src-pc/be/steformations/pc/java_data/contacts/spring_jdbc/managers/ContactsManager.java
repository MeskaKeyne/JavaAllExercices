package be.steformations.pc.java_data.contacts.spring_jdbc.managers;

import be.steformations.java_data.contacts.interfaces.beans.Contact;
import be.steformations.java_data.contacts.interfaces.beans.Country;
import be.steformations.java_data.contacts.interfaces.beans.Tag;
import be.steformations.java_data.contacts.interfaces.dao.ContactDao;
import be.steformations.java_data.contacts.interfaces.dao.CountryDao;
import be.steformations.java_data.contacts.interfaces.dao.TagDao;
import be.steformations.pc.java_data.contacts.spring_jdbc.mappers.ContactRowMapper;
import be.steformations.pc.java_data.contacts.spring_jdbc.mappers.TagRowMapper;

public class ContactsManager implements ContactDao {

	protected org.springframework.jdbc.core.JdbcTemplate jdbcTemplate;
	protected CountryDao countryDao;
	protected TagDao tagDao;
	protected ContactRowMapper contactRowMapper;
	protected TagRowMapper tagRowMapper;

	public ContactsManager(javax.sql.DataSource dataSource,
			CountryDao countryDao, TagDao tagDao) {
		super();
		this.jdbcTemplate = new org.springframework.jdbc.core.JdbcTemplate(
				dataSource);
		this.countryDao = countryDao;
		this.tagDao = tagDao;
		this.contactRowMapper = new ContactRowMapper("contact_id",
				"contact_fisrtname", "contact_name", "contact_email",
				"contact_country_id", "contact_country_abbreviation",
				"contact_country_name");
		this.tagRowMapper = new TagRowMapper("tag_id", "tag_value");
	}

	@Override
	public Contact getContactByFirstnameAndName(String firstname, String name) {
		Contact contact = null;
		if (firstname != null && !firstname.isEmpty() && name != null
				&& !name.isEmpty()) {
			String sql = String
					.format("select c.id as %s, c.prenom as %s, c.nom as %s, c.email as %s, p.id as %s, p.abreviation as %s, p.nom as %s from contacts c left join pays p on c.pays = p.id where c.prenom = ? and c.nom = ?",
							this.contactRowMapper.idColumn,
							this.contactRowMapper.firstnameColumn,
							this.contactRowMapper.nameColumn,
							this.contactRowMapper.emailColumn,
							this.contactRowMapper.countryIdColumn,
							this.contactRowMapper.countryAbbreviationColumn,
							this.contactRowMapper.countryNameColumn);
			try {
				contact = this.jdbcTemplate.queryForObject(sql,
						this.contactRowMapper, firstname, name);
			} catch (org.springframework.dao.EmptyResultDataAccessException ignored) {
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return contact;
	}

	@Override
	public Contact getContactById(int id) {
		Contact contact = null;
		if (id > 0) {
			String sql = String
					.format("select c.id as %s, c.prenom as %s, c.nom as %s, c.email as %s, p.id as %s, p.abreviation as %s, p.nom as %s from contacts c left join pays p on c.pays = p.id where c.id = ?",
							this.contactRowMapper.idColumn,
							this.contactRowMapper.firstnameColumn,
							this.contactRowMapper.nameColumn,
							this.contactRowMapper.emailColumn,
							this.contactRowMapper.countryIdColumn,
							this.contactRowMapper.countryAbbreviationColumn,
							this.contactRowMapper.countryNameColumn);
			try {
				contact = this.jdbcTemplate.queryForObject(sql,
						this.contactRowMapper, id);
			} catch (org.springframework.dao.EmptyResultDataAccessException ignored) {
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return contact;
	}

	public Contact getContactByEmail(String email) {
		Contact contact = null;
		if (email != null && !email.isEmpty()) {
			String sql = String
					.format("select c.id as %s, c.prenom as %s, c.nom as %s, c.email as %s, p.id as %s, p.abreviation as %s, p.nom as %s from contacts c left join pays p on c.pays = p.id where c.email = ?",
							this.contactRowMapper.idColumn,
							this.contactRowMapper.firstnameColumn,
							this.contactRowMapper.nameColumn,
							this.contactRowMapper.emailColumn,
							this.contactRowMapper.countryIdColumn,
							this.contactRowMapper.countryAbbreviationColumn,
							this.contactRowMapper.countryNameColumn);
			try {
				contact = this.jdbcTemplate.queryForObject(sql,
						this.contactRowMapper, email);
			} catch (org.springframework.dao.EmptyResultDataAccessException ignored) {
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return contact;
	}

	@Override
	public java.util.List<Contact> getContactsByCountry(String abbreviation) {
		java.util.List<Contact> contacts = new java.util.ArrayList<Contact>();
		String sql = String
				.format("select c.id as %s, c.prenom as %s, c.nom as %s, c.email as %s, p.id as %s, p.abreviation as %s, p.nom as %s from contacts c left join pays p on c.pays = p.id where p.abreviation = ?",
						this.contactRowMapper.idColumn,
						this.contactRowMapper.firstnameColumn,
						this.contactRowMapper.nameColumn,
						this.contactRowMapper.emailColumn,
						this.contactRowMapper.countryIdColumn,
						this.contactRowMapper.countryAbbreviationColumn,
						this.contactRowMapper.countryNameColumn);
		try {
			contacts = this.jdbcTemplate.query(sql, this.contactRowMapper,
					abbreviation);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return contacts;
	}

	@Override
	public java.util.List<Contact> getAllContacts() {
		java.util.List<Contact> contacts = new java.util.ArrayList<Contact>();
		String sql = String
				.format("select c.id as %s, c.prenom as %s, c.nom as %s, c.email as %s, p.id as %s, p.abreviation as %s, p.nom as %s from contacts c left join pays p on c.pays = p.id",
						this.contactRowMapper.idColumn,
						this.contactRowMapper.firstnameColumn,
						this.contactRowMapper.nameColumn,
						this.contactRowMapper.emailColumn,
						this.contactRowMapper.countryIdColumn,
						this.contactRowMapper.countryAbbreviationColumn,
						this.contactRowMapper.countryNameColumn);
		try {
			contacts = this.jdbcTemplate.query(sql, this.contactRowMapper);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return contacts;
	}

	@Override
	public java.util.List<Tag> getTagsByContact(int id) {
		java.util.List<Tag> tags = new java.util.ArrayList<Tag>();
		if (id > 0) {
			String sql = String
					.format("select t.id as %s, t.tag as %s from tags t join contacts_tags ct on ct.tag = t.id join contacts c on ct.contact = c.id where c.id = ?",
							this.tagRowMapper.idColumn,
							this.tagRowMapper.valueColumn);
			try {
				tags = this.jdbcTemplate.query(sql, this.tagRowMapper, id);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return tags;
	}

	@Override
	public Contact createAndSaveContact(String firstname, String name,
			String email, String countryAbbreviation,
			java.util.List<String> tagValues) {
		Contact contact = null;
		Country country = null;
		if (firstname != null
				&& !firstname.isEmpty()
				&& name != null
				&& !name.isEmpty()
				&& email != null
				&& !email.isEmpty()
				&& this.getContactByFirstnameAndName(firstname, name) == null
				&& this.getContactByEmail(email) == null
				&& (countryAbbreviation == null || (country = this.countryDao
						.getCountryByAbbreviation(countryAbbreviation)) != null)) {
			try {
				this.jdbcTemplate.getDataSource().getConnection()
						.setAutoCommit(false);
				try {
					this.jdbcTemplate
							.update("insert into contacts(prenom, nom, email, pays) values(?, ?, ?, ?)",
									firstname, name, email,
									country == null ? null : country.getId());
					contact = this.getContactByFirstnameAndName(firstname, name);
					if (tagValues != null && !tagValues.isEmpty()) {
						for (String value : tagValues) {
							Tag tag = this.tagDao.createAndSaveTag(value);
							this.jdbcTemplate.update("insert into contacts_tags(contact, tag) values(?, ?)", contact.getId(), tag.getId());
						}
					}
					this.jdbcTemplate.getDataSource().getConnection().commit();
				} catch (Exception e1) {
					this.jdbcTemplate.getDataSource().getConnection()
							.rollback();
					throw e1;
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return contact;
	}

	@Override
	public boolean removeContact(int id) {
		boolean deleted = false;
		if (id > 0) {
			try {
				deleted = this.jdbcTemplate.update("delete from contacts where id = ?", id) > 0;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return deleted;
	}

}
