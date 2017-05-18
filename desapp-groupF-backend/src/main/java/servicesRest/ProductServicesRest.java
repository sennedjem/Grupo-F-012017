package servicesRest;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import model.Product;
import repositories.ProductRepository;


@Path("/products")
@Produces("application/json")

public class ProductServicesRest {
	
	ProductRepository productRepository;
	
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
    
    public void setProductRepository(final ProductRepository productRepository) {
    	this.productRepository = productRepository;
    }

}
