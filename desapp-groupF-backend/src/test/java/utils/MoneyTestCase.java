package utils;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MoneyTestCase {

	Money aMoney;
	
	@Before
	public void setUp(){		
		aMoney = new Money(12, 50);
	}
	
	@Test
	public void testGeters() {
		assertEquals(aMoney.getEntirePart(), 12, 0);
		assertEquals(aMoney.getDecimalPart(), 50, 0);
	}
	
	@Test
	public void testSeters(){
		Integer previousEntirePart = aMoney.getEntirePart();
		Integer previousDecimalPart = aMoney.getDecimalPart();
		
		aMoney.setEntirePart(10);
		aMoney.setDecimalPart(20);
		
		assertFalse(previousEntirePart == aMoney.getEntirePart());
		assertFalse(previousDecimalPart == aMoney.getDecimalPart());
		
		assertEquals(aMoney.getDecimalPart(), 20, 0);
		assertEquals(aMoney.getEntirePart(), 10, 0);
	}

	@Test
	public void testToString(){
		String expected = "$12,50";
		assertEquals(aMoney.toString(), expected);
	}
	
	@Test
	public void testTimes2(){
		Money times2 = aMoney.times(2);
		
		assertEquals(times2.getEntirePart(), 25,0);
		assertEquals(times2.getDecimalPart(), 0, 0);
	}
	
	@Test
	public void testAMoneyEqualsTheSame(){
		assertEquals(aMoney, aMoney);
	}
	
	@Test
	public void testAMoneyIsNotEqualToOther(){
		Money newMoney = new Money(10,50);
		assertFalse(aMoney.equals(newMoney));
	}
	
	@Test
	public void testAdd50Cents(){
		Integer newCents = aMoney.addCents(50);
		assertEquals(newCents, 0, 0);
	}
	
	@Test
	public void testAdd25Cents(){
		Integer newCents = aMoney.addCents(25);
		assertEquals(newCents, 75, 0);
	}
	
	@Test
	public void testTimes0(){
		Money times0 = aMoney.times(0);
		
		assertEquals(times0.getEntirePart(), 0,0);
		assertEquals(times0.getDecimalPart(), 0, 0);
	}
	
	@Test
	public void testAdd(){
		Money newMoney = new Money(10,50);
		aMoney.add(newMoney);

		assertEquals(aMoney.getDecimalPart(), 0 , 0);
		assertEquals(aMoney.getEntirePart(), 23, 0);
	}
	
	@Test
	public void testToMoney(){
		String stringMoney1 = "10.10";
		String stringMoney2 = "0.1";
		assertEquals(new Money(10,10), Money.toMoney(stringMoney1));
		assertEquals(new Money(0,1), Money.toMoney(stringMoney2));

	}
}
