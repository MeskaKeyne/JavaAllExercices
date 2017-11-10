package be.steformations.pc.javaweb.spring.calcul.modele;

import be.steformations.pc.javaweb.calcul.modele.Calcul;
import be.steformations.pc.javaweb.calcul.modele.GestionnaireCalcul;

@org.springframework.stereotype.Service // spécialisation de @Component
@org.springframework.context.annotation.Scope("application") // singleton + durée de vie égale à l'application
public class SpringGestionnaireCalcul {

	private GestionnaireCalcul gestionnaireCalcul;
	
	// obligatoire pour l'instanciation par Spring
	public SpringGestionnaireCalcul() {
		System.out.println("SpringGestionnaireCalcul.SpringGestionnaireCalcul()");
		this.gestionnaireCalcul = new GestionnaireCalcul(10);
	}

	public Calcul genererCalcul() {
		return gestionnaireCalcul.genererCalcul();
	}

	public void verifierSolution(Calcul calcul, int proposition) {
		gestionnaireCalcul.verifierSolution(calcul, proposition);
	}
	
}
