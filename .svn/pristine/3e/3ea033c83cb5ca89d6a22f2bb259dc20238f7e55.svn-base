package be.steformations.pc.timesheets.rs;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.junit.Before;
import org.junit.Test;

import be.steformations.pc.timesheets.dto.EmployeeDto;
import be.steformations.pc.timesheets.dto.PrestationDto;
import be.steformations.pc.timesheets.dto.ProjectDto;

public class TestPrestationResource {

	protected TestUtils utils;
	protected WebTarget service;
	
	@Before
	public void setUp() throws Exception {
		this.utils = new TestUtils();
		this.service = ClientBuilder.newClient().target("http://localhost:8080/timesheets/rs/prestation");
	}

	@Test
	public void testFindOnePrestationByIdXmlOk() {
		PrestationDto prestation = this.utils.createSendEmail();
		Response response 
			= this.service.path(String.valueOf(prestation.getId()))
				.request(MediaType.APPLICATION_XML)
				.get();
			
		assertEquals(200, response.getStatus());
		assertTrue(response.hasEntity());
		
		PrestationDto found = response.readEntity(PrestationDto.class);
		assertEquals(prestation, found);
	}

	@Test
	public void testFindOnePrestationByIdXmlKo() {
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
	public void testFindOnePrestationByIdJsonOk() {
		PrestationDto prestation = this.utils.createSendEmail();
		Response response 
			= this.service.path(String.valueOf(prestation.getId()))
				.request(MediaType.APPLICATION_JSON)
				.get();
			
		assertEquals(200, response.getStatus());
		assertTrue(response.hasEntity());
		
		PrestationDto found = response.readEntity(PrestationDto.class);
		assertEquals(prestation, found);
	}

	@Test
	public void testFindOnePrestationByIdJsonKo() {
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
	public void testFindAllPrestationsByEmployeeIdXmlOk() {
		EmployeeDto batman = this.utils.createBatman();
		Response response 
			= this.service
				.path("employee")
				.path(String.valueOf(batman.getId()))
				.request(MediaType.APPLICATION_XML)
				.get();
			
		assertEquals(200, response.getStatus());
		assertTrue(response.hasEntity());
		
		GenericType<List<PrestationDto>> type = new GenericType<List<PrestationDto>>() {};
		List<PrestationDto> list = response.readEntity(type);
		
		assertTrue(list.contains(this.utils.createSendEmail()));
	}

	@Test
	public void testFindAllPrestationsByEmployeeIdXmlKo() {
		Response response 
			= this.service
				.path("employee")
				.path("0")
				.request(MediaType.APPLICATION_XML)
				.get();
			
		assertEquals(404, response.getStatus());
		
		response 
			= this.service
				.path("employee")
				.path("1000")
				.request(MediaType.APPLICATION_XML)
				.get();
			
		assertEquals(404, response.getStatus());
	}
	
	@Test
	public void testFindAllPrestationsByEmployeeIdJsonOk() {
		EmployeeDto batman = this.utils.createBatman();
		Response response 
			= this.service
				.path("employee")
				.path(String.valueOf(batman.getId()))
				.request(MediaType.APPLICATION_JSON)
				.get();
			
		assertEquals(200, response.getStatus());
		assertTrue(response.hasEntity());
		
		GenericType<List<PrestationDto>> type = new GenericType<List<PrestationDto>>() {};
		List<PrestationDto> list = response.readEntity(type);
		
		assertTrue(list.contains(this.utils.createSendEmail()));
	}

	@Test
	public void testFindAllPrestationsByEmployeeIdJsonKo() {
		Response response 
			= this.service
				.path("employee")
				.path("0")
				.request(MediaType.APPLICATION_JSON)
				.get();
			
		assertEquals(404, response.getStatus());
		
		response 
			= this.service
				.path("employee")
				.path("1000")
				.request(MediaType.APPLICATION_JSON)
				.get();
			
		assertEquals(404, response.getStatus());
	}	
	
	@Test
	public void testFindAllPrestationsByProjectIdXmlOk() {
		ProjectDto justiceLeague = this.utils.createJusticeLeague();
		Response response 
			= this.service
				.path("project")
				.path(String.valueOf(justiceLeague.getId()))
				.request(MediaType.APPLICATION_XML)
				.get();
			
		assertEquals(200, response.getStatus());
		assertTrue(response.hasEntity());
		
		GenericType<List<PrestationDto>> type = new GenericType<List<PrestationDto>>() {};
		List<PrestationDto> list = response.readEntity(type);
		
		assertTrue(list.contains(this.utils.createSendEmail()));
		assertTrue(list.contains(this.utils.createReadEmail()));
		assertTrue(list.contains(this.utils.createSendResponse()));
	}

	@Test
	public void testFindAllPrestationsByProjectIdXmlKo() {
		Response response 
			= this.service
				.path("project")
				.path("0")
				.request(MediaType.APPLICATION_XML)
				.get();
			
		assertEquals(404, response.getStatus());
		
		response 
			= this.service
				.path("project")
				.path("1000")
				.request(MediaType.APPLICATION_XML)
				.get();
			
		assertEquals(404, response.getStatus());
	}	
	
	@Test
	public void testFindAllPrestationsByProjectIdJsonOk() {
		ProjectDto justiceLeague = this.utils.createJusticeLeague();
		Response response 
			= this.service
				.path("project")
				.path(String.valueOf(justiceLeague.getId()))
				.request(MediaType.APPLICATION_JSON)
				.get();
			
		assertEquals(200, response.getStatus());
		assertTrue(response.hasEntity());
		
		GenericType<List<PrestationDto>> type = new GenericType<List<PrestationDto>>() {};
		List<PrestationDto> list = response.readEntity(type);
		
		assertTrue(list.contains(this.utils.createSendEmail()));
		assertTrue(list.contains(this.utils.createReadEmail()));
		assertTrue(list.contains(this.utils.createSendResponse()));
	}

	@Test
	public void testFindAllPrestationsByProjectIdJsonKo() {
		Response response 
			= this.service
				.path("project")
				.path("0")
				.request(MediaType.APPLICATION_JSON)
				.get();
			
		assertEquals(404, response.getStatus());
		
		response 
			= this.service
				.path("project")
				.path("1000")
				.request(MediaType.APPLICATION_JSON)
				.get();
			
		assertEquals(404, response.getStatus());
	}	
	
	@Test
	public void testAddPrestationFormXml() {
		PrestationDto prestation = this.utils.createNew();
		
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(prestation.getDay());
		
		MultivaluedMap<String, String> map
			= new MultivaluedHashMap<>();
		map.add("employee", String.valueOf(prestation.getEmployee().getId()));
		map.add("project", String.valueOf(prestation.getProject().getId()));
		map.add("comment", prestation.getComment());
		map.add("day", String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)));
		map.add("month", String.valueOf(calendar.get(Calendar.MONTH)+1));
		map.add("year", String.valueOf(calendar.get(Calendar.YEAR)));
		map.add("duration", String.valueOf(prestation.getDuration()));
		
		Entity<MultivaluedMap<String, String>> entity
			= Entity.entity(map, MediaType.APPLICATION_FORM_URLENCODED);
		
		Response response 
			= this.service.request(MediaType.APPLICATION_XML).post(entity);
		
		assertEquals(200, response.getStatus());
		assertTrue(response.hasEntity());
		
		PrestationDto created = response.readEntity(PrestationDto.class);
		
		assertNotNull(created);
		assertNotNull(created.getId());
		assertEquals(prestation.getComment(), created.getComment());
		assertEquals(prestation.getDuration(), created.getDuration());
		assertEquals(prestation.getDay(), created.getDay());
		assertEquals(prestation.getEmployee(), created.getEmployee());
		assertEquals(prestation.getProject(), created.getProject());
		
		response 
			= this.service.path(String.valueOf(created.getId()))
				.request(MediaType.APPLICATION_XML)
				.get();
			
		assertEquals(200, response.getStatus());
		assertTrue(response.hasEntity());
		
		PrestationDto found = response.readEntity(PrestationDto.class);
		assertEquals(created, found);
		
	}
	
