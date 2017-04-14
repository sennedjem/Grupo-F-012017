package model;

import java.time.LocalDate;

public class ByProduct extends Offer{

	private Product product;

	public ByProduct(LocalDate start, LocalDate end, int discount, Product product){
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
