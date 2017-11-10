package be.steformations.pc.javaweb.spring_mvc.biblio.actions.editors;

import be.steformations.pc.javaweb.spring_mvc.biblio.services.SpringLibraryService;

@org.springframework.stereotype.Controller("actions.editors.Add")
@org.springframework.context.annotation.Scope("request")
public class Add {

	@org.springframework.beans.factory.annotation.Autowired
	private SpringLibraryService service;
	
	public Add() {
		super();
	}
	
	@org.springframework.web.bind.annotation.RequestMapping(
		value="/collections/add",
		method=org.springframework.web.bind.annotation.RequestMethod.POST
	)
	public String execute(
		@org.springframework.web.bind.annotation.RequestParam("nom") String name,
		java.util.Map<String, Object> attributes
	) {
		if (!service.addEditorn(name)) {
			attributes.put("erreur", "la collection n'a pas pu être ajoutée");
		}
		return "/spring/collections";
	}
}
