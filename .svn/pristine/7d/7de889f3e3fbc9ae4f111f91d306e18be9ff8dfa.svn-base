package be.steformations.pc.javaweb.spring.calcul.session;

import be.steformations.pc.javaweb.calcul.modele.Calcul;

@org.springframework.stereotype.Component
@org.springframework.context.annotation.Scope("session") // une instance par client
public class SessionCalcul {

	public SessionCalcul() {
		System.out.println("SessionCalcul.SessionCalcul()");
	}
	
	private Calcul courant;
	private java.util.List<Calcul> anciens;
	
	public Calcul getCourant() {
		return this.courant;
	}
	
	public void setCourant(Calcul courant) {
		this.courant = courant;
	}
	
	public java.util.List<Calcul> getAnciens() {
		if (this.anciens == null) {
			this.anciens = new java.util.ArrayList<>();
		}
		return this.anciens;
	}
	
	
}
