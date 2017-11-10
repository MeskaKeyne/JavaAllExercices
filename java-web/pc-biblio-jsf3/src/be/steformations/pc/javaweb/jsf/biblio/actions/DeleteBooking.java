package be.steformations.pc.javaweb.jsf.biblio.actions;

import be.steformations.java_data.biblio.interfaces.Reservation;
import be.steformations.pc.javaweb.jsf.biblio.services.JsfLibraryService;
import be.steformations.pc.javaweb.jsf.biblio.session.Connection;
import be.steformations.pc.javaweb.jsf.biblio.session.SearchResults;

@javax.faces.bean.ManagedBean
@javax.faces.bean.RequestScoped
public class DeleteBooking {

	@javax.faces.bean.ManagedProperty(value="#{service}")
	private JsfLibraryService service;
	@javax.faces.bean.ManagedProperty(value="#{connection}")
	private Connection connection;	
	@javax.faces.bean.ManagedProperty(value="#{searchResults}")
	private SearchResults searchResults;	
	@javax.faces.bean.ManagedProperty(value="#{param.id}")
	private int id;
	
	public DeleteBooking() {
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
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String execute() {
		Reservation booking = this.service.getBooking(this.id);
		if (booking != null && this.service.removeBooking(this.id)) {
			this.service.refreshUserBookings(this.connection.getUser());
			this.searchResults.setAvailable(booking.getLivre().getCode(), true);
		}
		return null;
	}
}
