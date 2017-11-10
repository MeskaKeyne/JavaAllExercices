package be.steformations.pc.javaweb.spring.calcul.controleurs;

import be.steformations.pc.javaweb.calcul.modele.Calcul;
import be.steformations.pc.javaweb.spring.calcul.modele.SpringGestionnaireCalcul;
import be.steformations.pc.javaweb.spring.calcul.session.SessionCalcul;

@org.springframework.stereotype.Controller
@org.springframework.context.annotation.Scope("request")
public class Verifier {

	@org.springframework.beans.factory.annotation.Autowired // injection par Spring
	private SpringGestionnaireCalcul gestionnaireCalcul;
	@org.springframework.beans.factory.annotation.Autowired
	private SessionCalcul sessionCalcul;
	
	public Verifier() {
		System.out.println("Verifier.Verifier()");
	}
	
	// http://localhost:8080/webcalcul-spring-mvc/spring/jouer
	@org.springframework.web.bind.annotation.RequestMapping("jouer")
	public String resoudre(
				@org.springframework.web.bind.annotation.RequestParam("proposition") String solution,
				java.util.Map<String, Object> attributs
			) {
		Calcul c = this.sessionCalcul.getCourant();
		this.sessionCalcul.getAnciens().add(c);
		try {
			int i = Integer.parseInt(solution);
			this.gestionnaireCalcul.verifierSolution(c, i);
		} catch(NumberFormatException e) {}

		attributs.put("nouveauCalcul", c);
		attributs.put("anciensCalculs", this.sessionCalcul.getAnciens());
		return "/resultat.jsp";
	}
}
