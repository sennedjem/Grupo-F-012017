package builders;

import model.ListItem;
import model.Product;

public class ListItemBuilder {
	
	private ListItem listItem;
	
	public ListItemBuilder(){
		listItem = new ListItem();
	}
	
	public ListItem getListItem(){
		return listItem;
	}
	
	public void setListItem(ListItem listItem){
		this.listItem = listItem;
	}
	
	public ListItem build(){
		ListItem result = this.getListItem();
		this.listItem = new ListItem();
		return result;
	}
	
	public ListItemBuilder withQuantity(Integer quantity){
		this.listItem.setQuantity(quantity);
		return this;
	}
	
	public ListItemBuilder withProduct(Product product){
		this.listItem.setProduct(product);
		return this;
	}
	
	public ListItemBuilder withPurchased(boolean purchased){
		this.listItem.setPurchased(purchased);
		return this;
	}
	
	public ListItemBuilder withId(Integer id){
		this.listItem.setId(id);
		return this;
	}
	
}