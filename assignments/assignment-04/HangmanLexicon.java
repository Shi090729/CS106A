/*
 * File: HangmanLexicon.java
 * -------------------------
 * This file contains a stub implementation of the HangmanLexicon
 * class that you will reimplement for Part III of the assignment.
 */

import acm.util.*;
import java.io.*;
import java.util.*;

public class HangmanLexicon {
	private ArrayList<String> words = new ArrayList<String>();

	public HangmanLexicon() {
		try {
			Scanner scanner = new Scanner(new File("HangmanLexicon.txt"));
			while (scanner.hasNextLine()) {
				String word = scanner.nextLine().trim();
				if (!word.isEmpty()) words.add(word.toUpperCase());
			}
			scanner.close();
		} catch (FileNotFoundException ex) {
			throw new ErrorException("Unable to read HangmanLexicon.txt");
		}
	}

/** Returns the number of words in the lexicon. */
	public int getWordCount() {
		return words.size();
	}

/** Returns the word at the specified index. */
	public String getWord(int index) {
		if (index < 0 || index >= words.size()) throw new ErrorException("getWord: Illegal index");
		return words.get(index);
	};
}
