package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import exceptions.ProductDoesNotExistWithThisIdException;
import utils.Category;
import utils.Money;

public class AdminTestCase {

	private Management management;
	private Admin admin;
	
	private Product product1;
	private Product product2;
	
	@Before
	public void setUp(){
		
		product1 = new Product(1, "Remera", "Levi's", new Money(100,0), 45,"urlOfImage", Category.CLOTHING);
		product2 = new Product(2, "Remera", "Levi's", new Money(125,0), 45,"urlOfImage", Category.CLOTHING);

		management = new Management();
		management.addProduct(product1);

		admin = new Admin(management);
	}

	@Test
	public void testAddProduct() {
		admin.addProduct(product2);
		assertEquals(product2, management.getProducts().get(1));
	}
	
	@Test
	public void testRemoveProductExisting() {
		admin.removeProduct(1);
		assertEquals(0, management.getProducts().size());
	}
	
	@Test
	public void testRemoveProductNotExisting() {
		admin.removeProduct(2);
		assertEquals(1, management.getProducts().size());
	}
	
	@Test
	public void testModifyProductName() throws ProductDoesNotExistWithThisIdException{
		admin.modifyProductName(1, "New Name");
		assertEquals("New Name", this.product1.getName());
	}
	
	@Test
	public void testModifyProductBrand() throws ProductDoesNotExistWithThisIdException{
		admin.modifyProductBrand(1, "New Brand");
		assertEquals("New Brand", this.product1.getBrand());
	}	
	
	@Test
	public void testModifyProductPrice() throws ProductDoesNotExistWithThisIdException{
		Money newPrice = new Money (115,0);
		admin.modifyProductPrice(1, newPrice);
		assertEquals(newPrice, this.product1.getPrice());
	}	
	
	@Test
	public void testModifyProductStock() throws ProductDoesNotExistWithThisIdException{
		Integer newStock = 44;
		admin.modifyProductStock(1, newStock);
		assertEquals(newStock, this.product1.getStock());
	}	
	
	@Test
	public void testModifyProductImage() throws ProductDoesNotExistWithThisIdException{
		admin.modifyProductImage(1, "NewURL");
		assertEquals("NewURL", this.product1.getImage());
	}	
	
	@Test
	public void testModifyProductCategory() throws ProductDoesNotExistWithThisIdException{
		admin.modifyProductCategory(1, Category.SPORTS);
		assertEquals(Category.SPORTS, this.product1.getCategory());
	}	
	
	@Test(expected = ProductDoesNotExistWithThisIdException.class)
	public void testModifyProductCategoryException() throws ProductDoesNotExistWithThisIdException{
		admin.modifyProductCategory(2, Category.SPORTS);
	}
}
