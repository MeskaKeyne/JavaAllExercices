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

import be.steformations.java_data.timesheets.entities.Project;
import be.steformations.java_data.timesheets.service.TimesheetsDataService;
import be.steformations.pc.timesheets.dto.ProjectDto;
import be.steformations.pc.timesheets.dto.TimesheetsDtoFactory;

@Path("project")
public class ProjectResource {

	private TimesheetsDataService service;
	private TimesheetsDtoFactory dtoFactory;
	
	public ProjectResource() {
		super();
		this.service = ServiceFactory.getInstance().getTimesheetsDataService();
		this.dtoFactory = new TimesheetsDtoFactory();
	}

	@GET
	@Path("{id:[1-9][0-9]*}")
	@Produces(MediaType.APPLICATION_XML)
	public Response findOneProjectByIdXml(@PathParam("id") long id) {
		return this.findOneProjectById(id);
	}

	@GET
	@Path("{id:[1-9][0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findOneProjectByIdJson(@PathParam("id") long id) {
		return this.findOneProjectById(id);
	}
	
	@GET
	@Path("{name}")
	@Produces(MediaType.APPLICATION_XML)
	public Response findOneProjectByNameXml(@PathParam("name") String name) {
		return this.findOneProjectByName(name);
	}
	
	@GET
	@Path("{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findOneProjectByNameJson(@PathParam("name") String name) {
		return this.findOneProjectByName(name);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Response findAllProjectsXml() {
		return this.findAllProjects();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAllProjectsJson() {
		return this.findAllProjects();
	}
	
	@GET
	@Path("manager/{id:[1-9][0-9]*}")
	@Produces(MediaType.APPLICATION_XML)
	public Response findAllProjectByManagerIdXml(@PathParam("id") Long id) {
		return this.findAllProjectByManagerId(id);
	}
	
	@GET
	@Path("manager/{id:[1-9][0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAllProjectByManagerIdJson(@PathParam("id") Long id) {
		return this.findAllProjectByManagerId(id);
	}
	
	protected Response findOneProjectById(long id) {
		return this.createResponse(
					this.service.findOneProjectById(id));
	}

	protected Response findOneProjectByName(String name) {
		return this.createResponse(
					this.service.findOneProjectByName(name));
	}
	
	protected Response findAllProjects() {
		return this.createResponse(
					this.service.findAllProjects());
	}

	protected Response findAllProjectByManagerId(Long id) {
		List<Project> projects = new ArrayList<>();
		for (Project p : this.service.findAllProjects()) {
			if (p.getManager() != null && p.getManager().getId().equals(id)) {
				projects.add(p);
			}
		}
		return this.createResponse(projects);
	}
	
	protected Response createResponse(Project project) {
		Response response = null;
		if (project == null) {
			response = Response.status(Status.NOT_FOUND).build();
		} else {
			ProjectDto dto = this.dtoFactory.createProjectDto(project);
			response = Response.ok(dto).build();
		}
		return response;
	}
	
	protected Response createResponse(List<? extends Project> projects) {
		Response response = null;
		List<ProjectDto> dto = new ArrayList<>();
		for (Project p : projects) {
			dto.add(this.dtoFactory.createProjectDto(p));
		}
		GenericEntity<List<ProjectDto>> entity = new GenericEntity<List<ProjectDto>>(dto) {};
		response = Response.ok(entity).build();
		return response;
	}
}
