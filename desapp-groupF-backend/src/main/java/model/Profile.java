package model;

import utils.Money;

public class Profile {

	private Money maxAmount;
	private Address address;
	private Integer id;
	
	public Profile(){
		
	}
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
	
	public Integer getId(){
		return id;
	}
	
	public void setId(Integer id){
		this.id = id;
	}


}
