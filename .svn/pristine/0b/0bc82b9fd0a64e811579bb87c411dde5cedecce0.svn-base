package be.steformations.pc.javaweb.jsf.calcul.controleurs;

import be.steformations.pc.javaweb.jsf.calcul.modele.JsfGestionnaireCalcul;
import be.steformations.pc.javaweb.jsf.calcul.session.SessionCalcul;

//@javax.faces.bean.ManagedBean
//@javax.faces.bean.RequestScoped
public class Verifier {

	//@javax.faces.bean.ManagedProperty(value="#{jsfGestionnaireCalcul}")
	private JsfGestionnaireCalcul jsfGestionnaireCalcul;
	//@javax.faces.bean.ManagedProperty(value="#{sessionCalcul}")
	private SessionCalcul sessionCalcul;
	private String proposition;
	
	public Verifier() {
		System.out.println("Verifier.Verifier()");
	}
	
	public void setJsfGestionnaireCalcul(JsfGestionnaireCalcul jsfGestionnaireCalcul) {
		System.out.println("Verifier.setJsfGestionnaireCalcul()");
		this.jsfGestionnaireCalcul = jsfGestionnaireCalcul;
	}
	
	public void setSessionCalcul(SessionCalcul sessionCalcul) {
		System.out.println("Verifier.setSessionCalcul()");
		this.sessionCalcul = sessionCalcul;
	}
	
	public String getProposition() {
		System.out.println("Verifier.getProposition()");
		return proposition;
	}
	
	public void setProposition(String proposition) {
		System.out.println("Verifier.setProposition()");
		this.proposition = proposition;
	}
	
	public String executer() {
		System.out.println("Verifier.executer()");
		try {
			this.jsfGestionnaireCalcul.verifierSolution(
					this.sessionCalcul.getCourant(), 
					Integer.parseInt(this.proposition));
			this.sessionCalcul.getAnciens().add(this.sessionCalcul.getCourant());
		} catch(NumberFormatException e) {
			e.printStackTrace();
		}
		return "resultat";
	}
}
