package gameRules;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CardLoader {

	String[][] cards = new String[45][9];

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

	public CardLoader() throws IOException {
		String file = "src/gameRules/Cards.txt";

		BufferedReader reader = new BufferedReader(new FileReader(file));

		for (int i = 0; i < this.cards.length; i++) {
			String tempLine = reader.readLine();
			int progress = 0;

			for (int j = 0; j < this.cards[i].length; j++)
				this.cards[i][j] = "";

			for (int j = 0; j < tempLine.length(); j++) {
				char currChar = tempLine.charAt(j);
				if (currChar == '|')
					progress++;
				else
					this.cards[i][progress] += currChar;
			}
		}
		reader.close();
	}
	
	/**
	 * Return the entire String[][] of all chancecards created in the constructor.
	 * @return String[][] with all chancecards.
	 */

	public String[][] LoadDeck() {
		return this.cards;

	}
}
