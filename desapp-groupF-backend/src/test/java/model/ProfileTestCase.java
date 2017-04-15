package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import utils.Money;

public class ProfileTestCase {

	Profile profile;
	
	@Before
	public void setUp() throws Exception {
		profile = new Profile();
	}

	@Test
	public void getAndMaxAmountTest() {
		Money money = new Money(20,20);
		profile.setMaxAmount(money);
		assertEquals(money,profile.getMaxAmount());
	}

}
