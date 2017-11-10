package be.steformations.pc.service.contacts.rest.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import be.steformations.pc.service.contacts.rest.ContactRestClient;

public class TestGetTagValueByIdAsText {

	private ContactRestClient client;
	
	@Before
	public void setUp() throws Exception {
		this.client = new ContactRestClient();
	}

	@Test
	public void testGetTagValueByIdAsText() {
		String sexsymbol = this.client.getTagValueByIdAsText(1);
		assertEquals("sex-symbol", sexsymbol);
		
		String vamp = this.client.getTagValueByIdAsText(2);
		assertEquals("vamp", vamp);
	}

}
