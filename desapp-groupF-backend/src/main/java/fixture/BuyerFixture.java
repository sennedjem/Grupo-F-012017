package fixture;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import model.Profile;
import model.Purchase;
import builders.AddressBuilder;
import builders.BuyerBuilder;
import builders.ListItemBuilder;
import builders.ProductBuilder;
import builders.ProductListBuilder;
import builders.ProfileBuilder;
import model.Address;
import model.Buyer;
import model.ListItem;
import model.Product;
import model.ProductList;
import services.UsersService;
import utils.Category;
import utils.Money;

public class BuyerFixture {
	
	private UsersService usersService;
	
	@Transactional 
	public void createBuyers(){
		List<ProductList> purchaseHistorySal = new ArrayList<ProductList>();
		List<ListItem> productsSal = listItems();
		ProductList productListSal = createProductList(productsSal,"lista sal",1);
		purchaseHistorySal.add(productListSal);
		Address larreta = createAddress("larreta 1471","florencio varela",1);
		Profile profile1 = createProfile(new Money(2,2),larreta,1);
		Purchase purchase = new Purchase();
		Buyer buyer1 = createBuyer(1,"sebastianariell@gmail.com","sal",purchaseHistorySal,profile1,purchase);
		usersService.save(buyer1);
	}

	
	private List<ListItem> listItems() {
		List<ListItem> items = new ArrayList<ListItem>();
		Product product = createProduct(1,
				"https://www.vegaffinity.com/imagenes/alimentos/pringlesoriginal.png",
				"Pringles", Category.Food, new Money(50,0), "Papas Fritas");
		items.add(createListItem(2,1,product,true));
		return items;
	}

	public ListItem createListItem(Integer quantity, Integer id, Product product, boolean purchased){
		ListItemBuilder listItemBuilder = new ListItemBuilder();
		return listItemBuilder.withQuantity(quantity).withId(id).withPurchased(purchased).withProduct(product).build();
	}

	public ProductList createProductList(List<ListItem> products, String name, Integer id){
		ProductListBuilder productListBuilder = new ProductListBuilder();
		return productListBuilder.withName(name).withId(id).withProducts(products).build();
	}
	
	
	public Buyer createBuyer(Integer id,String email,String userName, List<ProductList> purchaseHistory, Profile profile, Purchase purchase){
		BuyerBuilder buyerBuilder = new BuyerBuilder();
		return buyerBuilder.withId(id).withBuyerName(userName).withEmail(email).withPurchaseHistory(purchaseHistory).withProfile(profile).withCurrentPurchase(purchase).build();
	}
	
	public Profile createProfile(Money maxAmount, Address address, Integer id){
		ProfileBuilder profileBuilder = new ProfileBuilder();
		return profileBuilder.withAddress(address).withMaxAmount(maxAmount).withId(id).build();
	}
	
	public Address createAddress(String street, String district, Integer id){
		AddressBuilder addresBuilder = new AddressBuilder();
		return addresBuilder.withId(id).withStreet(street).withDistrict(district).build();
	}
	
	public void setUsersService(UsersService usersService){
		this.usersService = usersService;
	}
	
	public UsersService getUsersService(){
		return usersService;
	}
	
	public Product createProduct(Integer id, String urlimg, String brand, Category cat, Money value, String name){
		ProductBuilder builder = new ProductBuilder();
		return builder.withBrand(brand).withCategory(cat).withStock(2).withImage(urlimg).withName(name).withPrice(value).build();
	}
}
