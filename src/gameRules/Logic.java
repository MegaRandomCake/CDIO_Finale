package gameRules;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Logic {
	/**
	 * 
	 */
	int[] fields = new int[40];
	int[] fieldOwned = new int[40];
	String file = "src/gameRules/fieldsText.txt";

	public Logic() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(this.file));
		for (int i = 0; i < this.fields.length; i++) {
			this.fields[i] = Integer.parseInt(reader.readLine());
			this.fieldOwned[i] = 0;
		}
		reader.close();

	}

	public String toString() {
		String out = "";
		for (int i = 0; i < this.fields.length; i++) {
			out += (1 + i + " " + this.fields[i]);
			if (this.fieldOwned[i] != 0)
				out += " " + this.fieldOwned[i];
			out += "\n";
		}
		return out;
	}

	public int getPrice(int newField) {
		return this.fields[newField];
	}

	public int checkFieldOwned(int field) {
		return this.fieldOwned[field] - 1;
	}

	public void buyField(int field, int player) {
		this.fieldOwned[field] = player + 1;
	}

}
