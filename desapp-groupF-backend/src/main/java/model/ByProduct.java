package model;

import java.time.LocalDate;

public class ByProduct extends Offer{

	private Product product;

	public ByProduct(String id, LocalDate start, LocalDate end, int discount, Product product){
		this.setId(id);
		this.setStartDate(start);
		this.setEndDate(end);
		this.setDiscount(discount);
		this.setProduct(product);
	}
	
	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
		
}
