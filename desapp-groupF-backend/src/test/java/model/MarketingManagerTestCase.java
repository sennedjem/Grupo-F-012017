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
		product1 = new Product(1, "Remera", "Levi's", new Money(100,0), 45,"urlOfImage", Category.Clothing);
		product2 = new Product(2, "Remera", "Levi's", new Money(125,0), 45,"urlOfImage", Category.Clothing);
	}

	@Test
	public void testAddOffersByCategory() {
		assertEquals(0, management.getOffers().size());
		marketingManager.createOfferByCategory(1, LocalDate.of(2017, 04, 06), LocalDate.of(2017, 04, 16),
                10, Category.Clothing);
		assertEquals(1, management.getOffers().size());
	}
	
	@Test
	public void testAddOffersByCombination() {
		assertEquals(0, management.getOffers().size());
		marketingManager.createOfferByCombination(2, LocalDate.of(2017, 04, 06), LocalDate.of(2017, 04, 16),
				10, product1, product2);
		assertEquals(1, management.getOffers().size());
	}
	
	@Test
	public void testAddOffersByProduct() {
		assertEquals(0, management.getOffers().size());
		marketingManager.createOfferByProduct(3, LocalDate.of(2017, 04, 06), LocalDate.of(2017, 04, 16),
				10, product1);
		assertEquals(1, management.getOffers().size());
	}
	

}
