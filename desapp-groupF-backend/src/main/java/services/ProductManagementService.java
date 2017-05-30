package services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import model.Product;
import repositories.ProductManagementRepository;

public class ProductManagementService{
	
	private ProductManagementRepository repository = new ProductManagementRepository();
	
	 public ProductManagementRepository getRepository() {
	        return this.repository;
	 }	
	 
	 public void setRepository(ProductManagementRepository rep) {
	        this.repository = rep;
	 }	
	 
	 
	@Transactional(readOnly = true)
    public List<Product> retrieveAllProducts() {
        return this.getRepository().findAllProducts();
    }
	
	@Transactional
	public void save(Object entity){
		this.getRepository().save(entity);
	}
	
	@Transactional
	public void delete(Object entity){
		this.getRepository().delete(entity);
	}

}