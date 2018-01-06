package entity;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class DeckOfCards {

	private ChanceCards[] cards;

	/**
	 * @param file
	 *            card format: 1 card per line. "String, cardType, String cardText,
	 *            int value"
	 * @param i
	 */
	public DeckOfCards(int i) {
		this.cards = new ChanceCards[i];
		String file = "src/entity/Cards.txt";
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(file));

			int[] movefield = new int[] { 0, 0, 24, 11, 19, 32, 15, 39 };
			int[] moneychangebank = new int[] { 500, 500, 200, 3000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000,
					-200, -200, -300, -100, -1000, -200, -3000, -3000, -200, -1000 };

			this.cards[0] = new ChanceCards(reader.readLine(), CardType.MOVESPACES, 3);
			this.cards[1] = new ChanceCards(reader.readLine(), CardType.MOVESPACES, 3);
			this.cards[2] = new ChanceCards(reader.readLine(), CardType.MOVESPACES, -3);
			for (int j = 3; j <= 10; j++) {
				this.cards[j] = new ChanceCards(reader.readLine(), CardType.MOVEFIELD, movefield[j - 3]);
			}
			this.cards[11] = new ChanceCards(reader.readLine(), CardType.MOVESHIP, 1);
			this.cards[12] = new ChanceCards(reader.readLine(), CardType.MOVESHIP, 1);
			this.cards[13] = new ChanceCards(reader.readLine(), CardType.KINGSBIRTHDAY, 40);
			this.cards[14] = new ChanceCards(reader.readLine(), CardType.KINGSBIRTHDAY, 40);
			this.cards[15] = new ChanceCards(reader.readLine(), CardType.GOTOJAIL, 10);
			this.cards[16] = new ChanceCards(reader.readLine(), CardType.GOTOJAIL, 10);
			for (int j = 17; j <= 38; j++) {
				this.cards[j] = new ChanceCards(reader.readLine(), CardType.MONEYCHANGEBANK, moneychangebank[j - 17]);
			}
			this.cards[39] = new ChanceCards(reader.readLine(), CardType.RECIEVEMONEYPLAYERS, 200);
			this.cards[40] = new ChanceCards(reader.readLine(), CardType.RECIEVEMONEYPLAYERS, 500);
			this.cards[41] = new ChanceCards(reader.readLine(), CardType.RECIEVEMONEYPLAYERS, 500);
			this.cards[42] = new ChanceCards(reader.readLine(), CardType.PAYOIL, 500);
			this.cards[43] = new ChanceCards(reader.readLine(), CardType.PAYOIL, 800);
			this.cards[44] = new ChanceCards(reader.readLine(), CardType.MATADORLEGAT, 40000);
			ShuffleDeck();
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String DrawCard() {
		int cardcounter = 0;

		CardType cardType = this.cards[cardcounter].getCardType();

		int value = this.cards[cardcounter].getValue();

		// this.cards[cardcounter].CheckCard(cardType, value);

		cardcounter++;
		if (cardcounter == 46) {
			cardcounter = 0;
			ShuffleDeck();
		}

		return this.cards[cardcounter - 1].getText();
	}

	public void ShuffleDeck() {
		Random random = new Random();
		for (int i = this.cards.length - 1; i > 0; i--) {
			int j = random.nextInt(i);

			ChanceCards temp = this.cards[i];
			this.cards[i] = this.cards[j];
			this.cards[j] = temp;
		}
	}

}
