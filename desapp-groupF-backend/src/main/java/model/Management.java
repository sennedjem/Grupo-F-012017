package model;

import java.util.ArrayList;
import java.util.List;

import exceptions.ProductDoesNotExistWithThisIdException;

public class Management {
	
	private Integer id;
	private List<Product> products;
	private List<Offer> offers;
	
	public Management(){
		this.products = new ArrayList<Product>();
		this.offers = new ArrayList<Offer>();
	}
	
	public void addProduct(Product product){
		this.products.add(product);
	}
	
	public void removeProduct(Integer productId){
		for(int i = 0; i < this.products.size(); i++){
			if (this.products.get(i).getId().equals(productId)){
				this.products.remove(this.products.get(i));
			}
		}
	}
	
	private boolean containsProduct(Integer id){
		boolean res = false;
		for(int i = 0; i < this.products.size(); i++){
			if (this.products.get(i).getId().equals(id)){
				res = true;
			}
		}
		return res;
	}
	
	public Product getProduct(Integer id) throws ProductDoesNotExistWithThisIdException{
		if(this.containsProduct(id)){	
			for(int i = 0; i < this.products.size(); i++){
				if (this.products.get(i).getId().equals(id)){
					return products.get(i);
				}
			}
		} else {
			throw new ProductDoesNotExistWithThisIdException();
		}
		return null;
	}
	
	public void addOffer(Offer offer){
		this.offers.add(offer);
	}
	
	public List<Product> getProducts(){
		return this.products;
	}
	
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public List<Offer> getOffers() {
		return offers;
	}
	
	public void setOffers(List<Offer> offers) {
		this.offers = offers;
	}
}
