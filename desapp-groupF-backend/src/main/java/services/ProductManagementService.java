package services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import model.Product;
import repositories.ProductManagementRepository;
import utils.Category;

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
	public void delete(Integer id){
		this.getRepository().delete(id);
	}
	
	@Transactional
	public Product getByID(Integer id){
		return this.getRepository().getByID(id);
	}

}