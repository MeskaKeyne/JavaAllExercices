package be.steformations.pc.timesheets.rs;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import be.steformations.java_data.timesheets.entities.Employee;
import be.steformations.java_data.timesheets.service.TimesheetsDataService;
import be.steformations.pc.timesheets.dto.EmployeeDto;
import be.steformations.pc.timesheets.dto.TimesheetsDtoFactory;

@Path("employee")
public class EmployeeResource {

	private TimesheetsDataService service;
	private TimesheetsDtoFactory dtoFactory;
	
	public EmployeeResource() {
		super();
		this.service = ServiceFactory.getInstance().getTimesheetsDataService();
		this.dtoFactory = new TimesheetsDtoFactory();
	}

	@GET
	@Path("{id:[1-9][0-9]*}")
	@Produces(MediaType.APPLICATION_XML)
	public Response findOneEmployeeByIdXml(@PathParam("id") long id) {
		return this.findOneEmployeeById(id);
	}

	@GET
	@Path("{id:[1-9][0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findOneEmployeeByIdJson(@PathParam("id") long id) {
		return this.findOneEmployeeById(id);
	}
	
	@GET
	@Path("{firstnameOrLogin}/{nameOrPassword}")
	@Produces(MediaType.APPLICATION_XML)
	public Response findOneEmployeeByStringParametersXml(
			@PathParam("firstnameOrLogin") String firstParam, 
			@PathParam("nameOrPassword") String secondParam) {
		return this.findOneEmployeeByStringParameters(firstParam, secondParam);
	}
	
	@GET
	@Path("{firstnameOrLogin}/{nameOrPassword}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findOneEmployeeByStringParametersJson(
			@PathParam("firstnameOrLogin") String firstParam, 
			@PathParam("nameOrPassword") String secondParam) {
		return this.findOneEmployeeByStringParameters(firstParam, secondParam);
	}	
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Response findAllEmployeesXml() {
		return this.findAllEmployees();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAllEmployeesJson() {
		return this.findAllEmployees();
	}
	
	protected Response findOneEmployeeById(long id) {
		return this.createResponse(
					this.service.findOneEmployeeById(id));
	}

	protected Response findOneEmployeeByStringParameters(String firstParam, String secondParam) {
		Employee e = this.service.findOneEmployeeByFirstnameAndName(firstParam, secondParam);
		if (e == null) {
			e = this.service.findOneEmployeeByLoginAndPassword(firstParam, secondParam);
		}
		return this.createResponse(e);
	}

	protected Response findAllEmployees() {
		return this.createResponse(this.service.findAllEmployees());
	}
	
	protected Response createResponse(Employee employee) {
		Response response = null;
		if (employee == null) {
			response = Response.status(Status.NOT_FOUND).build();
		} else {
			EmployeeDto dto = this.dtoFactory.createEmployeeDto(employee);
			response = Response.ok(dto).build();
		}
		return response;
	}
	
	protected Response createResponse(List<? extends Employee> employees) {
		Response response = null;
		List<EmployeeDto> dto = new ArrayList<>();
		for (Employee e : employees) {
			dto.add(this.dtoFactory.createEmployeeDto(e));
		}
		GenericEntity<List<EmployeeDto>> entity = new GenericEntity<List<EmployeeDto>>(dto) {};
		response = Response.ok(entity).build();
		return response;
	}
}
