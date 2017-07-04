package services;

import builders.ProfileBuilder;
import exceptions.MaxAmountExceededException;
import model.Buyer;
import model.ListItem;
import model.MaxAmountAlert;
import model.Product;
import model.Profile;
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
	 
	 public void save(Buyer buyer){
	 	 buyerRepository.save(buyer);
	 }
	 
	 public void update(Buyer buyer){
		 buyerRepository.update(buyer);
	 }
	 
	 public Buyer getUserByEmail(String email){
		 if (!(emailExist(email))){
			 createNewBuyer(email);
		 }
		 return buyerRepository.getByEmail(email);
	 }

	private void createNewBuyer(String email) {
		Buyer buyer = new Buyer();
		 buyer.setBuyerEmail(email);
		 buyer.setCurrentPurchase(new Purchase());
		 this.save(buyer);
	}

	 public boolean emailExist(String email){
		 return buyerRepository.getByEmail(email) != null;
	 }

	public void addProduct(Product product,Integer quantity, Integer buyerId) throws MaxAmountExceededException  {
		Buyer buyer = getBuyerById(buyerId);
		MaxAmountAlert maxAmountAlert = new MaxAmountAlert();
		maxAmountAlert.addProduct(product, quantity, buyer.getCurrentPurchase(), buyer.getProfile());
		this.update(buyer);
	}

	private Buyer getBuyerById(Integer buyerId) {
		Buyer buyer = buyerRepository.getById(buyerId);
		return buyer;
	}

	public void makePurchase(Integer id) {
		Buyer buyer = getBuyerById(id);
		buyer.makePurchase();
		this.save(buyer);
		
	}

	public boolean profileIsValid(Integer id, Profile profile) {
		Buyer buyer = getBuyerById(id);
		return buyer.getProfile().getId().equals(profile.getId());
	}

	public void updateProfile(Integer id, Profile profile) {
		Buyer buyer = getBuyerById(id);
		buyer.getProfile().update(profile);
		this.update(buyer);
	}
}
