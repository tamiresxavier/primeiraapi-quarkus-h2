package acc.br;

import acc.br.model.Fruta;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/frutas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FrutasResource {

    // GET - Listar todas as frutas
    @GET
    public List<Fruta> listar() {
        return Fruta.listAll();
    }

    // POST - Criar uma nova fruta
    @POST
    @Transactional
    public Response adicionar(Fruta fruta) {
        fruta.persist();
        return Response.status(Response.Status.CREATED).entity(fruta).build();
    }

    // DELETE - Remover uma fruta pelo ID
    @DELETE
    @Path("/{id}")
    @Transactional
    public Response remover(@PathParam("id") Long id) {
        Fruta fruta = Fruta.findById(id);
        if (fruta == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        fruta.delete();
        return Response.status(Response.Status.NO_CONTENT).build();
    }
    
}