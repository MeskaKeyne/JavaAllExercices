package be.steformations.pc.javaweb.spring_mvc.biblio.actions.books;

import be.steformations.pc.javaweb.spring_mvc.biblio.services.SpringLibraryService;

@org.springframework.stereotype.Controller("actions.books.List")
@org.springframework.context.annotation.Scope("request")
public class List {

	@org.springframework.beans.factory.annotation.Autowired
	private SpringLibraryService service;
	
	public List() {
		super();
	}
	
	@org.springframework.web.bind.annotation.RequestMapping(value="/livres")
	public String execute(java.util.Map<String, Object> attributes) {
		attributes.put("livres", service.getAllBooks());
		attributes.put("collections", service.getAllEditors());
		attributes.put("auteurs", service.getAllAuthors());
		return "/WEB-INF/jsp/livres.jsp";
	}
}
