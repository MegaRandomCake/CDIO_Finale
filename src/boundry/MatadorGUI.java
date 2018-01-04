package boundry;

import gui_main.GUI;

public class MatadorGUI {

	GUI gui = new GUI();
	int j = 0;

	public int dropdownInt(String text, String... choice) {
		String indput = this.gui.getUserSelection(text, choice);
		for (int i = 0; i < choice.length; i++)
			if (choice[i] == indput)
				return Integer.parseInt(choice[i]);
		return 0;

	}

	public String next(String msg) {
		String out = this.gui.getUserString(msg);
		//String[] out = { "a", "b", "c", "d", "e", "f" };
		return out;
	}
}
