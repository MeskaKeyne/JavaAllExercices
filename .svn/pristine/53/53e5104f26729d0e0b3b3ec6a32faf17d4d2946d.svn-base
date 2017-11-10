package be.steformations.pc.timesheets.rs;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import be.steformations.java_data.timesheets.service.TimesheetsDataService;
import be.steformations.pc.timesheets.dao.service.jpa.TimesheetsJpaDataServiceImpl;

public class ServiceFactory {

	private static final ServiceFactory instance = new ServiceFactory();
	private TimesheetsDataService timesheetsDataService;
	
	private ServiceFactory() {
		super();
		System.out.println("ServiceFactory.ServiceFactory()");
	}
	
	public static ServiceFactory getInstance() {
		return instance;
	}
	
	public TimesheetsDataService getTimesheetsDataService() {
		if (this.timesheetsDataService == null) {
			EntityManager em = Persistence.createEntityManagerFactory("postgresql_eclipselink").createEntityManager();
			this.timesheetsDataService = new TimesheetsJpaDataServiceImpl(em);
		}
		return timesheetsDataService;
	}
}
