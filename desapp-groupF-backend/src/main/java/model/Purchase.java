package model;

import utils.Money;

public class Purchase {
	
	private ProductList products;
	@SuppressWarnings("unused")
	private Boolean purchased = false;
	private Integer id;
	
	public void setId(Integer id){
		this.id = id;
	}
	
	public Integer getId(){
		return this.id;
	}
	
	public ProductList getProducts() {
		return products;
	}
	public void setProducts(ProductList products) {
		this.products = products;
	}
	public void addProduct(Product capitanDelEspacio, Integer cant) {
		this.products.addProduct(capitanDelEspacio, cant);
	}
	
	public Money getTotalAmount(){
		return products.totalAmount();
	}

	public Long getDurationOfPurchase(){
		return this.products.getQuantityOfProducts().longValue();
	}
	
}
