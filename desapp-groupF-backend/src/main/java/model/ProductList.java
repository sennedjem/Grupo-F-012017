package model;

import java.util.List;

import utils.Money;

import java.util.ArrayList;

public class ProductList {
	
	private String name;
	private List<ListItem> products = new ArrayList<ListItem>();
	
	public ProductList(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String newName){
		this.name = newName;
	}
	
	public void addProduct(Product product, Integer quantity){
		//Version simplificada
		//ToDo: Si existe el producto en el carrito, agregar stock
		this.products.add(new ListItem(product, quantity));
	}
	
	public void removeProduct(Product someProduct){
		//Agregar excepcion si no existe
		for (ListItem oneProduct : products){
			if(oneProduct.getProduct().equals(someProduct)){
				products.remove(oneProduct);
			}
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
	
	public Money spentAmount(){
		Money spent = new Money(0,0);
		for (ListItem oneProduct : products){
			if(oneProduct.getPurchased()){
				spent.add(oneProduct.getTotalValue());
			};
		}
		return spent;	
	}
}
