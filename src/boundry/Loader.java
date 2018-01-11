package boundry;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Loader {
	String[][] fields = new String[40][6];

	String file = "src/Boundry/fields.txt";

	/**
	 * Constructs a String[40][6] with all the fields and their values from a .txt
	 * file on disk. All values of i at j = 0 is type of field. Then name, name +
	 * basevalue (if basevalue != 0), information about the field, basevalue, color.
	 * 
	 * @throws IOException
	 *             if a file is not found.
	 */
	public Loader() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(this.file));

		for (int i = 0; i < this.fields.length; i++) {
			String tempLine = reader.readLine();
			int progress = 0;

			for (int j = 0; j < this.fields[i].length; j++)
				this.fields[i][j] = "";

			for (int j = 0; j < tempLine.length(); j++) {
				char currChar = tempLine.charAt(j);
				if (currChar == ',')
					progress++;
				else
					this.fields[i][progress] += currChar;
			}
		}
		reader.close();
	}

	/**
	 * Returns the entire String[][] containing all information about the fields
	 * that is made in the constructor.
	 * 
	 * @return the String[][] fields.
	 */

	public String[][] getFields() {
		return this.fields;
	}

}
