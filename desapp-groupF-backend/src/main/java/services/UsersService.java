package services;

import model.Buyer;
import model.User;
import repositories.BuyerRepository;

public class UsersService {
	
	
	private BuyerRepository buyerRepository;
	
	 public BuyerRepository getBuyerRepository() {
	        return this.buyerRepository;
	 }	
	 
	 public void setBuyerRepository(BuyerRepository rep) {
	        this.buyerRepository = rep;
	 }	
	 
	 public void save(Buyer user){
		 buyerRepository.save(user);
	 }

}
