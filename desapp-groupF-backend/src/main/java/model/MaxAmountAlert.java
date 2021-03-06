package model;

import exceptions.MaxAmountExceededException;
import utils.Money;

public class MaxAmountAlert extends AlertSystem{

	@Override
	public void checkAlert(Purchase currentPurchase, Money priceToItem, Profile profile) throws MaxAmountExceededException {
		if(maxAmountExceeded(currentPurchase, profile)){
			throw new MaxAmountExceededException();
		}
	}

	private Boolean maxAmountExceeded(Purchase currentPurchase, Profile profile) {
		return currentPurchase.getTotalAmount().higher(profile.getMaxAmount());
	}




}
