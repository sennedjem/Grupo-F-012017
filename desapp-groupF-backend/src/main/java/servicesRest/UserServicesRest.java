package servicesRest;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;

import exceptions.MaxAmountExceededException;
import model.Buyer;
import model.ListItem;
import model.Product;
import model.User;
import services.UsersService;

@CrossOriginResourceSharing(allowAllOrigins = true)
@Path("/users")
@Produces("application/json")

public class UserServicesRest {
	
	UsersService usersService;
	
    @GET
    @Path("/getUsers")
    @Produces("application/json")
    public Response getUsers() {
    	List<Buyer> users = usersService.getBuyerRepository().findAll();
	    return Response.ok(users, MediaType.APPLICATION_JSON)
	    		.status(200)
	            .build();
    }
    
	@GET
	@Consumes("application/json")
	@Path("/getUser/{email}")
	public Response getUserByEmail(@PathParam("email") final String email){
	    return Response.ok(usersService.getUserByEmail(email), MediaType.APPLICATION_JSON)
	    		.status(200)
	            .build();
	}
	
	@POST
	@Consumes("application/json")
	@Path("/{id}/addProduct")
	@Transactional
	public Response addProduct(@PathParam("id") Integer id,ListItem product){
		try {
			usersService.addProduct(product.getProduct(),product.getQuantity(),id);
			return Response.ok().build();
		} catch (MaxAmountExceededException e) {
			e.printStackTrace();
		    return Response.ok("amount exceeded", MediaType.APPLICATION_JSON)
		    		.status(200)
		            .build();
		}
	}
	
	@PUT
	@Consumes("application/json")
	@Path("/update")
	@Transactional
	public Response updateBuyer(Buyer buyer){
		usersService.update(buyer);
		return Response.ok().build(); 
	}
	

    public void setUsersService(final UsersService usersService) {
    	this.usersService = usersService;
    }
}
