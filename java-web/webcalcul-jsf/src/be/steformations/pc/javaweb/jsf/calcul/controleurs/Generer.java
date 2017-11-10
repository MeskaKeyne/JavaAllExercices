package be.steformations.pc.javaweb.jsf.calcul.controleurs;

import be.steformations.pc.javaweb.calcul.modele.Calcul;
import be.steformations.pc.javaweb.jsf.calcul.modele.JsfGestionnaireCalcul;
import be.steformations.pc.javaweb.jsf.calcul.session.SessionCalcul;

//@javax.faces.bean.ManagedBean
//@javax.faces.bean.RequestScoped // par défaut
public class Generer {

	private Calcul calcul;
	//@javax.faces.bean.ManagedProperty(value="#{jsfGestionnaireCalcul}")
	private JsfGestionnaireCalcul jsfGestionnaireCalcul;
	//@javax.faces.bean.ManagedProperty(value="#{sessionCalcul}")
	private SessionCalcul sessionCalcul;
	
	public Generer() {
		System.out.println("Generer.Generer()");
		
//		this.calcul = new Calcul();
//		this.calcul.setOperandeGauche(123);
//		this.calcul.setOperandeDroite(456);
//		this.calcul.setOperation(Operation.ADDITION);
//		this.calcul.setResultat(579);

		// trop tôt: le jsfGestionnaireCalcul n'a pas encore été injecté => NullPointerException
//		this.calcul = this.jsfGestionnaireCalcul.genererCalcul();
	}
	
	// obligatoire pour l'injection avec @ManagedProperty
	public void setJsfGestionnaireCalcul(JsfGestionnaireCalcul jsfGestionnaireCalcul) {
		System.out.println("Generer.setJsfGestionnaireCalcul()");
		this.jsfGestionnaireCalcul = jsfGestionnaireCalcul;
	}
	
	public void setSessionCalcul(SessionCalcul sessionCalcul) {
		System.out.println("Generer.setSessionCalcul()");
		this.sessionCalcul = sessionCalcul;
	}
	
	public Calcul getCalcul() {
		System.out.println("Generer.getCalcul()");
		if (this.calcul == null) {
			this.calcul = this.jsfGestionnaireCalcul.genererCalcul();
			this.sessionCalcul.setCourant(this.calcul);
		}
		return calcul;
	}
}
