package fixture;

import java.util.List;

import javax.transaction.Transactional;

import model.Profile;
import model.Purchase;
import builders.AddressBuilder;
import builders.BuyerBuilder;
import builders.ProfileBuilder;
import model.Address;
import model.Buyer;
import model.ProductList;
import services.UsersService;
import utils.Money;

public class BuyerFixture {
	
	private UsersService userService;
	
	@Transactional 
	public void createBuyers(){
		//Profile profile1 = new createProfile(new Money(2,2),)
		//Buyer buyer1 = createBuyer("sal",)
	}

	public Buyer createBuyer(String userName, List<ProductList> purchaseHistory, Profile profile, Purchase purchase){
		BuyerBuilder buyerBuilder = new BuyerBuilder();
		return buyerBuilder.withUserName(userName).withPurchaseHistory(purchaseHistory).withProfile(profile).withCurrentPurchase(purchase).build();
	}
	
	public Profile createProfile(Money maxAmount, Address address, Integer id){
		ProfileBuilder profileBuilder = new ProfileBuilder();
		return profileBuilder.withAddress(address).withMaxAmount(maxAmount).withId(id).build();
	}
	
	public Address createAddress(String street, String district, Integer id){
		AddressBuilder addresBuilder = new AddressBuilder();
		return addresBuilder.withId(id).withStreet(street).withDistrict(district).build();
	}
	
	public void setUserService(UsersService usersService){
		this.userService = usersService;
	}
	
	public UsersService getUsersService(){
		return userService;
	}
}
