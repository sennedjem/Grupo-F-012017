package model;

import java.util.List;

import utils.Money;

public class Buyer extends User{

	//private TurnsManager turnsManager;
	private Profile profile = new Profile();
	private List<ProductList> purchaseHistory;
	private Purchase currentPurchase;
	//private AlertSystem alertSystem;
	private String buyerName;
	private Integer id;
	
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

	public void makePurchase() {
		addProductListToHistory(currentPurchase.getProducts());
		this.currentPurchase = new Purchase();
	}
	
	private void addProductListToHistory(ProductList productList){
		this.purchaseHistory.add(productList);
	}

	/*
	public void setAlertSystem(AlertSystem alertSystem) {
		this.alertSystem = alertSystem;
		
	}

	public void addProduct(Product capitanDelEspacio, Integer cant) throws Exception {
		this.alertSystem.addProduct(capitanDelEspacio,cant,currentPurchase,profile);
	}
	*/

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	
	public void setMaxAmount(Money cant){
		this.profile.setMaxAmount(cant);
	}
	

}
