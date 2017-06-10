 package model;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import utils.Money;
 
public class BuyerTestCase {

	Buyer buyer;
	TurnsManager turnsManager;
	ProductList listProductMock1;
	ProductList listProductMock2;
	List<ProductList> purchaseHistory;
	
	@Before
	public void setUp() throws Exception {
		buyer = new Buyer();
		turnsManager = mock(TurnsManager.class);
		//buyer.setTurnsManager(turnsManager);
		listProductMock1 = mock(ProductList.class);
		listProductMock2 = mock(ProductList.class);
		purchaseHistory = new ArrayList<ProductList>();
		purchaseHistory.add(listProductMock1);
		purchaseHistory.add(listProductMock2);
		buyer.setPurchaseHistory(purchaseHistory);
		
	}

	/*
	@Test
	public void requestTurn() {
		buyer.requestTurn();
		verify(turnsManager).requestTurn();
	}
	*/
	
	@Test
	public void getPurchaseHistoryTest() {
		List<ProductList> purchaseHistory = buyer.getPurchaseHistory();
		assertEquals(purchaseHistory.size(),2);
		assertTrue(purchaseHistory.contains(listProductMock1));
		assertTrue(purchaseHistory.contains(listProductMock2));
	}
	
	@Test
	public void whenThePurchaseIsMadeTheHistoryListIsUpdated() {
		ProductList productList;
		productList = mock(ProductList.class);
		Purchase currentPurchase = new Purchase();
		currentPurchase.setProducts(productList);
		buyer.setCurrentPurchase(currentPurchase);
		buyer.makePurchase();
		List<ProductList> purchaseHistory = buyer.getPurchaseHistory();
		assertEquals(purchaseHistory.size(),3);
		assertTrue(purchaseHistory.contains(productList));
	}
	
	/*
	@Test 
	public void addAProductTest() throws Exception{
		Product capitanDelEspacio ;
		capitanDelEspacio = mock(Product.class);
		AlertSystem alertSystem;
		alertSystem = mock(AlertSystem.class);
		Profile profile = buyer.getProfile();
		buyer.setAlertSystem(alertSystem);
		buyer.addProduct(capitanDelEspacio,1);
		verify(alertSystem).addProduct(capitanDelEspacio, 1, null, profile);
	}
	*/
	
	@Test 
	public void setProfileAndSetMaxAmountTest(){
		Profile profile;
		profile = mock(Profile.class);
		Money money = new Money(20,20);
		buyer.setProfile(profile);
		buyer.setMaxAmount(money);
		assertEquals(profile,buyer.getProfile());
		verify(profile).setMaxAmount(money);
	}
	

}
