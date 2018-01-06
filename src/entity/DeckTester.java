package entity;

import java.io.IOException;

public class DeckTester {

	public static void main(String[] args) throws IOException{
		ChanceCards[] cards = null;
		DeckOfCards deck = new DeckOfCards(cards);
		
		deck.CreateDeck();
		deck.ShuffleDeck();
	}

}
