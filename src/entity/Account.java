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
	 * @param Balance
	 *            The starting balance for all players.
	 * @param defaultBalance
	 *            The default balance set to 30000 that can be changed if necessary.
	 */

	public Account() {
		this.Balance = (this.defaultBalance);
		// balanceCheck();
	}

	/**
	 * Returns the balance as a integer.
	 * 
	 * @param Balance
	 *            The player's current balance
	 * @return The current balance
	 */

	public int getBalance() {
		return this.Balance;
	}

	/**
	 * Sets the balance to something else by adding or subtracting the BalanceLocal
	 * 
	 * @param BalanceLocal
	 *            The amount that needs to be changed from the player's balance.
	 */

	public void addBalance(int BalanceLocal) {
		this.Balance += BalanceLocal;
	}

	/**
	 * Return the balance as a String, with the valuta "kr." at the beginning.
	 * 
	 * @param Balance
	 *            The player's current balance
	 * @return "kr." + The balance
	 */

	public String toString() {
		return "kr. " + Integer.toString(this.Balance);
	}
}
