package be.steformations.pc.javaweb.spring.calcul.controleurs;

import be.steformations.pc.javaweb.calcul.modele.Calcul;
import be.steformations.pc.javaweb.spring.calcul.modele.SpringGestionnaireCalcul;
import be.steformations.pc.javaweb.spring.calcul.session.SessionCalcul;

//@org.springframework.stereotype.Component  // instanciation par le framwork spring
@org.springframework.stereotype.Controller // spécialisation de Component
@org.springframework.context.annotation.Scope("request") // durée de vie égale à une seule requête
public class Generer {

	@org.springframework.beans.factory.annotation.Autowired // injection par Spring
	private SpringGestionnaireCalcul gestionnaireCalcul;
	@org.springframework.beans.factory.annotation.Autowired
	private SessionCalcul sessionCalcul;
	
	// obligatoire pour l'instanciation par Spring
	public Generer() {
		System.out.println("Generer.Generer()");
	}
	
	// http://localhost:8080/webcalcul-spring-mvc/spring/new
	@org.springframework.web.bind.annotation.RequestMapping("new") // unique si @Controller
	public String createAndShowCalcul(
			java.util.Map<String, Object> attributs // attributs de l'HttpServletRequest
		) {
		Calcul c = gestionnaireCalcul.genererCalcul();
		this.sessionCalcul.setCourant(c);
		attributs.put("nouveauCalcul", c);
		return "/nouveau.jsp"; // http://localhost:8080/webcalcul-spring-mvc/nouveau.jsp
	}
}
