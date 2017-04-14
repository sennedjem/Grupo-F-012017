package model;

import java.time.LocalDate;

public class ByCombination extends Offer{

	private Product product1;
	private Product product2;
	
	public ByCombination(LocalDate start, LocalDate end, int discount, Product p1, Product p2){
		this.setStartDate(start);
		this.setEndDate(end);
		this.setDiscount(discount);
		this.combination(p1, p2);
	}
	
	public void combination(Product product1, Product product2){
		this.product1 = product1;
		this.product2 = product2;
	}
	
	public Product getProduct1() {
		return this.product1;
	}
	
	public Product getProduct2() {
		return this.product2;
	}
}
