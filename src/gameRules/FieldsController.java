package gameRules;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;

import boundry.MatadorGUI;
import entity.PlayerList;

/**
 * Provides an array with all the fields on the gameboard that can handle buying a field,
 * returning the field buying price, and checking what player owns what field.
 *
 */
public class FieldsController {
	
	int[] fields = new int[40];
	int[] fieldOwned = new int[40];
	int[] fieldRent = new int[40];
	String file = "src/gameRules/fieldsText.txt";
	private PlayerList player;
	
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
	
	public int getRent(int rentField) {
		return this.fieldRent[rentField];
	}
	
	public void setDoubleRent(int rentField) {
		this.fieldRent[rentField] *= 2;
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
	
	public void payForField() {
		int price = getPrice(this.player.getField(this.player.getActivePlayer()));
		player.addBalance(this.player.getActivePlayer(), -price);
		buyField(this.player.getField(this.player.getActivePlayer()), this.player.getActivePlayer());
	}
	
	public void payRent() {
		this.player.addBalance(this.player.getActivePlayer(), -this.getRent(this.player.getField(this.player.getActivePlayer())));
		this.player.addBalance(this.checkFieldOwned(this.player.getField(this.player.getActivePlayer())), this.getRent(this.player.getField(this.player.getActivePlayer())));
	}
	
	public void buyHouse(int field) {	
		switch (field) {
		case 1:case 3:case 6:case 8:case 9:
			this.player.addBalance(player.getActivePlayer(), -1000);
		case 11:case 13:case 14: case 16: case 18: case 19:
			this.player.addBalance(player.getActivePlayer(), -2000);
		case 21:case 23:case 24: case 26: case 27: case 29:
			this.player.addBalance(player.getActivePlayer(), -3000);
		case 31:case 32: case 34: case 37: case 39:
			this.player.addBalance(player.getActivePlayer(), -4000);
		}
	}
	
	public void checkAllOwned(int player) {
	while (checkFieldOwned(1) == player && checkFieldOwned(3) == player) {
		this.setDoubleRent(1); this.setDoubleRent(3);	
	}
	while (checkFieldOwned(6) == player && checkFieldOwned(8) == player && checkFieldOwned(9) == player) {
		this.setDoubleRent(6); this.setDoubleRent(8); this.setDoubleRent(9);
	}
	while (checkFieldOwned(11) == player && checkFieldOwned(13) == player && checkFieldOwned(14) == player) {
		this.setDoubleRent(11); this.setDoubleRent(13); this.setDoubleRent(14);
	}
	while (checkFieldOwned(16) == player && checkFieldOwned(18) == player && checkFieldOwned(19) == player) {
		this.setDoubleRent(16); this.setDoubleRent(18); this.setDoubleRent(19);
	}
	while (checkFieldOwned(21) == player && checkFieldOwned(23) == player && checkFieldOwned(24) == player) {
		this.setDoubleRent(21); this.setDoubleRent(23); this.setDoubleRent(24);
	}
	while (checkFieldOwned(26) == player && checkFieldOwned(27) == player && checkFieldOwned(29) == player) {
		this.setDoubleRent(26); this.setDoubleRent(27); this.setDoubleRent(29);
	}
	while (checkFieldOwned(31) == player && checkFieldOwned(32) == player && checkFieldOwned(34) == player) {
		this.setDoubleRent(31); this.setDoubleRent(32); this.setDoubleRent(34);
	}
	while (checkFieldOwned(37) == player && checkFieldOwned(39) == player) {
		this.setDoubleRent(37); this.setDoubleRent(39);
	}
	
	
	
	
	}

}
