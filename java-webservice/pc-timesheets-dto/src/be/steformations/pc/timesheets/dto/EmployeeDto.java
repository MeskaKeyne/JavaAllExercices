package be.steformations.pc.timesheets.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import be.steformations.pc.timesheets.dao.entities.EmployeeImpl;

@XmlRootElement(name="employee")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class EmployeeDto extends EmployeeImpl {

	private static final long serialVersionUID = -2513995436050726951L;
}
