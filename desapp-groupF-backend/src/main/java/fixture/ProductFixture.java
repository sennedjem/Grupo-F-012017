package fixture;

import javax.transaction.Transactional;

import builders.ProductBuilder;
import model.Product;
import services.ProductManagementService;
import services.ProductService;
import utils.Category;
import utils.Money;

public class ProductFixture {
	
	private ProductManagementService productManagement;
	
	
	@Transactional
	public void createProducts(){
		Product product = createProduct(1,
										"https://www.vegaffinity.com/imagenes/alimentos/pringlesoriginal.png",
										"Pringles", Category.FOOD, new Money(50,0), "Papas Fritas");
		Product product1 = createProduct(2,
				"http://jumbo.vteximg.com.br/arquivos/ids/161514-100-100/1582126.jpg",
				"ALoLoco", Category.FOOD, new Money(25,0), "Maní x 500 gr.");
		Product product2 = createProduct(3,
				"http://jumbo.vteximg.com.br/arquivos/ids/169721-100-100/705256-KG.jpg",
				"Bocatti", Category.FOOD, new Money(40,0), "Jamón cocido x 100 gr.");
		Product product3 = createProduct(4,
				"http://walmartar.vteximg.com.br/arquivos/ids/780751-100-100/0779095000019-1.jpg",
				"Gancia", Category.DRINKS, new Money(80,0), "Aperitivo x 1L");
		Product product4 = createProduct(5,
				"http://jumbo.vteximg.com.br/arquivos/ids/159435-100-100/263427.jpg",
				"Sprite", Category.FOOD, new Money(22,0), "Gaseosa x 2.25L");
		
		this.productManagement.save(product);
		this.productManagement.save(product1);
		this.productManagement.save(product2);
		this.productManagement.save(product3);
		this.productManagement.save(product4);
	}
	
	public Product createProduct(Integer id, String urlimg, String brand, Category cat, Money value, String name){
		ProductBuilder builder = new ProductBuilder();
		return builder.withBrand(brand).withCategory(cat).withId(id).withStock(2).withImage(urlimg).withName(name).withPrice(value).build();
	}

	public ProductManagementService getProductManagementService() {
		return productManagement;
	}

	public void setProductManagementService(ProductManagementService productService) {
		this.productManagement = productService;
	}
}