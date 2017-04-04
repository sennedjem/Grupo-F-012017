package model;

import java.util.ArrayList;
import java.util.List;

public class Management {
	
	List<Product> products = new ArrayList<Product>();
	
	public void addProduct(Product product){
		this.products.add(product);
	}
	
	public void removeProduct(Product product){
		for (Product oneProduct : this.products){
			if(oneProduct.getId().equals(product)){
				products.remove(oneProduct);
			}
		}
	}
	
	public List<Product> getProducts(){
		return this.products;
	}
}
