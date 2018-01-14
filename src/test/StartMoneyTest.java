package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import entity.PlayerList;

public class StartMoneyTest {
	PlayerList players;
	int startmoney = 4000;
	@Before
	public void setUp() throws Exception {
		this.players = new PlayerList(3);
	}

	@Test
	public void StartMoneytest() {
		int expected = this.players.getBalance(0);
		this.players.addToField(0, 41);
		int actual = this.players.getBalance(0);
		assertEquals(actual, expected+startmoney);
	}

	@Test
	public void StartMoneyBoundrytest() {
		int expected = this.players.getBalance(0);
		this.players.addToField(0, 40);
		int actual = this.players.getBalance(0);
		assertEquals(actual, expected+startmoney);
	}
}
