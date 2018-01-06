package entity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class DeckOfCards {
	
	private ChanceCards[] cards;
	
	public DeckOfCards(int i) {
		this.cards = new ChanceCards[i];
	}
	

	public void CreateDeck() throws IOException {

		String file = "src/entity/Cards.txt";
		BufferedReader reader = new BufferedReader(new FileReader(file));
		int[] movefield = new int[] { 0, 0, 24, 11, 19, 32, 15, 39 };
		int[] moneychangebank = new int[] { 500, 500, 200, 3000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, -200,
				-200, -300, -100, -1000, -200, -3000, -3000, -200, -1000 };

		cards[0] = new ChanceCards(reader.readLine(), CardType.MOVESPACES, 3);
		cards[1] = new ChanceCards(reader.readLine(), CardType.MOVESPACES, 3);
		cards[2] = new ChanceCards(reader.readLine(), CardType.MOVESPACES, -3);
		for (int i = 3; i <= 10; i++) {
			cards[i] = new ChanceCards(reader.readLine(), CardType.MOVEFIELD, movefield[i - 3]);
		}
		cards[11] = new ChanceCards(reader.readLine(), CardType.MOVESHIP, 1);
		cards[12] = new ChanceCards(reader.readLine(), CardType.MOVESHIP, 1);
		cards[13] = new ChanceCards(reader.readLine(), CardType.KINGSBIRTHDAY, 40);
		cards[14] = new ChanceCards(reader.readLine(), CardType.KINGSBIRTHDAY, 40);
		cards[15] = new ChanceCards(reader.readLine(), CardType.GOTOJAIL, 10);
		cards[16] = new ChanceCards(reader.readLine(), CardType.GOTOJAIL, 10);
		for (int i = 17; i <= 38; i++) {
			cards[i] = new ChanceCards(reader.readLine(), CardType.MONEYCHANGEBANK, moneychangebank[i - 17]);
		}
		cards[39] = new ChanceCards(reader.readLine(), CardType.RECIEVEMONEYPLAYERS, 200);
		cards[40] = new ChanceCards(reader.readLine(), CardType.RECIEVEMONEYPLAYERS, 500);
		cards[41] = new ChanceCards(reader.readLine(), CardType.RECIEVEMONEYPLAYERS, 500);
		cards[42] = new ChanceCards(reader.readLine(), CardType.PAYOIL, 500);
		cards[43] = new ChanceCards(reader.readLine(), CardType.PAYOIL, 800);
		cards[44] = new ChanceCards(reader.readLine(), CardType.MATADORLEGAT, 40000);
		ShuffleDeck();
		reader.close();
	}
	
	public String DrawCard() {
		int cardcounter = 0;
		
		CardType cardType = cards[cardcounter].getCardType();
		
		int value = cards[cardcounter].getValue();
		
		cards[cardcounter].CheckCard(cardType, value);

		cardcounter++;
		if(cardcounter == 46) {
			cardcounter = 0;
			ShuffleDeck();
		}
		
		return cards[cardcounter-1].getText();
	}
	
	public void ShuffleDeck() {
		Random random = new Random();
		for(int i = cards.length -1; i > 0; i--) {
			int j = random.nextInt(i);
			
			ChanceCards temp = cards[i];
			cards[i] = cards[j];
			cards[j] = temp;
		}
	}

}
