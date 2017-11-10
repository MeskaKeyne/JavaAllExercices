package be.steformations.pc.service.contacts.rest.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import be.steformations.pc.java_data.contacts.dto.TagDto;
import be.steformations.pc.service.contacts.soap.clients.ContactSoapClient;

public class TestGetTagByValue {

	ContactSoapClient client;
	
	@Before
	public void setUp() throws Exception {
		this.client = new ContactSoapClient();
	}

	@Test
	public void testGetTagByValue() {
		TagDto tag = this.client.getTagByValue("sex-symbol");
		
		assertNotNull(tag);
		assertEquals(new Integer(1), tag.getId());
		assertEquals("sex-symbol", tag.getValue());
	}

}
