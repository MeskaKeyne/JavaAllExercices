package be.steformations.pc.service.contacts.rest.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import be.steformations.pc.java_data.contacts.dto.CountryDto;
import be.steformations.pc.service.contacts.soap.clients.ContactSoapClient;

public class TestGetCountryByAbbreviation {

	ContactSoapClient client;
	
	@Before
	public void setUp() throws Exception {
		this.client = new ContactSoapClient();
	}

	@Test
	public void testGetCountryByAbbreviation() {
		CountryDto usa = new CountryDto();
		usa.setId(1);
		usa.setAbbreviation("US");
		usa.setName("Etats-Unis");
		
		CountryDto found = this.client.getCountryByAbbreviation("US");
		assertEquals(usa, found);
	}

}
