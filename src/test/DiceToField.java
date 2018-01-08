package test;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import entity.Cup;
import entity.Player;

public class DiceToField {
	
	Cup cup;
	Player player;

	@Before
	public void setUp() throws Exception {
		this.cup = new Cup();
		this.player = new Player();
	}

	

	@Test
	public void testDiceToField() {
		this.player.setField(1);
		this.cup.rollCup();
		this.player.addToField(this.cup.getEyes());
		int actual = this.cup.getEyes();
		int expected = this.player.getField();
		assertEquals(actual+1, expected);
	}

}
 