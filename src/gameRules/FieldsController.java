package gameRules;

import java.io.IOException;

/**
 * field. a field, returning the field buying price, and checking what player
 * owns what Provides an array with all the fields on the gameboard that can
 * handle buying
 *
 */
public class FieldsController {

	private int[] house = new int[40];
	int[] fieldCost = new int[40];
	int[] fieldOwner = new int[40];
	int[][] fieldRent = new int[40][6];
	String file = "src/gameRules/fieldsText.txt";
	private int[] fieldHouseCost = new int[40];
	private int Profit = 0;

	/**
	 * Constructs a new array fields that handles all the buying prices which is
	 * read from a text file. Also constructs a new array filedOwned that handles
	 * what player owns what field.
	 * 
	 * @param strings
	 * 
	 * @throws IOException
	 */

	public FieldsController(String[][] strings) throws IOException {
		for (int i = 0; i < strings.length; i++) {
			this.fieldOwner[i] = -1;
			this.fieldCost[i] = Integer.parseInt(strings[i][0]);
			this.fieldHouseCost[i] = Integer.parseInt(strings[i][1]);
			for (int j = 2; j < strings[i].length; j++) {
				this.fieldRent[i][j - 2] = Integer.parseInt(strings[i][j]);
			}
		}
	}

	// BufferedReader reader = new BufferedReader(new FileReader(this.file));
	// for (int i = 0; i < this.fields.length; i++) {
	// String tempLine = reader.readLine();
	// this.house[i] = 0;
	// this.fieldOwned[i] = -1;
	// int progress = 0;
	// for (int j = 0; j < tempLine.length(); j++) {
	// char currChar = tempLine.charAt(j);
	// if (currChar == ',')
	// progress++;
	// else
	// this.fields[i][progress] += currChar;
	// }
	// }
	// reader.close();

	/**
	 * Returns a list of all the field with their number on the gameboard, buying
	 * price and their current owner.
	 * 
	 * @return List with all field, price and their owners.
	 */

	public String toString() {
		String out = "";
		for (int i = 0; i < this.fieldCost.length; i++) {
			out += (1 + i + " " + this.fieldCost[i]);
			if (this.fieldOwner[i] != 0)
				out += " " + this.fieldOwner[i];
			out += "\n";
		}
		return out;
	}

	/**
	 * Return the buying price for acquiring a field.
	 * 
	 * @param newField
	 * @return The price of a field.
	 */

	public int getPrice(int newField, int activePlayer) {

		if (this.fieldOwner[newField] < 0) {
			System.out.println(
					activePlayer + " is the new owner of field " + newField + " for " + this.fieldCost[newField]);
			this.fieldOwner[newField] = activePlayer;
			return -this.fieldCost[newField];
		} else if (this.fieldOwner[newField] >= 0) {
			if(this.house[newField]<6)
			this.house[newField]++;
			System.out.println(this.getRent(newField) + " is the price for field" + newField);
			this.Profit = this.getRent(newField);
			return -this.getRent(newField);
		}
		return 0;
	}

	public int getProfit() {
		return this.Profit;
	}

	public int getRent(int rentField) {
		return this.fieldRent[rentField][this.house[rentField]];
	}

	/**
	 * Returns the playernumber that owns the field. The player's playernumber is
	 * their indexnumber in the players[] + 1.
	 * 
	 * @param field
	 *            The fieldnumber in the field array. "Start" is the first field at
	 *            0 and the last field is at 39.
	 * @return The player that owns the field.
	 */

	public int getFieldOwner(int field) {
		return this.fieldOwner[field] - 1;
	}

	public boolean getFieldOwned(int field) {
		return this.fieldOwner[field] >= 0;
	}

	/**
	 * Sets a fields number in the fieldOwned[] to the playernumber of the player
	 * that is buying the field.
	 * 
	 * @param field
	 *            The fieldnumber in the field array. "Start" is the first field at
	 *            0 and the last field is at 39.
	 * @param player
	 *            The player that is buying the field. The player's playernumber is
	 *            their indexnumber in the players[] + 1.
	 */

	public void buyField(int field, int player) {
		this.fieldOwner[field] = player + 1;
	}

	public int getOwner(int newField) {
		return this.getFieldOwner(newField);
	}




}