	@Test
	public void testAddPrestationFormJson() {

		PrestationDto prestation = this.utils.createNew();
		
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(prestation.getDay());
		
		MultivaluedMap<String, String> map
			= new MultivaluedHashMap<>();
		map.add("employee", String.valueOf(prestation.getEmployee().getId()));
		map.add("project", String.valueOf(prestation.getProject().getId()));
		map.add("comment", prestation.getComment());
		map.add("day", String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)));
		map.add("month", String.valueOf(calendar.get(Calendar.MONTH)+1));
		map.add("year", String.valueOf(calendar.get(Calendar.YEAR)));
		map.add("duration", String.valueOf(prestation.getDuration()));
		
		Entity<MultivaluedMap<String, String>> entity
			= Entity.entity(map, MediaType.APPLICATION_FORM_URLENCODED);
		
		Response response 
			= this.service.request(MediaType.APPLICATION_JSON).post(entity);
		
		assertEquals(200, response.getStatus());
		assertTrue(response.hasEntity());
		
		PrestationDto created = response.readEntity(PrestationDto.class);
		
		assertNotNull(created);
		assertNotNull(created.getId());
		assertEquals(prestation.getComment(), created.getComment());
		assertEquals(prestation.getDuration(), created.getDuration());
		assertEquals(prestation.getDay(), created.getDay());
		assertEquals(prestation.getEmployee(), created.getEmployee());
		assertEquals(prestation.getProject(), created.getProject());
		
		response 
			= this.service.path(String.valueOf(created.getId()))
				.request(MediaType.APPLICATION_JSON)
				.get();
			
		assertEquals(200, response.getStatus());
		assertTrue(response.hasEntity());
		
		PrestationDto found = response.readEntity(PrestationDto.class);
		assertEquals(created, found);
	}

	@Test
	public void testAddPrestationXml() {
		PrestationDto prestation = this.utils.createNew();
		Entity<PrestationDto> entity
			= Entity.entity(prestation, MediaType.APPLICATION_XML);
		Response response = this.service.request(MediaType.APPLICATION_XML).post(entity);
		
		assertEquals(200, response.getStatus());
		assertTrue(response.hasEntity());
		
		PrestationDto created = response.readEntity(PrestationDto.class);
		
		assertNotNull(created);
		assertNotNull(created.getId());
		assertEquals(prestation.getComment(), created.getComment());
		assertEquals(prestation.getDuration(), created.getDuration());
		assertEquals(prestation.getDay(), created.getDay());
		assertEquals(prestation.getEmployee(), created.getEmployee());
		assertEquals(prestation.getProject(), created.getProject());
		
		response 
			= this.service.path(String.valueOf(created.getId()))
				.request(MediaType.APPLICATION_XML)
				.get();
			
		assertEquals(200, response.getStatus());
		assertTrue(response.hasEntity());
		
		PrestationDto found = response.readEntity(PrestationDto.class);
		assertEquals(created, found);
	}

	@Test
	public void testAddPrestationJson() {
		PrestationDto prestation = this.utils.createNew();
		Entity<PrestationDto> entity
			= Entity.entity(prestation, MediaType.APPLICATION_JSON);
		Response response = this.service.request(MediaType.APPLICATION_JSON).post(entity);
		
		assertEquals(200, response.getStatus());
		assertTrue(response.hasEntity());
		
		PrestationDto created = response.readEntity(PrestationDto.class);
		
		assertNotNull(created);
		assertNotNull(created.getId());
		assertEquals(prestation.getComment(), created.getComment());
		assertEquals(prestation.getDuration(), created.getDuration());
		assertEquals(prestation.getDay(), created.getDay());
		assertEquals(prestation.getEmployee(), created.getEmployee());
		assertEquals(prestation.getProject(), created.getProject());
		
		response 
			= this.service.path(String.valueOf(created.getId()))
				.request(MediaType.APPLICATION_JSON)
				.get();
			
		assertEquals(200, response.getStatus());
		assertTrue(response.hasEntity());
		
		PrestationDto found = response.readEntity(PrestationDto.class);
		assertEquals(created, found);
	}

	@Test
	public void testDeletePrestationXml() {
		PrestationDto prestation = this.utils.createNew();
		Entity<PrestationDto> entity
			= Entity.entity(prestation, MediaType.APPLICATION_XML);
		Response response = this.service.request(MediaType.APPLICATION_XML).post(entity);
		
		assertEquals(200, response.getStatus());
		assertTrue(response.hasEntity());
		
		PrestationDto created = response.readEntity(PrestationDto.class);
		
		assertNotNull(created);
		assertNotNull(created.getId());
		assertEquals(prestation.getComment(), created.getComment());
		assertEquals(prestation.getDuration(), created.getDuration());
		assertEquals(prestation.getDay(), created.getDay());
		assertEquals(prestation.getEmployee(), created.getEmployee());
		assertEquals(prestation.getProject(), created.getProject());
		
		response 
			= this.service.path(String.valueOf(created.getId()))
				.request(MediaType.APPLICATION_XML)
				.get();
			
		assertEquals(200, response.getStatus());
		assertTrue(response.hasEntity());
		
		PrestationDto found = response.readEntity(PrestationDto.class);
		assertEquals(created, found);
		
		response = this.service
					.path(String.valueOf(created.getId()))
					.request(MediaType.APPLICATION_XML)
					.delete();
		
		assertEquals(200, response.getStatus());
		assertTrue(response.hasEntity());
		
		found = response.readEntity(PrestationDto.class);
		assertEquals(created, found);
		
		response 
			= this.service.path(String.valueOf(created.getId()))
				.request(MediaType.APPLICATION_XML)
				.get();
			
		assertEquals(404, response.getStatus());
	}

	@Test
	public void testDeletePrestationJson() {
		PrestationDto prestation = this.utils.createNew();
		Entity<PrestationDto> entity
			= Entity.entity(prestation, MediaType.APPLICATION_JSON);
		Response response = this.service.request(MediaType.APPLICATION_JSON).post(entity);
		
		assertEquals(200, response.getStatus());
		assertTrue(response.hasEntity());
		
		PrestationDto created = response.readEntity(PrestationDto.class);
		
		assertNotNull(created);
		assertNotNull(created.getId());
		assertEquals(prestation.getComment(), created.getComment());
		assertEquals(prestation.getDuration(), created.getDuration());
		assertEquals(prestation.getDay(), created.getDay());
		assertEquals(prestation.getEmployee(), created.getEmployee());
		assertEquals(prestation.getProject(), created.getProject());
		
		response 
			= this.service.path(String.valueOf(created.getId()))
				.request(MediaType.APPLICATION_JSON)
				.get();
			
		assertEquals(200, response.getStatus());
		assertTrue(response.hasEntity());
		
		PrestationDto found = response.readEntity(PrestationDto.class);
		assertEquals(created, found);
		
		response = this.service
					.path(String.valueOf(created.getId()))
					.request(MediaType.APPLICATION_JSON)
					.delete();
		
		assertEquals(200, response.getStatus());
		assertTrue(response.hasEntity());
		
		found = response.readEntity(PrestationDto.class);
		assertEquals(created, found);
		
		response 
			= this.service.path(String.valueOf(created.getId()))
				.request(MediaType.APPLICATION_JSON)
				.get();
			
		assertEquals(404, response.getStatus());
	}

}
