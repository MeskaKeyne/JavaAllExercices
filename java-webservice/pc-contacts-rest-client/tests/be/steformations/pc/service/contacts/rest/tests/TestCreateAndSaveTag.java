package be.steformations.pc.service.contacts.rest.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import be.steformations.pc.java_data.contacts.dto.TagDto;
import be.steformations.pc.service.contacts.rest.ContactRestClient;

public class TestCreateAndSaveTag {

	ContactRestClient client;
	
	@Before
	public void setUp() throws Exception {
		this.client = new ContactRestClient();
	}

	@Test
	public void testCreateAndSaveTag() {
		String value = "newTag-" + System.currentTimeMillis();
		TagDto tag = this.client.createAndSaveTag(value);
		
		assertNotNull(tag);
		assertNotNull(tag.getId());
		assertEquals(value, tag.getValue());
		
		TagDto found = this.client.getTagById(tag.getId());
		
		assertEquals(tag, found);
	}

}