package entity;

/**
 * Provides a six-sided die with methods for rolling the die, and returning the
 * faceup value of the die.
 */
public class Cup {
	

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
	}

	/**
	 * Returns the current faceup-value of the die
	 * 
	 * @param eyes
	 *            The current faceup-value
	 * @return The current faceup-value of the die
	 */

	public int getEyes() {
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
	
	public void setDoubles(boolean doubles) {
		this.doubles = doubles;
	}
	
	public boolean getDoubles() {
		return doubles;
	}
	
	private void isDoubles() {
		if(dice == dice2) {
			doubles = true;
		}
		else {
			doubles = false;
		}
	}
	
}
