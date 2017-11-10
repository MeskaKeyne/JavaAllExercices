package be.steformations.pc.java_data.contacts.dto.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import be.steformations.pc.java_data.contacts.dto.ContactsDtoFactory;
import be.steformations.pc.java_data.contacts.dto.CountryDto;

public class TestCountryDto {

	private ContactsDtoFactory factory;
	
	@Before
	public void setUp() throws Exception {
		this.factory = new ContactsDtoFactory();
	}

	@Test
	public void testCountryToXml() {
		CountryDto source = new CountryDto();
		source.setId(1);
		source.setAbbreviation("BE");
		source.setName("Belgique");
		
		String xml = this.factory.countryToXml(source);
		System.out.println("countryToXml() => " + xml);
		
		CountryDto copy = this.factory.xmlToCountry(xml);
		System.out.println("xmlToCountry() => " + copy);
		
		assertEquals(source, copy);
	}

}
