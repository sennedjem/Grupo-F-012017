package model;

import utils.Category;
import utils.Money;

public class Admin extends User{
	
	private Management management;
	
	public void addProduct(Product product){
		this.management.addProduct(product);
	}
	
	public void removeProduct(Product product){
		this.management.removeProduct(product);
	}
	
	public void modifyProductName(Product product, String newName){
		product.setName(newName);
	}
	
	public void modifyProductBrand(Product product, String newBrand){
		product.setBrand(newBrand);
	}	

	public void modifyProductPrice(Product product, Money newPrice){
		product.setPrice(newPrice);
	}
	
	public void modifyProductStock(Product product, Integer newStock){
		product.setStock(newStock);
	}
	
	public void modifyProductImage(Product product, String newImage){
		product.setImage(newImage);
	}
	
	public void modifyProductCategory(Product product, Category newCategory){
		product.setCategory(newCategory);
	}
}
