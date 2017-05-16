package servicesRest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import repositories.ProductRepository;


@Path("/posts")
public class ProductServicesRest {
	
	ProductRepository productRepository;
	
    @GET
    @Path("/products")
    @Produces("application/json")
    public List<String> getProducts() {
    	List<String> list = new ArrayList<String>();
    	list.add("capitan");
    	list.add("jorgito");
        return list;
    }
    
    public void setProductRepository(final ProductRepository productRepository) {
    	this.productRepository = productRepository;
    }

}
