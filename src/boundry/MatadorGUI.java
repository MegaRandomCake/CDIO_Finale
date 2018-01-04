package boundry;

import java.awt.Color;

import gui_fields.GUI_Car;
import gui_fields.GUI_Player;
import gui_main.GUI;

public class MatadorGUI {

	GUI gui = new GUI();
	int j = 0;
	GUI_Player[] players;
	GUI_Car[] cars;
	Color[] colors = {Color.RED, Color.YELLOW, Color.GREEN, Color.BLUE, Color.BLACK, Color.WHITE};

	public int dropdownInt(String text, String... choice) {
		String indput = this.gui.getUserSelection(text, choice);
		for (int i = 0; i < choice.length; i++)
			if (choice[i] == indput)
				return Integer.parseInt(choice[i]);
		return 0;

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
			this.players[i] = new GUI_Player(names[i], 	balances[i], this.cars[i]);
			this.gui.addPlayer(this.players[i]);
		}
		
	}

}
