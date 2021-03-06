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
	private int[] addPlayerBalance = new int[2];
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
			this.deck = new DeckOfCards(new FileLoader("src/gameRules/Cards.txt", 45, 9).LoadDeck());
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.out = new Object[11];
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

	public Object[] getArray(int newField, int activePlayer) {
		ResetOut();
		checkField(newField, activePlayer);
		this.out[0] = this.gameText;
		this.out[1] = this.centerText;
		this.out[2] = this.moveFields;
		this.out[3] = this.moveToFields;
		this.out[4] = this.addAPBalance;
		this.out[5] = this.addNAPBalance;
		this.out[6] = this.addPlayerBalance;
		this.out[7] = this.PayDouble;
		this.out[8] = this.GoToJail;
		this.out[9] = this.KingsBirthday;
		this.out[10] = this.SpecialEvent;
		return this.out;
	}

	/**
	 * Calls the DrawCard method if the current active player lands on a Chance
	 * field.
	 * 
	 * @param newField
	 *            The indexnumber of the field, the current player have landed on.
	 */

	private void checkField(int newField, int activePlayer) {
		switch (newField) {
		case 2:
		case 7:
		case 17:
		case 22:
		case 33:
		case 36:

			DrawCard();
			break;
		case 0:
		case 10:
		case 20:
		case 30:
		case 4:
		case 5:
		case 12:
		case 15:
		case 25:
		case 28:
		case 35:
		case 38:
			System.out.println("Gratis parkering: " + newField);
			break;
		default:
			getStreetPrice(newField, activePlayer);
			break;
		}
		// if (this.fields.checkFieldOwned(newField))
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
		if (this.CurrentTopCard == 44) {
			this.deck.shuffleDeck();
			this.CurrentTopCard = 0;
		}
		System.out.println(this.centerText);

	}

	private void getStreetPrice(int newField, int activePlayer) {
		if (this.fields.getFieldOwned(newField)) {
			int rent = this.fields.getRent(newField);
			this.addAPBalance = -rent;
			this.addPlayerBalance[0] = this.fields.getOwner(newField);
			this.addPlayerBalance[1] = rent;
		}
		this.addAPBalance = this.fields.getPrice(newField, activePlayer);
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
