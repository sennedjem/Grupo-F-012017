package builders;

import java.util.List;

import model.Buyer;
import model.ProductList;
import model.Profile;
import model.Purchase;

public class BuyerBuilder {
	
	private Buyer buyer;
	
	public BuyerBuilder(){
		buyer = new Buyer();
	}
	
	public Buyer getBuyer(){
		return buyer;
	}
	
	public void setBuyer(Buyer buyer){
		this.buyer = buyer;
	}
	
	public Buyer build(){
		Buyer result = this.getBuyer();
		this.buyer = new Buyer();
		return result;
	}
	
	public void withProfile(Profile profile){
		this.buyer.setProfile(profile);
	}
	
	public void withPurchaseHistory(List<ProductList> purchaseHistory){
		this.buyer.setPurchaseHistory(purchaseHistory);
	}
	
	public void withUserName(String userName){
		this.buyer.setUserName(userName);
	}
	
	public void setCurrentPurchase(Purchase purchase){
		this.buyer.setCurrentPurchase(purchase);
	}
}
