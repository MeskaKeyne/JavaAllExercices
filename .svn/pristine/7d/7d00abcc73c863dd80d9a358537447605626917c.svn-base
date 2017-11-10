package be.steformations.pc.java_data.comics;

import java.sql.Date;
import java.util.List;

import be.steformations.java_data.comics.interfaces.jdbc.ComicsJDBC;

public class ComicsSpringJdbcImpl implements ComicsJDBC {

	private org.springframework.jdbc.core.JdbcTemplate jdbcTemplate;
	
	public ComicsSpringJdbcImpl(String url, String login, String pwd) {
		super();
		javax.sql.DataSource dataSource
			= new org.springframework.jdbc.datasource.DriverManagerDataSource(url, login, pwd);
		this.jdbcTemplate = new org.springframework.jdbc.core.JdbcTemplate(dataSource);
	}
	
	@Override
	public boolean ping() {
		boolean ok = false;
		
		try {
			java.sql.Connection c = this.jdbcTemplate.getDataSource().getConnection();
			ok = true;
		} catch (java.sql.SQLException e) {
			e.printStackTrace();
		}
		
		return ok;
	}

	@Override
	public String selectAka(String prenom, String nom) {
		String aka = null;
		if (prenom != null && nom != null) {
			String sql = "select aka from personnages "
					+    "where prenom = ? and nom = ?";
			try {
				aka = this.jdbcTemplate.queryForObject(sql, String.class, prenom, nom);
			} catch(org.springframework.dao.EmptyResultDataAccessException e) {
				// pas de résultat
			}
		}
		
		return aka;
	}

	@Override
	public String selectGenre(String prenom, String nom) {
		String genre = null;
		if (prenom != null && nom != null) {
			String sql = "select g.nom as nomDuGenre "
					+    "from personnages as p join genres as g on g.num = p.fk_genre "
					+    "where p.prenom = ? and p.nom = ?";
			try {
				genre = this.jdbcTemplate.queryForObject(sql, String.class, prenom, nom);
			} catch(org.springframework.dao.EmptyResultDataAccessException e) {
				// pas de résultat
			}
		}
		
		return genre;
	}

	@Override
	public List<String> selectPrenoms(String genre) {
		java.util.List<String> liste = null;
		
		if (genre != null) {
			String sql = "select prenom from personnages join genres on fk_genre=num "
					+    "where genres.nom = ?";
			liste = this.jdbcTemplate.queryForList(sql, String.class, genre);
		} else {
			liste = java.util.Collections.emptyList();
		}
		return liste;
	}

	@Override
	public int insertPersonnage(String prenom, String nom, String aka, Date ddn) {
		int id = 0;
		
		if (prenom != null && nom != null) {
			String sqlInsert = "insert into personnages(prenom, nom, aka, ddn) "
			         + " values(?, ?, ?, ?)";
			String sqlSelect = "select pk from personnages where prenom = ? and nom = ?";
			
			this.jdbcTemplate.update(sqlInsert, prenom, nom, aka, ddn);
			id = this.jdbcTemplate.queryForObject(sqlSelect, Integer.class, prenom, nom);
		}
		
		return id;
	}

	@Override
	public void updateAka(String prenom, String nom, String aka) {
		if (prenom != null && nom != null) {
			String sql = "update personnages set aka = ? "
					+    "where prenom = ? and nom = ? ";
			this.jdbcTemplate.update(sql, aka, prenom, nom);
		}
		
	}

}
