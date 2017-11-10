package be.steformations.pc.service.contacts.rest;

import be.steformations.pc.java_data.contacts.dto.ContactDto;
import be.steformations.pc.java_data.contacts.dto.ContactsDtoFactory;
import be.steformations.pc.java_data.contacts.dto.CountryDto;
import be.steformations.pc.java_data.contacts.dto.TagDto;

public class ContactRestClient {

	private javax.ws.rs.client.WebTarget service;
	private ContactsDtoFactory contactsDtoFactory;
	
	public ContactRestClient() {
		super();
		this.service = javax.ws.rs.client.ClientBuilder
				.newClient().target("http://localhost:8080/contacts-rest/rs");
		this.contactsDtoFactory = new ContactsDtoFactory();
	}
	
	public String getTagValueByIdAsText(int id) {
		String value = null;
		
		value = this.service.path("tag").path(String.valueOf(id)).path("value")
					.request(javax.ws.rs.core.MediaType.TEXT_PLAIN)
					.get(String.class);
		
		return value;
	}
	
	public TagDto getTagById(int id) {
		TagDto dto = null;
		
		String xml = this.service.path("tag").path(String.valueOf(id))
						.request(javax.ws.rs.core.MediaType.TEXT_PLAIN)
						.get(String.class);
		TagDto temp = this.contactsDtoFactory.xmlToTag(xml);
		if (temp.getId() != null) {
			dto = temp;
		}
		
		return dto;
	}
	
	public TagDto createAndSaveTag(String value) {
		TagDto dto = null;
		
		dto = this.service.path("tag").path(value)
				.request(javax.ws.rs.core.MediaType.APPLICATION_XML)
				.post(null, TagDto.class);
		
		return dto;
	}
	
	public TagDto getTagByValue(String value) {
		TagDto dto = null;
		
		javax.ws.rs.core.Response response
			= this.service.path("tag").path(value)
				.request(javax.ws.rs.core.MediaType.APPLICATION_XML)
				.get();
		
		if (response.getStatus() == 200) {
			dto = response.readEntity(TagDto.class);
		}
		
		return dto;
	}
	
	public java.util.List<TagDto> getAllTags() {
		java.util.List<TagDto> tags = null;
		
		javax.ws.rs.core.Response response
			= this.service.path("tag")
				.request(javax.ws.rs.core.MediaType.APPLICATION_XML)
				.get();
		
		if (response.getStatus() == 200) {
			javax.ws.rs.core.GenericType<java.util.List<TagDto>> type
				= new javax.ws.rs.core.GenericType<java.util.List<TagDto>>() {};
			tags = response.readEntity(type);
		} else {
			tags = java.util.Collections.emptyList();
		}
		
		return tags;
	}
	
	public boolean removeTag(int id) {
		boolean deleted = false;
		
		javax.ws.rs.core.Response response
			= this.service.path("tag").path("delete").path(String.valueOf(id))
				.request()
				.delete();
	
		if (response.getStatus() == 200) {
			deleted = true;
		} else {
			System.out.println("ContactRestClient.removeTag() => " + response.getStatus());
		}
		
		return deleted;
	}
	
	public CountryDto getCountryByAbbreviation(String abbreviation) {
		CountryDto country = null;
		javax.ws.rs.core.Response response 
			= this.service.path("country").path(abbreviation)
				.request(javax.ws.rs.core.MediaType.APPLICATION_JSON)
				.get();
		if (response.getStatus() == 200) {
			country = response.readEntity(CountryDto.class);
		}
		return country;
	}
	
	public java.util.List<CountryDto> getAllCountries() {
		java.util.List<CountryDto> countries = null;
		javax.ws.rs.core.Response response 
			= this.service.path("country")
				.request(javax.ws.rs.core.MediaType.APPLICATION_JSON)
				.get();
		if (response.getStatus() == 200) {
			javax.ws.rs.core.GenericType<java.util.List<CountryDto>> type
				= new javax.ws.rs.core.GenericType<java.util.List<CountryDto>>() {};
			countries = response.readEntity(type);
		}
		return countries;
	}
	
	public CountryDto createAndSaveCountry(String abbreviation, String name) {
		CountryDto country = null;
		
		javax.ws.rs.core.MultivaluedMap<String, String> form
			= new javax.ws.rs.core.MultivaluedHashMap<>();
		form.add("abbr", abbreviation);
		form.add("name", name);
		
		javax.ws.rs.client.Entity<javax.ws.rs.core.MultivaluedMap<String, String>> entity
			= javax.ws.rs.client.Entity.entity(
					form, javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED);
		
		javax.ws.rs.core.Response response 
			= this.service.path("country")
				.request(javax.ws.rs.core.MediaType.APPLICATION_JSON)
				.post(entity);
		
		if (response.getStatus() == 200) {
			country = response.readEntity(CountryDto.class);
		}
		return country;
	}
	
	public ContactDto getContactById(int id) {
		ContactDto contactDto = null;
		javax.ws.rs.core.Response response 
			= this.service.path("contact").path(String.valueOf(id))
				.request(javax.ws.rs.core.MediaType.APPLICATION_XML)
				.get();
		if (response.getStatus() == 200) {
			contactDto = response.readEntity(ContactDto.class);
		}
		return contactDto;
	}
	
	public java.util.List<ContactDto> getAllContacts() {
		java.util.List<ContactDto> contacts = null;
		javax.ws.rs.core.Response response 
			= this.service.path("contact")
				.request(javax.ws.rs.core.MediaType.APPLICATION_XML)
				.get();
		if (response.getStatus() == 200) {
			javax.ws.rs.core.GenericType<java.util.List<ContactDto>> type
				= new javax.ws.rs.core.GenericType<java.util.List<ContactDto>>() {};
			contacts = response.readEntity(type);
		}
		return contacts;
	}
	
	public ContactDto createAndSaveContact(String firstname, String name, 
			String email, String countryAbbreviation, java.util.List<String> tagValues) {
		ContactDto contactDto = null;
		
		ContactDto input = new ContactDto();
		input.setFirstname(firstname);
		input.setName(name);
		input.setEmail(email);
		
		CountryDto countryDto = null;
		if (countryAbbreviation != null) {
			countryDto = new CountryDto();
			countryDto.setAbbreviation(countryAbbreviation);
		}
		input.setCountry(countryDto);
		
		if (tagValues != null) {
			for (String value : tagValues) {
				TagDto tagDto = new TagDto();
				tagDto.setValue(value);
				input.getTags().add(tagDto);
			}
		}
		
		System.out.println("ContactRestClient.createAndSaveContact() => " + input);
		javax.ws.rs.client.Entity<ContactDto> entity
			= javax.ws.rs.client.Entity.entity(
					input, javax.ws.rs.core.MediaType.APPLICATION_XML);
		
		javax.ws.rs.core.Response response 
			= this.service.path("contact")
				.request(javax.ws.rs.core.MediaType.APPLICATION_XML)
				.post(entity);
		
		System.out.println("ContactRestClient.createAndSaveContact() => " + response.getStatus());
		if (response.getStatus() == 200) {
			contactDto = response.readEntity(ContactDto.class);
		}
		
		return contactDto;
	}
	
	public ContactDto removeContact(int id) {
		ContactDto contactDto = null;
		javax.ws.rs.core.Response response 
			= this.service.path("contact").path(String.valueOf(id))
				.request(javax.ws.rs.core.MediaType.APPLICATION_XML)
				.delete();
		if (response.getStatus() == 200) {
			contactDto = response.readEntity(ContactDto.class);
		}
		return contactDto;
	}
}





