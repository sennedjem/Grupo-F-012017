package servicesRest;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.dao.DataAccessException;

import model.Product;
import repositories.ProductRepository;
import utils.Money;


@Path("/products")
@Produces("application/json")

public class ProductServicesRest {
	
	ProductRepository productRepository;
	
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
	
    @GET
    @Path("/getAll")
    @Produces("application/json")
    public List<Product> getProducts() {
        return productRepository.findAll();
    }
    
    @GET
    @Path("/moneys")
    @Produces("application/json")
    public List<Money> getMoneys() {
        List<Money> mns = new ArrayList<Money>();
        mns.add(new Money(50,00));
        mns.add(new Money(20,00));
        return mns;
    }
    
    public void setProductRepository(final ProductRepository productRepository) {
    	this.productRepository = productRepository;
    }

}
