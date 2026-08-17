/*
 * File: Hailstone.java
 * Name: Shi090729
 * Section Leader: Independent study
 * --------------------
 * This file is the starter file for the Hailstone problem.
 */

import acm.program.*;

public class Hailstone extends ConsoleProgram {
	public void run() {
		int number = readPositiveInteger();
		int steps = 0;

		while (number != 1) {
			if (number % 2 == 0) {
				int next = number / 2;
				println(number + " is even, so I take half: " + next);
				number = next;
			} else {
				int next = 3 * number + 1;
				println(number + " is odd, so I make 3n + 1: " + next);
				number = next;
			}
			steps++;
		}

		println("The process took " + steps + " to reach 1.");
	}

	/* Reads again until the user supplies a positive integer. */
	private int readPositiveInteger() {
		int number = readInt("Enter a number: ");
		while (number <= 0) {
			println("Please enter a positive integer.");
			number = readInt("Enter a number: ");
		}
		return number;
	}
}
