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
		this.players = new PlayerList(3);
		this.logic = new Logic();
	}

	@Test
	public void test() {
		int payerActual = this.players.getBalance(1);
		int receiverActual = this.players.getBalance(0);
		this.logic.buyField(3, 0);
		this.players.addToField(1, 3);
		int payerExpected = this.players.getBalance(1);
		int receiverExpected = this.players.getBalance(0);
		assertEquals(payerActual, payerExpected-field3rent);
		assertEquals(receiverActual, receiverExpected-field3price+field3rent);
	}
	
}
