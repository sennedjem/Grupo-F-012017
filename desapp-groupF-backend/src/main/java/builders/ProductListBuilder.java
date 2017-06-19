package builders;

import java.util.List;

import model.ListItem;
import model.ProductList;

public class ProductListBuilder {
	
	private ProductList publicList;
	
	public ProductListBuilder(){
		publicList = new ProductList();
	}
	
	public ProductList getProductList(){
		return publicList;
	}
	
	public void setProductList(ProductList address){
		this.publicList = address;
	}
	
	public ProductList build(){
		ProductList result = this.getProductList();
		this.publicList = new ProductList();
		return result;
	}
	
	public ProductListBuilder withName(String name){
		this.publicList.setName(name);
		return this;
	}
	
	public ProductListBuilder withProducts(List<ListItem> products){
		this.publicList.setProducts(products);
		return this;
	}
	
	public ProductListBuilder withId(Integer id){
		this.publicList.setId(id);
		return this;
	}
	
}