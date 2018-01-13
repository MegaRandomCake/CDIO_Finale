package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import entity.PlayerList;

/**
 * Tests the passTurn() from the entity#PlayerList
 * 
 * @see PlayerList#addBalance(int, int)
 * @see PlayerList#passTurn(boolean)
 * @see PlayerList#getActivePlayer()
 */
public class EndGameTest {

	PlayerList players;

	@Before
	public void setUp() throws Exception {
		this.players = new PlayerList(3);
	}

	@Test
	/**
	 * Tests if the player gets to be the active player when they have -1 in their
	 * balance. Expected: They are NOT allowed to be the active player.
	 */
	public void PlayerNoTurnTest() {
		boolean actual = true;
		this.players.addBalance(1, -30001);
		for (int i = 0; i <= 10; i++, this.players.passTurn(false)) {
			if (this.players.getActivePlayer() == 1)
				actual = false;
		}
		assertEquals(actual, true);
	}

	@Test
	/**
	 * Tests if the player gets to be the active player when they have 0 in their
	 * balance. Expected: They are allowed to be the active player.
	 */
	public void PlayerNoTurnTestBoundry() {
		boolean actual = false;
		this.players.addBalance(1, -30000);
		for (int i = 0; i <= 10; i++, this.players.passTurn(false)) {
			if (this.players.getActivePlayer() == 1)
				actual = true;
		}
		assertEquals(actual, true);
	}

	@Test
	public void PlayerTurnTest() {
		int t = this.players.getActivePlayer();
		this.players.passTurn(false);
		int actual = this.players.getActivePlayer();
		int expected = t + 1;
		assertEquals(actual, expected);
	}
}
