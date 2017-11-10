package be.steformations.pc.javaweb.jsf.biblio.actions;

import be.steformations.pc.javaweb.jsf.biblio.services.JsfLibraryService;
import be.steformations.pc.javaweb.jsf.biblio.session.Connection;
import be.steformations.pc.javaweb.jsf.biblio.session.SearchResults;

@javax.faces.bean.ManagedBean
@javax.faces.bean.RequestScoped
public class AddBooking {

	@javax.faces.bean.ManagedProperty(value="#{service}")
	private JsfLibraryService service;
	@javax.faces.bean.ManagedProperty(value="#{connection}")
	private Connection connection;	
	@javax.faces.bean.ManagedProperty(value="#{searchResults}")
	private SearchResults searchResults;
	@javax.faces.bean.ManagedProperty(value="#{param.id}")
	private String id;
	
	public AddBooking() {
		super();
	}
	
	public void setService(JsfLibraryService service) {
		this.service = service;
	}
	
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	public void setSearchResults(SearchResults searchResults) {
		this.searchResults = searchResults;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String execute() {
		if (this.service.addBooking(this.connection.getUser().getId(), id) != null) {
			this.service.refreshUserBookings(this.connection.getUser());
			this.searchResults.setAvailable(id, false);
		}
		return "reservations";
	}
}
