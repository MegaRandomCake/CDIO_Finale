package entity;

/**
 * Provides a player for the entity.PlayerList class that can handle the action
 * of creating players with a name and an account, checking whenever the game is
 * over, printing the player's balance as a String and using methods from the
 * entity.Account class.
 * 
 * This class should only be imported from the entity.PlayerList class.
 */
public class Player {
	private Account account;
	private String name;
	private int field;

	/**
	 * Returns a boolean based on the state of the game. As long as a player have
	 * not reached under 0 in their balance, this boolean will be false, otherwise
	 * it will be true.
	 * 
	 * @return <code>true</code> if a player have under 0 in their balance;
	 *         <code>false</code> otherwise.
	 */

	public boolean gameOver() {
		if (this.account.getBalance() < 0)
			return true;
		return false;
	}

	/**
	 * Constructs a player with an account and a name.
	 * 
	 * @param account
	 *            The starting balance for the player.
	 * @param name
	 *            The player's name.
	 */

	public Player(int i) {
		this.account = new Account(i);
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
	 *            The fieldnumber. The field "Start is number 0".
	 */

	public void setField(int field) {
		this.field = field;
	}

	/**
	 * Returns the current field
	 * 
	 * @param field
	 *            The fieldnumber. The field "Start" is number 0.
	 */
	public int getField() {
		return this.field;
	}

	/**
	 * Sets the fieldnumber for when the player have rolled the die and needs to go
	 * to another space
	 * 
	 * @param field
	 *            The fieldnumber. The field "Start is number 0".
	 * @param eyes
	 *            The faceup-value on the die.
	 */

	public void addToField(int eyes, int fields) {
		this.field = (this.field + eyes) % fields;
	}
}
