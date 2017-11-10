package be.steformations.pc.timesheets.rs;

import static org.junit.Assert.*;

import java.util.List;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.Before;
import org.junit.Test;

import be.steformations.pc.timesheets.dto.EmployeeDto;
import be.steformations.pc.timesheets.dto.ProjectDto;

public class TestProjectResource {

	private TestUtils utils;
	private WebTarget service;
	
	@Before
	public void setUp() throws Exception {
		this.utils = new TestUtils();
		this.service = ClientBuilder.newClient().target("http://localhost:8080/timesheets/rs/project");
	}

	@Test
	public void testFindOneProjectByIdXmlOk() {
		ProjectDto justiceLeague = this.utils.createJusticeLeague();
		Response response 
			= this.service.path(String.valueOf(justiceLeague.getId()))
				.request(MediaType.APPLICATION_XML)
				.get();
		
		assertEquals(200, response.getStatus());
		assertTrue(response.hasEntity());
		
		ProjectDto found = response.readEntity(ProjectDto.class);
		assertEquals(justiceLeague, found);
	}

	@Test
	public void testFindOneProjectByIdXmlKo() {
		Response response 
			= this.service.path("0")
				.request(MediaType.APPLICATION_XML)
				.get();
		
		assertEquals(404, response.getStatus());

		response 
			= this.service.path("1000")
				.request(MediaType.APPLICATION_XML)
				.get();
	
		assertEquals(404, response.getStatus());
	}
	
	@Test
	public void testFindOneProjectByIdJsonOk() {
		ProjectDto justiceLeague = this.utils.createJusticeLeague();
		Response response 
			= this.service.path(String.valueOf(justiceLeague.getId()))
				.request(MediaType.APPLICATION_JSON)
				.get();
		
		assertEquals(200, response.getStatus());
		assertTrue(response.hasEntity());
		
		ProjectDto found = response.readEntity(ProjectDto.class);
		assertEquals(justiceLeague, found);
	}

	@Test
	public void testFindOneProjectByIdJsonKo() {
		Response response 
			= this.service.path("0")
				.request(MediaType.APPLICATION_JSON)
				.get();
		
		assertEquals(404, response.getStatus());
	
		response 
			= this.service.path("1000")
				.request(MediaType.APPLICATION_JSON)
				.get();
	
		assertEquals(404, response.getStatus());		
	}
	
	@Test
	public void testFindOneProjectByNameXmlOk() {
		ProjectDto justiceLeague = this.utils.createJusticeLeague();
		Response response 
			= this.service.path(justiceLeague.getName())
				.request(MediaType.APPLICATION_XML)
				.get();
		
		assertEquals(200, response.getStatus());
		assertTrue(response.hasEntity());
		
		ProjectDto found = response.readEntity(ProjectDto.class);
		assertEquals(justiceLeague, found);
	}

	@Test
	public void testFindOneProjectByNameXmlKo() {
		Response response 
			= this.service.path("xxxxxx")
				.request(MediaType.APPLICATION_XML)
				.get();
	
		assertEquals(404, response.getStatus());		
	}
	
	@Test
	public void testFindOneProjectByNameJsonOk() {
		ProjectDto justiceLeague = this.utils.createJusticeLeague();
		Response response 
			= this.service.path(justiceLeague.getName())
				.request(MediaType.APPLICATION_JSON)
				.get();
		
		assertEquals(200, response.getStatus());
		assertTrue(response.hasEntity());
		
		ProjectDto found = response.readEntity(ProjectDto.class);
		assertEquals(justiceLeague, found);
	}

	@Test
	public void testFindOneProjectByNameJsonKo() {
		Response response 
			= this.service.path("xxxxxx")
				.request(MediaType.APPLICATION_JSON)
				.get();
	
		assertEquals(404, response.getStatus());		
	}	
	
	@Test
	public void testFindAllProjectsXml() {
		Response response 
			= this.service.request(MediaType.APPLICATION_XML).get();
		
		assertEquals(200, response.getStatus());
		assertTrue(response.hasEntity());
		
		GenericType<List<ProjectDto>> type = new GenericType<List<ProjectDto>>() {};
		List<ProjectDto> list = response.readEntity(type);
		
		assertTrue(list.contains(this.utils.createJusticeLeague()));
		assertTrue(list.contains(this.utils.createFortressOfSolitude()));
	}

	@Test
	public void testFindAllProjectsJson() {
		Response response 
			= this.service.request(MediaType.APPLICATION_JSON).get();
		
		assertEquals(200, response.getStatus());
		assertTrue(response.hasEntity());
		
		GenericType<List<ProjectDto>> type = new GenericType<List<ProjectDto>>() {};
		List<ProjectDto> list = response.readEntity(type);
		
		assertTrue(list.contains(this.utils.createJusticeLeague()));
		assertTrue(list.contains(this.utils.createFortressOfSolitude()));
	}

	@Test
	public void testFindAllProjectByManagerIdXml() {
		EmployeeDto batman = this.utils.createBatman();
		Response response 
			= this.service
				.path("manager")
				.path(String.valueOf(batman.getId()))
				.request(MediaType.APPLICATION_XML)
				.get();
		
		assertEquals(200, response.getStatus());
		assertTrue(response.hasEntity());
		
		GenericType<List<ProjectDto>> type = new GenericType<List<ProjectDto>>() {};
		List<ProjectDto> list = response.readEntity(type);
		
		assertTrue(list.contains(this.utils.createJusticeLeague()));
	}

	@Test
	public void testFindAllProjectByManagerIdJson() {
		EmployeeDto batman = this.utils.createBatman();
		Response response 
			= this.service
				.path("manager")
				.path(String.valueOf(batman.getId()))
				.request(MediaType.APPLICATION_JSON)
				.get();
		
		assertEquals(200, response.getStatus());
		assertTrue(response.hasEntity());
		
		GenericType<List<ProjectDto>> type = new GenericType<List<ProjectDto>>() {};
		List<ProjectDto> list = response.readEntity(type);
		
		assertTrue(list.contains(this.utils.createJusticeLeague()));
	}

}
