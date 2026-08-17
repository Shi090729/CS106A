/*
 * File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.awt.*;

public class Hangman extends ConsoleProgram {
	private HangmanLexicon lexicon;
	private HangmanCanvas canvas;

    public void run() {
		lexicon = new HangmanLexicon();
		canvas = new HangmanCanvas();
		add(canvas, EAST);
		println("Welcome to Hangman!");
		String secret = lexicon.getWord(RandomGenerator.getInstance().nextInt(lexicon.getWordCount()));
		String guessed = "";
		int wrong = 0;
		canvas.reset();
		while (wrong < 8 && !isSolved(secret, guessed)) {
			String view = mask(secret, guessed);
			canvas.displayWord(view);
			println("The word now looks like: " + view);
			println("You have " + (8 - wrong) + " guesses left.");
			String input = readLine("Your guess: ").trim().toUpperCase();
			if (input.length() != 1 || !Character.isLetter(input.charAt(0))) { println("Please guess a single letter."); continue; }
			char c = input.charAt(0);
			if (guessed.indexOf(c) >= 0) { println("You already guessed that letter."); continue; }
			guessed += c;
			if (secret.indexOf(c) >= 0) println("That guess is correct.");
			else { wrong++; canvas.noteIncorrectGuess(c); println("There are no " + c + "'s in the word."); }
		}
		canvas.displayWord(mask(secret, guessed));
		if (isSolved(secret, guessed)) println("You guessed the word: " + secret);
		else println("You're completely hung. The word was " + secret + ".");
	}
	private String mask(String word, String guessed) { StringBuilder s=new StringBuilder(); for(char c:word.toCharArray()) s.append(guessed.indexOf(c)>=0?c:'-'); return s.toString(); }
	private boolean isSolved(String word, String guessed) { return mask(word, guessed).indexOf('-') < 0; }

}
