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
		this.out[0] = this.gameText;
		this.out[1] = this.centerText;
		this.out[2] = this.moveFields;
		this.out[3] = this.moveToFields;
		this.out[4] = this.addAPBalance;
		this.out[5] = this.addNAPBalance;
		this.out[6] = this.PayDouble;
		this.out[7] = this.GoToJail;
		this.out[8] = this.KingsBirthday;
		this.out[9] = this.SpecialEvent;
		return this.out;
	}

	private void checkField(int newField) {
		switch (newField) {
		case 2:
		case 7:
		case 17:
		case 22:
		case 33:
		case 36:

			DrawCard();
			break;
		default:
			break;
		}
//		if (this.fields.checkFieldOwned(newField))
		this.addAPBalance = this.addAPBalance - this.fields.getPrice(newField);
	}

	private void DrawCard() {
		this.centerText = this.deck.deck[this.CurrentTopCard][0];
		this.moveFields = Integer.parseInt(this.deck.deck[this.CurrentTopCard][1]);
		this.addAPBalance = Integer.parseInt(this.deck.deck[this.CurrentTopCard][2]);
		this.addNAPBalance = Integer.parseInt(this.deck.deck[this.CurrentTopCard][3]);
		this.SpecialEvent = Integer.parseInt(this.deck.deck[this.CurrentTopCard][4]);
		this.PayDouble = Boolean.parseBoolean(this.deck.deck[this.CurrentTopCard][5]);
		this.GoToJail = Boolean.parseBoolean(this.deck.deck[this.CurrentTopCard][6]);
		this.KingsBirthday = Boolean.parseBoolean(this.deck.deck[this.CurrentTopCard][7]);
		this.moveToFields = Integer.parseInt(this.deck.deck[this.CurrentTopCard][8]);
		this.CurrentTopCard++;
		if (this.CurrentTopCard == 44)
			this.deck.ShuffleDeck();

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