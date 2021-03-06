package be.steformations.pc.service.contacts.rest.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import be.steformations.pc.java_data.contacts.dto.TagDto;
import be.steformations.pc.service.contacts.rest.ContactRestClient;

public class TestGetAllTags {

	ContactRestClient client;
	
	@Before
	public void setUp() throws Exception {
		this.client = new ContactRestClient();
	}

	@Test
	public void testGetTagById() {
		TagDto vamp = new TagDto();
		vamp.setId(2);
		vamp.setValue("vamp");
		
		TagDto sexsymbol = new TagDto();
		sexsymbol.setId(1);
		sexsymbol.setValue("sex-symbol");
		
		java.util.List<TagDto> tags = this.client.getAllTags();
		
		assertTrue(tags.contains(vamp));
		assertTrue(tags.contains(sexsymbol));
	}

}
