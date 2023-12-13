package services;

import javax.inject.Inject;
import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.Endereco;

import repository.EnderecoRepository;
@Path("/endereco")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EnderecoService {

	@Inject
	private EnderecoRepository enderecoRepository;

	@GET
	public Response listar() {
		return Response.ok().entity(this.enderecoRepository.listar()).build();
	}

	@GET
	@Path("/{id}")
	public Response consultar(@PathParam("id") int id) {
		return Response.ok().entity(this.enderecoRepository.consultar(id)).build();
	}

	@POST
	public Response cadastrar(Endereco novo) {
		return Response.ok().entity(this.enderecoRepository.cadastrar(novo)).build();
	}

	@PUT
	public Response atualizar(Endereco endereco) {
		try {
			this.enderecoRepository.remover(endereco);
			return Response.ok(this.enderecoRepository.atualizar(endereco)).build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getMessage()).build();
		}
	}

	@DELETE
	public Response remover(Endereco endereco) {
		try {
			this.enderecoRepository.remover(endereco);
			return Response.ok().build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getMessage()).build();
		}
	}

}