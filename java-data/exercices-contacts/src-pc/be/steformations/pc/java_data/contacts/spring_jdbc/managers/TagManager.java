package be.steformations.pc.java_data.contacts.spring_jdbc.managers;

import be.steformations.java_data.contacts.interfaces.beans.Tag;
import be.steformations.java_data.contacts.interfaces.dao.TagDao;
import be.steformations.pc.java_data.contacts.spring_jdbc.mappers.TagRowMapper;

public class TagManager implements TagDao {

	protected org.springframework.jdbc.core.JdbcTemplate jdbcTemplate;
	protected TagRowMapper tagRowMapper;

	public TagManager(javax.sql.DataSource dataSource) {
		super();
		this.jdbcTemplate = new org.springframework.jdbc.core.JdbcTemplate(
				dataSource);
		this.tagRowMapper = new TagRowMapper("tag_id", "tag_value");
	}

	@Override
	public Tag getTagByValue(String value) {
		Tag tag = null;
		if (value != null && !value.isEmpty()) {
			String sql = String
					.format("select t.id as %s, t.tag as %s from tags t where t.tag = ?",
							this.tagRowMapper.idColumn,
							this.tagRowMapper.valueColumn);
			try {
				tag = this.jdbcTemplate.queryForObject(sql, this.tagRowMapper,
						value);
			} catch (org.springframework.dao.EmptyResultDataAccessException ignored) {
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return tag;
	}

	@Override
	public Tag getTagById(int id) {
		Tag tag = null;
		if (id > 0) {
			String sql = String
					.format("select t.id as %s, t.tag as %s from tags t where t.id = ?",
							this.tagRowMapper.idColumn,
							this.tagRowMapper.valueColumn);
			try {
				tag = this.jdbcTemplate.queryForObject(sql, this.tagRowMapper,
						id);
			} catch (org.springframework.dao.EmptyResultDataAccessException ignored) {
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return tag;
	}

	@Override
	public java.util.List<Tag> getAllTags() {
		java.util.List<Tag> tags = new java.util.ArrayList<Tag>();
		String sql = String
				.format("select t.id as %s, t.tag as %s from tags t",
						this.tagRowMapper.idColumn,
						this.tagRowMapper.valueColumn);
		try {
			tags = this.jdbcTemplate.query(sql, this.tagRowMapper);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tags;
	}

	@Override
	public Tag createAndSaveTag(String value) {
		Tag tag = null;
		if (value != null && !value.isEmpty() && (tag = this.getTagByValue(value)) == null) {
			try {
				this.jdbcTemplate.update("insert into tags(tag) values(?)", value);
				tag = this.getTagByValue(value);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return tag;
	}

	@Override
	public void removeTag(int id) {
		if (id > 0) {
			try {
				this.jdbcTemplate.update("delete from tags where id = ?", id);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
