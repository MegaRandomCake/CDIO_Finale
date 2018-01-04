import java.util.Scanner;

import controller.Controller;
import entity.Cup;
import entity.PlayerList;
import gameRules.Logic;

/**
 * Provides the main method so the game can run.
 *
 */
public class Main {
	static Scanner boundry = new Scanner(System.in);
	static PlayerList players;
	static Logic gameLogic;
	static Cup cup = new Cup();

	public static void main(String[] args) {
		new Controller(players, boundry, gameLogic, cup).launchGame();
	}

}
