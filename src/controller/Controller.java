package controller;

import java.io.IOException;
import java.util.Scanner;

import entity.PlayerList;
import gameRules.Logic;

public class Controller {
	PlayerList players;
	Scanner boundry;
	Logic gameLogic;

	public Controller(PlayerList players, Scanner boundry, Logic gameLogic) {
		System.out.println("Controller constructor launced");
		this.players = players;
		this.boundry = boundry;
		this.gameLogic = gameLogic;
	}

	public void runGame() {
		System.out.println("runGame launched");
		System.out.println("indtast antal spillere");
		playerInit();
		System.out.println(this.players);
		try {
			this.gameLogic = new Logic();
		} catch (IOException e) {
			System.out.println("error loading file");
			e.printStackTrace();
		}
		System.out.println(this.gameLogic);
	}

	private void playerInit() {
		int numofplayers = 0;
		// GUI_Car[] cars = generateCars();

		// numofplayers = gui.getUserInteger("Please enter the number of the players
		// Between 2 and 4", 2, 4);
		System.out.println("Please enter the number of the players Between 2 and 4");
		numofplayers = this.boundry.nextInt();
		this.players = new PlayerList(numofplayers);
		// guiplayers = new GUI_Player[numofplayers];
		for (int i = 0; i < numofplayers; i++) {
			System.out.println("Please enter the " + (i + 1) + " player name");
			String playerName = this.boundry.next();
			// String playerName = gui.getUserString("Please enter the " + (i + 1) + "
			// player name");
			this.players.setName(playerName, i);
			// GUI_Player player = new GUI_Player(playerName, balance, cars[i]);
			// gui.addPlayer(player);
			// guiplayers[i] = player;
			// gui.getFields()[0].setCar(player, true);
		}
	}
}
