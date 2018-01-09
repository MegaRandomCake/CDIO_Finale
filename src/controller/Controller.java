package controller;

import java.io.IOException;

import boundry.MatadorGUI;
import entity.Cup;
import entity.PlayerList;
import gameRules.FieldsController;
import gameRules.GameRulesController;

/**
 * Provides the methods for running the game by getting information from other
 * classes.
 */
public class Controller {
	private PlayerList players;
	private MatadorGUI boundry;
	private GameRulesController gameLogic;
	private Cup cup;

	/**
	 * Constructs a controller with information from the entity and gameRules
	 * packages, so that the program can run.
	 * 
	 * @param players
	 *            The PlayerList class containing methods for managing the players
	 *            and their balance.
	 * @param boundry
	 *            A Scanner from the java.util package.
	 * @param gameLogic
	 *            The Logic class containing methods for managing the field and the
	 *            rules.
	 * @param cup
	 *            The Cup class containing methods for managing the roll of the
	 *            dice.
	 */

	public Controller(PlayerList players, MatadorGUI boundry, GameRulesController gameLogic, Cup cup) {
		System.out.println("Controller constructor launced");
		this.players = players;
		this.boundry = boundry;
		this.gameLogic = gameLogic;
		this.cup = cup;
	}

	public Controller() {
		this.boundry = new MatadorGUI();
		this.gameLogic = new GameRulesController();
		this.cup = new Cup();
	}

	/**
	 * Launches the game by calling different methods from this class.
	 */

	public void launchGame() {
		playerInit();
		runGame();
	}

	/**
	 * Sets the number of players for the game and their playername.
	 * 
	 * @param numofplayers
	 *            The number of player in the game. The user will change this.
	 */

	private void playerInit() {
		int numOfPlayers = 0;
		System.out.println("indtast antal spillere 2-6");
		numOfPlayers = this.boundry.dropdownInt("indtast antal spillere 2-6", "2", "3", "4", "5", "6");
		this.players = new PlayerList(numOfPlayers);
		/* Makes all the players input their playername. */
		this.players.setNames(this.boundry.PlayerRegistration(numOfPlayers));
		this.boundry.addPlayer(this.players.getNames(), this.players.getBalances());
	}

	/**
	 * Sets the field and gameLogic from the Logic class.
	 */

	/**
	 * Run the game until only a single player have more than negative in their
	 * balance.
	 */

	private void runGame() {
		while (this.players.activePlayerNr() > 1) {
			runTurn();
			System.out.println(this.players);
			this.players.passTurn(this.cup.getDoubles());
		}
		System.out.println(this.players.getTurnCount());
	}

	/**
	 * Makes the game go a single turn for a single player. !Rename to "turn" before
	 * after iteration 2!
	 */

	private void runTurn() {
		/* Loads the active player. */
		int activePlayer = this.players.getActivePlayer();
		int oldField = this.players.getField(activePlayer);

		this.boundry.waitForEnter(String.format("player %s's turn", activePlayer + 1), "roll die",
				"roll die but with this button");
		/* Rolls the dice and moves the player forward the number of the dice. */
		this.cup.rollCup();
		this.boundry.setDice(this.cup.getEyes());
		this.players.addToField(activePlayer, this.cup.getSum());
		/* Loads the new field and its value. */
		int newField = this.players.getField(activePlayer);
		checkLogic(activePlayer, newField);
		this.boundry.movePlayer(activePlayer, oldField, newField);
		this.boundry.setBalance(this.players.getBalance(activePlayer), activePlayer);
	}

	private void checkLogic(int activePlayer, int newField) {
		Object[] doThis = this.gameLogic.getArray(newField);
		boundry.nextmessage((String) doThis[1]);
		this.players.addToField(activePlayer, (Integer) doThis[2]);
		/* Virker ikke, bilen flyttes men der skabes en ikke-flytbar klon på det gamle felt */
//		if ((Integer) doThis[3] != 40)
//			this.players.setField(activePlayer, (Integer) doThis[3]);
		this.players.addBalance(activePlayer, (Integer) doThis[4]);
		this.players.takeMoneyAllPlayers((Integer) doThis[5]);
		/* Endnu ikke implementeret */
		// this.players.PayDouble((Boolean) doThis[6]);
		// this.players.setPrisonState(activePlayer, (Boolean) doThis[7]);
		// if((Boolean) doThis[8] == true)
		// this.players.addBirthdayCard(activePlayer);

		/* Buys the field if possible | !move method to gameRules package! */
		// buyField(newField, activePlayer);
	}

	/**
	 * Sets the field a player just landed on to their field by buying it from the
	 * bank.
	 * 
	 * !This method is to be moved into the gameRules package!
	 * 
	 * @param field
	 *            A field on the gameboard. "Start" is number 0 and the largest
	 *            number is 39.
	 * @param activePlayer
	 *            The current player who just landed on the field.
	 */
	// private void buyField(int field, int activePlayer) {
	// if (this.gameLogic.checkFieldOwned(field) == -1) {
	// this.gameLogic.buyField(field, activePlayer);
	// }
	// }

}
