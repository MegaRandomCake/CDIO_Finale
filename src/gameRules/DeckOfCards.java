package gameRules;

import java.io.IOException;
//import java.util.Random;
import java.util.Random;

/**
 * Provides a constructor for creating a complete deck of cards for the game
 * along with a method for shuffling the cards
 */

public class DeckOfCards {

	String[][] deck;

	/**
	 * Constructs a new deck of chancecards from the gamesRules.CardLoader. Also
	 * shuffles the deck afterwards.
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

	/**
	 * Sets the order in which the cards are placed in the deck[][] to a new
	 * pseudorandom number in the array. Basically it shuffles the deck.
	 */

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