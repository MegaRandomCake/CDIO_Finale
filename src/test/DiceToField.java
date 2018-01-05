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
		player.addToField(cup.getEyes());
		int actual = cup.getEyes();
		int expected = player.getField();
		assertEquals(actual+1, expected);
	}

}
 