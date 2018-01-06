package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entity.Player;
import gameRules.Logic;

class BuyPropertyTest {
	
	Logic logic;

	@BeforeEach
	void setUp() throws Exception {
		this.logic = new Logic();
	}

	@Test
	void testBuyProperty() {
		this.logic.buyField(1, 1);
		int expected = 1;
		int actual = this.logic.checkFieldOwned(1);
		assertEquals(actual, expected);
	}

}
