package model;

import java.time.LocalDate;

import utils.Category;

public class ByCategory extends Offer{

	private Category category;

	public ByCategory(){}
	
	public ByCategory(Integer id, LocalDate start, LocalDate end, int discount, Category category){
		this.setId(id);
		this.setStartDate(start);
		this.setEndDate(end);
		this.setDiscount(discount);
		this.category = category;
	}
	
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
