package be.steformations.javaweb.servlet_jsp.contacts.pc.control;

import be.steformations.javaweb.servlet_jsp.contacts.pc.beans.WebContact;
import be.steformations.javaweb.servlet_jsp.contacts.pc.dao.ContactsWebDao;

public class ContactController {
	
	private class ContactSorter implements java.util.Comparator<WebContact> {
		@Override
		public int compare(WebContact o1, WebContact o2) {
			return Integer.compare(o1.getId(), o2.getId());
		}
	}

	protected ContactsWebDao dao;
	protected java.util.regex.Pattern emailPattern;
	protected java.util.Comparator<WebContact> sorter;

	public ContactController(ContactsWebDao dao) {
		super();
		this.dao = dao;
		this.emailPattern = java.util.regex.Pattern.compile(
				"^[a-z0-9!#$%&'*+/=?^_`{|}~-]([.]?[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@[a-z0-9]([.]?[a-z0-9-]+)*[a-z0-9]$", 
				java.util.regex.Pattern.CASE_INSENSITIVE);
		this.sorter = new ContactSorter();
	}
	
	public void showContacts(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) 
			throws javax.servlet.ServletException, java.io.IOException {
		System.out.println("ContactController.showContacts()");
		java.util.List<WebContact> webcontacts = this.dao.selectContacts();
		webcontacts.sort(this.sorter);
		req.setAttribute("contacts", webcontacts);
		req.setAttribute("pays", this.dao.selectCountries());
		req.setAttribute("tags", this.dao.selectTags());
		req.getRequestDispatcher("/WEB-INF/jsp/contacts.jsp").forward(req, resp);
	}
	
	public void insertContact(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) 
			throws javax.servlet.ServletException, java.io.IOException  {
		System.out.println("ContactController.insertContact()");
		String firstname = req.getParameter("prenom");
		String name = req.getParameter("nom");
		String email = req.getParameter("email");
		String countryAbbr = req.getParameter("pays");
		String[] tagsIds = req.getParameterValues("tags");
		
		boolean ok = false;
		if (firstname != null && name != null && email != null
				&& ! firstname.isEmpty() && ! name.isEmpty() && ! email.isEmpty()
				&& this.emailPattern.matcher(email).matches()) {
			
			if (countryAbbr != null && countryAbbr.equals("-")) {
				countryAbbr = null;
			}
			
			java.util.List<String> tags = null;
			if (tagsIds == null) {
				ok = false;
			} else {
				if (tagsIds.length > 0) {
					java.util.List<String> tmp = java.util.Arrays.asList(tagsIds);
					if (! tmp.contains("NONE")) {
						tags = java.util.Arrays.asList(tagsIds);
					}
				}
				ok = this.dao.insertContact(firstname, name, email, countryAbbr, tags);
			}
		} 
		if ( !ok ) {
			req.setAttribute("erreur", "le contact n'a pu être inséré");
		}
		this.showContacts(req, resp);
	}
	
	public void deleteContact(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) 
			throws javax.servlet.ServletException, java.io.IOException  {
		System.out.println("ContactController.deleteContact()");
		try {
			int id = Integer.parseInt(req.getParameter("id"));
			this.dao.deleteContact(id);
		} catch(NumberFormatException e) {
			req.setAttribute("erreur", "Mauvais identifiant de Contact");
		}
		this.showContacts(req, resp);
	}
}
