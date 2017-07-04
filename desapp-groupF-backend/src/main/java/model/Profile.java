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
	
	public void setAddress(Address address){
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
	public void update(Profile profile) {
		this.setMaxAmount(profile.getMaxAmount());
		this.setAddress(profile.getAddress());
		
	}


}
