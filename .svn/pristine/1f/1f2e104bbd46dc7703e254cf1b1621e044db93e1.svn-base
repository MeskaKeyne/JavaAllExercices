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

public class TestEmployeeResource {

	private TestUtils utils;
	private WebTarget service;
	
	@Before
	public void setUp() throws Exception {
		this.utils = new TestUtils();
		this.service = ClientBuilder.newClient().target("http://localhost:8080/timesheets/rs");
	}

	@Test
	public void testFindOneEmployeeByIdXmlOk() {
		EmployeeDto batman = this.utils.createBatman();
		Response response =
			this.service
				.path("employee")
				.path(String.valueOf(batman.getId()))
				.request(MediaType.APPLICATION_XML)
				.get();
		
		assertEquals(200, response.getStatus());
		assertTrue(response.hasEntity());

		EmployeeDto found = response.readEntity(EmployeeDto.class);
			
		assertEquals(batman, found);
	}

	@Test
	public void testFindOneEmployeeByIdXmlKo() {
		Response response =
			this.service
				.path("employee")
				.path("0")
				.request(MediaType.APPLICATION_XML)
				.get();
		
		assertEquals(404, response.getStatus());
		
		response =
				this.service
					.path("employee")
					.path("1000")
					.request(MediaType.APPLICATION_XML)
					.get();
			
		assertEquals(404, response.getStatus());
	}
	
	@Test
	public void testFindOneEmployeeByIdJsonOk() {
		EmployeeDto batman = this.utils.createBatman();
		Response response =
			this.service
				.path("employee")
				.path(String.valueOf(batman.getId()))
				.request(MediaType.APPLICATION_JSON)
				.get();
		
		assertEquals(200, response.getStatus());
		assertTrue(response.hasEntity());

		EmployeeDto found = response.readEntity(EmployeeDto.class);
			
		assertEquals(batman, found);
	}

	@Test
	public void testFindOneEmployeeByIdJsonKo() {
		Response response =
			this.service
				.path("employee")
				.path("0")
				.request(MediaType.APPLICATION_JSON)
				.get();
		
		assertEquals(404, response.getStatus());
		
		response =
				this.service
					.path("employee")
					.path("1000")
					.request(MediaType.APPLICATION_JSON)
					.get();
		
		assertEquals(404, response.getStatus());
	}
	
	@Test
	public void testFindOneEmployeeByFirstnameAndNameXmlOk() {
		EmployeeDto batman = this.utils.createBatman();
		Response response =
			this.service
				.path("employee")
				.path(batman.getFirstname())
				.path(batman.getName())
				.request(MediaType.APPLICATION_XML)
				.get();
		
		assertEquals(200, response.getStatus());
		assertTrue(response.hasEntity());

		EmployeeDto found = response.readEntity(EmployeeDto.class);
			
		assertEquals(batman, found);
	}

	@Test
	public void testFindOneEmployeeByLoginAndPasswordXmlOk() {
		EmployeeDto batman = this.utils.createBatman();
		Response response =
			this.service
				.path("employee")
				.path(batman.getLogin())
				.path(batman.getPassword())
				.request(MediaType.APPLICATION_XML)
				.get();
		
		assertEquals(200, response.getStatus());
		assertTrue(response.hasEntity());

		EmployeeDto found = response.readEntity(EmployeeDto.class);
			
		assertEquals(batman, found);
	}
	
	@Test
	public void testFindOneEmployeeByFirstnameAndNameJsonOk() {
		EmployeeDto batman = this.utils.createBatman();
		Response response =
			this.service
				.path("employee")
				.path(batman.getFirstname())
				.path(batman.getName())
				.request(MediaType.APPLICATION_JSON)
				.get();
		
		assertEquals(200, response.getStatus());
		assertTrue(response.hasEntity());

		EmployeeDto found = response.readEntity(EmployeeDto.class);
			
		assertEquals(batman, found);
	}
	
	@Test
	public void testFindOneEmployeeByLoginAndPasswordJsonOk() {
		EmployeeDto batman = this.utils.createBatman();
		Response response =
			this.service
				.path("employee")
				.path(batman.getLogin())
				.path(batman.getPassword())
				.request(MediaType.APPLICATION_JSON)
				.get();
		
		assertEquals(200, response.getStatus());
		assertTrue(response.hasEntity());

		EmployeeDto found = response.readEntity(EmployeeDto.class);
			
		assertEquals(batman, found);
	}

	@Test
	public void testFindAllEmployeesXml() {
		Response response =
				this.service
					.path("employee")
					.request(MediaType.APPLICATION_XML)
					.get();
			
		assertEquals(200, response.getStatus());
		assertTrue(response.hasEntity());
		
		GenericType<List<EmployeeDto>> type = new GenericType<List<EmployeeDto>>() {}; 
		List<EmployeeDto> list = response.readEntity(type);
		
		assertNotNull(list);
		assertTrue(list.contains(this.utils.createBatman()));
		assertTrue(list.contains(this.utils.createSuperman()));
		assertTrue(list.contains(this.utils.createWonderWoman()));
	}

	@Test
	public void testFindAllEmployeesJson() {
		Response response =
				this.service
					.path("employee")
					.request(MediaType.APPLICATION_JSON)
					.get();
			
		assertEquals(200, response.getStatus());
		assertTrue(response.hasEntity());
		
		GenericType<List<EmployeeDto>> type = new GenericType<List<EmployeeDto>>() {}; 
		List<EmployeeDto> list = response.readEntity(type);
		
		assertNotNull(list);
		assertTrue(list.contains(this.utils.createBatman()));
		assertTrue(list.contains(this.utils.createSuperman()));
		assertTrue(list.contains(this.utils.createWonderWoman()));
	}

}
