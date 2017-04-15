package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import builders.ProductBuilder;
import exceptions.ProductDoesNotExistsInListException;
import utils.Money;

public class ProductListTestCase {

	private Product product1;
	private Product product2;
	private ProductList shoppingCart;
	
	@Before
	public void setUp(){
		ProductBuilder builder = new ProductBuilder();
		product1 = builder.withBrand("Marolio").withName("Aceite").withPrice(new Money(40,00)).build();
		product2 = builder.withBrand("Natura").withName("Mayonesa").withPrice(new Money(15,00)).build();
		shoppingCart = new ProductList("Lista de la semana");
	}
	
	@Test
	public void testSetName(){
		shoppingCart.setName("Compras del mes");
		assertEquals(shoppingCart.getName(), "Compras del mes");
	}
	
	@Test
	public void testConstructor() {
		String nameOfCart = shoppingCart.getName();
		assertEquals(nameOfCart, "Lista de la semana");
		assertEquals(shoppingCart.getProducts().size(), 0, 0);
	}
	
	@Test
	public void testAddProductWithEmptyCart(){
		Integer productsWithoutAdding = shoppingCart.getQuantityOfProducts();
		shoppingCart.addProduct(product1, 3);
		Integer productsAfterAdding = shoppingCart.getQuantityOfProducts();
		
		assertEquals(productsWithoutAdding, 0, 0);
		assertEquals(productsAfterAdding, 3, 0);
	}
	
	@Test
	public void testAddSameProductTwice(){
		Integer productsWithoutAdding = shoppingCart.getQuantityOfProducts();
		shoppingCart.addProduct(product1, 3);
		Integer productsAfterAddingFirstTime = shoppingCart.getQuantityOfProducts();
		shoppingCart.addProduct(product1, 1);
		Integer productsAfterAdding = shoppingCart.getQuantityOfProducts();
		Integer productTypes = shoppingCart.getQuantityOfProductTypes();
		
		assertEquals(productsWithoutAdding, 0, 0);
		assertEquals(productsAfterAddingFirstTime, 3, 0);
		assertEquals(productsAfterAdding, 4, 0);
		assertEquals(productTypes, 1, 0);
	}
	
	@Test(expected=ProductDoesNotExistsInListException.class)
	public void testRemoveProuctWithEmptyCart() throws ProductDoesNotExistsInListException{
		shoppingCart.removeProduct(product2);
	}
	
	@Test
	public void testRemoveProductWithTwoProducts() throws ProductDoesNotExistsInListException{
		shoppingCart.addProduct(product1, 1);
		shoppingCart.addProduct(product2, 2);
		Integer itemsAfterRemoving = shoppingCart.getQuantityOfProductTypes();
		
		shoppingCart.removeProduct(product2);
		
		Integer itemsBeforeRemoving = shoppingCart.getQuantityOfProductTypes();
		
		assertEquals(itemsAfterRemoving,2, 0);
		assertEquals(itemsBeforeRemoving, 1, 0);
	}
	
	@Test
	public void testGetAmountsWithoutCheckedProducts(){
		shoppingCart.addProduct(product1, 2);
		shoppingCart.addProduct(product2, 2);
		Money totalAmount = shoppingCart.totalAmount();
		Money spentAmount = shoppingCart.spentAmount();
		
		Money zero = new Money(0,0);
		Money total = new Money(110,00);
		
		assertEquals(totalAmount, total);
		assertEquals(spentAmount, zero);
	}
	
	@Test
	public void testGetAmountsWithOneCheckedProduct(){
		shoppingCart.addProduct(product1, 2);
		shoppingCart.addProduct(product2, 2);
		shoppingCart.checkProduct(product1);
		Money totalAmount = shoppingCart.totalAmount();
		Money spentAmount = shoppingCart.spentAmount();
		
		Money zero = new Money(80,0);
		Money total = new Money(110,00);
		
		assertEquals(totalAmount, total);
		assertEquals(spentAmount, zero);
	}
}
