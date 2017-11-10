package be.steformations.pc.java_data.contacts.spring_jdbc.managers;

import be.steformations.java_data.contacts.interfaces.beans.Country;
import be.steformations.java_data.contacts.interfaces.dao.CountryDao;
import be.steformations.pc.java_data.contacts.spring_jdbc.mappers.CountryRowMapper;

public class CountryManager implements CountryDao {

	protected org.springframework.jdbc.core.JdbcTemplate jdbcTemplate;
	protected CountryRowMapper countryRowMapper;

	public CountryManager(javax.sql.DataSource dataSource) {
		super();
		this.jdbcTemplate = new org.springframework.jdbc.core.JdbcTemplate(
				dataSource);
		this.countryRowMapper = new CountryRowMapper("country_id",
				"country_abbreviation", "country_name");
	}

	@Override
	public Country getCountryByAbbreviation(String abbreviation) {
		Country country = null;
		if (abbreviation != null && !abbreviation.isEmpty()) {
			String sql = String
					.format("select p.id as %s, p.abreviation as %s, p.nom as %s from pays p where p.abreviation = ?",
							this.countryRowMapper.idColumn,
							this.countryRowMapper.abbreviationColumn,
							this.countryRowMapper.nameColumn);
			try {
				country = this.jdbcTemplate.queryForObject(sql, this.countryRowMapper, abbreviation);
			} catch (org.springframework.dao.EmptyResultDataAccessException ignored) {
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return country;
	}

	@Override
	public java.util.List<Country> getAllCountries() {
		java.util.List<Country> countries = new java.util.ArrayList<Country>();
		String sql = String
				.format("select p.id as %s, p.abreviation as %s, p.nom as %s from pays p",
						this.countryRowMapper.idColumn,
						this.countryRowMapper.abbreviationColumn,
						this.countryRowMapper.nameColumn);
		try {
			countries = this.jdbcTemplate.query(sql, this.countryRowMapper);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return countries;
	}

	@Override
	public Country createAndSaveCountry(String abbreviation, String name) {
		Country country = null;
		if (abbreviation != null && !abbreviation.isEmpty() && name != null
				&& !name.isEmpty() && this.getCountryByAbbreviation(abbreviation) == null) {
			try {
				this.jdbcTemplate.update("insert into pays(abreviation, nom) values(?, ?)", abbreviation, name);
				country = this.getCountryByAbbreviation(abbreviation);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return country;
	}

}
