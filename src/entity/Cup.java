package entity;

/**
 * Provides a six-sided die with methods for rolling the die, and returning the
 * faceup value of the die.
 */
public class Cup {
	private int eyes;
	private boolean doubles;
	private int dice, dice2;

	/**
	 * Sets the value of the die to a random number from [1,2,3,4,5,6]
	 * 
	 * @see Cup#dice()
	 * @param eyes
	 *            The current faceup-value of the die
	 */

	public void rollCup() {
		dice = dice();
		dice2 = dice2();
		this.eyes = dice + dice2;
	}

	/**
	 * Returns the current faceup-value of the die
	 * 
	 * @param eyes
	 *            The current faceup-value
	 * @return The current faceup-value of the die
	 */

	public int getEyes() {
		return this.eyes;
	}

	/**
	 * Returns a pseudorandom number from [1,2,3,4,5,6] with Math.random
	 * The method is only used in the Cup.rollCup() method
	 * 
	 * @return A number from 1 to 6.
	 */

	private int dice() {
		return (int) ((Math.random() * 6) + 1);
	}
	
	private int dice2() {
		return (int) ((Math.random() * 6) + 1);
	}
	
	public int getDice() {
		return dice;
	}

	public int getDice2() {
		return dice2;
	}
	
	public void setDoubles(boolean doubles) {
		this.doubles = doubles;
	}
	
	public boolean getDoubles() {
		return doubles;
	}
	
	public void isDoubles(int d1, int d2) {
		if(dice == dice2) {
			doubles = true;
		}
		else {
			doubles = false;
		}
	}
	
}
