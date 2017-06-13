package model;

public class Address {
	private String street;
	private String district;
	private Integer id;
	
	public Integer getId(){
		return id;
	}
	
	public void setId(Integer id){
		this.id = id;
	}
	
	public String getStreet(){
		return street;
	}
	
	public String getDistrict(){
		return district;
	}
	
	public void setStreet(String street){
		this.street = street;
	}
	
	public void setDistrict(String district){
		this.district = district;
	}
}
