package be.steformations.pc.java_data.contacts.spring_jdbc.mappers;

import be.steformations.java_data.contacts.interfaces.beans.Contact;
import be.steformations.pc.java_data.contacts.beans.ContactImpl;
import be.steformations.pc.java_data.contacts.beans.CountryImpl;

public class ContactRowMapper 
	implements org.springframework.jdbc.core.RowMapper<Contact> {

	public final String idColumn;
	public final String firstnameColumn;
	public final String nameColumn;
	public final String emailColumn;
	public final String countryIdColumn;
	public final String countryAbbreviationColumn;
	public final String countryNameColumn;

	public ContactRowMapper(String idColumn, String firstnameColumn, String nameColumn, String emailColumn,
			String countryIdColumn, String countryAbbreviationColumn, String countryNameColumn) {
		super();
		this.idColumn = idColumn;
		this.firstnameColumn = firstnameColumn;
		this.nameColumn = nameColumn;
		this.emailColumn = emailColumn;
		this.countryIdColumn = countryIdColumn;
		this.countryAbbreviationColumn = countryAbbreviationColumn;
		this.countryNameColumn = countryNameColumn;
	}

	@Override
	public Contact mapRow(java.sql.ResultSet rs, int rank) throws java.sql.SQLException {
		ContactImpl c = new ContactImpl();
		c.setId(rs.getInt(idColumn));
		c.setFirstname(rs.getString(firstnameColumn));
		c.setName(rs.getString(nameColumn));
		c.setEmail(rs.getString(emailColumn));
		CountryImpl country = null;
		int countryId = rs.getInt(countryIdColumn);
		if ( !rs.wasNull() ) {
			country = new CountryImpl();
			country.setId(countryId);
			country.setAbbreviation(rs.getString(countryAbbreviationColumn));
			country.setName(rs.getString(countryNameColumn));
		}
		c.setCountry(country);
		return c;
	}

}
