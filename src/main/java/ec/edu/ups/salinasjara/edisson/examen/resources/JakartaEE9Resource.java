package ec.edu.ups.salinasjara.edisson.examen.resources;

import ec.edu.ups.entidades.Bodega;
import ec.edu.ups.facade.BodegaFacade;
import ec.edu.ups.facade.ProductoFacade;
import jakarta.ejb.EJB;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

/**
 *
 * @author
 */
@Path("jakartaee9")
public class JakartaEE9Resource {
@EJB
    private ProductoFacade producto;
    @EJB
    
    private BodegaFacade ejbBodega;

    @GET
    public Response ping() {

        Bodega bo1 = new Bodega(1, "bodega1", "cuenca");
        ejbBodega.create(bo1);
        Bodega b2 = new Bodega(2, "bodega2", "Chordeleg");
        ejbBodega.create(b2);
        Bodega b3 = new Bodega(3, "bodega3", "Gualaceo");
        ejbBodega.create(b3);
        return Response
                .ok("ping Jakarta EE")
                .build();
    }
}
