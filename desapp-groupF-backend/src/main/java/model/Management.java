package model;

import java.util.ArrayList;
import java.util.List;

public class Management {
	
	private List<Product> products;
	private List<Offer> offers;
	
	//TODO 1: Agregar un metodo que revise si una oferta esta vigente.
	//TODO 2: Agregar un metodo que revise que producto, productos o categoria tiene la oferta.
	
	public Management(){
		this.products = new ArrayList<Product>();
		this.offers = new ArrayList<Offer>();
	}
	
	public void addProduct(Product product){
		this.products.add(product);
	}
	
	public void removeProduct(String productId){
		for(int i = 0; i < this.products.size(); i++){
			if (this.products.get(i).getId().equals(productId)){
				this.products.remove(this.products.get(i));
			}
		}
	}
	
	private boolean containsProduct(String id){
		boolean res = false;
		for(int i = 0; i < this.products.size(); i++){
			if (this.products.get(i).getId().equals(id)){
				res = true;
			}
		}
		return res;
	}
	
	public Product getProduct(String id) throws ProductDoesNotExistWithThisIdException{
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
	
	public List<Offer> getOffers() {
		return offers;
	}
}
