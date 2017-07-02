package services;

import builders.ProfileBuilder;
import model.Buyer;
import model.Purchase;
import model.User;
import repositories.BuyerRepository;

public class UsersService extends GenericService<Buyer>{
	
	
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
	 
	 public Buyer getUserByEmail(String email){
		 if (!(emailExist(email))){
			 Buyer buyer = new Buyer();
			 buyer.setBuyerEmail(email);
			 buyer.setCurrentPurchase(new Purchase());
			 this.save(buyer);
			 
		 }
		 Buyer toReturn =buyerRepository.getByEmail(email);
		 return toReturn;
	 }

	 public boolean emailExist(String email){
		 return buyerRepository.getByEmail(email) != null;
	 }
}
