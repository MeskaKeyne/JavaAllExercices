package be.steformations.pc.timesheets.rs;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import be.steformations.java_data.timesheets.entities.Prestation;
import be.steformations.java_data.timesheets.service.TimesheetsDataService;
import be.steformations.pc.timesheets.dto.PrestationDto;
import be.steformations.pc.timesheets.dto.TimesheetsDtoFactory;

@Path("prestation")
public class PrestationResource {

	private TimesheetsDataService service;
	private TimesheetsDtoFactory dtoFactory;
	private Calendar calendar;
	
	public PrestationResource() {
		super();
		this.service = ServiceFactory.getInstance().getTimesheetsDataService();
		this.dtoFactory = new TimesheetsDtoFactory();
		this.calendar = new GregorianCalendar();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
	}
	
	@GET
	@Path("{id:[1-9][0-9]*}")
	@Produces(MediaType.APPLICATION_XML)
	public Response findOnePrestationByIdXml(@PathParam("id") long id) {
		return this.findOnePrestationById(id);
	}
	
	@GET
	@Path("{id:[1-9][0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findOnePrestationByIdJson(@PathParam("id") long id) {
		return this.findOnePrestationById(id);
	}
	
	@GET
	@Path("employee/{id:[1-9][0-9]*}")
	@Produces(MediaType.APPLICATION_XML)
	public Response findAllPrestationsByEmployeeIdXml(@PathParam("id") long id) {
		return this.findAllPrestationsByEmployeeId(id);
	}
	
	@GET
	@Path("employee/{id:[1-9][0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAllPrestationsByEmployeeIdJson(@PathParam("id") long id) {
		return this.findAllPrestationsByEmployeeId(id);
	}
	
	@GET
	@Path("project/{id:[1-9][0-9]*}")
	@Produces(MediaType.APPLICATION_XML)
	public Response findAllPrestationsByProjectIdXml(@PathParam("id") long id) {
		return this.findAllPrestationsByProjectId(id);
	}
	
	@GET
	@Path("project/{id:[1-9][0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAllPrestationsByProjectIdJson(@PathParam("id") long id) {
		return this.findAllPrestationsByProjectId(id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_XML)
	public Response addPrestationFormXml(
			@FormParam("employee") long employeeId, @FormParam("project") long projectId, 
			@FormParam("comment") String comment, 
			@FormParam("day") int day, @FormParam("month") int month, @FormParam("year") int year, 
			@FormParam("duration") int duration) {
		return this.addPrestation(employeeId, projectId, comment, day, month, year, duration);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addPrestationFormJson(
			@FormParam("employee") long employeeId, @FormParam("project") long projectId, 
			@FormParam("comment") String comment, 
			@FormParam("day") int day, @FormParam("month") int month, @FormParam("year") int year, 
			@FormParam("duration") int duration) {
		return this.addPrestation(employeeId, projectId, comment, day, month, year, duration);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response addPrestationXml(PrestationDto p) {
		return this.addPrestation(p.getEmployee().getId(), p.getProject().getId(), 
				p.getComment(), p.getDay(), p.getDuration());
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addPrestationJson(PrestationDto p) {
		return this.addPrestation(p.getEmployee().getId(), p.getProject().getId(), 
				p.getComment(), p.getDay(), p.getDuration());
	}
	
	@DELETE
	@Path("{id:[1-9][0-9]*}")
	@Produces(MediaType.APPLICATION_XML)
	public Response deletePrestationXml(@PathParam("id") long id) {
		return this.deletePrestation(id);
	}

	@DELETE
	@Path("{id:[1-9][0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deletePrestationJson(@PathParam("id") long id) {
		return this.deletePrestation(id);
	}
	
	protected Response findOnePrestationById(long id) {
		return this.createResponse(
					this.service.findOnePrestationById(id));
	}

	protected Response findAllPrestationsByEmployeeId(long id) {
		List<? extends Prestation> list = this.service.findAllPrestationsByEmployeeId(id);
		if (list.size() > 0) {
			return this.createResponse(list);
		} else {
			return Response.status(Status.NOT_FOUND).build();
		}
	}

	protected Response findAllPrestationsByProjectId(long id) {
		List<? extends Prestation> list = this.service.findAllPrestationsByProjectId(id);
		if (list.size() > 0) {
			return this.createResponse(list);
		} else {
			return Response.status(Status.NOT_FOUND).build();
		}
	}

	protected Response addPrestation(long employeeId, long projectId, String comment, 
			int day, int month, int year, int duration) {
		this.calendar.set(Calendar.YEAR, year);
		this.calendar.set(Calendar.MONTH, month-1);
		this.calendar.set(Calendar.DAY_OF_MONTH, day);
		return this.addPrestation(employeeId, projectId, comment, this.calendar.getTime(), duration);
	}
	
	protected Response addPrestation(long employeeId, long projectId, String comment, Date day, int duration) {
		Prestation prestation = this.service.addPrestation(employeeId, projectId, comment, day, duration);
		if (prestation != null) {
			return this.createResponse(prestation);
		} else {
			return Response.status(Status.NO_CONTENT).build();
		}
	}

	protected Response deletePrestation(long id) {
		Prestation prestation = this.service.deletePrestation(id);
		if (prestation != null) {
			return this.createResponse(prestation);
		} else {
			return Response.status(Status.NOT_FOUND).build();
		}
	}

	protected Response createResponse(Prestation prestation) {
		Response response = null;
		if (prestation == null) {
			response = Response.status(Status.NOT_FOUND).build();
		} else {
			PrestationDto dto = this.dtoFactory.createPrestationDto(prestation);
			response = Response.ok(dto).build();
		}
		return response;
	}
	
	protected Response createResponse(List<? extends Prestation> prestations) {
		Response response = null;
		List<PrestationDto> dto = new ArrayList<>();
		for (Prestation p : prestations) {
			dto.add(this.dtoFactory.createPrestationDto(p));
		}
		GenericEntity<List<PrestationDto>> entity = new GenericEntity<List<PrestationDto>>(dto) {};
		response = Response.ok(entity).build();
		return response;
	}
}
