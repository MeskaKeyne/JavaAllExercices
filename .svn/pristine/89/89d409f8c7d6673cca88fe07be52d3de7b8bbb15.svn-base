package be.steformations.pc.javaweb.jsf.biblio.actions;

import be.steformations.pc.javaweb.jsf.biblio.services.JsfLibraryService;
import be.steformations.pc.javaweb.jsf.biblio.session.SearchCriteria;
import be.steformations.pc.javaweb.jsf.biblio.session.SearchResults;

@javax.faces.bean.ManagedBean
@javax.faces.bean.RequestScoped
public class Search {

	@javax.faces.bean.ManagedProperty(value="#{service}")
	private JsfLibraryService service;
	@javax.faces.bean.ManagedProperty(value="#{searchCriteria}")
	private SearchCriteria searchCriteria;
	@javax.faces.bean.ManagedProperty(value="#{searchResults}")
	private SearchResults searchResults;
	
	public Search() {
		super();
	}
	
	public void setService(JsfLibraryService service) {
		this.service = service;
	}
	
	public void setSearchCriteria(SearchCriteria searchCriteria) {
		this.searchCriteria = searchCriteria;
	}
	
	public void setSearchResults(SearchResults searchResults) {
		this.searchResults = searchResults;
	}
	
	public String execute() {
		Integer author = this.searchCriteria.getAuthorId();
		Integer editor = this.searchCriteria.getEditorId();
		String pattern = this.searchCriteria.getPattern();
		
		if (author == 0) { author = null; }
		if (editor == 0) { editor = null; }
		if (pattern.isEmpty()) { pattern = null; }
		
		this.searchResults.setInitialized(true);
		this.searchResults.getBooks().clear();
		this.searchResults.getBooks().addAll(this.service.search(author, editor, pattern));
		
		return null;
	}
}
