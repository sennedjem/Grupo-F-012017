package servicesRest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;

import model.Buyer;
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
    

    public void setUsersService(final UsersService usersService) {
    	this.usersService = usersService;
    }
}
