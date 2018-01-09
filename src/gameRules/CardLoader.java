package gameRules;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CardLoader {
	
	String[][] cards = new String[45][9];
	
	/**
	 * String med beskrivelse, int med hvor mange felt er der skal rykkes, int med balanceændring for aktiv spiller,
	 * int med balanceændring for alle ikke-aktive spillere,int oliepriser(1)/ejendomsskat(2)/matadorlegat(3), 
	 * boolean Skal man betale dobbelt, boolean Ryger man i fængsel, boolean kongensfødselsdag, int[] med felter der kan flyttes til.
	 * @throws IOException
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

	public String[][] LoadDeck() {
		return this.cards;
		
	}
}
