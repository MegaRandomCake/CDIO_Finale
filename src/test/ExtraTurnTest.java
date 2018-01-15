package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import entity.PlayerList;

public class ExtraTurnTest {
	
	PlayerList player;

	@Before
	public void setUp() throws Exception {
		this.player = new PlayerList(2);
	}

	@Test
	public void test() {
		int a = player.getActivePlayer();
		System.out.println("Active player is " + player.getActivePlayer());
		player.passTurn(true);
		System.out.println("Active player is " + player.getActivePlayer());
		assertEquals(a, player.getActivePlayer());
		
		int b = player.getActivePlayer();
		System.out.println("Active player is " + player.getActivePlayer());
		player.passTurn(false);
		System.out.println("Active player is " + player.getActivePlayer());
		assertNotEquals(b, player.getActivePlayer());
		
	}
}
