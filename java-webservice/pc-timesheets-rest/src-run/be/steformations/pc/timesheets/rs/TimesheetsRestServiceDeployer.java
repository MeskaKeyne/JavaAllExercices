package be.steformations.pc.timesheets.rs;

import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import com.sun.net.httpserver.HttpServer;

public class TimesheetsRestServiceDeployer {

	private static final java.net.URI uri 
		= UriBuilder.fromUri("http://localhost:8080/timesheets/rs").build();
	
	public static void main(String[] args) {
		ResourceConfig config = new ResourceConfig(EmployeeResource.class, 
				ProjectResource.class, PrestationResource.class);
		HttpServer server = JdkHttpServerFactory.createHttpServer(uri, config, false);
		server.start();
		System.out.println("Timesheet rest service ready"); 
	}
}
