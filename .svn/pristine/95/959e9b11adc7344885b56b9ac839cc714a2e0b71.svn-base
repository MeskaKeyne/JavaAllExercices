package be.steformations.pc.java_data.contacts.dto.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import be.steformations.pc.java_data.contacts.dto.ContactDto;
import be.steformations.pc.java_data.contacts.dto.ContactsDtoFactory;
import be.steformations.pc.java_data.contacts.dto.CountryDto;
import be.steformations.pc.java_data.contacts.dto.TagDto;

public class TestContactDto {

	private ContactsDtoFactory factory;
	
	@Before
	public void setUp() throws Exception {
		this.factory = new ContactsDtoFactory();
	}

	@Test
	public void testContactToXml() {
		CountryDto belgium = new CountryDto();
		belgium.setId(1);
		belgium.setAbbreviation("BE");
		belgium.setName("Belgique");
		
		TagDto vamp = new TagDto();
		vamp.setId(1);
		vamp.setValue("vamp");
		
		TagDto sexy = new TagDto();
		sexy.setId(2);
		sexy.setValue("sexy");
		
		ContactDto source = new ContactDto();
		source.setId(1);
		source.setFirstname("betty");
		source.setName("betty");
		source.setEmail("betty.boop@hollywood.com");
		source.setCountry(belgium);
		source.getTags().add(vamp);
		source.getTags().add(sexy);
		
		String xml = this.factory.contactToXml(source);
		System.out.println("contactToXml() => " + xml);
		
		ContactDto copy = this.factory.xmlToContact(xml);
		System.out.println("xmlToContact() => " + copy);
		
		assertEquals(source, copy);
	}

}
