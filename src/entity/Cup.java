package entity;

/**
 * Provides a six-sided die with methods for rolling the die, and returning the
 * faceup value of the die.
 */
public class Cup {
	private int[] eyes = new int[2];
	boolean doubles = false;

	/**
	 * Sets the value of the die to a random number from [1,2,3,4,5,6]
	 * 
	 * @see Cup#dice()
	 * @param eyes
	 *            The current faceup-value of the die
	 */

	public void rollCup() {
		for (int i = 0; i < this.eyes.length; i++)
			this.eyes[i] = dice();
		if (this.eyes[0] == this.eyes[1])
			this.doubles = true;
		else
			this.doubles = false;
	}

	/**
	 * Returns the current faceup-value of the die
	 * 
	 * @param eyes
	 *            The current faceup-value
	 * @return The current faceup-value of the die
	 */

	public int getSum() {
		int out = 0;
		for (int roll : this.eyes) {
			out += roll;
		}
		return out;
	}

	/**
	 * Returns a pseudorandom number from [1,2,3,4,5,6] with Math.random The method
	 * is only used in the Cup.rollCup() method
	 * 
	 * @return A number from 1 to 6.
	 */

	private int dice() {
		return (int) ((Math.random() * 6) + 1);
	}

	public boolean getDoubles() {
		return this.doubles;
	}

	public int[] getEyes() {
		return this.eyes;
	}
}
