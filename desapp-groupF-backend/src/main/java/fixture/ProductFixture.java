package fixture;

import javax.transaction.Transactional;

import builders.ProductBuilder;
import model.Product;
import services.ProductService;
import utils.Category;
import utils.Money;

public class ProductFixture {
	
	private ProductService productService;
	
	
	@Transactional
	public void createProducts(){
		Product product = createProduct(1,
										"https://www.vegaffinity.com/imagenes/alimentos/pringlesoriginal.png",
										"Pringles", Category.FOOD, new Money(50,0), "Papas Fritas");
		
		this.productService.save(product);
	}
	
	public Product createProduct(Integer id, String urlimg, String brand, Category cat, Money value, String name){
		ProductBuilder builder = new ProductBuilder();
		return builder.withBrand(brand).withCategory(cat).withId(id).withStock(2).withImage(urlimg).withName(name).withPrice(value).build();
	}

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
}