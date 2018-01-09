package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import entity.PlayerList;
import gameRules.Logic;

public class PayRentTest {
	
	PlayerList players;
	Logic logic;
	int field3price = 1200;
	int field3rent = 50;

	@Before
	public void setUp() throws Exception {
		players = new PlayerList(3);
		logic = new Logic();
	}

	@Test
	public void test() {
		int payerActual = players.getBalance(1);
		int receiverActual = players.getBalance(0);
		logic.buyField(3, 0);
		players.addToField(1, 3);
		int payerExpected = players.getBalance(1);
		int receiverExpected = players.getBalance(0);
		assertEquals(payerActual, payerExpected-field3rent);
		assertEquals(receiverActual, receiverExpected-field3price+field3rent);
		
	}
	
}
