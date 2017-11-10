package be.steformations.pc.javaweb.spring_mvc.biblio.actions.authors;

import be.steformations.pc.javaweb.spring_mvc.biblio.services.SpringLibraryService;

@org.springframework.stereotype.Controller("actions.authors.Add")
@org.springframework.context.annotation.Scope("request")
public class Add {

	@org.springframework.beans.factory.annotation.Autowired
	private SpringLibraryService service;
	
	public Add() {
		super();
	}
	
	@org.springframework.web.bind.annotation.RequestMapping(
		value="/auteurs/add",
		method=org.springframework.web.bind.annotation.RequestMethod.POST
	)
	public String execute(
		@org.springframework.web.bind.annotation.RequestParam("prenom") String firstname,
		@org.springframework.web.bind.annotation.RequestParam("nom") String name,
		java.util.Map<String, Object> attributes
	) {
		if (!service.addAuthor(firstname, name)) {
			attributes.put("erreur", "l'auteur n'a pas pu être inséré");
		}
		return "/spring/auteurs";
	}
}
