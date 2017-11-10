package be.steformations.pc.service.contacts.rest;

import javax.ws.rs.core.GenericEntity;

import be.steformations.java_data.contacts.interfaces.beans.Country;
import be.steformations.java_data.contacts.interfaces.dao.CountryDao;
import be.steformations.pc.java_data.contacts.dto.CountryDto;

@javax.ws.rs.Path("country")
public class CountryRestService {

	private CountryDao countryDao;
	
	public CountryRestService() {
		super();
		this.countryDao = ContactRestDaoFactory.getInstance().getCountryDao();
	}
	
	// http://localhost:8080/contacts-rest/rs/country/US
	@javax.ws.rs.GET
	@javax.ws.rs.Path("{abbr}")
	@javax.ws.rs.Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public javax.ws.rs.core.Response getCountryByAbbreviation(
			@javax.ws.rs.PathParam("abbr") String abbreviation) {
		System.out.println("CountryRestService.getCountryByAbbreviation()");
		javax.ws.rs.core.Response response = null;
		Country country = this.countryDao.getCountryByAbbreviation(abbreviation);
		if (country == null) {
			response = javax.ws.rs.core.Response.status(404).build();
		} else {
			CountryDto dto = new CountryDto();
			dto.setId(country.getId());
			dto.setAbbreviation(country.getAbbreviation());
			dto.setName(country.getName());
			response = javax.ws.rs.core.Response.ok(dto).build();
		}
		return response;
	}
	
	// http://localhost:8080/contacts-rest/rs/country
	@javax.ws.rs.GET
	@javax.ws.rs.Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public javax.ws.rs.core.Response getAllCountries() {
		System.out.println("CountryRestService.getAllCountries()");
		javax.ws.rs.core.Response response = null;
		java.util.List<? extends Country> list = this.countryDao.getAllCountries();
		java.util.List<CountryDto> dtos = new java.util.ArrayList<>();
		for (Country country : list) {
			CountryDto dto = new CountryDto();
			dto.setId(country.getId());
			dto.setAbbreviation(country.getAbbreviation());
			dto.setName(country.getName());
			dtos.add(dto);
		}
		javax.ws.rs.core.GenericEntity<java.util.List<CountryDto>> entity
			= new javax.ws.rs.core.GenericEntity<java.util.List<CountryDto>>(dtos) {};
		response = javax.ws.rs.core.Response.ok(entity).build();
		return response;
	}
	
	// POST http://localhost:8080/contacts-rest/rs/country
	@javax.ws.rs.POST
	@javax.ws.rs.Consumes(javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED) // form html
	@javax.ws.rs.Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public javax.ws.rs.core.Response createAndSaveCountry(
			@javax.ws.rs.FormParam("abbr") String abbreviation, 
			@javax.ws.rs.FormParam("name") String name) {
		System.out.println("CountryRestService.createAndSaveCountry()");
		javax.ws.rs.core.Response response = null;
		Country country = this.countryDao.createAndSaveCountry(abbreviation, name);
		if (country != null) {
			CountryDto dto = new CountryDto();
			dto.setId(country.getId());
			dto.setAbbreviation(country.getAbbreviation());
			dto.setName(country.getName());
			response = javax.ws.rs.core.Response.ok(dto).build();
		} else {
			response = javax.ws.rs.core.Response.serverError().build();
		}
		return response;
	}
}
