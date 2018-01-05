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
		player = new Player();
	}

	

	@Test
	public void testDiceToField() {
		player.setField(1);
		cup.rollCup();
		int actual = cup.getEyes()+1;
		int expected = player.getField();
		assertEquals(actual, expected);
	}

}
 