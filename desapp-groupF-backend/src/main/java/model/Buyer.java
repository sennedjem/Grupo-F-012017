package model;

import java.util.List;

public class Buyer {

	private TurnsManager turnsManager;
	private List<ProductList> purchaseHistory;
	private ProductList currentPurchase;
	
	
	public void setTurnsManager(TurnsManager turnsManager){
		this.turnsManager = turnsManager;
		
	}
	
	public void requestTurn() {
		turnsManager.requestTurn();
		
	}

	public void setPurchaseHistory(List<ProductList> purchaseHistory) {
		this.purchaseHistory = purchaseHistory;
		
	}
	
	public List<ProductList> getPurchaseHistory(){
		return purchaseHistory;
	}

	public void setCurrentPurchase(ProductList currentPurchase) {
		this.currentPurchase = currentPurchase;
		
	}

	public void makePurchase() {
		addProductListToHistory(currentPurchase);
		this.currentPurchase = new ProductList();
	}
	
	private void addProductListToHistory(ProductList productList){
		this.purchaseHistory.add(productList);
	}
	

}
