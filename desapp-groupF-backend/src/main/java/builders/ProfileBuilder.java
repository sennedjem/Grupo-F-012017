package builders;

import model.Address;
import model.Profile;
import utils.Money;

public class ProfileBuilder {

	private Profile profile;
	
	public ProfileBuilder(){
		profile = new Profile();
	}
	
	public void setProfile(Profile profile){
		this.profile = profile;
	}
	
	public Profile getProfile(){
		return profile;
	}
	
	public ProfileBuilder withMaxAmount(Money maxAmount){
		this.profile.setMaxAmount(maxAmount);
		return this;
	}
	
	public ProfileBuilder withId(Integer id){
		this.profile.setId(id);
		return this;
	}
	
	public ProfileBuilder withAddress(Address address){
		this.profile.setAddress(address);
		return this;
	}
	
	public Profile build(){
		Profile result = getProfile();
		this.profile = new Profile();
		return result;
	}


}
