package be.steformations.pc.java_data.contacts.spring_jdbc.mappers;

import be.steformations.java_data.contacts.interfaces.beans.Country;
import be.steformations.pc.java_data.contacts.beans.CountryImpl;

public class CountryRowMapper 
	implements org.springframework.jdbc.core.RowMapper<Country> {

	public final String idColumn;
	public final String abbreviationColumn;
	public final String nameColumn;
	
	public CountryRowMapper(String idColumn, String abbreviationColumn, String nameColumn) {
		super();
		this.idColumn = idColumn;
		this.abbreviationColumn = abbreviationColumn;
		this.nameColumn = nameColumn;
	}

	@Override
	public Country mapRow(java.sql.ResultSet rs, int rank) throws java.sql.SQLException {
		CountryImpl c = new CountryImpl();
		c.setId(rs.getInt(idColumn));
		c.setAbbreviation(rs.getString(abbreviationColumn));
		c.setName(rs.getString(nameColumn));
		return c;
	}

}
