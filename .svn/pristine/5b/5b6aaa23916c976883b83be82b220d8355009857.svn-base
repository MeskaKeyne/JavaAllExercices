package be.steformations.pc.javaweb.jsf.biblio.beans;

import be.steformations.java_data.biblio.interfaces.Emprunteur;
import be.steformations.java_data.biblio.interfaces.Reservation;

@SuppressWarnings("serial")
public class WebUser implements Emprunteur {

	private Emprunteur delegate;
	private java.util.List<Reservation> bookings;

	public WebUser(Emprunteur delegate) {
		super();
		this.delegate = delegate;
	}

	public java.util.List<Reservation> getBookings() {
		if (this.bookings == null) {
			this.bookings = new java.util.ArrayList<>();
		}
		return bookings;
	}
	
	public Integer getId() {
		return delegate.getId();
	}

	public String getPrenom() {
		return delegate.getPrenom();
	}

	public String getNom() {
		return delegate.getNom();
	}

	public java.util.Date getDateDeNaissance() {
		return delegate.getDateDeNaissance();
	}

	public String getTelephone() {
		return delegate.getTelephone();
	}

	public String getEmail() {
		return delegate.getEmail();
	}
}
