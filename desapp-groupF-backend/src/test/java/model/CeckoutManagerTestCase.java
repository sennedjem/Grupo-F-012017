package model;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CeckoutManagerTestCase {

	private CheckoutManager checkoutManager;
	
	@Before
	public void setUp(){
		this.checkoutManager = CheckoutManager.getInstance();
	}
	
	@After
	public void tearDown(){
		this.checkoutManager.setCheckoutManagerInstance(null);
	}
	
	@Test
	public void testInitialization() {
		assertEquals(checkoutManager.getCashes().size(), 20, 0);
	}

	@Test
	public void testGetNextWithTwoEmptyRegisters(){
		CashRegister c1 = mock(CashRegister.class);
		CashRegister c2 = mock(CashRegister.class);		
		when(c1.getWaitingTime()).thenReturn(0L);
		when(c2.getWaitingTime()).thenReturn(0L);
		List<CashRegister> registers = new ArrayList<CashRegister>();
		registers.add(c1);
		registers.add(c2);
		
		this.checkoutManager.setCashes(registers);
		CashRegister next = this.checkoutManager.getNextCash();
		
		assertEquals(next, c1);
	}
	
	
	@Test
	public void testGetNextWithZeroEmptyRegister(){
		CashRegister c1 = mock(CashRegister.class);
		CashRegister c2 = mock(CashRegister.class);		
		when(c1.getWaitingTime()).thenReturn(20L);
		when(c2.getWaitingTime()).thenReturn(29L);
		List<CashRegister> registers = new ArrayList<CashRegister>();
		registers.add(c1);
		registers.add(c2);
		
		this.checkoutManager.setCashes(registers);
		CashRegister next = this.checkoutManager.getNextCash();
		
		assertEquals(next, c1);
	}
}
