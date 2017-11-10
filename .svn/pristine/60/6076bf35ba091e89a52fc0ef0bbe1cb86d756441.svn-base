package be.steformations.pc.service.contacts.soap;

import be.steformations.pc.service.contacts.soap.implementations.ContactSoapServiceImpl;
import be.steformations.pc.service.contacts.soap.implementations.CountrySoapServiceImpl;
import be.steformations.pc.service.contacts.soap.implementations.TagSoapServiceImpl;

public class ContactSoapServer {

	public static void main(String[] args) {
		TagSoapServiceImpl tagSoapService = new TagSoapServiceImpl();
		javax.xml.ws.Endpoint.publish(
				"http://localhost:8080/contacts-soap/ws/TagSoapService?wsdl", 
				tagSoapService);
		
		CountrySoapServiceImpl countrySoapService = new CountrySoapServiceImpl();
		javax.xml.ws.Endpoint.publish(
				"http://localhost:8080/contacts-soap/ws/CountrySoapService?wsdl", 
				countrySoapService);
		
		ContactSoapServiceImpl contactSoapServiceImpl
			= new ContactSoapServiceImpl();
		javax.xml.ws.Endpoint.publish(
				"http://localhost:8080/contacts-soap/ws/ContactSoapService?wsdl", 
				contactSoapServiceImpl);
		
		System.out.println("Service Soap contact prêt");
	}
}
