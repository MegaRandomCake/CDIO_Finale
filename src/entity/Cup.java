package entity;

/**
 * Provides a six-sided die with methods for rolling the dice/setting their
 * face-up value, returning the total face-up value of all dice, returning a
 * boolean based on if the dice is alike and returning an array with the face-up
 * value of all dice.
 */

public class Cup {
	private int[] eyes = new int[2];
	boolean doubles = false;
	private int doubleCounter = 0;

	/**
	 * Sets the value of the die to a random number from [1,2,3,4,5,6]
	 * 
	 * @see Cup#dice()
	 * @param eyes
	 *            The current faceup-value of the dice
	 */

	/**
	 * Sets the face-up value of the dice with dice(), the boolean doubles and the
	 * int doubleCounter.
	 * 
	 * @see Cup#dice()
	 * @param eyes
	 *            An int[2] containing the face-up value of the dice.
	 * @param doubles
	 *            A boolean that is <code>true</code> if the dice is alike.
	 * @param doubleCounter
	 *            The number of times a player have rolled 2 alike dice in a row.
	 */

	public void rollCup() {
		for (int i = 0; i < this.eyes.length; i++)
			this.eyes[i] = dice();
		if (this.eyes[0] == this.eyes[1] && this.doubleCounter <= 2) {
			this.doubles = true;
			this.doubleCounter++;
		} else {
			this.doubles = false;
			this.doubleCounter = 0;
		}
	}

	/**
	 * Returns the total face-up value of all dice.
	 * 
	 * @param eyes
	 *            The current faceup-value for a single die.
	 * @return The current faceup-value of the dice
	 */

	public int getSum() {
		int out = 0;
		for (int roll : this.eyes) {
			out += roll;
		}
		return out;
	}

	/**
	 * Returns a pseudorandom number from [1,2,3,4,5,6] with Math.random.
	 * 
	 * @return A number from 1 to 6.
	 */

	public int dice() {
		return (int) ((Math.random() * 6) + 1);
	}

	/**
	 * Returns true if the 2 dice in the eyes[2] have the same face-up value. Else
	 * it will return false.
	 * 
	 * @return <code>true</code> if the 2 dice is alike; <code>false</code>
	 *         otherwise.
	 */

	public boolean getDoubles() {
		return this.doubles;
	}

	/**
	 * Returns the entire eyes[2], where the current face-up value of the dice is
	 * stored.
	 * 
	 * @return the eyes[2].
	 */

	public int[] getEyes() {
		return this.eyes;
	}
}
