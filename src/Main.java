import java.util.Scanner;

import controller.Controller;
import entity.PlayerList;
import gameRules.Logic;

public class Main {
	static Scanner boundry = new Scanner(System.in);
	static PlayerList players;
	static Logic gameLogic;

	public static void main(String[] args) {
		System.out.println(Math.random() + " main launched");
		new Controller(players, boundry, gameLogic).runGame();
	}

}
