package gameRules;

import java.io.IOException;
//import java.util.Random;

public class DeckOfCards {
	
	String[][] deck;

//	private int cardcounter = 0;

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
	}
		

//	public String DrawCard(PlayerList spiller) {
//
//		CardType cardType = this.cards[cardcounter].getCardType();
//
//		int value = this.cards[cardcounter].getValue();
//
//		this.cards[cardcounter].CheckCard(spiller, cardType, value);
//
//		cardcounter++;
//		if (cardcounter == 46) {
//			cardcounter = 0;
//			ShuffleDeck();
//		}
//
//		return this.cards[cardcounter - 1].getText();
//	}
//
//	public void ShuffleDeck() {
//		Random random = new Random();
//		for (int i = this.cards.length - 1; i > 0; i--) {
//			int j = random.nextInt(i);
//
//			ChanceCards temp = this.cards[i];
//			this.cards[i] = this.cards[j];
//			this.cards[j] = temp;
//		}
//	}

}
