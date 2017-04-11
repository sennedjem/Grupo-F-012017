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
	
	public void removeProduct(Product product){
		for (Product oneProduct : this.products){
			if(oneProduct.getId().equals(product)){
				products.remove(oneProduct);
			}
		}
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
