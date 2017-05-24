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

import org.springframework.dao.DataAccessException;

import fixture.ProductFixture;
import model.Product;
import repositories.MoneyRepository;
import repositories.ProductRepository;
import utils.Money;


@Path("/products")
@Produces("application/json")

public class ProductServicesRest {
	
	ProductRepository productRepository;
	MoneyRepository moneyRepository;
	
	@DELETE
	@Path("/deleteProduct")
	@Transactional
	public Response deleteProduct(Product product){
		if(!product.valid()){
			return Response.status(Response.Status.NOT_ACCEPTABLE).build();
		}
		try{
			productRepository.delete(product);
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
		productRepository.save(product);
		return Response.ok().build();
	}
	
	@POST
	@Consumes("application/json")
	@Path("/addMoney")
	@Transactional
	public Response addMoney(Money money){
		if(!money.valid()){
			return Response.status(Response.Status.NOT_ACCEPTABLE).build();
		}
		moneyRepository.save(money);
		return Response.ok().build();
	}
	
    @GET
    @Path("/getAll")
    @Produces("application/json")
	    public Response getProducts() {
    	try{
			List<Product> products = productRepository.findAll();
		    return Response.ok(products, MediaType.APPLICATION_JSON)
		            .header("Access-Control-Allow-Origin", "*")
		            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
		            .header("Access-Control-Allow-Credentials", "true")
		            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
		            .header("Access-Control-Max-Age", "1209600")
		            .build();
		}catch(Exception e){
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Exception raised").build();
		}
    }
    
    @GET
    @Path("/moneys")
    @Produces("application/json")
    public List<Money> getMoneys() {
    	return moneyRepository.findAll();
    }
    
    public void setMoneyRepository(final MoneyRepository moneyRepository) {
    	this.moneyRepository = moneyRepository;
    }
    
    public void setProductRepository(final ProductRepository productRepository) {
    	this.productRepository = productRepository;
    }

}
