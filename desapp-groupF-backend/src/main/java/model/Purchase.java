package model;

import utils.Money;

public class Purchase {
	
	private ProductList products;
	@SuppressWarnings("unused")
	private Boolean purchased = false;
	
	public ProductList getProducts() {
		return products;
	}
	public void setProducts(ProductList products) {
		this.products = products;
	}
	public void addProduct(Product capitanDelEspacio, Integer cant) {
		this.products.addProduct(capitanDelEspacio, cant);
	}
	
	public Money getTotal(){
		return products.totalAmount();
	}

	public Long getDurationOfPurchase(){
		return this.products.getQuantityOfProducts().longValue();
	}
	
}
