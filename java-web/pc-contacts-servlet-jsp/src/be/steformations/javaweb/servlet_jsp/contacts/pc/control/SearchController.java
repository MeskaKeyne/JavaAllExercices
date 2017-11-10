package be.steformations.javaweb.servlet_jsp.contacts.pc.control;

import be.steformations.java_data.contacts.interfaces.beans.Tag;
import be.steformations.javaweb.servlet_jsp.contacts.pc.beans.WebContact;
import be.steformations.javaweb.servlet_jsp.contacts.pc.dao.ContactsWebDao;

public class SearchController {

	protected ContactsWebDao dao;
	
	public SearchController(ContactsWebDao dao) {
		super();
		this.dao = dao;
	}

	public void show(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp)
			throws javax.servlet.ServletException, java.io.IOException {
		System.out.println("SearchController.show()");
		
		req.setAttribute("selectedCountries", "");
		req.setAttribute("selectedTags", "");
		req.setAttribute("fullname", "");
		req.setAttribute("pays", this.dao.selectCountries());
		req.setAttribute("tags", this.dao.selectTags());
		
		req.getRequestDispatcher("/WEB-INF/jsp/recherche.jsp").forward(req, resp);
	}
	
	public void search(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp)
		throws javax.servlet.ServletException, java.io.IOException {
		System.out.println("SearchController.search()");
		
		String[] countriesParams = req.getParameterValues("pays");
		java.util.List<String> countriesAbbr = null;
		if (countriesParams == null) {
			countriesAbbr = java.util.Collections.emptyList();
		} else {
			countriesAbbr = java.util.Arrays.asList(countriesParams);
			if (countriesAbbr.contains("tous")) {
				countriesAbbr = java.util.Collections.emptyList();
			}
		}
		
		String[] tagsParams = req.getParameterValues("tags");
		java.util.List<String> tagsValues;
		if (tagsParams == null) {
			tagsValues = java.util.Collections.emptyList();
		} else {
			tagsValues = new java.util.ArrayList<String>(java.util.Arrays.asList(tagsParams));
			if (tagsValues.contains("tous")) {
				tagsValues.clear();
			}
		}
		
		String fullname = req.getParameter("fullname");
		if (fullname != null && fullname.isEmpty()) {
			fullname = null;
		}
		
		java.util.List<WebContact> found = new java.util.ArrayList<WebContact>();
		for (WebContact wc : this.dao.selectContacts()) {
			
			if (fullname != null 
				&& ! (fullname.equalsIgnoreCase(wc.getFirstname()) || fullname.equalsIgnoreCase(wc.getName()))) {
				continue;
			}
			
			if (!countriesAbbr.isEmpty()
				&& (wc.getCountry() == null || !countriesAbbr.contains(wc.getCountry().getAbbreviation()))
			){
				continue;
			}
			
			if (!tagsValues.isEmpty()) {
				java.util.List<Tag> commonTags 
					= wc.getTags().stream()
									.filter(tag -> tagsValues.contains(tag.getValue()))
									.collect(java.util.stream.Collectors.toList());
				if (commonTags.isEmpty()) {
					continue;
				}
			}
			
			found.add(wc);
		}
		
		req.setAttribute("contacts", found);
		req.setAttribute("selectedCountries", countriesParams == null ? "" : String.join("*", countriesParams));
		req.setAttribute("selectedTags", tagsParams == null ? "" : String.join("*", tagsParams));
		req.setAttribute("fullname", fullname);
		req.setAttribute("pays", this.dao.selectCountries());
		req.setAttribute("tags", this.dao.selectTags());
		req.getRequestDispatcher("/WEB-INF/jsp/recherche.jsp").forward(req, resp);
	}
}
