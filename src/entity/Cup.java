package entity;

/**
 * Provides a six-sided die with metods for rolling the die, and returning the
 * faceup value of the die. This class should only be imported from the
 * controller.Controller class
 */
public class Cup {
	private int eyes;

	/**
	 * Sets the value of the die to a random number from [1,2,3,4,5,6]
	 * 
	 * @see Cup#Dice()
	 * @param eyes
	 *            The current faceup-value of the die
	 */

	public void rollCup() {
		this.eyes = Dice();
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
	 * Returns a pseudorandom number from [1,2,3,4,5,6] with Math.random The method
	 * is only used in the Cup.rollCup() method
	 * 
	 * @return A number from 1 to 6.
	 */

	private int Dice() {
		return (int) ((Math.random() * 6) + 1);
	}
}
