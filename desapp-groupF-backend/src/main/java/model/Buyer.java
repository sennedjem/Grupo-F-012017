package model;

import java.util.List;

import utils.Money;

public class Buyer extends User{

	//private TurnsManager turnsManager;
	private Profile profile = new Profile();
	private List<ProductList> purchaseHistory;
	private Purchase currentPurchase;
	private String buyerName;
	private Integer id;
	private String buyerEmail;
	
	/*
	public void setTurnsManager(TurnsManager turnsManager){
		this.turnsManager = turnsManager;
	}
	
	public void requestTurn() {
		turnsManager.requestTurn();
	}
	*/
	
	public Integer getId(){
		return id;
	}
	
	public void setId(Integer id){
		this.id = id;
	}
	
	public String getBuyerName(){
		return buyerName;
	}
	
	public void setBuyerName(String buyerName){
		this.buyerName = buyerName;
	}
	
	public void setPurchaseHistory(List<ProductList> purchaseHistory) {
		this.purchaseHistory = purchaseHistory;
	}
	
	public List<ProductList> getPurchaseHistory(){
		return purchaseHistory;
	}

	public void setCurrentPurchase(Purchase currentPurchase) {
		this.currentPurchase = currentPurchase;
	}

	
	public Purchase getCurrentPurchase(){
		return this.currentPurchase;
	}
	
	public void makePurchase() {
		addProductListToHistory(currentPurchase.getProducts());
		this.setCurrentPurchase(new Purchase());
	}
	
	private void addProductListToHistory(ProductList productList){
		this.purchaseHistory.add(productList);
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	
	public void setMaxAmount(Money cant){
		this.profile.setMaxAmount(cant);
	}
  
	public void setBuyerEmail(String email) {
		this.buyerEmail = email;
	}
	
	public String getBuyerEmail(){
		return this.buyerEmail;
	}
	

}
