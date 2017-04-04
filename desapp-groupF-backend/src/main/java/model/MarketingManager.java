package model;

import java.time.LocalDate;

import utils.Category;
import utils.Money;

public class MarketingManager extends User {
	
	public void createOfferByCategory(LocalDate start, LocalDate end,
			                          Category category, Money discount){
		
		ByCategory byCategory = new ByCategory();
		byCategory.setStartDate(start);
		byCategory.setEndDate(end);
		byCategory.setDiscount(discount);
		byCategory.setCategory(category);
	}
	
	public void createOfferByCombination(LocalDate start, LocalDate end, Product product1,
			                             Product product2, Money discount){
		
		ByCombination byCombination = new ByCombination();
		byCombination.setStartDate(start);
		byCombination.setEndDate(end);
		byCombination.setDiscount(discount);
		byCombination.combination(product1, product2);
	}
	
	public void createOfferByProduct(LocalDate start, LocalDate end,
                                     Product product, Money discount){
		
		ByProduct byProduct = new ByProduct();
		byProduct.setStartDate(start);
		byProduct.setEndDate(end);
		byProduct.setDiscount(discount);
		byProduct.setProduct(product);
	}
}
