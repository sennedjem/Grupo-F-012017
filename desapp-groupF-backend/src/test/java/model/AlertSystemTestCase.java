package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;


import utils.Money;

public class AlertSystemTestCase {
	
	MaxAmountAlert alertSystem;
	
	@Before
	public void setUp() throws Exception {
		alertSystem = new MaxAmountAlert();
	}

	@Test(expected = MaxAmountExceededException.class)
	public void alertMaxAmountExceededtest() throws Exception {
		Product capitanDelEspacio;
		capitanDelEspacio = Mockito.mock(Product.class);
		Purchase purchase = Mockito.mock(Purchase.class);
		Profile profile = Mockito.mock(Profile.class);
		Money money = new Money(20,5);
		Money money2 = new Money(10,5);
		Mockito.when(capitanDelEspacio.getPrice()).thenReturn(money);
		Mockito.when(purchase.getTotal()).thenReturn(money);
		Mockito.when(profile.getMaxAmount()).thenReturn(money2);
		alertSystem.addProduct(capitanDelEspacio, 2, purchase, profile);
	}



}
