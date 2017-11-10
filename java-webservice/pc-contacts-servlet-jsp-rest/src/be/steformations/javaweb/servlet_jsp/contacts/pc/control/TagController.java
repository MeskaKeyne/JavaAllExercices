package be.steformations.javaweb.servlet_jsp.contacts.pc.control;

import be.steformations.javaweb.servlet_jsp.contacts.pc.dao.ContactsWebDao;

public class TagController {

	protected ContactsWebDao dao;

	public TagController(ContactsWebDao dao) {
		super();
		this.dao = dao;
	} 
	
	public void showTags(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) 
			throws javax.servlet.ServletException, java.io.IOException {
		System.out.println("TagController.showTags()");
		req.setAttribute("tags", this.dao.selectTags());
		req.getRequestDispatcher("/WEB-INF/jsp/tags.jsp").forward(req, resp);		
	}
	
	public void insertTag(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) 
			throws javax.servlet.ServletException, java.io.IOException  {
		System.out.println("TagController.insertTag()");
		String value = req.getParameter("valeur");
		boolean ok = false;
		if (value != null && ! value.isEmpty()) {
			ok = this.dao.insertTag(value);
		}
		if (!ok) {
			req.setAttribute("erreur", "le tag n'a pu être inséré");
		}
		this.showTags(req, resp);
	}
	
	public void deleteTag(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) 
			throws javax.servlet.ServletException, java.io.IOException  {
		System.out.println("TagController.deleteTag()");
		try {
			int id = Integer.parseInt(req.getParameter("id"));
			this.dao.deleteTag(id);
		} catch(NumberFormatException e) {
			req.setAttribute("erreur", "Mauvais identifiant de Tag");
		}
		this.showTags(req, resp);
	}

}
