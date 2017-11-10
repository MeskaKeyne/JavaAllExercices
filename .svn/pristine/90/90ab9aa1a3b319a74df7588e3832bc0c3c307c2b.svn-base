package be.steformations.pc.javaweb.spring_mvc.biblio.actions.books;

import be.steformations.pc.javaweb.spring_mvc.biblio.services.SpringLibraryService;

@org.springframework.stereotype.Controller("actions.books.Add")
@org.springframework.context.annotation.Scope("request")
public class Add {

	@org.springframework.beans.factory.annotation.Autowired
	private SpringLibraryService service;
	private java.text.DateFormat fmt = new java.text.SimpleDateFormat("dd-MM-yyyy");
	
	public Add() {
		super();
	}
	
	@org.springframework.web.bind.annotation.RequestMapping(
		value="/livres/add",
		method=org.springframework.web.bind.annotation.RequestMethod.POST
	)
	public String execute(
		@org.springframework.web.bind.annotation.RequestParam("titre") String title,
		@org.springframework.web.bind.annotation.RequestParam("collection") String editor,
		@org.springframework.web.bind.annotation.RequestParam("parution") String publication,
		@org.springframework.web.bind.annotation.RequestParam("pages") String pages,
		@org.springframework.web.bind.annotation.RequestParam("edition") String edition,
		@org.springframework.web.bind.annotation.RequestParam("auteurs") String[] authors,
		java.util.Map<String, Object> attributes
	) {
		if (title.isEmpty()) {
			attributes.put("erreur", "le titre est obligatoire");
		} else {
			try {
				java.sql.Date date = new java.sql.Date(this.fmt.parse(publication).getTime());
				java.util.List<Integer> ids = new java.util.ArrayList<Integer>();
				for (String sid : authors) {
					if (! sid.equals("-1")) {
						ids.add(Integer.parseInt(sid));
					}
				}
				if (! this.service.addBook(title, Short.parseShort(pages), date, 
						Integer.parseInt(editor), Short.parseShort(edition), ids)) {
					attributes.put("erreur", "le livre n'a pas pu être créé");
				}				
			} catch (Exception e) {
				attributes.put("erreur", e.getMessage());
			}
		}
		
		return "/spring/livres";
	}
}
