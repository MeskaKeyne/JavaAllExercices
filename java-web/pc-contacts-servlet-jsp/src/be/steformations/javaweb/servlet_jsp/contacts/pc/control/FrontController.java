package be.steformations.javaweb.servlet_jsp.contacts.pc.control;

import be.steformations.javaweb.servlet_jsp.contacts.pc.dao.ContactsWebDao;

@SuppressWarnings("serial")
public class FrontController extends javax.servlet.http.HttpServlet {

	protected TagController tagController;
	protected CountryController countryController;
	protected ContactController contactController;
	protected SearchController searchController;
	
	@Override
	public void init(javax.servlet.ServletConfig config) throws javax.servlet.ServletException {
		super.init(config);
		try {
			String driver = config.getInitParameter("driver");
			String url = config.getInitParameter("url");
			String user = config.getInitParameter("user");
			String password = config.getInitParameter("password");
			
			Class.forName(driver);
			ContactsWebDao dao = new ContactsWebDao(url, user, password);
			
			this.tagController = new TagController(dao);
			this.countryController = new CountryController(dao);
			this.contactController = new ContactController(dao);
			this.searchController = new SearchController(dao);
			
		} catch(Exception e) {
			throw new javax.servlet.ServletException(e);
		}
	}

	@Override
	protected void doGet(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp)
			throws javax.servlet.ServletException, java.io.IOException {
		
		String pathInfo = req.getPathInfo();
		System.out.println("FrontController.doGet(): pathInfo = " + pathInfo);
		if (pathInfo == null || pathInfo.equals("/")) {
			System.out.println("FrontController.doGet().forward('/index.jsp')");
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
		} else {
			req.setCharacterEncoding("UTF-8");
			switch(pathInfo) {
			case "/tags":
				this.tagController.showTags(req, resp);
				break;
			case "/pays":
				this.countryController.showCountries(req, resp);
				break;		
			case "/contacts":
				this.contactController.showContacts(req, resp);
				break;
			case "/delete/contact" :
				this.contactController.deleteContact(req, resp);
				break;
			case "/search/show":
				this.searchController.show(req, resp);
				break;
			default:
				System.out.println("FrontController.doGet(): wrong pathInfo '" + pathInfo + "'");
				resp.setStatus(javax.servlet.http.HttpServletResponse.SC_NOT_FOUND);
			}
		}
	}

	@Override
	protected void doPost(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp)
			throws javax.servlet.ServletException, java.io.IOException {
		
		String pathInfo = req.getPathInfo();
		System.out.println("FrontController.doPost(): pathInfo = " + pathInfo);
		if (pathInfo == null || pathInfo.equals("/")) {
			System.out.println("FrontController.doPost().forward('/index.jsp')");
			req.getRequestDispatcher("/index.html").forward(req, resp);
		} else {
			req.setCharacterEncoding("UTF-8");
			switch(pathInfo) {
			case "/insert/tag":
				this.tagController.insertTag(req, resp);
				break;
			case "/insert/pays":
				this.countryController.insertCountry(req, resp);
				break;				
			case "/delete/tag":
				this.tagController.deleteTag(req, resp);
				break;
			case "/insert/contact":
				this.contactController.insertContact(req, resp);
				break;
			case "/search/go":
				this.searchController.search(req, resp);
				break;
			default:
				System.out.println("FrontController.doPost(): wrong pathInfo '" + pathInfo + "'");
				resp.setStatus(javax.servlet.http.HttpServletResponse.SC_NOT_FOUND);
			}
		}
	}
}
