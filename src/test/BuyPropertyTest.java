package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import gameRules.FieldsController;

/**
 * Tests the methods buyField(int, int) and checkFieldOwned(int) from
 * gameRules#FieldsController.
 * 
 * @see FieldsController#buyField(int, int)
 * @see FieldsController#checkFieldOwned(int)
 */
public class BuyPropertyTest {

	FieldsController logic;

	@Before
	public void setUp() throws Exception {
		this.logic = new FieldsController();
	}

	@Test
	/**
	 * Tests by checking if the expected value of the field have changed ownership
	 * to player 1 with a field where player 1 owns that field.
	 */
	public void testBuyProperty() {
		this.logic.buyField(1, 1);
		boolean expected = true;
		boolean actual = this.logic.getFieldOwned(1);
		assertEquals(actual, expected);
	}

}
