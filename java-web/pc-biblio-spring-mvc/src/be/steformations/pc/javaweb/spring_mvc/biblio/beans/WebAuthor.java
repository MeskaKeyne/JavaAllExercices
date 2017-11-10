package be.steformations.pc.javaweb.spring_mvc.biblio.beans;

import be.steformations.java_data.biblio.interfaces.Auteur;

@SuppressWarnings("serial")
public class WebAuthor implements Auteur {

	protected Auteur delegate;
	protected int bookCount;
	
	public WebAuthor(Auteur delegate) {
		super();
		this.delegate = delegate;
	}

	public Integer getId() {
		return delegate.getId();
	}

	public String getNom() {
		return delegate.getNom();
	}

	public String getPrenom() {
		return delegate.getPrenom();
	}

	public int getBookCount() {
		return bookCount;
	}

	public void setBookCount(int bookCount) {
		this.bookCount = bookCount;
	}
}
