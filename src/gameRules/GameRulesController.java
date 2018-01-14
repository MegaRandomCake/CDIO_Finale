package gameRules;

import java.io.IOException;

public class GameRulesController {

	/**
	 * Provides a set of gamerules for the game with methods for setting, getting
	 * and resetting variables that are sent to the main controller.
	 */
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

	/**
	 * Constructs a GameRulesController that contains the FieldsController
	 * constructor, the DeckOfCards constructor and a Object array[10].
	 */

	public GameRulesController() {
		try {
			this.fields = new FieldsController(new FileLoader("src/gameRules/fieldsText.txt", 40, 8).LoadDeck());
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			this.deck = new DeckOfCards(new FileLoader("src/gameRules/Cards.txt", 45, 8).LoadDeck());
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.out = new Object[10];
		this.gameText = "text in the top corner";
		this.centerText = "text in the center";

	}

	/**
	 * Returns an Object[10] with String gameText, String centerText, int
	 * moveFields, int moveToFields, int addAPBalance, int addNAPBalance, boolean
	 * PayDouble, boolean GotoJail, boolean, KingsBirthday and int SpecialEvent
	 * where 1 is oilprices, 2 is housingtaxes and 3 is the matador endowment.
	 * 
	 * @param newField
	 *            The indexnumber of the field, the current player have landed on.
	 * @return An Object[10] with Strings, ints and Booleans.
	 */

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

	/**
	 * Calls the DrawCard method if the current active player lands on a Chance
	 * field.
	 * 
	 * @param newField
	 *            The indexnumber of the field, the current player have landed on.
	 */

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
		// if (this.fields.checkFieldOwned(newField))
		this.addAPBalance = this.addAPBalance - this.fields.getPrice(newField);
	}

	/**
	 * Sets all variables variables used by the out array from the constructor based
	 * the current top card in the deck. Calls the ShuffleDeck method from
	 * DeckOfCards if all cards have been drawn.
	 */

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

	/**
	 * Sets all variables used by the out array from the constructor to their
	 * default values. Note that this only changes the variables the out array calls
	 * and not the out array itself.
	 */

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
