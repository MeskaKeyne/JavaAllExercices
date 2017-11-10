package be.steformations.pc.javaweb.jsf.biblio.session;

import be.steformations.pc.javaweb.jsf.biblio.beans.WebUser;

@javax.faces.bean.ManagedBean
@javax.faces.bean.SessionScoped
public class Connection {

	private WebUser user;
	
	public Connection() {
		super();
	}
	
	public WebUser getUser() {
		return user;
	}
	
	public void setUser(WebUser user) {
		this.user = user;
	}
}
