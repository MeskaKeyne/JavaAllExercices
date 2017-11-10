package be.steformations.pc.javaweb.struts.calcul.controleurs;

import be.steformations.pc.javaweb.calcul.modele.Calcul;
import be.steformations.pc.javaweb.calcul.modele.GestionnaireCalcul;

public class Verifier {
	
	private Calcul calcul;
	private java.util.List<Calcul> anciens;
	private GestionnaireCalcul gestionnaireCalcul;
	private String proposition;
	
	public Verifier() {
		System.out.println("Verifier.Verifier()");
	}
	
	// injection par Spring
	public void setCalculManager(GestionnaireCalcul manager) {
		System.out.println("Verifier.setCalculManager()");
		this.gestionnaireCalcul = manager;
	}
	
	public java.util.List<Calcul> getAnciens() {
		System.out.println("Verifier.getAnciens()");
		return this.anciens;
	}
	
	public Calcul getCalcul() {
		System.out.println("Verifier.getCalcul()");
		return calcul;
	}
	
	// <input type="text" name="proposition">
	public void setProposition(String proposition) {
		System.out.println("Verifier.setProposition()");
		this.proposition = proposition;
	}
	
	// http:localhost:8080/webcalcul-struts/valider.action
	@SuppressWarnings("unchecked")
	public String valider() {
		System.out.println("Verifier.valider()");
		try {
			java.util.Map<String, Object> session
				= com.opensymphony.xwork2.ActionContext.getContext()
						.getSession();
			this.calcul = (Calcul) session.get("calcul");
			this.anciens = (java.util.List<Calcul>) session.get("anciens"); 
			if (this.anciens == null) {
				this.anciens = new java.util.ArrayList<>();
				session.put("anciens", this.anciens);
			}
			this.anciens.add(this.calcul);
			
			int solution = Integer.parseInt(this.proposition);
			this.gestionnaireCalcul.verifierSolution(this.calcul, solution);
			return "ok";
		} catch(Exception e) {
			e.printStackTrace();
			return "ko";
		}
	}
}
