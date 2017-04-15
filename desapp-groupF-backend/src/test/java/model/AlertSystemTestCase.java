package model;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import exceptions.MaxAmountExceededException;
import utils.Money;

public class AlertSystemTestCase {
	
	private MaxAmountAlert alertSystemMaxAmount;
	private NoAlert noAlert;
	private Product capitanDelEspacio;
	private Purchase purchase;
	private Profile profile;
	private Money money = new Money(20,5);
	private Money money2 = new Money(10,5);
	
	@Before
	public void setUp() throws Exception {
		alertSystemMaxAmount = new MaxAmountAlert();
		noAlert = new NoAlert();
		purchase = Mockito.mock(Purchase.class);
		capitanDelEspacio = Mockito.mock(Product.class);
		profile = Mockito.mock(Profile.class);
		Mockito.when(capitanDelEspacio.getPrice()).thenReturn(money);
		Mockito.when(purchase.getTotal()).thenReturn(money);
	}

	@Test(expected = MaxAmountExceededException.class)
	public void alertMaxAmountExceededtest() throws Exception {
		Mockito.when(profile.getMaxAmount()).thenReturn(money2);
		alertSystemMaxAmount.addProduct(capitanDelEspacio, 2, purchase, profile);
	}


	@Test
	public void alertMaxAmountNotExceededtest() throws Exception {
		Mockito.when(profile.getMaxAmount()).thenReturn(money);
		alertSystemMaxAmount.addProduct(capitanDelEspacio, 2, purchase, profile);
	}
	
	@Test
	public void addProductTest() throws Exception{
		noAlert.addProduct(capitanDelEspacio, 2, purchase, profile);
		Mockito.verify(purchase).addProduct(capitanDelEspacio,2);
	}


}
