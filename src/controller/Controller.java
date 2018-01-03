package controller;

import java.io.IOException;
import java.util.Scanner;

import entity.Cup;
import entity.PlayerList;
import gameRules.Logic;

public class Controller {
	PlayerList players;
	Scanner boundry;
	Logic gameLogic;
	Cup cup;

	public Controller(PlayerList players, Scanner boundry, Logic gameLogic, Cup cup) {
		System.out.println("Controller constructor launced");
		this.players = players;
		this.boundry = boundry;
		this.gameLogic = gameLogic;
		this.cup = cup;
	}

	public void launchGame() {
		playerInit();
		loadRules();
		runGame();

	}

	private void runGame() {
		int turnCounter = 0;
		while (this.players.activePlayerNr() > 1) {
			runTurn();
			turnCounter++;
			System.out.println(this.players);
			if (turnCounter%6==0) {
				System.out.println(this.gameLogic);
			}
			this.players.passTurn();
		}
		System.out.println(turnCounter);
	}

	private void runTurn() {
		int activePlayer = this.players.getActivePlayer();
		int oldField = this.players.getField(activePlayer);
		this.cup.rollCup();
		this.players.addToField(activePlayer, this.cup.getEyes());
		int newField = this.players.getField(activePlayer);
		this.players.addBalance(activePlayer, -this.gameLogic.getPrice(newField));
		buyField(newField, activePlayer);
	}

	private void buyField(int field, int activePlayer) {
		if (this.gameLogic.checkFieldOwned(field) == -1) {
			this.gameLogic.buyField(field, activePlayer);
		}
	}

	private void loadRules() {
		try {
			this.gameLogic = new Logic();
		} catch (IOException e) {
			System.out.println("error loading file");
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	private void playerInit() {
		int numofplayers = 0;
		System.out.println("Please enter the number of the players Between 2 and 4");
		numofplayers = this.boundry.nextInt();
		this.players = new PlayerList(numofplayers);
		for (int i = 0; i < numofplayers; i++) {
			System.out.println("Please enter the " + (i + 1) + " player name");
			String playerName = this.boundry.next();
			this.players.setName(playerName, i);
		}
	}
}
