package model;

import java.time.LocalDate;

import utils.Money;

public class Offer {
	
	LocalDate startDate;
	LocalDate endDate;
	Money discount;
	
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public Money getDiscount() {
		return discount;
	}
	public void setDiscount(Money discount) {
		this.discount = discount;
	}
	
}
