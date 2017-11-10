package be.steformations.pc.timesheets.dto.tests;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import be.steformations.pc.timesheets.dto.TimesheetsDtoFactory;
import be.steformations.pc.timesheets.dto.EmployeeDto;

public class EmployeeDtoTest {

	public static void main(String[] args) throws Exception {
		TimesheetsDtoFactory dtoFactory = new TimesheetsDtoFactory();
		EmployeeDto dto = dtoFactory.createEmployeeDto(1L, "betty", "boop", "betty.boop@hollywood.com", "boooop");
		
		JAXBContext jaxbContext = JAXBContext.newInstance(EmployeeDto.class);
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.marshal(dto, System.out);
	}
}
