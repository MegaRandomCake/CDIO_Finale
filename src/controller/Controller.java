package controller;

import java.io.IOException;
import java.util.Scanner;

import entity.Cup;
import entity.PlayerList;
import gameRules.Logic;

/**
 * Provides the methods for running the game by getting information from other classes.
 */
public class Controller {
	PlayerList players;
	Scanner boundry;
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

	public Controller(PlayerList players, Scanner boundry, Logic gameLogic, Cup cup) {
		System.out.println("Controller constructor launced");
		this.players = players;
		this.boundry = boundry;
		this.gameLogic = gameLogic;
		this.cup = cup;
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
	 * Run the game until only a single player have more than negative in their balance.
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
		this.players.addBalance(activePlayer, - this.gameLogic.getPrice(newField));
		/* Buys the field if possible */
		buyField(newField, activePlayer);
	}

	/**
	 * Sets the field a player just landed on to their field by buying it from the bank.
	 * 
	 * @param field A field on the gameboard. "Start" is number 0 and the largest number is 39.
	 * @param activePlayer The current player who just landed on the field.
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
	 * @param numofplayers The number of player in the game. The user will change this.
	 * @param c A character that helps with checking the input.
	 */

	private void playerInit() {
		int numofplayers = 0;
		char c = 0;
		System.out.println("Please enter the number of the players between 2 and 6");
		/* Loop that checks that whatever is inputed is valid. */
		while (true) {
			c = boundry.next().charAt(0);
			if (c >= '2' && c <= '6')
				break;
			else
				System.out.println("Input is not valid, please enter a number from 2 to 6.");
		}
		numofplayers = Character.getNumericValue(c);
		this.players = new PlayerList(numofplayers);
		/* Makes all the players input their playername. */
		for (int i = 0; i < numofplayers; i++) {
			System.out.println("Please enter the " + (i + 1) + " player name");
			String playerName = this.boundry.next();
			this.players.setName(playerName, i);
		}
	}
}
