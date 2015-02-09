
package boundary;

import validation.Validatable;
import entity.Beer;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("")
@Stateless // Needed because CDI interceptors will not work in JAX-RS Resource
public class Boundary {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Beer get() {
        return new Beer("Grolsch Kanon", 1998);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Validatable
    public void post(Beer beer) {
        System.out.println("beer = " + beer);
    }
}
