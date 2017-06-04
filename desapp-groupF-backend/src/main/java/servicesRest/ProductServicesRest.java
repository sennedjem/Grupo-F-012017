package servicesRest;

import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;
import org.springframework.dao.DataAccessException;

import model.Product;
import repositories.ProductRepository;
import services.ProductManagementService;
import utils.Money;

@CrossOriginResourceSharing(allowAllOrigins = true)
@Path("/products")
@Produces("application/json")

public class ProductServicesRest {
	
	ProductRepository productRepository;
	ProductManagementService productManagementService;
	
	@DELETE
	@Path("/deleteProduct")
	@Transactional
	public Response deleteProduct(Product product){
		if(!product.valid()){
			return Response.status(Response.Status.NOT_ACCEPTABLE).build();
		}
		try{
			productManagementService.delete(product);
			return Response.ok().build();
		} catch(DataAccessException exception){
			return Response.status(Response.Status.NOT_ACCEPTABLE).build();
		}
		
	}
	
	@POST
	@Consumes("application/json")
	@Path("/addProduct")
	@Transactional
	public Response addProduct(Product product){
		if(!product.valid()){
			return Response.status(Response.Status.NOT_ACCEPTABLE).build();
		}
		productManagementService.save(product);
		return Response.ok().build();
	}
	
	@POST
	@Consumes("application/json")
	@Path("/addMoney")
	@Transactional
	public Response addMoney(Money money){
		productManagementService.save(money);
		return Response.ok().build();
	}
	
    @GET
    @Path("/getProducts")
    @Produces("application/json")
    public Response getProducts() {
	try{
		List<Product> products = productManagementService.retrieveAllProducts();
	    return Response.ok(products, MediaType.APPLICATION_JSON)
	    		.status(200)
	            .build();
	}catch(Exception e){
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Exception raised").build();
		}
    }
        
    public void setProductRepository(final ProductRepository productRepository) {
    	this.productRepository = productRepository;
    }
    
    public void setProductManagementService(final ProductManagementService productManagementService) {
    	this.productManagementService = productManagementService;
    }

}
