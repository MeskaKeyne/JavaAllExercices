package be.steformations.pc.timesheets.dto.tests;

import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import be.steformations.pc.timesheets.dto.TimesheetsDtoFactory;
import be.steformations.pc.timesheets.dto.EmployeeDto;
import be.steformations.pc.timesheets.dto.ProjectDto;

public class ProjectDtoTest {

	public static void main(String[] args) throws Exception {
		TimesheetsDtoFactory dtoFactory = new TimesheetsDtoFactory();
		EmployeeDto manager = dtoFactory.createEmployeeDto(1L, "betty", "boop", "betty.boop@hollywood.com", "boooop");
		ProjectDto project = dtoFactory.createProjectDto(123L, "test", "ceci est un test", new Date(), new Date(), manager);
		
		JAXBContext jaxbContext = JAXBContext.newInstance(EmployeeDto.class, ProjectDto.class);
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.marshal(project, System.out);
	}
}
