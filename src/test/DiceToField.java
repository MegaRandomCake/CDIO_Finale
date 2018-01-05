package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.Before;
import entity.Cup;
import entity.Player;

class DiceToField {
	
	Cup cup;
	Player player;

	@Before
	public void setUp() throws Exception {
		cup = new Cup();
	}

	

	@Test
	public void testDiceToField() {
		cup.rollCup();
		int actual = cup.getEyes();
		int expected = player.getField()+1;
		assertEquals(actual, expected);
	}

}
