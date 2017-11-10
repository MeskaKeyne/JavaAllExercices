package be.steformations.pc.timesheets.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import be.steformations.pc.timesheets.dao.entities.EmployeeImpl;
import be.steformations.pc.timesheets.dao.entities.PrestationImpl;
import be.steformations.pc.timesheets.dao.entities.ProjectImpl;

@XmlRootElement(name="prestation")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class PrestationDto extends PrestationImpl {

	private static final long serialVersionUID = 1215382188192812536L;

	@Override
	public void setEmployee(EmployeeImpl employee) {
		if (!(employee instanceof EmployeeDto)) {
			this.employee = new EmployeeDto();
			this.employee.setId(employee.getId());
			this.employee.setFirstname(employee.getFirstname());
			this.employee.setName(employee.getName());
			this.employee.setLogin(employee.getLogin());
			this.employee.setPassword(employee.getPassword());
		} else {
			this.employee = employee;
		}
	}

	@Override
	public void setProject(ProjectImpl project) {
		if (!(project instanceof ProjectDto)) {
			this.project = new ProjectDto();
			this.project.setId(project.getId());
			this.project.setName(project.getName());
			this.project.setDescription(project.getDescription());
			this.project.setStartDate(project.getStartDate());
			this.project.setEndDate(project.getEndDate());
			this.project.setManager(project.getManager());
		} else {
			this.project = project;
		}
	}
	
	
}
