package test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;
import entity.Player;

public class BalanceTest {
	
	Player player;

	@Before
	public void setUp() throws Exception {
		this.player = new Player();
	}

	@Test
	public void defaultBalanceCheck() {
		int expected = this.player.getBalance();
		int actual = 30000;
		assertEquals(actual, expected);
	}
	
	@Test
	public void addBalanceCheck() {
		int defaultBalance = this.player.getBalance();
		this.player.addBalance(1000);
		int expected = this.player.getBalance();
		int actual = defaultBalance+1000;
		assertEquals(actual, expected);
	}

}
