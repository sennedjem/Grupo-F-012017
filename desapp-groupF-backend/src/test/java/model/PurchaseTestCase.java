package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import utils.Money;

public class PurchaseTestCase {
	
	Purchase purchase;
	ProductList productList;
	
	@Before
	public void setUp() throws Exception {
		purchase = new Purchase();
		productList = Mockito.mock(ProductList.class);
		purchase.setProducts(productList);
	}

	@Test
	public void testAddProduct() {
		Product capitanDelEspacio;
		capitanDelEspacio = Mockito.mock(Product.class);
		purchase.addProduct(capitanDelEspacio, 2);
		Mockito.verify(productList).addProduct(capitanDelEspacio,2);
	}
	
	@Test 
	public void testGetTotal(){
		Money money = new Money(20,20);
		Mockito.when(productList.totalAmount()).thenReturn(money);
		assertEquals(money,purchase.getTotal());
	}

}
