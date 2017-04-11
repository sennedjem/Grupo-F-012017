package model;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class BuyerTestCase {

	Buyer buyer;
	TurnsManager turnsManager;
	ProductList listProductMock1;
	ProductList listProductMock2;
	List<ProductList> purchaseHistory;
	
	@Before
	public void setUp() throws Exception {
		buyer = new Buyer();
		turnsManager = Mockito.mock(TurnsManager.class);
		buyer.setTurnsManager(turnsManager);
		listProductMock1 = Mockito.mock(ProductList.class);
		listProductMock2 = Mockito.mock(ProductList.class);
		purchaseHistory = new ArrayList<ProductList>();
		purchaseHistory.add(listProductMock1);
		purchaseHistory.add(listProductMock2);
		buyer.setPurchaseHistory(purchaseHistory);
		
	}

	@Test
	public void requestTurn() {
		buyer.requestTurn();
		verify(turnsManager).requestTurn();
	}
	
	@Test
	public void getPurchaseHistoryTest() {
		List<ProductList> purchaseHistory = buyer.getPurchaseHistory();
		assertEquals(purchaseHistory.size(),2);
		assertTrue(purchaseHistory.contains(listProductMock1));
		assertTrue(purchaseHistory.contains(listProductMock2));
	}
	
	@Test
	public void whenThePurchaseIsMadeTheHistoryListIsUpdated() {
		ProductList currentPurchase;
		currentPurchase = Mockito.mock(ProductList.class);
		buyer.setCurrentPurchase(currentPurchase);
		buyer.makePurchase();
		List<ProductList> purchaseHistory = buyer.getPurchaseHistory();
		assertEquals(purchaseHistory.size(),3);
		assertTrue(purchaseHistory.contains(currentPurchase));
	}

}
