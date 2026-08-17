/*
 * File: HangmanCanvas.java
 * ------------------------
 * This file keeps track of the Hangman display.
 */

import acm.graphics.*;

public class HangmanCanvas extends GCanvas {
	private int errors;
	private String bad = "";
	private GLabel wordLabel;
	private GLabel incorrectLabel;

/** Resets the display so that only the scaffold appears */
	public void reset() {
		removeAll(); errors=0; bad=""; wordLabel=null; incorrectLabel=null;
		add(new GLine(40, 390, 220, 390)); add(new GLine(130,390,130,40));
		add(new GLine(130,40,274,40)); add(new GLine(274,40,274,58));
	}

/**
 * Updates the word on the screen to correspond to the current
 * state of the game.  The argument string shows what letters have
 * been guessed so far; unguessed letters are indicated by hyphens.
 */
	public void displayWord(String word) {
		if(wordLabel != null) remove(wordLabel); wordLabel = new GLabel(word, 300, 350); add(wordLabel);
	}

/**
 * Updates the display to correspond to an incorrect guess by the
 * user.  Calling this method causes the next body part to appear
 * on the scaffold and adds the letter to the list of incorrect
 * guesses that appears at the bottom of the window.
 */
	public void noteIncorrectGuess(char letter) {
		bad += letter; if(incorrectLabel != null) remove(incorrectLabel); incorrectLabel = new GLabel("Incorrect guesses: " + bad, 300, 390); add(incorrectLabel);
		drawPart(errors++);
	}
	private void drawPart(int n) {
		double x=274, y=94;
		switch(n) {
		case 0: add(new GOval(x-HEAD_RADIUS,y-HEAD_RADIUS,2*HEAD_RADIUS,2*HEAD_RADIUS)); break;
		case 1: add(new GLine(x,y+HEAD_RADIUS,x,y+HEAD_RADIUS+BODY_LENGTH)); break;
		case 2: add(new GLine(x,y+ARM_OFFSET_FROM_HEAD,x-UPPER_ARM_LENGTH,y+ARM_OFFSET_FROM_HEAD+LOWER_ARM_LENGTH)); break;
		case 3: add(new GLine(x,y+ARM_OFFSET_FROM_HEAD,x+UPPER_ARM_LENGTH,y+ARM_OFFSET_FROM_HEAD+LOWER_ARM_LENGTH)); break;
		case 4: add(new GLine(x,y+HEAD_RADIUS+BODY_LENGTH,x-HIP_WIDTH,y+HEAD_RADIUS+BODY_LENGTH+LEG_LENGTH)); break;
		case 5: add(new GLine(x,y+HEAD_RADIUS+BODY_LENGTH,x+HIP_WIDTH,y+HEAD_RADIUS+BODY_LENGTH+LEG_LENGTH)); break;
		case 6: add(new GLine(x-HIP_WIDTH,y+HEAD_RADIUS+BODY_LENGTH+LEG_LENGTH,x-HIP_WIDTH-FOOT_LENGTH,y+HEAD_RADIUS+BODY_LENGTH+LEG_LENGTH)); break;
		case 7: add(new GLine(x+HIP_WIDTH,y+HEAD_RADIUS+BODY_LENGTH+LEG_LENGTH,x+HIP_WIDTH+FOOT_LENGTH,y+HEAD_RADIUS+BODY_LENGTH+LEG_LENGTH)); break;
		}
	}

/* Constants for the simple version of the picture (in pixels) */
	private static final int SCAFFOLD_HEIGHT = 360;
	private static final int BEAM_LENGTH = 144;
	private static final int ROPE_LENGTH = 18;
	private static final int HEAD_RADIUS = 36;
	private static final int BODY_LENGTH = 144;
	private static final int ARM_OFFSET_FROM_HEAD = 28;
	private static final int UPPER_ARM_LENGTH = 72;
	private static final int LOWER_ARM_LENGTH = 44;
	private static final int HIP_WIDTH = 36;
	private static final int LEG_LENGTH = 108;
	private static final int FOOT_LENGTH = 28;

}
