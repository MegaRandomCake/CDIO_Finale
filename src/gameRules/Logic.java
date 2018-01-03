package gameRules;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Logic {
	int[] fields;
	String file = "src/gameRules/fieldsText.txt";

	public Logic() throws IOException {
		try (Stream<String> stream = Files.lines(Paths.get(this.file))) {
	        stream.forEach(System.out::println);
	}

	}
}
