package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class CashRegisterTestCase {

	private CashRegister cashRegister;
	
	@Before
	public void setUp(){
		this.cashRegister = new CashRegister();
	}
	
	@Test
	public void testInitialization() {
		List<Purchase> quantityOfPurchases = this.cashRegister.getPurchases();
		boolean cashOpen = this.cashRegister.isOpen();
		boolean cashBusy = this.cashRegister.isBusy();
		
		assertFalse(cashBusy);
		assertTrue(cashOpen);
		assertEquals(quantityOfPurchases.size(), 0, 0);
	}
	
	@Test 
	public void testSetOpen(){
		this.cashRegister.setOpen(false);
		assertFalse(this.cashRegister.isOpen());
	}

	
	@Test
	public void testSetNextPurchase(){
		this.cashRegister.setNextPurchase();
		assertFalse(this.cashRegister.isBusy());
	}
	
	@Test
	public void testAddPurchase(){
		Purchase p1 = mock(Purchase.class);
		Purchase p2 = mock(Purchase.class);
		this.cashRegister.addPurchase(p1);
		this.cashRegister.addPurchase(p2);
		
		assertEquals(this.cashRegister.getPurchases().size(), 2, 0);
	}
	
	@Test
	public void testProcessPurchase(){
		Purchase p1 = mock(Purchase.class);
		when(p1.getDurationOfPurchase()).thenReturn(3L);
		this.cashRegister.addPurchase(p1);
		
		this.cashRegister.processPurchase(p1);
		assertTrue(this.cashRegister.isBusy());
	}
	
	@Test
	public void testAdvanceLine(){
		Purchase p1 = mock(Purchase.class);
		Purchase p2 = mock(Purchase.class);
		when(p1.getDurationOfPurchase()).thenReturn(3L);
		when(p1.getDurationOfPurchase()).thenReturn(17L);
		this.cashRegister.addPurchase(p1);
		this.cashRegister.addPurchase(p2);
		
		assertEquals(this.cashRegister.getPurchases().size(), 2, 0);
		
		this.cashRegister.advanceLine();
		
		assertEquals(this.cashRegister.getPurchases().size(), 1, 0);
		assertFalse(this.cashRegister.isBusy());
	}
	
	@Test
	public void testGetWaitingTime(){
		Purchase p1 = mock(Purchase.class);
		Purchase p2 = mock(Purchase.class);
		when(p1.getDurationOfPurchase()).thenReturn(3L);
		when(p2.getDurationOfPurchase()).thenReturn(17L);
		this.cashRegister.addPurchase(p1);
		this.cashRegister.addPurchase(p2);
		
		assertEquals(this.cashRegister.getWaitingTime(), 20, 0);
	} 
	
	@Test
	public void testCompareToTheSame(){
		assertEquals(this.cashRegister.compareTo(this.cashRegister), 0, 0);		
	}
	 
	
	@Test
	public void testCompareToLarger(){
		Purchase p1 = mock(Purchase.class);
		Purchase p2 = mock(Purchase.class);
		when(p1.getDurationOfPurchase()).thenReturn(0L);
		when(p1.getDurationOfPurchase()).thenReturn(20L);
		CashRegister cashRegister2 = new CashRegister();
		cashRegister2.addPurchase(p1);
		cashRegister2.addPurchase(p2);
		
		assertEquals(cashRegister2.compareTo(this.cashRegister), 1, 0);
		assertEquals(this.cashRegister.compareTo(cashRegister2), -1, 0);
	}	
	
}
