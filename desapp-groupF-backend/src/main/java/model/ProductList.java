package model;

import java.util.List;

import exceptions.ProductDoesNotExistsInListException;
import utils.Money;

import java.util.ArrayList;

public class ProductList {
	
	private String name;
	private List<ListItem> products = new ArrayList<ListItem>();
	
	public ProductList(String name){
		this.name = name;
	}
	
	public ProductList() {
	}

	public List<ListItem> getProducts(){
		return this.products;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String newName){
		this.name = newName;
	}
	
	public void addProduct(Product product, Integer quantity){
		boolean exists = false;
		for (ListItem oneProduct : products){
			if(oneProduct.getProduct().equals(product)){
				oneProduct.setQuantity(oneProduct.getQuantity() + quantity);
				exists = exists || true;
				break;
			}
		}
		
		if (!exists){
			this.products.add(new ListItem(product, quantity));
		}
	}
	
	public void removeProduct(Product someProduct) throws ProductDoesNotExistsInListException{
		boolean exists = false;
		
		for (ListItem oneProduct : products){
			if(oneProduct.getProduct().equals(someProduct)){
				products.remove(oneProduct);
				exists = exists || true;
				break;
			}
		}
		
		if (!exists){
			throw new ProductDoesNotExistsInListException();
		}
	}
	
	public void checkProduct(Product someProduct){
		for (ListItem oneProduct : products){
			if(oneProduct.getProduct().equals(someProduct)){
				oneProduct.setPurchased(true);
			}
		}
	}
	
	public Money totalAmount(){
		Money total = new Money(0,0);
		for (ListItem oneProduct : products){
			total.add(oneProduct.getTotalValue());
		}
		return total;		
	}
	
	public Integer getQuantityOfProductTypes(){
		return products.size();
	}
	
	public Integer getQuantityOfProducts(){
		Integer quantity = 0;
		for(ListItem product : products){
			quantity += product.getQuantity();
		}
		return quantity;
	}
	
	public Money spentAmount(){
		Money spent = new Money(0,0);
		for (ListItem oneProduct : products){
			if(oneProduct.getPurchased()){
				spent.add(oneProduct.getTotalValue());
			}
		}
		return spent;	
	}
}
