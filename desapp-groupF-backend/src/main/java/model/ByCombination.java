package model;

public class ByCombination extends Offer{

	private Product product1;
	private Product product2;
	
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
