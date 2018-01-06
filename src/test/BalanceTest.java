package test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import entity.Player;
import entity.Account;

class BalanceTest {
	
	Player player;

	@BeforeEach
	void setUp() throws Exception {
		this.player = new Player();
	}

	@Test
	void defaultBalanceCheck() {
		int expected = this.player.getBalance();
		int actual = 30000;
		assertEquals(actual, expected);
	}
	
	@Test
	void addBalanceCheck() {
		int defaultBalance = this.player.getBalance();
		this.player.addBalance(1000);
		int expected = this.player.getBalance();
		int actual = defaultBalance+1000;
		assertEquals(actual, expected);
	}

}
