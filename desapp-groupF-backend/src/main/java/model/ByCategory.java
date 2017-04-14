package model;

import java.time.LocalDate;

import utils.Category;

public class ByCategory extends Offer{

	private Category category;

	public ByCategory(String id, LocalDate start, LocalDate end, int discount, Category category){
		this.setId(id);
		this.setStartDate(start);
		this.setEndDate(end);
		this.setDiscount(discount);
		this.setCategory(category);
	}
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
