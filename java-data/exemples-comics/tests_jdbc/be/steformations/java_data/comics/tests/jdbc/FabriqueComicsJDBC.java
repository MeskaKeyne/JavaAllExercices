package be.steformations.java_data.comics.tests.jdbc;

import be.steformations.java_data.comics.interfaces.jdbc.ComicsJDBC;

public class FabriqueComicsJDBC {

	public static ComicsJDBC getComicsJDBC() {
		// return new be.steformations.pc.java_data.comics.ComicsJdbcImpl();
		return new be.steformations.pc.java_data.comics.ComicsSpringJdbcImpl("jdbc:postgresql://localhost/comics-java", "postgres", "postgres");
	}
}
