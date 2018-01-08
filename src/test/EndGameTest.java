package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import entity.PlayerList;

public class EndGameTest {
	
	PlayerList players;

	@Before
	public void setUp() throws Exception {
		this.players = new PlayerList(3);
	}

	@Test
	public void PlayerNoTurnTest() {
		boolean actual = true;
		this.players.addBalance(1, -30001);
		for(int i = 0; i <= 10; i++, this.players.passTurn(0)) {
			if (this.players.getActivePlayer() == 1)
				actual = false;
		}
		assertEquals(actual, true);
	}
	
	@Test
	public void PlayerNoTurnTestBoundry() {
		boolean actual = false;
		this.players.addBalance(1, -30000);
		for(int i = 0; i <= 10; i++, this.players.passTurn(0)) {
			if (this.players.getActivePlayer() == 1)
				actual = true;
		}
		assertEquals(actual, true);
	}
	

	@Test
	public void PlayerTurnTest() {
		int t = this.players.getActivePlayer();
		this.players.passTurn(0);
		int actual = this.players.getActivePlayer();
		int expected = t+1;
		assertEquals(actual, expected);
	}
}
