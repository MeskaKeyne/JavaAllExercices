package be.steformations.pc.javaweb.jsf.biblio.actions;

import be.steformations.pc.javaweb.jsf.biblio.beans.WebUser;
import be.steformations.pc.javaweb.jsf.biblio.services.JsfLibraryService;
import be.steformations.pc.javaweb.jsf.biblio.session.Connection;

@javax.faces.bean.ManagedBean
@javax.faces.bean.RequestScoped
public class Login {

	@javax.faces.bean.ManagedProperty(value="#{service}")
	private JsfLibraryService service;
	@javax.faces.bean.ManagedProperty(value="#{connection}")
	private Connection connection;
	private String email;
	
	public Login() {
		super();
	}
	
	public void setService(JsfLibraryService service) {
		this.service = service;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String execute() {
		WebUser user = this.service.getUser(this.email);
		if (user == null) {
			javax.faces.application.FacesMessage message
				= new javax.faces.application.FacesMessage("mauvais email");
			javax.faces.context.FacesContext.getCurrentInstance().addMessage(null, message);
			return "index";
		} else {
			this.connection.setUser(user);
			return "menu";
		}
	}
}
