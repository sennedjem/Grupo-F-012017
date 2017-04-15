package model;

import exceptions.ProductDoesNotExistWithThisIdException;
import utils.Category;
import utils.Money;

public class Admin extends User{
	
	public Admin(Management management){
		this.setManagement(management);
	}
	
	public void addProduct(Product product){
		this.getManagement().addProduct(product);
	}
	
	public void removeProduct(String productId){
		this.getManagement().removeProduct(productId);
	}
	
	public void modifyProductName(String productId, String newName) throws ProductDoesNotExistWithThisIdException{
		this.getManagement().getProduct(productId).setName(newName);
	}
	
	public void modifyProductBrand(String productId, String newBrand) throws ProductDoesNotExistWithThisIdException{
		this.getManagement().getProduct(productId).setBrand(newBrand);
	}	

	public void modifyProductPrice(String productId, Money newPrice) throws ProductDoesNotExistWithThisIdException{
		this.getManagement().getProduct(productId).setPrice(newPrice);
	}
	
	public void modifyProductStock(String productId, Integer newStock) throws ProductDoesNotExistWithThisIdException{
		this.getManagement().getProduct(productId).setStock(newStock);
	}
	
	public void modifyProductImage(String productId, String newImage) throws ProductDoesNotExistWithThisIdException{
		this.getManagement().getProduct(productId).setImage(newImage);
	}
	
	public void modifyProductCategory(String productId, Category newCategory) throws ProductDoesNotExistWithThisIdException{
		this.getManagement().getProduct(productId).setCategory(newCategory);
	}
}
