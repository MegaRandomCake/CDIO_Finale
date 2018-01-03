package gameRules;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Logic {
	int[] fields = new int[40];
	String file = "src/gameRules/fieldsText.txt";

	public Logic() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(this.file));
		for(int i=0; i<this.fields.length;i++) {
			this.fields[i] = Integer.parseInt(reader.readLine());
		}
		reader.close();

	}
	public String toString() {
		String out="";
		for(int i = 0; i<this.fields.length;i++) {
			out += (this.fields[i] + "\n"); 
		}
		return out;
	}
	public int getPrice(int newField) {
return this.fields[newField];		
	}
}
