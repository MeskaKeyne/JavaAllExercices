package be.steformations.pc.contacts.soap.config;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@SuppressWarnings("serial")
@WebServlet(loadOnStartup=1, urlPatterns="/config")
public class ConfigJdbcServlet extends HttpServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		try {
			Class.forName("org.postgresql.Driver");
		} catch(Exception e) {
			throw new ServletException(e);
		}
	}
}
