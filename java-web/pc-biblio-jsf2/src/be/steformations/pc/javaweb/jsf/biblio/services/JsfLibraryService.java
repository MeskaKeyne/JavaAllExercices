package be.steformations.pc.javaweb.jsf.biblio.services;

import be.steformations.java_data.biblio.interfaces.Auteur;
import be.steformations.java_data.biblio.interfaces.Collection;
import be.steformations.java_data.biblio.interfaces.Emprunteur;
import be.steformations.java_data.biblio.interfaces.GestionnaireBibliotheque;
import be.steformations.java_data.biblio.interfaces.Livre;
import be.steformations.java_data.biblio.interfaces.Reservation;
import be.steformations.pc.java_data.biblio.dao.jpa.JpaGestionnaireBibliotheque;
import be.steformations.pc.javaweb.jsf.biblio.beans.WebBook;
import be.steformations.pc.javaweb.jsf.biblio.beans.WebUser;

@javax.faces.bean.ManagedBean(name="service")
@javax.faces.bean.ApplicationScoped
public class JsfLibraryService {

	protected GestionnaireBibliotheque delegate;
	
	public JsfLibraryService() {
		super();
		try {
			javax.persistence.EntityManager em 
				= javax.persistence.Persistence.createEntityManagerFactory("postgresql_eclipselink").createEntityManager();
			this.delegate = new JpaGestionnaireBibliotheque(em);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public WebUser getUser(String email) {
		WebUser user = null;
		Emprunteur e = delegate.getEmprunteurByEmail(email);
		if (e != null) {
			user = new WebUser(e);
			user.getBookings().addAll(this.delegate.getReservationsByEmprunteurCode(user.getId()));
		}
		return user;
	}

	public Reservation getBooking(int id) {
		return this.delegate.getReservationByCode(id);
	}
	
	public void refreshUserBookings(WebUser user) {
		user.getBookings().clear();
		user.getBookings().addAll(this.delegate.getReservationsByEmprunteurCode(user.getId()));
	}
	
	public java.util.List<? extends Auteur> getAuthors() {
		return delegate.getAllAuteurs();
	}

	public java.util.List<? extends Collection> getEditors() {
		return delegate.getAllCollections();
	}

	public java.util.List<WebBook> search(Integer authorId, Integer editorId, String pattern) {
		java.util.List<WebBook> list = new java.util.ArrayList<>();
		for (Livre l : this.delegate.searchLivres(authorId, editorId, pattern)) {
			WebBook b = new WebBook(l);
			b.setAvailable(this.delegate.getReservationsByLivreCode(b.getCode()).isEmpty());
			list.add(b);
		}
		return list;
	}

	public Reservation addBooking(int userID, String bookCode) {
		return delegate.addReservation(userID, bookCode);
	}

	public boolean removeBooking(int id) {
		delegate.removeReservation(id);
		if (delegate.getReservationByCode(id) != null) {
			return false;
		}
		return true;
	}
}
