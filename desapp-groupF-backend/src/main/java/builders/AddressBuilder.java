package builders;

import model.Address;


public class AddressBuilder {
	
	private Address address;
	
	public AddressBuilder(){
		address = new Address();
	}
	
	public Address getBuyer(){
		return address;
	}
	
	public void setBuyer(Address address){
		this.address = address;
	}
	
	public Address build(){
		Address result = this.getBuyer();
		this.address = new Address();
		return result;
	}
	
	public AddressBuilder withStreet(String street){
		this.address.setStreet(street);
		return this;
	}
	
	public AddressBuilder withDistrict(String district){
		this.address.setDistrict(district);
		return this;
	}
	
	public AddressBuilder withId(Integer id){
		this.address.setId(id);
		return this;
	}
	
}