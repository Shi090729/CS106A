/*
 * File: Yahtzee.java
 * ------------------
 * This program will eventually play the Yahtzee game.
 */

import acm.io.*;
import acm.program.*;
import acm.util.*;

public class Yahtzee extends GraphicsProgram implements YahtzeeConstants {

	public static void main(String[] args) {
		new Yahtzee().start(args);
	}

	public void run() {
		IODialog dialog = getDialog();
		nPlayers = dialog.readInt("Enter number of players");
		playerNames = new String[nPlayers];
		for (int i = 1; i <= nPlayers; i++) {
			playerNames[i - 1] = dialog.readLine("Enter name for player " + i);
		}
		display = new YahtzeeDisplay(getGCanvas(), playerNames);
		playGame();
	}

	private void playGame() {
		int[][] scores = new int[nPlayers][N_CATEGORIES];
		for (int round = 0; round < N_SCORING_CATEGORIES; round++) {
			for (int player = 1; player <= nPlayers; player++) {
				int[] dice = new int[N_DICE];
				display.waitForPlayerToClickRoll(player);
				rollAll(dice); display.displayDice(dice);
				for (int reroll = 0; reroll < 2; reroll++) {
					display.waitForPlayerToSelectDice();
					for (int i=0;i<N_DICE;i++) if (display.isDieSelected(i)) dice[i]=rgen.nextInt(1,6);
					display.displayDice(dice);
				}
				int category = display.waitForPlayerToSelectCategory();
				int value = scoreCategory(dice, category);
				scores[player-1][category] = value; display.updateScorecard(category, player, value);
			}
		}
	}
	private void rollAll(int[] dice) { for (int i=0;i<dice.length;i++) dice[i]=rgen.nextInt(1,6); }
	private int scoreCategory(int[] d, int cat) {
		int sum=0; int[] c=new int[7]; for(int v:d){sum+=v;c[v]++;}
		if(cat>=ONES&&cat<=SIXES) return c[cat]*cat;
		if(cat==THREE_OF_A_KIND) return hasAtLeast(c,3)?sum:0;
		if(cat==FOUR_OF_A_KIND) return hasAtLeast(c,4)?sum:0;
		if(cat==FULL_HOUSE) return ((hasCount(c,3)&&hasCount(c,2))?25:0);
		if(cat==SMALL_STRAIGHT) return straight(c,4)?30:0;
		if(cat==LARGE_STRAIGHT) return straight(c,5)?40:0;
		if(cat==YAHTZEE) return hasAtLeast(c,5)?50:0;
		if(cat==CHANCE) return sum;
		return 0;
	}
	private boolean hasAtLeast(int[] c,int n){for(int i=1;i<=6;i++)if(c[i]>=n)return true;return false;}
	private boolean hasCount(int[] c,int n){for(int i=1;i<=6;i++)if(c[i]==n)return true;return false;}
	private boolean straight(int[] c,int n){int run=0;for(int i=1;i<=6;i++){if(c[i]>0)run++;else run=0;if(run>=n)return true;}return false;}

/* Private instance variables */
	private int nPlayers;
	private String[] playerNames;
	private YahtzeeDisplay display;
	private RandomGenerator rgen = new RandomGenerator();

}
