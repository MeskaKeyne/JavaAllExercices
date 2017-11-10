package be.steformations.pc.javaweb.spring_mvc.biblio.actions.editors;

import be.steformations.pc.javaweb.spring_mvc.biblio.services.SpringLibraryService;

@org.springframework.stereotype.Controller("actions.editors.List")
@org.springframework.context.annotation.Scope("request")
public class List {

	@org.springframework.beans.factory.annotation.Autowired
	private SpringLibraryService service;
	
	public List() {
		super();
	}
	
	@org.springframework.web.bind.annotation.RequestMapping(value="/collections")
	public String execute(java.util.Map<String, Object> attributes) {
		attributes.put("collections", service.getAllEditors());
		return "/WEB-INF/jsp/collections.jsp";
	}
}
