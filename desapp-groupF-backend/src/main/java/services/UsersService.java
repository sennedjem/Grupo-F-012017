package services;

import repositories.BuyerRepository;
import repositories.ProductManagementRepository;

public class UsersService {
	
	private BuyerRepository buyerRepo;
	
	 public BuyerRepository getBuyerRepository() {
	        return this.buyerRepo;
	 }	
	 
	 public void setRepository(BuyerRepository rep) {
	        this.buyerRepo = rep;
	 }	

}
