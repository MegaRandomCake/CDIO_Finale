package entity;

/**
 * Provides a player for the entity.PlayerList class that can handle the action
 * of creating players with a name and an account, checking whenever the game is
 * over, printing the player's balance as a String and using methods from the
 * entity.Account class.
 * 
 */
public class Player {
	private Account account;
	private String name;
	private int field;

	/**
	 * Constructs a player with an account and a name.
	 * 
	 * @param account The starting balance for the player.
	 * @param name The player's name.
	 * @param field The fieldnumber in the field array. "Start" is the first field at 0 and the last field is at 39.
	 */

	public Player() {
		this.account = new Account();
		this.name = "";
		this.field = 0;
	}

	/**
	 * Sets the player's name to the String input.
	 * 
	 * @param name
	 *            The player's name.
	 */

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the name of the player.
	 * 
	 * @return The player's name.
	 */

	public String getName() {
		return this.name;
	}

	/**
	 * @see Account#getBalance()
	 * @return The current balance
	 */

	public int getBalance() {
		return this.account.getBalance();
	}

	/**
	 * Adds a value to the player's account.
	 * 
	 * @see Account#addBalance()
	 * 
	 * @param value
	 *            A value that will be added to the balance.
	 */

	public void addBalance(int value) {
		this.account.addBalance(value);
	}

	/**
	 * Returns the player's name along with their current balance on their account
	 * as a String
	 * 
	 * @param name
	 *            The player's name
	 * @param account
	 *            The player's current balance
	 * 
	 * @return "player " + name + " has " + account + " in their bank."
	 */

	public String toString() {
		return "player " + this.name + " has " + this.account + " in their bank.";
	}

	/**
	 * Sets the fieldnumber to another number.
	 * 
	 * @param field
	 *            The fieldnumber in the field array. "Start" is the first field at 0 and the last field is at 39.
	 */

	public void setField(int field) {
		this.field = field;
	}

	/**
	 * Returns the current field
	 * 
	 * @param field
	 *            The fieldnumber in the field array. "Start" is the first field at 0 and the last field is at 39.
	 */
	public int getField() {
		return this.field;
	}

	/**
	 * Sets the fieldnumber for when the player have rolled the die and needs to go
	 * to another space.
	 * 
	 * @param field
	 *            The fieldnumber in the field array. "Start" is the first field at 0 and the last field is at 39.
	 * @param eyes
	 *            The faceup-value on the die.
	 */

	public void addToField(int eyes) {
		int move = this.field + eyes;
		this.field = move % 40;
		this.account.addBalance(4000*(move / 40));
	}
}
