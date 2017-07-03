package services;

import builders.ProfileBuilder;
import exceptions.MaxAmountExceededException;
import model.Buyer;
import model.ListItem;
import model.MaxAmountAlert;
import model.Product;
import model.Purchase;
import model.User;
import repositories.BuyerRepository;
import repositories.ListItemRepository;

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
		 Buyer toReturn = buyerRepository.getByEmail(email);
		 return toReturn;
	 }

	 public boolean emailExist(String email){
		 return buyerRepository.getByEmail(email) != null;
	 }

	public void addProduct(Product product,Integer quantity, Integer buyerId) throws MaxAmountExceededException  {
		Buyer buyer = buyerRepository.getById(buyerId);
		MaxAmountAlert maxAmountAlert = new MaxAmountAlert();
		maxAmountAlert.addProduct(product, quantity, buyer.getCurrentPurchase(), buyer.getProfile());
		buyerRepository.update(buyer);
		buyer = buyerRepository.getById(buyerId);
		String sarasa = "sarasa";
	}
}
