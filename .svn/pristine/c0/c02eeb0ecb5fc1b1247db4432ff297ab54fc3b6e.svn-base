package be.steformations.pc.javaweb.jsf.biblio.session;

import be.steformations.pc.javaweb.jsf.biblio.beans.WebBook;

@javax.faces.bean.ManagedBean
@javax.faces.bean.SessionScoped
public class SearchResults {

	private java.util.List<WebBook> books;
	private boolean initialized;
	
	public SearchResults() {
		super();
	}
	
	public java.util.List<WebBook> getBooks() {
		if (this.books == null) {
			this.books = new java.util.ArrayList<>();
		}
		return this.books;
	}
	
	public boolean isInitialized() {
		return initialized;
	}
	
	public void setInitialized(boolean initialized) {
		this.initialized = initialized;
	}
	
	public void setAvailable(String bookCode, boolean available) {
		boolean found = false;
		for (java.util.Iterator<WebBook> iterator = books.iterator(); !found && iterator.hasNext();) {
			WebBook webBook = iterator.next();
			if (webBook.getCode().equals(bookCode)) {
				found = true;
				webBook.setAvailable(available);
			}
		}
	}
}
