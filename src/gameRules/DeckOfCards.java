package gameRules;

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
	public DeckOfCards(String[][] data) {
			this.deck = data;

		shuffleDeck();
	}

	/**
	 * Sets the order in which the cards are placed in the deck[][] to a new
	 * pseudorandom number in the array. Basically it shuffles the deck.
	 */

	public void shuffleDeck() {
		Random random = new Random();

		for (int i = this.deck.length - 1; i > 0; i--) {
			int m = random.nextInt(i + 1);
			for (int j = 0; j < this.deck[i].length; j++) {

				String temp = this.deck[i][j];
				this.deck[i][j] = this.deck[m][j];
				this.deck[m][j] = temp;
			}
		}
	}
}