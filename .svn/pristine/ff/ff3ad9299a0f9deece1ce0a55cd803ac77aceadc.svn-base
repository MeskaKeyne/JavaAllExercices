package be.steformations.pc.timesheets.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import be.steformations.pc.timesheets.dao.entities.EmployeeImpl;
import be.steformations.pc.timesheets.dao.entities.ProjectImpl;

@XmlRootElement(name="project")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class ProjectDto extends ProjectImpl {

	private static final long serialVersionUID = -9108472594361638445L;

	@Override
	public void setManager(EmployeeImpl manager) {
		if (! (manager instanceof EmployeeDto)) {
			this.manager = new EmployeeDto();
			this.manager.setId(manager.getId());
			this.manager.setFirstname(manager.getFirstname());
			this.manager.setName(manager.getName());
			this.manager.setLogin(manager.getLogin());
			this.manager.setPassword(manager.getPassword());
		} else {
			this.manager = manager;
		}
	}
	
	

}
