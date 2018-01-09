package gameRules;

import java.io.IOException;

public class GameRulesController {
	private String gameText;
	private String centerText;
	private int moveFields;
	private int moveToFields;
	private int addAPBalance;
	private int addNAPBalance;
	private FieldsController fields;

	public GameRulesController() {
		try {
			this.fields = new FieldsController();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.gameText = "text in the top corner";
		this.centerText = "text in the center";

	}

	public Object[] getArray(int newField) {
		checkField(newField);
		Object[] out = new Object[6];
		out[0] = this.gameText;
		out[1] = this.centerText;
		out[2] = this.moveFields;
		out[3] = this.moveToFields;
		out[4] = this.addAPBalance;
		out[5] = this.addNAPBalance;
		return out;
	}

	private void checkField(int newField) {
		this.addAPBalance = -this.fields.getPrice(newField);
	}
	
	private void CheckCard() {
		
	}
}
