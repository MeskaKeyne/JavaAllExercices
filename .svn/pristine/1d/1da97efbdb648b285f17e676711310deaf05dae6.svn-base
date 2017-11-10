package be.steformations.pc.javaweb.spring_mvc.biblio.services;

import be.steformations.java_data.biblio.interfaces.Auteur;
import be.steformations.java_data.biblio.interfaces.Collection;
import be.steformations.java_data.biblio.interfaces.GestionnaireBibliotheque;
import be.steformations.java_data.biblio.interfaces.Livre;
import be.steformations.pc.java_data.biblio.dao.jpa.JpaGestionnaireBibliotheque;
import be.steformations.pc.javaweb.spring_mvc.biblio.beans.WebAuthor;
import be.steformations.pc.javaweb.spring_mvc.biblio.beans.WebBook;
import be.steformations.pc.javaweb.spring_mvc.biblio.beans.WebEditor;

@org.springframework.stereotype.Service
@org.springframework.context.annotation.Scope("application")
public class SpringLibraryService {

	protected GestionnaireBibliotheque delegate;
	protected java.util.List<WebEditor> editors;
	protected java.util.List<WebAuthor> authors;
	protected java.util.List<WebBook> books;
	
	public SpringLibraryService() {
		super(); 
		System.out.println("SpringLibraryService.SpringLibraryService()");
		try {
			javax.persistence.EntityManager em 
				= javax.persistence.Persistence.createEntityManagerFactory("postgresql_eclipselink").createEntityManager();
			this.delegate = new JpaGestionnaireBibliotheque(em);
			this.editors = new java.util.ArrayList<WebEditor>();
			this.authors = new java.util.ArrayList<WebAuthor>();
			this.books = new java.util.ArrayList<WebBook>();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public java.util.List<WebAuthor> getAllAuthors() {
		if (this.authors.isEmpty()) {
			this.loadAuthors();
		}
		return this.authors;
	}

	public boolean addAuthor(String firstname, String name) {
		boolean b = false;
		if (delegate.addAuteur(firstname, name) != null) {
			b = true;
			this.loadAuthors();
		}
		return b;
	}

	public void removeAuthor(int code) {
		delegate.removeAuteur(code);
		this.loadAuthors();
	}

	public java.util.List<WebEditor> getAllEditors() {
		if (this.editors.isEmpty()) {
			this.loadEditors();
		}
		return this.editors;
	}

	public boolean addEditorn(String name) {
		boolean b = false;
		if (delegate.addCollection(name) != null) {
			b = true;
			this.loadEditors();
		}
		return b;
	}

	public void removeEditor(int code) {
		delegate.removeCollection(code);
		this.loadEditors();
	}

	public boolean addBook(String title, short pages, java.sql.Date date, int editorId,
			short edition, java.util.List<Integer> authorsIds) {
		boolean b = false;
		if (delegate.addLivre(title, pages, date, editorId, edition, authorsIds) != null) {
			b = true;
			this.loadBooks();
		}
		return b;
	}

	public void removeBook(String code) {
		delegate.removeLivre(code);
		this.loadBooks();
	}

	public java.util.List<WebBook> getAllBooks() {
		if (this.books.isEmpty()) {
			this.loadBooks();
		}
		return this.books;
	}
	
	protected void loadEditors() {
		this.editors.clear();
		for (Collection c : this.delegate.getAllCollections()) {
			WebEditor e = new WebEditor(c);
			e.setBookCount(this.delegate.searchLivres(null, e.getId(), null).size());
			this.editors.add(e);
		}
	}
	
	protected void loadAuthors() {
		this.authors.clear();
		for (Auteur a : this.delegate.getAllAuteurs()) {
			WebAuthor author = new WebAuthor(a);
			author.setBookCount(this.delegate.searchLivres(a.getId(), null, null).size());
			this.authors.add(author);
		}
	}
	
	protected void loadBooks() {
		this.books.clear();
		for (Livre l : this.delegate.getAllLivres()) {
			WebBook b = new WebBook(l);
			b.setAvailable(this.delegate.getReservationsByLivreCode(b.getCode()).isEmpty());
			this.books.add(b);
		}
	}
}
