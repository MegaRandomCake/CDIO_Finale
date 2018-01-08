package boundry;

import java.awt.Color;
import java.io.IOException;

import gui_fields.GUI_Brewery;
import gui_fields.GUI_Car;
import gui_fields.GUI_Chance;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_fields.GUI_Refuge;
import gui_fields.GUI_Start;
import gui_fields.GUI_Street;
import gui_fields.GUI_Tax;
import gui_main.GUI;

public class MatadorGUI {

	private GUI_Field[] fields = new GUI_Field[40];
	GUI gui;
	GUI_Player[] players;
	GUI_Car[] cars;
	Color[] colors = { Color.RED, Color.YELLOW, Color.GREEN, Color.BLUE, Color.BLACK, Color.WHITE };

	public MatadorGUI() {
		Loader loader = null;
		try {
			loader = new Loader();
			String[][] tempFields = loader.getFields();
			for (int i = 0; i < tempFields.length; i++)
				switch (tempFields[i][0].toLowerCase()) {
				case "street":
				case "ferry":
					this.fields[i] = new GUI_Street(tempFields[i][1], tempFields[i][2], tempFields[i][3],
							tempFields[i][4], Color.BLUE, Color.MAGENTA);
					break;
				case "chance":
					this.fields[i] = new GUI_Chance(tempFields[i][1], tempFields[i][2], tempFields[i][3], Color.WHITE,
							Color.BLACK);
					break;
				case "tax":
					this.fields[i] = new GUI_Tax(tempFields[i][1], tempFields[i][2], tempFields[i][3], Color.BLACK,
							Color.WHITE);
					break;
				case "brewery":
					this.fields[i] = new GUI_Brewery("arg0", "arg1", "arg2", "arg3", "arg4", Color.RED,
							Color.DARK_GRAY);
					break;
				case "refuge":
				case "jail":
					this.fields[i] = new GUI_Refuge("arg0", "arg1", "arg2", "arg3", Color.RED, Color.DARK_GRAY);
					break;
				/* !Hvad er GUI_Shipping?! */
				// case "shipping":
				// this.fields = new GUI_Shipping("arg0", "arg1", "arg2", "arg3", "arg4",
				// Color.BLACK, Color.YELLOW);
				// break;
				case "start":
					this.fields[i] = new GUI_Start(tempFields[i][1], tempFields[i][2], tempFields[i][3], Color.RED,
							Color.RED);
					break;
				default:
					break;

				}
			this.gui = new GUI(this.fields);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(" ERROR:\"error nr here\" Spillebræt ikke fundet, kontakt venligts IT support." + e);

		}
	}

	public void waitForEnter(String text, String... Button) {
		this.gui.getUserButtonPressed(text, Button);
	}

	public int dropdownInt(String text, String... choice) {
		String indput = this.gui.getUserSelection(text, choice);
		for (int i = 0; i < choice.length; i++)
			if (choice[i] == indput)
				return Integer.parseInt(choice[i]);
		return 0;

	}

	public void nextmessage(String txt) {
		this.gui.displayChanceCard(txt);
	}

	public String next(String msg) {
		String out = this.gui.getUserString(msg);
		// String[] out = { "a", "b", "c", "d", "e", "f" };
		return out;
	}

	public void addPlayer(String[] names, int[] balances) {
		this.players = new GUI_Player[names.length];
		this.cars = new GUI_Car[names.length];
		for (int i = 0; i < names.length && i < balances.length; i++) {
			this.cars[i] = new GUI_Car();
			this.cars[i].setPrimaryColor(this.colors[i]);
			this.players[i] = new GUI_Player(names[i], balances[i], this.cars[i]);
			this.gui.addPlayer(this.players[i]);
			this.fields[0].setCar(this.players[i], true);
		}

	}

	public void setBalance(int balance, int activePlayer) {
		this.players[activePlayer].setBalance(balance);
	}

	public void movePlayer(int activePlayer, int oldField, int newField) {
		this.fields[oldField].setCar(this.players[activePlayer], false);
		this.fields[newField].setCar(this.players[activePlayer], true);
	}

	public String[] PlayerRegistration(int numOfPlayers) {
		String[] out = new String[numOfPlayers];
		for (int i = 0; i < out.length; i++)
			out[i] = this.gui.getUserString("Please enter the " + (i + 1) + " player name");

		return out;
	}

	public void setDice(int[] eyes) {
		this.gui.setDice(eyes[0], eyes[1]);
	}

}
