package model;

import java.io.IOException;

import exceptions.ProductDoesNotExistWithThisIdException;
import utils.CSVFileManager;
import utils.Category;
import utils.Money;

public class Admin extends User{
	
	CSVFileManager csvFileManager;
	
	public Admin(Management management){
		this.setManagement(management);
		this.csvFileManager = new CSVFileManager(management);
	}
	
	public void addProduct(Product product){
		this.getManagement().addProduct(product);
	}
	
	public void addProductsWithCSVFile(String filePath) throws NumberFormatException, IOException{
		csvFileManager.importProducts(filePath);
	}
	
	public void removeProduct(Integer productId){
		this.getManagement().removeProduct(productId);
	}
	
	public void modifyProductName(Integer productId, String newName) throws ProductDoesNotExistWithThisIdException{
		this.getManagement().getProduct(productId).setName(newName);
	}
	
	public void modifyProductBrand(Integer productId, String newBrand) throws ProductDoesNotExistWithThisIdException{
		this.getManagement().getProduct(productId).setBrand(newBrand);
	}	

	public void modifyProductPrice(Integer productId, Money newPrice) throws ProductDoesNotExistWithThisIdException{
		this.getManagement().getProduct(productId).setPrice(newPrice);
	}
	
	public void modifyProductStock(Integer productId, Integer newStock) throws ProductDoesNotExistWithThisIdException{
		this.getManagement().getProduct(productId).setStock(newStock);
	}
	
	public void modifyProductImage(Integer productId, String newImage) throws ProductDoesNotExistWithThisIdException{
		this.getManagement().getProduct(productId).setImage(newImage);
	}
	
	public void modifyProductCategory(Integer productId, Category newCategory) throws ProductDoesNotExistWithThisIdException{
		this.getManagement().getProduct(productId).setCategory(newCategory);
	}
}
