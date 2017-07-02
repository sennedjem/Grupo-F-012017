package model;

import exceptions.MaxAmountExceededException;
import utils.Money;

public abstract class AlertSystem {

	public void addProduct(Product product, Integer cant, Purchase currentPurchase, Profile profile) throws MaxAmountExceededException {
		currentPurchase.addProduct(product,cant);
		Money priceToItem = product.getPrice().times(cant);
		checkAlert(currentPurchase,priceToItem,profile);
	}

	public abstract void checkAlert(Purchase currentPurchase, Money priceToItem, Profile profile) throws MaxAmountExceededException;



}
