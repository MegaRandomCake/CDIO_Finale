package gameRules;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;

/**
 * Provides an array with all the fields on the gameboard that can handle buying a field,
 * returning the field buying price, and checking what player owns what field.
 *
 */
public class FieldsController {
	
	int[] fields = new int[40];
	int[] fieldOwned = new int[40];
	String file = "src/gameRules/fieldsText.txt";
	
	/**
	 * Constructs a new array fields that handles all the buying prices which is read from a text file.
	 * Also constructs a new array filedOwned that handles what player owns what field.
	 * 
	 * @throws IOException
	 */

	public FieldsController() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(this.file));
		for (int i = 0; i < this.fields.length; i++) {
			this.fields[i] = Integer.parseInt(reader.readLine());
			this.fieldOwned[i] = 0;
		}
		reader.close();
	}
	
	/**
	 * Returns a list of all the field with their number on the gameboard, buying price and their current owner. 
	 * 
	 * @return List with all field, price and their owners.
	 */

	public String toString() {
		String out = "";
		for (int i = 0; i < this.fields.length; i++) {
			out += (1 + i + " " + this.fields[i]);
			if (this.fieldOwned[i] != 0)
				out += " " + this.fieldOwned[i];
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

	public int getPrice(int newField) {
		return this.fields[newField];
	}
	
	/**
	 * Returns the playernumber that owns the field.
	 * The player's playernumber is their indexnumber in the players[] + 1.
	 * 
	 * @param field The fieldnumber in the field array. "Start" is the first field at 0 and the last field is at 39.
	 * @return The player that owns the field.
	 */

	public int checkFieldOwned(int field) {
		return this.fieldOwned[field] - 1;
	}
	
	/**
	 * Sets a fields number in the fieldOwned[] to the playernumber of the player that is buying the field.
	 * 
	 * @param field The fieldnumber in the field array. "Start" is the first field at 0 and the last field is at 39.
	 * @param player The player that is buying the field. The player's playernumber is their indexnumber in the players[] + 1.
	 */

	public void buyField(int field, int player) {
		this.fieldOwned[field] = player + 1;
	}

}
