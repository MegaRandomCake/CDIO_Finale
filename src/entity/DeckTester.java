package entity;

import java.io.IOException;

public class DeckTester {

	public static void main(String[] args) throws IOException{
		ChanceCards[] cards = null;
		DeckOfCards deck = new DeckOfCards(cards);
		PlayerList players;
		

			int numofplayers = 0;
			numofplayers = 2;
			players = new PlayerList(numofplayers);
			/* Makes all the players input their playername. */
			for (int i = 0; i < numofplayers; i++) {
				System.out.println("Please enter the " + (i + 1) + " player name");
				String playerName = "1";
				players.setName(playerName, i);
			}
		
		
		deck.CreateDeck();
		deck.DrawCard();
		deck.ShuffleDeck();
	}

}
