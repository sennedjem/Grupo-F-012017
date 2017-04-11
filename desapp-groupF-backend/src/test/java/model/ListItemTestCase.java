package model;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import builders.ProductBuilder;
import utils.Money;

public class ListItemTestCase {
	
	Product aProduct;
	ListItem anItem;
	
	@Before
	public void setUp() throws Exception {
		ProductBuilder builder = new ProductBuilder();
		aProduct = builder.withPrice(new Money(10,00)).build();
		anItem = new ListItem(aProduct, 2);	
	}

	@Test
	public void testConstructor() {
		assertFalse(anItem.getPurchased());
		assertEquals(anItem.getProduct(), aProduct);
		assertEquals(anItem.getQuantity(), 2, 0);
		assertEquals(anItem.getTotalValue().getDecimalPart(), 0, 0);
		assertEquals(anItem.getTotalValue().getEntirePart(), 20, 0);
	}
	
	@Test
	public void testSetPurchased(){
		anItem.setPurchased(true);
		assertTrue(anItem.getPurchased());
	}

}
