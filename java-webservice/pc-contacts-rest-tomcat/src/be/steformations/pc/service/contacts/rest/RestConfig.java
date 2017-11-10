package be.steformations.pc.service.contacts.rest;

public class RestConfig 
	extends org.glassfish.jersey.server.ResourceConfig{

	public RestConfig() {
		super();
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
		
		this.register(TagRestService.class);
		this.register(CountryRestService.class);
		this.register(ContactRestService.class);
	}
	
}
