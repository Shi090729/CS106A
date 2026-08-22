/*
 * File: Hangman.java
 * ------------------
 * Plays the Hangman word-guessing game.
 */

import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

public class Hangman extends ConsoleProgram {

    private static final int MAX_INCORRECT_GUESSES = 8;

    private HangmanLexicon lexicon;
    private HangmanCanvas canvas;

    public void init() {
        canvas = new HangmanCanvas();
        add(canvas);
    }

    public void run() {
        lexicon = new HangmanLexicon();
        println("Welcome to Hangman!");
        playGame(chooseSecretWord());
    }

    private String chooseSecretWord() {
        int index = RandomGenerator.getInstance().nextInt(
                0, lexicon.getWordCount() - 1);
        return lexicon.getWord(index);
    }

    private void playGame(String secretWord) {
        String guessedLetters = "";
        int incorrectGuesses = 0;
        canvas.reset();

        while (incorrectGuesses < MAX_INCORRECT_GUESSES
                && !isSolved(secretWord, guessedLetters)) {
            String visibleWord = maskWord(secretWord, guessedLetters);
            canvas.displayWord(visibleWord);
            println("The word now looks like: " + visibleWord);
            println("You have "
                    + (MAX_INCORRECT_GUESSES - incorrectGuesses)
                    + " guesses left.");

            char guess = readGuess();
            if (secretWord.indexOf(guess) >= 0) {
                if (guessedLetters.indexOf(guess) == -1) {
                    guessedLetters += guess;
                    println("That guess is correct.");
                }
            } else {
                guessedLetters += guess;
                incorrectGuesses++;
                canvas.noteIncorrectGuess(guess);
                println("There are no " + guess + "'s in the word.");
            }
        }

        canvas.displayWord(maskWord(secretWord, guessedLetters));
        if (isSolved(secretWord, guessedLetters)) {
            println("You guessed the word: " + secretWord);
        } else {
            println("You're completely hung. The word was "
                    + secretWord + ".");
        }
    }

    private char readGuess() {
        while (true) {
            String input = readLine("Your guess: ").trim().toUpperCase();
            if (input.length() == 1
                    && Character.isLetter(input.charAt(0))) {
                return input.charAt(0);
            }
            println("Please guess a single letter.");
        }
    }

    private String maskWord(String word, String guessedLetters) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (guessedLetters.indexOf(letter) >= 0) {
                result.append(letter);
            } else {
                result.append('-');
            }
        }
        return result.toString();
    }

    private boolean isSolved(String word, String guessedLetters) {
        return maskWord(word, guessedLetters).indexOf('-') == -1;
    }
}
