package be.steformations.pc.javaweb.spring_mvc.biblio.actions.editors;

import be.steformations.pc.javaweb.spring_mvc.biblio.services.SpringLibraryService;

@org.springframework.stereotype.Controller("actions.editors.Delete")
@org.springframework.context.annotation.Scope("request")
public class Delete {

	@org.springframework.beans.factory.annotation.Autowired
	private SpringLibraryService service;
	
	public Delete() {
		super();
	}
	
	@org.springframework.web.bind.annotation.RequestMapping(
		value="/collections/delete",
		method=org.springframework.web.bind.annotation.RequestMethod.POST
	)
	public String execute(
		@org.springframework.web.bind.annotation.RequestParam("id") String id,
		java.util.Map<String, Object> attributes
	) {
		service.removeEditor(Integer.parseInt(id));
		return "/spring/collections";
	}
}
