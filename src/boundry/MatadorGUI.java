package boundry;

import java.awt.Color;

import gui_fields.GUI_Car;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_fields.GUI_Street;
import gui_main.GUI;

public class MatadorGUI {

	private GUI_Field[] fields = new GUI_Field[40];
	GUI gui = new GUI();
	int j = 0;
	GUI_Player[] players;
	GUI_Car[] cars;
	Color[] colors = { Color.RED, Color.YELLOW, Color.GREEN, Color.BLUE, Color.BLACK, Color.WHITE };

	public MatadorGUI() {
		for (int i = 0; i < this.fields.length; i++)
			this.fields[i] = new GUI_Street("title" + i, "subText" + i, "description" + i, "rent" + i, Color.YELLOW,
					Color.RED);

		
	}

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

}
