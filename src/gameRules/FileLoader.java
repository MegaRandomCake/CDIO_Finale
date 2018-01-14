package gameRules;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Provides a 2d array with information about the chancecards and their various
 * Strings, ints and booleans.
 */

public class FileLoader {

	String[][] fileIn;

	/**
	 * Constructs a String[45][9] with all the chancecards and their values from a
	 * .txt file on disk. All values of i at j = 0 is The message shown to the
	 * player. Then number of spaces to move, balancechange for activeplayer,
	 * balancechange for all other players, int for special fees, boolean for if the
	 * player need to pay double, boolean do the player go to jail, boolean do the
	 * player gain a "get out of jail card" and indexnumber of a field the player
	 * must move to.
	 * 
	 * @throws IOException
	 *             If no file is found.
	 */

	public FileLoader(String path, int lines, int datapoints) throws IOException {
		String file = path;
		this.fileIn = new String[lines][datapoints];
		BufferedReader reader = new BufferedReader(new FileReader(file));

		for (int i = 0; i < this.fileIn.length; i++) {
			String tempLine = reader.readLine();
			int progress = 0;

			for (int j = 0; j < this.fileIn[i].length; j++)
				this.fileIn[i][j] = "";

			for (int j = 0; j < tempLine.length(); j++) {
				char currChar = tempLine.charAt(j);
				if (currChar == '|')
					progress++;
				else
					this.fileIn[i][progress] += currChar;
			}
		}
		reader.close();
	}

	/**
	 * Return the entire String[][] of all chancecards created in the constructor.
	 * 
	 * @return String[][] with all chancecards.
	 */

	public String[][] LoadDeck() {
		return this.fileIn;

	}
}
