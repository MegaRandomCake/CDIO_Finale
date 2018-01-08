package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import gameRules.Logic;

public class BuyPropertyTest {
	
	Logic logic;

	@Before
	public void setUp() throws Exception {
		this.logic = new Logic();
	}

	@Test
	public void testBuyProperty() {
		this.logic.buyField(1, 1);
		int expected = 1;
		int actual = this.logic.checkFieldOwned(1);
		assertEquals(actual, expected);
	}

}
