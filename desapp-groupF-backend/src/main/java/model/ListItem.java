package model;

import utils.Money;

public class ListItem {
	
	private Product product;
	private Integer quantity;
	private boolean purchased;
	private Integer id;
	
	public ListItem(Product product, Integer quantity){
		this.product = product;
		this.quantity = quantity;
		this.purchased = false;
	}

	public ListItem() {
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Money getTotalValue() {
		return product.getPrice().times(quantity);
	}

}
