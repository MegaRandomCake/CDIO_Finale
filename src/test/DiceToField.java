package test;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import entity.Cup;
import entity.Player;

/**
 * Tests the setField(), rollCup(), addToField(int) and getField() that works
 * together when a player rolls a die and have to move to a field.
 * 
 * @see Player#setField()
 * @see Player#addToField(int)
 * @see Player#getField()
 * @see Cup#rollCup()
 */
public class DiceToField {

	Cup cup;
	Player player;

	@Before
	public void setUp() throws Exception {
		this.cup = new Cup();
		this.player = new Player();
	}

	@Test
	/**
	 * Checks the methods by comparing the expected field of the player with their
	 * old field + the roll of the dice.
	 */
	public void testDiceToField() {
		this.player.setField(1);
		this.cup.rollCup();
		this.player.addToField(this.cup.getSum());
		int actual = this.cup.getSum();
		int expected = this.player.getField();
		assertEquals(actual + 1, expected);
	}

}
