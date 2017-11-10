package be.steformations.pc.javaweb.spring_mvc.biblio.beans;

import java.util.Date;
import java.util.List;

import be.steformations.java_data.biblio.interfaces.Auteur;
import be.steformations.java_data.biblio.interfaces.Collection;
import be.steformations.java_data.biblio.interfaces.Livre;

@SuppressWarnings("serial")
public class WebBook implements Livre {

	protected Livre delegate;
	protected boolean available;;

	public WebBook(Livre delegate) {
		super();
		this.delegate = delegate;
	}
	
	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public String getCode() {
		return delegate.getCode();
	}

	public String getTitre() {
		return delegate.getTitre();
	}

	public short getNombreDePages() {
		return delegate.getNombreDePages();
	}

	public short getNumeroEdition() {
		return delegate.getNumeroEdition();
	}

	public Date getDateDeParution() {
		return delegate.getDateDeParution();
	}

	public Collection getCollection() {
		return delegate.getCollection();
	}

	public List<? extends Auteur> getAuteurs() {
		return delegate.getAuteurs();
	}
	
	
}
