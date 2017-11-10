package be.steformations.pc.timesheets.dto;

import java.util.Date;

import be.steformations.java_data.timesheets.entities.Employee;
import be.steformations.java_data.timesheets.entities.Prestation;
import be.steformations.java_data.timesheets.entities.Project;

public class TimesheetsDtoFactory {

	public EmployeeDto createEmployeeDto(Long id, String firstname, String name, String login, String password) {
		EmployeeDto dto = new EmployeeDto();
		dto.setId(id);
		dto.setFirstname(firstname);
		dto.setName(name);
		dto.setLogin(login);
		dto.setPassword(password);
		return dto;
	}
	
	public EmployeeDto createEmployeeDto(Employee e) {
		if (e == null) {
			return null;
		}
		return this.createEmployeeDto(e.getId(), e.getFirstname(), e.getName(), e.getLogin(), e.getPassword());
	}
	
	public ProjectDto createProjectDto(Long id, String name, String description, Date startDate, Date endDate, EmployeeDto manager) {
		ProjectDto dto = new ProjectDto();
		dto.setId(id);
		dto.setName(name);
		dto.setDescription(description);
		dto.setStartDate(startDate);
		dto.setEndDate(endDate);
		dto.setManager(manager);
		return dto;
	}
	
	public ProjectDto createProjectDto(Project p) {
		if (p == null) {
			return null;
		}
		EmployeeDto manager = this.createEmployeeDto(p.getManager());
		return this.createProjectDto(p.getId(), p.getName(), p.getDescription(), p.getStartDate(), p.getEndDate(), manager);
	}
	
	public PrestationDto createPrestationDto(Long id, String comment, Date day, int duration, EmployeeDto employee, ProjectDto project) {
		PrestationDto dto = new PrestationDto();
		dto.setId(id);
		dto.setComment(comment);
		dto.setDay(day);
		dto.setDuration(duration);
		dto.setEmployee(employee);
		dto.setProject(project);
		return dto;
	}
	
	public PrestationDto createPrestationDto(Prestation p) {
		if (p == null) {
			return null;
		}
		EmployeeDto employee = this.createEmployeeDto(p.getEmployee());
		ProjectDto project = this.createProjectDto(p.getProject());
		return this.createPrestationDto(p.getId(), p.getComment(), p.getDay(), p.getDuration(), employee, project);
	}
}
