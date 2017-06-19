package builders;

import model.Address;


public class AddressBuilder {
	
	private Address address;
	
	public AddressBuilder(){
		address = new Address();
	}
	
	public Address getAddress(){
		return address;
	}
	
	public void setAddress(Address address){
		this.address = address;
	}
	
	public Address build(){
		Address result = this.getAddress();
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