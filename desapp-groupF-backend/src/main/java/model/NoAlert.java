package model;

import exceptions.MaxAmountExceededException;
import utils.Money;

public class NoAlert extends AlertSystem {

	@Override
	public void checkAlert(Purchase currentPurchase, Money priceToItem, Profile profile) throws MaxAmountExceededException {
		
	}

}
