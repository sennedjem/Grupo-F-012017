package model;

import utils.Money;

public class ListItem {
	
	Product product;
	Integer quantity;
	boolean purchased;
	Money totalValue;
	
	public ListItem(Product product, Integer quantity){
		this.product = product;
		this.quantity = quantity;
		this.purchased = false;
		this.totalValue = product.getPrice().times(quantity);
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public boolean getPurchased() {
		return purchased;
	}

	public void setPurchased(boolean purchased) {
		this.purchased = purchased;
	}
}
