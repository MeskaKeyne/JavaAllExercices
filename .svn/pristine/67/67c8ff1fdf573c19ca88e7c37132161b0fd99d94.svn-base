package be.steformations.pc.chesspuzzles.ejb.rest;

import be.steformations.pc.chesspuzzles.dto.ChessPuzzleDto;
import be.steformations.pc.chesspuzzles.ejb.ChesspuzzleEjbService;

@javax.ejb.Stateless
@javax.ws.rs.Path("chesspuzzle")
public class ChessPuzzzleResource {

	@javax.ejb.EJB // injection par serveur JEE
	private ChesspuzzleEjbService ejbService;
	
	@javax.ws.rs.GET
	@javax.ws.rs.Path("{rank: [1-9][0-9]*}")
	@javax.ws.rs.Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public javax.ws.rs.core.Response read(@javax.ws.rs.PathParam("rank") int id) {
		System.out.println("ChessPuzzzleResource.read()");
		return this.createResponse(this.ejbService.read(id));
	}
	
	@javax.ws.rs.GET
	@javax.ws.rs.Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public javax.ws.rs.core.Response random() {
		System.out.println("ChessPuzzzleResource.random()");
		return this.createResponse(this.ejbService.random());
	}
	
	@javax.ws.rs.DELETE
	@javax.ws.rs.Path("{rank: [1-9][0-9]*}")
	@javax.ws.rs.Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public javax.ws.rs.core.Response delete(@javax.ws.rs.PathParam("rank") int id) {
		System.out.println("ChessPuzzzleResource.delete()");
		return this.createResponse(this.ejbService.delete(id));
	}
	
	@javax.ws.rs.POST
	@javax.ws.rs.Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@javax.ws.rs.Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public javax.ws.rs.core.Response create(ChessPuzzleDto dto) {
		System.out.println("ChessPuzzzleResource.create()");
		return this.createResponse(this.ejbService.create(dto.getFen(), dto.getSan()));
	}
	
	@javax.ws.rs.PUT
	@javax.ws.rs.Consumes(javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED)
	@javax.ws.rs.Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public javax.ws.rs.core.Response update(
			@javax.ws.rs.FormParam("id") int id,
			@javax.ws.rs.FormParam("san") String san) {
		System.out.println("ChessPuzzzleResource.update()");
		return this.createResponse(this.ejbService.update(id, san));
	}
	
	protected javax.ws.rs.core.Response createResponse(ChessPuzzleDto dto) {
		javax.ws.rs.core.Response response = null;
		if (dto == null) {
			response = javax.ws.rs.core.Response.status(404).build();
		} else {
			response = javax.ws.rs.core.Response.ok(dto).build();
		}
		return response;
	}
}
