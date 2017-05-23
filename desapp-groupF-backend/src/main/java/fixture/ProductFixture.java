package fixture;

import java.util.ArrayList;
import java.util.List;

import builders.ProductBuilder;
import model.Product;
import utils.Category;
import utils.Money;

public class ProductFixture {
	
	public static List<Product> createProducts(){
		List<Product> products = new ArrayList<Product>();
		products.add(ProductFixture.createProduct(1,
										"https://www.vegaffinity.com/imagenes/alimentos/pringlesoriginal.png",
										"Pringles", Category.FOOD, new Money(50,0), "Papas Fritas"));
		return products;
	}
	
	public static Product createProduct(Integer id, String urlimg, String brand, Category cat, Money value, String name){
		ProductBuilder builder = new ProductBuilder();
		return builder.withBrand(brand).withCategory(cat).withId(id).withImage(urlimg).withName(name).build();
	}
}