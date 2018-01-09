package gameRules;

import java.io.IOException;

public class GameRulesController {
	private int CurrentTopCard = 0;
	private String gameText;
	private String centerText;
	private int moveFields;
	private int moveToFields;
	private int addAPBalance;
	private int addNAPBalance;
	private FieldsController fields;
	private DeckOfCards deck;
	private int SpecialEvent;
	private boolean PayDouble;
	private boolean GoToJail;
	private boolean KingsBirthday;
	Object[] out;

	public GameRulesController() {
		try {
			this.fields = new FieldsController();
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.deck = new DeckOfCards();
		this.out = new Object[10];
		this.gameText = "text in the top corner";
		this.centerText = "text in the center";

	}

	public Object[] getArray(int newField) {
		ResetOut();
		checkField(newField);
		out[0] = this.gameText;
		out[1] = this.centerText;
		out[2] = this.moveFields;
		out[3] = this.moveToFields;
		out[4] = this.addAPBalance;
		out[5] = this.addNAPBalance;
		out[6] = this.PayDouble;
		out[7] = this.GoToJail;
		out[8] = this.KingsBirthday;
		out[9] = this.SpecialEvent;
		return out;
	}

	private void checkField(int newField) {
		DrawCard(newField);
		this.addAPBalance = this.addAPBalance - this.fields.getPrice(newField);
	}

	private void DrawCard(int newField) {
		switch (newField) {
		case 2:case 7:case 17:case 22:case 33:case 36:
			this.centerText = this.deck.deck[CurrentTopCard][0];
			this.moveFields = Integer.parseInt(this.deck.deck[CurrentTopCard][1]);
			this.addAPBalance = Integer.parseInt(this.deck.deck[CurrentTopCard][2]);
			this.addNAPBalance = Integer.parseInt(this.deck.deck[CurrentTopCard][3]);
			this.SpecialEvent = Integer.parseInt(this.deck.deck[CurrentTopCard][4]);
			this.PayDouble = Boolean.parseBoolean(this.deck.deck[CurrentTopCard][5]);
			this.GoToJail = Boolean.parseBoolean(this.deck.deck[CurrentTopCard][6]);
			this.KingsBirthday = Boolean.parseBoolean(this.deck.deck[CurrentTopCard][7]);
			this.moveToFields = Integer.parseInt(this.deck.deck[CurrentTopCard][8]);
			CurrentTopCard++;
			if (CurrentTopCard == 44)
				deck.ShuffleDeck();
		}
	}

	private void ResetOut() {
		this.centerText = "";
		this.moveFields = 0;
		this.moveToFields = 40;
		this.addAPBalance = 0;
		this.addNAPBalance = 0;
		this.PayDouble = false;
		this.GoToJail = false;
		this.KingsBirthday = false;
		this.SpecialEvent = 0;
	}
}
