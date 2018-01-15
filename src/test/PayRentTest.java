package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import entity.PlayerList;
import gameRules.FieldsController;
import gameRules.FileLoader;

public class PayRentTest {

	PlayerList players;
	FieldsController logic;
	int field3price = 1200;
	int field3rent = 50;

	@Before
	public void setUp() throws Exception {
		this.players = new PlayerList(3);
		this.logic = new FieldsController(new FileLoader("src/gameRules/fieldsText.txt", 40, 8).LoadDeck());
	}

	@Test
	public void test() {
		int payerActual = this.players.getBalance(1);
		int receiverActual = this.players.getBalance(0);
		this.logic.buyField(3, 0);
		this.logic.getPrice(3, 1);
		int payerExpected = this.players.getBalance(1);
		int receiverExpected = this.players.getBalance(0);
		assertEquals(payerExpected, payerActual - this.field3rent);
		assertEquals(receiverActual, receiverExpected - this.field3price + this.field3rent);
		System.out.println(this.players.getField(1));
	}

}
