package model;

import utils.Category;
import utils.Money;

public class Product {

	String id;
	String name;
	String brand;
	Money price;
	Integer stock;
	String image;
	Category category;

	public Product(String id, String name, String brand, Money price, Integer stock, String image, Category category){
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.stock = stock;
		this.image = image;
		this.category = category;
	}

	@Override
	public boolean equals(Object productToCompare){
		if (productToCompare != null && productToCompare instanceof Product){
			Product oneProduct = (Product) productToCompare;
			boolean eqName = this.getName() == oneProduct.getName();
			boolean eqPrice = this.getPrice() == oneProduct.getPrice();
			boolean eqBrand = this.getBrand() == oneProduct.getBrand();
			return eqName && eqPrice && eqBrand;
		}
		return false;		
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Money getPrice() {
		return price;
	}

	public void setPrice(Money price) {
		this.price = price;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	
}
