package model;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import utils.Category;
import utils.Money;

public class MarketingManagerTestCase {

	private Management management;
	private MarketingManager marketingManager;
	
	private Product product1;
	private Product product2;
	
	@Before
	public void setUp(){
		management = new Management();
		marketingManager = new MarketingManager(management);
		product1 = new Product("A1", "Remera", "Levi's", new Money(100,0), 45,"urlOfImage", Category.CLOTHING);
		product2 = new Product("A2", "Remera", "Levi's", new Money(125,0), 45,"urlOfImage", Category.CLOTHING);
	}

	@Test
	public void testAddOffersByCategory() {
		assertEquals(0, management.getOffers().size());
		marketingManager.createOfferByCategory(LocalDate.of(2017, 04, 06), LocalDate.of(2017, 04, 16),
                10, Category.CLOTHING);
		assertEquals(1, management.getOffers().size());
	}
	
	@Test
	public void testAddOffersByCombination() {
		assertEquals(0, management.getOffers().size());
		marketingManager.createOfferByCombination(LocalDate.of(2017, 04, 06), LocalDate.of(2017, 04, 16),
				10, product1, product2);
		assertEquals(1, management.getOffers().size());
	}
	
	@Test
	public void testAddOffersByProduct() {
		assertEquals(0, management.getOffers().size());
		marketingManager.createOfferByProduct(LocalDate.of(2017, 04, 06), LocalDate.of(2017, 04, 16),
				10, product1);
		assertEquals(1, management.getOffers().size());
	}
	

}
