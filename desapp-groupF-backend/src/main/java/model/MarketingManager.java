package model;

import java.time.LocalDate;

import utils.Category;

public class MarketingManager extends User {
	
	public MarketingManager(Management management){
		this.setManagement(management);
	}
	
	public void createOfferByCategory(LocalDate start, LocalDate end, int discount,
			                          Category category){
		
		this.getManagement().addOffer(new ByCategory(start, end, discount, category));
	}
	
	public void createOfferByCombination(LocalDate start, LocalDate end, int discount, Product product1,
			                             Product product2){
		
		this.getManagement().addOffer(new ByCombination(start, end, discount, product1, product2));
	}
	
	public void createOfferByProduct(LocalDate start, LocalDate end, int discount,
                                     Product product){
		
		this.getManagement().addOffer(new ByProduct(start, end, discount, product));
	}
}