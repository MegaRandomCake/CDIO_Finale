package controller;

import java.io.IOException;
import boundry.MatadorGUI;
import entity.Cup;
import entity.PlayerList;
import gameRules.Logic;

/**
 * Provides the methods for running the game by getting information from other
 * classes.
 */
public class Controller {
	PlayerList players;
	MatadorGUI boundry;
	Logic gameLogic;
	Cup cup;

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

	public Controller(PlayerList players, MatadorGUI boundry, Logic gameLogic, Cup cup) {
		System.out.println("Controller constructor launced");
		this.players = players;
		this.boundry = new MatadorGUI();
		this.gameLogic = gameLogic;
		this.cup = cup;
	}

	public Controller() {
		this.boundry = new MatadorGUI();
		try {
			this.gameLogic = new Logic();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.cup = new Cup();
	}

	/**
	 * Launches the game by calling different methods from this class.
	 */

	public void launchGame() {
		playerInit();
		loadRules();
		runGame();

	}

	/**
	 * Run the game until only a single player have more than negative in their
	 * balance.
	 */

	private void runGame() {
		int turnCounter = 0;
		while (this.players.activePlayerNr() > 1) {
			runTurn();
			turnCounter++;
			System.out.println(this.players);
			if (turnCounter % 6 == 0) {
				System.out.println(this.gameLogic);
			}
			this.players.passTurn();
		}
		System.out.println(turnCounter);
	}

	/**
	 * Makes the game go a single turn for a single player.
	 */

	private void runTurn() {
		/* Loads the active player. */
		int activePlayer = this.players.getActivePlayer();
		int oldField = this.players.getField(activePlayer);
		/* Rolls the dice and moves the player forward the number of the dice. */
		this.cup.rollCup();
		this.players.addToField(activePlayer, this.cup.getEyes());
		/* Loads the new field and its value. */
		int newField = this.players.getField(activePlayer);
		this.players.addBalance(activePlayer, -this.gameLogic.getPrice(newField));
		/* Buys the field if possible */
		buyField(newField, activePlayer);
	}

	/**
	 * Sets the field a player just landed on to their field by buying it from the
	 * bank.
	 * 
	 * @param field
	 *            A field on the gameboard. "Start" is number 0 and the largest
	 *            number is 39.
	 * @param activePlayer
	 *            The current player who just landed on the field.
	 */
	private void buyField(int field, int activePlayer) {
		if (this.gameLogic.checkFieldOwned(field) == -1) {
			this.gameLogic.buyField(field, activePlayer);
		}
	}

	/**
	 * Sets the field and gameLogic from the Logic class.
	 */

	private void loadRules() {
		try {
			this.gameLogic = new Logic();
		} catch (IOException e) {
			System.out.println("error loading file");
			e.printStackTrace();
		}
	}

	/**
	 * Sets the number of players for the game and their playername.
	 * 
	 * @param numofplayers
	 *            The number of player in the game. The user will change this.
	 */

	private void playerInit() {
		int numofplayers = 0;
		System.out.println("indtast antal spillere 2-6");
		numofplayers = this.boundry.dropdownInt("indtast antal spillere 2-6", "2", "3", "4", "5", "6");
		this.players = new PlayerList(numofplayers);
		/* Makes all the players input their playername. */
		for (int i = 0; i < numofplayers; i++) {
			//System.out.println("Please enter the " + (i + 1) + " player name");
			String playerName = this.boundry.next("Please enter the " + (i + 1) + " player name");
			this.players.setName(playerName, i);
		}
	}
}
