package be.steformations.pc.javaweb.jsf.calcul.modele;

import be.steformations.pc.javaweb.calcul.modele.Calcul;
import be.steformations.pc.javaweb.calcul.modele.GestionnaireCalcul;

//@javax.faces.bean.ManagedBean
//@javax.faces.bean.ApplicationScoped // singleton instancié pour toute la durée de vie de l'application
public class JsfGestionnaireCalcul {

	private GestionnaireCalcul gestionnaireCalcul;
	
	public JsfGestionnaireCalcul() {
		super();
		System.out.println("JsfGestionnaireCalcul.JsfGestionnaireCalcul()");
		this.gestionnaireCalcul = new GestionnaireCalcul(10);
	}

	public Calcul genererCalcul() {
		return gestionnaireCalcul.genererCalcul();
	}

	public void verifierSolution(Calcul calcul, int proposition) {
		gestionnaireCalcul.verifierSolution(calcul, proposition);
	}
	
	
}
