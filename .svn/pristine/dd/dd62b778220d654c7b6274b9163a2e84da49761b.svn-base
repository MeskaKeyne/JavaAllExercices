package be.steformations.pc.java_data.contacts.dto.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import be.steformations.pc.java_data.contacts.dto.ContactsDtoFactory;
import be.steformations.pc.java_data.contacts.dto.TagDto;

public class TestTagDto {

	private ContactsDtoFactory factory;
	
	@Before
	public void setUp() throws Exception {
		this.factory = new ContactsDtoFactory();
	}

	@Test
	public void testTagToXml() {
		TagDto source = new TagDto();
		source.setId(1);
		source.setValue("vamp");
		
		String xml = this.factory.tagToXml(source);
		System.out.println("tagToXml() => " + xml);

		TagDto copy = this.factory.xmlToTag(xml);
		System.out.println("xmlToTag() => " + copy);
		
		assertNotNull(copy);
		assertEquals(new Integer(1), copy.getId());
		assertEquals("vamp", copy.getValue());
	}

}
