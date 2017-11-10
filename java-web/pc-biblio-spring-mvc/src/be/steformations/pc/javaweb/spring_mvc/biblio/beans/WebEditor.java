package be.steformations.pc.javaweb.spring_mvc.biblio.beans;

import be.steformations.java_data.biblio.interfaces.Collection;

@SuppressWarnings("serial")
public class WebEditor implements Collection {

	protected Collection delegate;
	protected int bookCount;
	
	public WebEditor(Collection delegate) {
		super();
		this.delegate = delegate;
	}

	public Integer getId() {
		return delegate.getId();
	}

	public String getNom() {
		return delegate.getNom();
	}

	public int getBookCount() {
		return bookCount;
	}

	public void setBookCount(int bookCount) {
		this.bookCount = bookCount;
	}
}
