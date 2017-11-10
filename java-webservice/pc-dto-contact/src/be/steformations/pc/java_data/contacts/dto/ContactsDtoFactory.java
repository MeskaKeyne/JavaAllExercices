package be.steformations.pc.java_data.contacts.dto;

public class ContactsDtoFactory {

	private javax.xml.bind.JAXBContext jaxbContext;
	
	public ContactsDtoFactory() throws RuntimeException {
		super();
		try {
			this.jaxbContext 
				= javax.xml.bind.JAXBContext.newInstance(TagDto.class, 
						CountryDto.class, ContactDto.class);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public String tagToXml(TagDto tag) {
		return this.objectToXml(tag);
	}
	
	public TagDto xmlToTag(String xml) {
		return (TagDto) this.xmlToObject(xml);
	}
	
	public String countryToXml(CountryDto country) {
		return this.objectToXml(country);
	}
	
	public CountryDto xmlToCountry(String xml) {
		return (CountryDto) this.xmlToObject(xml);
	}
	
	public String contactToXml(ContactDto contact) {
		return this.objectToXml(contact);
	}
	
	public ContactDto xmlToContact(String xml) {
		return (ContactDto) this.xmlToObject(xml);
	}
	
	private String objectToXml(Object object) {
		String xml = null;
		try (
			java.io.ByteArrayOutputStream output = new java.io.ByteArrayOutputStream();		
		) {
			javax.xml.bind.Marshaller marshaller = this.jaxbContext.createMarshaller();
			marshaller.marshal(object, output); // transformation objet => xml
			xml = output.toString();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return xml;
	}
	
	private Object xmlToObject(String xml) {
		Object object = null;
		try (
			java.io.StringReader input = new java.io.StringReader(xml);
		) {
			javax.xml.bind.Unmarshaller unmarshaller = this.jaxbContext.createUnmarshaller();
			object = unmarshaller.unmarshal(input); // transformation xml => object
		} catch(Exception e) {
			e.printStackTrace();
		}
		return object;
	}
}
