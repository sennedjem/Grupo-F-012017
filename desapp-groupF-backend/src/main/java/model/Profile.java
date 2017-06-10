package model;

import utils.Money;

public class Profile {

	private Money maxAmount;
	private Address address;
	
	public Address getAddress(){
		return address;
	}
	
	public void setDirection(Address address){
		this.address = address;
	}

	public Money getMaxAmount() {
		return maxAmount;
	}

	public void setMaxAmount(Money maxAmount) {
		this.maxAmount = maxAmount;
	}


}
