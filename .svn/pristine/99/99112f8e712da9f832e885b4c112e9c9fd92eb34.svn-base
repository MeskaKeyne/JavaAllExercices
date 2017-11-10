package be.steformations.pc.service.contacts.rest.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import be.steformations.pc.java_data.contacts.dto.CountryDto;
import be.steformations.pc.java_data.contacts.dto.TagDto;
import be.steformations.pc.service.contacts.rest.ContactRestClient;

public class TestGetAllCountries {

	ContactRestClient client;
	
	@Before
	public void setUp() throws Exception {
		this.client = new ContactRestClient();
	}

	@Test
	public void testGetAllCountries() {
		CountryDto usa = new CountryDto();
		usa.setId(1);
		usa.setAbbreviation("US");
		usa.setName("Etats-Unis");
		
		java.util.List<CountryDto> countries = this.client.getAllCountries();
		assertTrue(countries.contains(usa));
	}

}
