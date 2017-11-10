package be.steformations.pc.java_data.contacts.spring_jdbc.mappers;

import be.steformations.java_data.contacts.interfaces.beans.Tag;
import be.steformations.pc.java_data.contacts.beans.TagImpl;

public class TagRowMapper 
	implements org.springframework.jdbc.core.RowMapper<Tag> {

	public final String idColumn;
	public final String valueColumn;
	
	public TagRowMapper(String idColumn, String valueColumn) {
		super();
		this.idColumn = idColumn;
		this.valueColumn = valueColumn;
	}

	@Override
	public Tag mapRow(java.sql.ResultSet rs, int rank) throws java.sql.SQLException {
		TagImpl t = new TagImpl();
		t.setId(rs.getInt(this.idColumn));
		t.setValue(rs.getString(this.valueColumn));
		return t;
	}

}
