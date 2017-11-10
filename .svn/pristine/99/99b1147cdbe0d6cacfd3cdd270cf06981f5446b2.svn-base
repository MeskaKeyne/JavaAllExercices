package be.steformations.pc.javaweb.spring_mvc.biblio.actions.authors;

import be.steformations.pc.javaweb.spring_mvc.biblio.services.SpringLibraryService;

@org.springframework.stereotype.Controller("actions.authors.List")
@org.springframework.context.annotation.Scope("request")
public class List {

	@org.springframework.beans.factory.annotation.Autowired
	private SpringLibraryService service;
	
	public List() {
		super();
	}
	
	@org.springframework.web.bind.annotation.RequestMapping("auteurs")
	public String execute(java.util.Map<String, Object> attributes) {
		attributes.put("auteurs", this.service.getAllAuthors());
		return "/WEB-INF/jsp/auteurs.jsp";
	}
}
