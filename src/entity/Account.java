package entity;

/**
 * Provides an account for the entity.Player class that can handle getting,
 * checking and adding/subtracting from the account.
 */

public class Account {

	int Balance, defaultBalance = 30000;

	/**
	 * Constructs an account with a balance based on the number of players.
	 * 
	 * @param i
	 *            The number of players.
	 * @param Balance
	 *            The starting balance for all players.
	 * @param defaultBalance
	 *            A number set to 20 that can be changed if necessary
	 */

	public Account(int i) {
		this.Balance = (this.defaultBalance);
		// balanceCheck();
	}

	/**
	 * Returns the balance as a integer, this method will be expanded in the
	 * entity.Player class.
	 * 
	 * @param Balance
	 *            The player's current balance
	 * @return The current balance
	 */

	public int getBalance() {
		return this.Balance;
	}

	/**
	 * Sets the balance to something else by adding or subtracting
	 * 
	 * @param BalanceLocal
	 *            The amount that needs to be changed from the player's balance.
	 */

	public void addBalance(int BalanceLocal) {
		this.Balance += BalanceLocal;
	}

	/**
	 * Return the balance as a String, with the valuta "M$" at the end
	 * 
	 * @param Balance
	 *            The player's current balance
	 * @return The balance + "M$"
	 */

	public String toString() {
		return "kr. " + Integer.toString(this.Balance);
	}
}
