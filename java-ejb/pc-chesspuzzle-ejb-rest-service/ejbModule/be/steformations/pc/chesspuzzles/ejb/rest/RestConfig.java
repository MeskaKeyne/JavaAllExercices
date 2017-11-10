package be.steformations.pc.chesspuzzles.ejb.rest;

@javax.ws.rs.ApplicationPath("rs")
public class RestConfig extends javax.ws.rs.core.Application {

	@Override
	public java.util.Set<Class<?>> getClasses() {
		System.out.println("RestConfig.getClasses()");
		java.util.Set<Class<?>> classes = new java.util.HashSet<>();
		classes.add(ChessPuzzzleResource.class);
		return classes;
	}

	
}
