package be.steformations.pc.javaweb.struts.calcul.controleurs;

import be.steformations.pc.javaweb.calcul.modele.Calcul;
import be.steformations.pc.javaweb.calcul.modele.GestionnaireCalcul;

public class Generer { // scope Request

	private Calcul calcul;
	private GestionnaireCalcul gestionnaireCalcul;
	
	public Generer() {
		System.out.println("Generer.Generer()");
		this.gestionnaireCalcul = new GestionnaireCalcul(10);
	}
	
	public Calcul getCalcul() {
		System.out.println("Generer.getCalcul()");
		return this.calcul;
	}
	
	// http:localhost:8080/webcalcul-struts/nouveau.action
	public String createAndShowCalcul() {
		System.out.println("Generer.createAndShowCalcul()");

//		this.calcul = new Calcul();
//		this.calcul.setOperandeGauche(10);
//		this.calcul.setOperandeDroite(5);
//		this.calcul.setOperation(Operation.ADDITION);
//		this.calcul.setResultat(15);
		
		this.calcul = this.gestionnaireCalcul.genererCalcul();
		// mise en session du calcul
		com.opensymphony.xwork2.ActionContext.getContext()
			.getSession().put("calcul", this.calcul);
		
		return "ok";
	}
			
}
