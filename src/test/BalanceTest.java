package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import entity.Player;

/**
 * Tests the getBalance and addBalance from the entity.player Class.
 * 
 * @see Player#getBalance()
 * @see Player#addBalance(int)
 */

public class BalanceTest {

	Player player;

	@Before
	public void setUp() throws Exception {
		this.player = new Player();
	}

	@Test

	/**
	 * Tests the getBalance() method by comparing the starting balance which is set
	 * to be 30000 with the number 30000.
	 */
	public void defaultBalanceCheck() {
		int expected = this.player.getBalance();
		int actual = 30000;
		assertEquals(actual, expected);
	}

	@Test
	/**
	 * Tests the addBalance() method by comparing the starting balance + 1000 with
	 * starting balance + addBalance(1000).
	 */
	public void addBalanceCheck() {
		int defaultBalance = this.player.getBalance();
		this.player.addBalance(1000);
		int expected = this.player.getBalance();
		int actual = defaultBalance + 1000;
		assertEquals(actual, expected);
	}

}
