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
	
	public BuyerBuilder withProfile(Profile profile){
		this.buyer.setProfile(profile);
		return this;
	}
	
	public BuyerBuilder withPurchaseHistory(List<ProductList> purchaseHistory){
		this.buyer.setPurchaseHistory(purchaseHistory);
		return this;
	}
	
	public BuyerBuilder withBuyerName(String buyerName){
		this.buyer.setBuyerName(buyerName);
		return this;
	}
	
	public BuyerBuilder withCurrentPurchase(Purchase purchase){
		this.buyer.setCurrentPurchase(purchase);
		return this;
	}
	
	public BuyerBuilder withId(Integer id){
		this.buyer.setId(id);
		return this;
	}
}
