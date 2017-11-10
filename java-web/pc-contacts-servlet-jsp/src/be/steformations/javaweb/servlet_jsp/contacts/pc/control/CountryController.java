package be.steformations.javaweb.servlet_jsp.contacts.pc.control;

import be.steformations.javaweb.servlet_jsp.contacts.pc.dao.ContactsWebDao;

public class CountryController {

	protected ContactsWebDao dao;

	public CountryController(ContactsWebDao dao) {
		super();
		this.dao = dao;
	}
	
	public void showCountries(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp)
			throws javax.servlet.ServletException, java.io.IOException {
		System.out.println("CountryController.showCountries()");
		req.setAttribute("pays", this.dao.selectCountries());
		req.getRequestDispatcher("/WEB-INF/jsp/pays.jsp").forward(req, resp);		
	}
	
	public void insertCountry(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) 
			throws javax.servlet.ServletException, java.io.IOException  {
		System.out.println("CountryController.insertCountry()");
		String abbr = req.getParameter("abreviation");
		String name = req.getParameter("nom");
		boolean ok = false;
		if (abbr != null && name != null 
				&& ! abbr.isEmpty() && ! name.isEmpty()) {
			ok = this.dao.insertCountry(abbr, name);
		}
		if (!ok) {
			req.setAttribute("erreur", "le pays n'a pu être inséré");
		}
		this.showCountries(req, resp);
	}
}
