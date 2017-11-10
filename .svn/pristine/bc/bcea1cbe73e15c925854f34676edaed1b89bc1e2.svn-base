package be.steformations.pc.javaweb.spring_mvc.biblio.actions.books;

import be.steformations.pc.javaweb.spring_mvc.biblio.services.SpringLibraryService;

@org.springframework.stereotype.Controller("actions.books.Delete")
@org.springframework.context.annotation.Scope("request")
public class Delete {

	@org.springframework.beans.factory.annotation.Autowired
	private SpringLibraryService service;
	
	public Delete() {
		super();
	}
	
	@org.springframework.web.bind.annotation.RequestMapping(
		value="/livres/delete",
		method=org.springframework.web.bind.annotation.RequestMethod.GET
	)
	public String execute(
		@org.springframework.web.bind.annotation.RequestParam("code") String code,
		java.util.Map<String, Object> attributes
	) {
		service.removeBook(code);
		return "/spring/livres";
	}
}
