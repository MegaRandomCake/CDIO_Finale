package entity;

public class ChanceCards {
	private int value;
	private PlayerList spiller;
	private CardType cardType;
	private String text;
	
	public ChanceCards(String text, CardType cardType, int value) {
		this.text = text;
		this.cardType = cardType;
		this.value = value;
	}
	
	public void CheckCard() {
		switch (cardType) {
		case GOTOJAIL:
			spiller.setField(spiller.getActivePlayer(), 10);
			break;
		case KINGSBIRTHDAY:
			break;
		case MATADORLEGAT:
			break;
		case MONEYCHANGEBANK:
			spiller.addBalance(spiller.getActivePlayer(), value);
			break;
		case MOVEFIELD:
			if(spiller.getField(spiller.getActivePlayer()) > value)
				value +=40;
			spiller.addToField(spiller.getActivePlayer(), value - spiller.getField(spiller.getActivePlayer()));
			break;
		case MOVESHIP:
			break;
		case MOVESPACES:
			spiller.addToField(spiller.getActivePlayer(), value);
			break;
		case PAYOIL:
			break;
		case RECIEVEMONEYPLAYERS:
			int i = spiller.activePlayerNr();
			spiller.addBalance(spiller.getActivePlayer(), value * i);
			spiller.takeMoneyAllPlayers(value);
			break;
		}
	}
	
	public String toString() {
		return text;
	}
}
