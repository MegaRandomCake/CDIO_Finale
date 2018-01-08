package test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DiceTest {
	int testRolls, errorRoof, diceSides;
	entity.Cup test;

	@Before
	public void setop() throws Exception {
		test = new entity.Cup();
	}

	@After
	public void tearDown() throws Exception {
		// testRolls = 0;
	}

	@Test
	void test() {
		testRolls = 10000; // times the test rolls per side on the dice used (this helps ensure the
							// randomness is thoughly tested)
		errorRoof = 2; // we guarantee 2% error roof with testrolls above 10000. 1% will mostly be true
						// too, but no guaranteed.
		entity.Cup test = new entity.Cup();
		diceSides = 6;
		testRolls = testRolls * diceSides;
		int[][] result = new int[3][];
		double[] expected_val = new double[diceSides * 2 - 1];
		expected_calc(expected_val);
		result[0] = new int[diceSides * 2 - 1];
		result_init(result);
		dice_Roller(test, result);
		double[] diviation = new double[] { 0, 0, 0 };
		for (int i = 0; i < result[0].length; i++) {
			System.out.println(i + 2 + " was rolled: " + result[0][i] + " times, with an expectation of "
					+ Math.round(expected_val[i] / 100 * testRolls * 100) / 100 + ", and a diviation of "
					+ Math.round(Math.abs(result[0][i] - expected_val[i] / 100 * testRolls)));
			diviation[0] += (Math.abs(result[0][i] - expected_val[i] / 100 * testRolls));
		}
		System.out.println("diviation on 2d" + diceSides + " is: " + Math.round(diviation[0] * 100) / 100 + "/"
				+ testRolls * errorRoof / 100);
		for (int i = 0; i < diceSides; i++) {
			System.out.println(i + 1 + " was rolled " + result[1][i] + " times by d1 with a diviation of "
					+ Math.abs(result[1][i] + -testRolls / diceSides) + " and " + result[2][i]
					+ " times by d2, with a diviation of " + Math.abs(result[2][i] + -testRolls / diceSides));
			for (int j = 1; j < result.length; j++)
				diviation[j] += Math.abs(result[j][i] + -testRolls / diceSides);
		}
		for (int i = 1; i < diviation.length; i++)
			System.out.println("diviation on d" + i + " is: " + diviation[i] + "/" + testRolls * errorRoof / 100);

		assertEquals(true, diviation[0] < testRolls * errorRoof / 100 && diviation[1] < testRolls / errorRoof
				&& diviation[2] < testRolls / errorRoof);
	}

	private void dice_Roller(entity.Cup test, int[][] result) {
		for (int i = 0; i < testRolls; i++) {
			result[0][test.rollCup()-2]++;
			for (int j = 1; j < result.length; j++)
				result[j][test.getEyes(j) - 1]++;
		}
	}

	private void result_init(int[][] result) {
		for (int i = 1; i < result.length; i++) {
			result[i] = new int[diceSides];
			for (@SuppressWarnings("unused")
			int j : result[i]) // warning suppressed as calling the loop will initialise result [i][j] so there
								// is no need to actually "use" j.
				;

		}
	}

	private void expected_calc(double[] expected_val) {
		for (int i = 0; i < diceSides; i++)
			for (int j = 0; j < diceSides; j++) {
				expected_val[i + j] += 100 / Math.pow(diceSides, 2);
			}
	}

}