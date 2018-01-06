package entity;

public class ChanceCards {
	private int value;
	public PlayerList spiller;
	private CardType cardType;
	private String text;
	
	public ChanceCards(String text, CardType cardType, int value) {
		this.setText(text);
		this.setCardType(cardType);
		this.setValue(value);
	}
	
	public void CheckCard(CardType cardType, int value) {
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

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public CardType getCardType() {
		return cardType;
	}

	public void setCardType(CardType cardType) {
		this.cardType = cardType;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
