package be.steformations.pc.javaweb.jsf.calcul.session;

import be.steformations.pc.javaweb.calcul.modele.Calcul;

//@javax.faces.bean.ManagedBean
//@javax.faces.bean.SessionScoped
public class SessionCalcul {

	private Calcul courant;
	private java.util.List<Calcul> anciens;

	public SessionCalcul() {
		System.out.println("SessionCalcul.SessionCalcul()");
	}
	
	public Calcul getCourant() {
		return courant;
	}
	
	public void setCourant(Calcul courant) {
		this.courant = courant;
	}
	
	public java.util.List<Calcul> getAnciens() {
		if (this.anciens == null) {
			this.anciens = new java.util.ArrayList<>();
		}
		return anciens;
	}
}
