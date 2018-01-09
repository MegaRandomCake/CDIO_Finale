package gameRules;

import java.io.IOException;
//import java.util.Random;
import java.util.Random;

public class DeckOfCards {
	
	String[][] deck;

	/**
	 * @param file
	 *            card format: 1 card per line. "String, cardType, String cardText,
	 *            int value"
	 * @param i
	 * @throws IOException 
	 */
	public DeckOfCards() {
		try {
			deck = new CardLoader().LoadDeck();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ShuffleDeck();
	}
	
	public void ShuffleDeck() {
	    Random random = new Random();

	    for (int i = deck.length - 1; i > 0; i--) {
	    	int m = random.nextInt(i + 1);
	        for (int j = 0; j < deck[i].length; j++) {
	            
	            String temp = deck[i][j];
	            deck[i][j] = deck[m][j];
	            deck[m][j] = temp;
	        }
	    }
	}
}
