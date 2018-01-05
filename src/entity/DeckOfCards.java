package entity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DeckOfCards {
	
	public static void main(String[] args) throws IOException {
		String file = "src/entity/Cards.txt";
		BufferedReader reader = new BufferedReader(new FileReader(file));
		
			ChanceCards[] cards = new ChanceCards[45];
			
			cards[0] = new ChanceCards(reader.readLine(), CardType.MOVESPACES, 3);
			cards[1] = cards[0];
			cards[2] = new ChanceCards(reader.readLine(), CardType.MOVESPACES, -3);
			cards[3] = new ChanceCards(reader.readLine(), CardType.MOVEFIELD, 0);
			cards[4] = cards[3];
			cards[5] = new ChanceCards(reader.readLine(), CardType.MOVEFIELD, 24);
			cards[6] = new ChanceCards(reader.readLine(), CardType.MOVEFIELD, 11);
			cards[7] = new ChanceCards(reader.readLine(), CardType.MOVEFIELD, 19);
			cards[8] = new ChanceCards(reader.readLine(), CardType.MOVEFIELD, 32);
			cards[9] = new ChanceCards(reader.readLine(), CardType.MOVEFIELD, 15);
			cards[10] = new ChanceCards(reader.readLine(), CardType.MOVEFIELD, 39);
			cards[11] = new ChanceCards(reader.readLine(), CardType.MOVESHIP, 1);
			cards[12] = cards[11];
			cards[13] = new ChanceCards(reader.readLine(), CardType.KINGSBIRTHDAY, 40);
			cards[14] = cards[13];
			cards[15] = new ChanceCards(reader.readLine(), CardType.GOTOJAIL, 10);
			cards[16] = cards[15];
			cards[17] = new ChanceCards(reader.readLine(), CardType.MONEYCHANGEBANK, 500);
			cards[18] = cards[17];
			cards[19] = new ChanceCards(reader.readLine(), CardType.MONEYCHANGEBANK, 200);
			cards[20] = new ChanceCards(reader.readLine(), CardType.MONEYCHANGEBANK, 3000);
			for(int i = 21; i <= 28; i++) {
				cards[i] = new ChanceCards(reader.readLine(), CardType.MONEYCHANGEBANK, 1000);
			}
			cards[29] = new ChanceCards(reader.readLine(), CardType.RECIEVEMONEYPLAYERS, 200);
			cards[30] = new ChanceCards(reader.readLine(), CardType.RECIEVEMONEYPLAYERS, 500);
			cards[31] = new ChanceCards(reader.readLine(), CardType.RECIEVEMONEYPLAYERS, 500);
			cards[32] = new ChanceCards(reader.readLine(), CardType.MONEYCHANGEBANK, -200);
			cards[33] = new ChanceCards(reader.readLine(), CardType.MONEYCHANGEBANK, -200);
			cards[34] = new ChanceCards(reader.readLine(), CardType.MONEYCHANGEBANK, -300);
			cards[35] = new ChanceCards(reader.readLine(), CardType.MONEYCHANGEBANK, -1000);
			cards[36] = new ChanceCards(reader.readLine(), CardType.MONEYCHANGEBANK, -1000);
			cards[37] = new ChanceCards(reader.readLine(), CardType.MONEYCHANGEBANK, -2000);
			cards[38] = new ChanceCards(reader.readLine(), CardType.MONEYCHANGEBANK, -3000);
			cards[39] = cards[38];
			cards[40] = new ChanceCards(reader.readLine(), CardType.MONEYCHANGEBANK, -200);
			cards[41] = new ChanceCards(reader.readLine(), CardType.MONEYCHANGEBANK, -1000);
			cards[42] = new ChanceCards(reader.readLine(), CardType.PAYOIL, 500);
			cards[43] = new ChanceCards(reader.readLine(), CardType.PAYOIL, 800);
			cards[44] = new ChanceCards(reader.readLine(), CardType.MATADORLEGAT, 40000);
		
		
		for(int i = 0; i<cards.length;i++){
			System.out.println(cards[i].toString());
		}
		
		reader.close();
		
	}

}
