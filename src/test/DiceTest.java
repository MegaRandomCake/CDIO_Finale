package test;

import static org.junit.Assert.assertEquals;

import java.text.DecimalFormat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DiceTest {
	entity.Cup cup;

	@Before
	public void setop() throws Exception {
		this.cup = new entity.Cup();
	}

	@After
	public void tearDown() throws Exception {
		// testRolls = 0;
	}

	@Test
	public void SandsynlighedTest() {
		int[] Resultat = new int[12];
		DecimalFormat df = new DecimalFormat("####0.00");
		double[] Sandsynlighederne = new double[] { 2.78, 5.56, 8.33, 11.11, 13.89, 16.67, 13.89, 11.11, 8.33, 5.56,
				2.78, 0 };
		String[] tal = new String[] { "to'ere", "tre'ere", "fire'ere", "fem'ere", "seks'ere", "syv'ere", "otte'ere",
				"ni'ere", "ti'ere", "elleve'ere", "tolv'ere", "fejl" };

		for (int i = 0; i < Resultat.length; i++)
			Resultat[i] = 0;

		for (int i = 1; i < 360000; i++) {
			this.cup.rollCup();
			int[] a = this.cup.getEyes();

			switch (a[0] + a[1]) {
			case (2):
				Resultat[0]++;
				break;
			case (3):
				Resultat[1]++;
				break;
			case (4):
				Resultat[2]++;
				break;
			case (5):
				Resultat[3]++;
				break;
			case (6):
				Resultat[4]++;
				break;
			case (7):
				Resultat[5]++;
				break;
			case (8):
				Resultat[6]++;
				break;
			case (9):
				Resultat[7]++;
				break;
			case (10):
				Resultat[8]++;
				break;
			case (11):
				Resultat[9]++;
				break;
			case (12):
				Resultat[10]++;
				break;
			default:
				Resultat[11]++;
			}
		}

		for (int i = 0; i < Resultat.length; i++) {
			System.out.println("Der blev slået " + Resultat[i] + " " + tal[i] + ", hvilket svarer til "
					+ df.format((Resultat[i] * 100) / 360000.0) + " %");
		}

		System.out.println("\nStatisk set er der 2.78% chance for at slå 2 og 12, 5.56% chance for at slå 3 og 11,"
				+ "8.33% chance for at slå 4 og 10, 11.11% chance for at slå 5 og 9, 13.89% chance for at slå 6 og 8, og 16.67% for at slå 7.\n");

		for (int i = 0; i < Resultat.length; i++) {
			assertEquals(360000 * (Sandsynlighederne[i] / 100), Resultat[i],
					(360000 * (Sandsynlighederne[i] / 100) / 100) * 2);
		}

	}

	@Test
	public void ErTerningenRetfærdig() {

		int[] Resultat = new int[7];
		DecimalFormat df = new DecimalFormat("####0.00");
		String[] tal = new String[] { "en'ere", "to'ere", "tre'ere", "fire'ere", "fem'ere", "seks'ere", "fejl" };

		for (int i = 0; i < Resultat.length; i++)
			Resultat[i] = 0;

		for (int i = 1; i < 100000; i++) {
			int a = this.cup.dice();

			switch (a) {
			case (1):
				Resultat[0]++;
				break;
			case (2):
				Resultat[1]++;
				break;
			case (3):
				Resultat[2]++;
				break;
			case (4):
				Resultat[3]++;
				break;
			case (5):
				Resultat[4]++;
				break;
			case (6):
				Resultat[5]++;
				break;
			default:
				Resultat[6]++;
			}
		}

		for (int i = 0; i < Resultat.length; i++) {
			System.out.println("Der blev slået " + Resultat[i] + " " + tal[i] + ", hvilket svarer til "
					+ df.format((Resultat[i] * 100) / 100000.0) + " %");
		}

		System.out.println("\nStatisk set er chancen 16.67% for at slå alle tal.\n");

		for (int i = 0; i < Resultat.length - 1; i++) {
			assertEquals(100000 * (16.67 / 100), Resultat[i], (100000 * (16.67 / 100) / 100) * 2);
		}
		assertEquals(0, Resultat[6]);
	}

}
