package model;

import org.junit.Before;
import org.junit.Test;

import builders.ProductBuilder;
import junit.framework.TestCase;
import utils.Category;
import utils.Money;


public class ProductTestCase extends TestCase{

	private ProductBuilder builder;
	private Money aMoney;
	
	@Before
	public void setUp(){
		builder = new ProductBuilder();
		aMoney = new Money(12, 50);
	}
	
	@Test
	public void testProductConstructor(){
		Product aProduct = new Product(1, "Remera", "Levi's", aMoney, 45,"urlOfImage", Category.Clothing);
		Integer id = aProduct.getId();
		String name = aProduct.getName();
		String brand = aProduct.getBrand();
		Money price = aProduct.getPrice();
		Integer stock = aProduct.getStock();
		String image = aProduct.getImage();
		Category category = aProduct.getCategory();
		
		assertEquals(id, 1, 0);
		assertEquals(name, "Remera");
		assertEquals(brand, "Levi's");
		assertEquals(price, aMoney);
		assertEquals(stock, 45, 0);
		assertEquals(image, "urlOfImage");
		assertEquals(category, Category.Clothing);
	}
	
	@Test
	public void testAProductEqualsTheSameProduct(){
		Product aProduct = builder.withBrand("Marolio").withCategory(Category.Food).withName("Aceite").withImage("someUrl").withStock(10).withPrice(aMoney).build();
		assertTrue(aProduct.equals(aProduct));
	}
	
	@Test
	public void testAProductIsNotEqualToOtherProduct(){
		Money otherMoney = new Money(10,00);
		Product aProduct = builder.withBrand("Marolio").withCategory(Category.Food).withName("Aceite").withImage("someUrl").withStock(10).withPrice(aMoney).build();
		Product otherProduct = builder.withBrand("Natura").withCategory(Category.Food).withName("Mayonesa").withImage("someUrl").withStock(10).withPrice(otherMoney).build();
		assertFalse(aProduct.equals(otherProduct));
	}	
	
	@Test
	public void testAProductIsNotEqualToNull(){
		Product aProduct = builder.withBrand("Marolio").withCategory(Category.Food).withName("Aceite").withImage("someUrl").withStock(10).withPrice(aMoney).build();
		assertFalse(aProduct.equals(null));
	}

	@Test
	public void testAProductIsNotEqualToANumber(){
		Product aProduct = builder.withBrand("Marolio").withCategory(Category.Food).withName("Aceite").withImage("someUrl").withStock(10).withPrice(aMoney).build();
		assertFalse(aProduct.equals(1));
	}
	
	@Test
	public void testGetSetID(){
		Product aProduct = builder.withId(1).build();
		Integer previousID = aProduct.getId();
		aProduct.setId(2);
		Integer newID = aProduct.getId();
		
		assertFalse(previousID.equals(newID));
		assertEquals(previousID, 1, 0);
		assertEquals(newID, 2, 0);
	}
	
	@Test
	public void testGetSetImageUrl(){
		Product aProduct = builder.withImage("someUrl").build();
		String previousImage = aProduct.getImage();
		aProduct.setImage("otherUrl");
		String newImage = aProduct.getImage();
		
		assertFalse(previousImage.equals(newImage));
		assertEquals(previousImage, "someUrl");
		assertEquals(newImage, "otherUrl");
	}
	
	@Test
	public void testGetSetStock(){
		Product aProduct = builder.withStock(20).build();
		Integer previousStock = aProduct.getStock();
		aProduct.setStock(40);
		Integer newStock = aProduct.getStock();
		
		assertFalse(previousStock.equals(newStock));
		assertEquals(previousStock, 20, 0);
		assertEquals(newStock, 40, 0);
	}
	
	@Test
	public void testGetSetCategory(){
		Product aProduct = builder.withCategory(Category.Cleaning).build();
		Category previousCategory = aProduct.getCategory();
		aProduct.setCategory(Category.Clothing);
		Category newCategory = aProduct.getCategory();
		
		assertFalse(previousCategory.equals(newCategory));
		assertEquals(previousCategory, Category.Cleaning);
		assertEquals(newCategory, Category.Clothing);
	}
	
}