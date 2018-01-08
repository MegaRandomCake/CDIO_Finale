package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import gameRules.FieldsController;

public class BuyPropertyTest {
	
	FieldsController logic;

	@Before
	public void setUp() throws Exception {
		this.logic = new FieldsController();
	}

	@Test
	public void testBuyProperty() {
		this.logic.buyField(1, 1);
		int expected = 1;
		int actual = this.logic.checkFieldOwned(1);
		assertEquals(actual, expected);
	}

}
