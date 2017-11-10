package be.steformations.pc.service.contacts.rest.server;

import be.steformations.pc.service.contacts.rest.ContactRestService;
import be.steformations.pc.service.contacts.rest.CountryRestService;
import be.steformations.pc.service.contacts.rest.TagRestService;

public class ContactRestServer {

	public static void main(String[] args) throws Exception {
		java.net.URI uri = new java.net.URI("http://localhost:8080/contacts-rest/rs");
		//java.net.URI uri = new java.net.URI("http://prim2014-18.fapse.priv:8080/contacts-rest/rs");
		
		org.glassfish.jersey.server.ResourceConfig config
			= new org.glassfish.jersey.server.ResourceConfig();
		config.register(TagRestService.class);
		config.register(CountryRestService.class);
		config.register(ContactRestService.class);
		
		org.glassfish.jersey.jdkhttp.JdkHttpServerFactory.createHttpServer(uri, config);
		
		System.out.println("Contact Rest service ready");
	}
}
