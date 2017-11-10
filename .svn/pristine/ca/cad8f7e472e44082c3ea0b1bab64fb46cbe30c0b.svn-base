package be.steformations.pc.javaweb.spring_mvc.biblio.actions.authors;

import be.steformations.pc.javaweb.spring_mvc.biblio.services.SpringLibraryService;

@org.springframework.stereotype.Controller("actions.authors.Delete")
@org.springframework.context.annotation.Scope("request")
public class Delete {

	@org.springframework.beans.factory.annotation.Autowired
	private SpringLibraryService service;
	
	public Delete() {
		super();
	}
	
	@org.springframework.web.bind.annotation.RequestMapping(
		value="/auteurs/delete",
		method=org.springframework.web.bind.annotation.RequestMethod.POST
	)
	public String execute(
		@org.springframework.web.bind.annotation.RequestParam("id") String id,
		java.util.Map<String, Object> attributes
	) {
		service.removeAuthor(Integer.parseInt(id));
		return "/spring/auteurs";
	}
}
