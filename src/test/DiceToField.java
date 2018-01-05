package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.Before;
import entity.Cup;

class DiceToField {
	
	Cup cup;

	@Before
	public void setUp() throws Exception {
		cup = new Cup();
	}

	

	@Test
	public void testDiceToField() {
		cup.rollCup();
		int actual = cup.getEyes();
		int expected = actual+1;
		assertEquals(actual, expected);
	}

}
