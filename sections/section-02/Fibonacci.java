/*
 * File: Fibonacci.java
 * --------------------
 * Prints Fibonacci terms that are less than 10,000.
 */

import acm.program.*;

public class Fibonacci extends ConsoleProgram {
	public void run() {
		println("This program lists the Fibonacci sequence.");
		int previous = 0;
		int current = 1;

		while (previous < MAX_TERM_VALUE) {
			println(previous);
			int next = previous + current;
			previous = current;
			current = next;
		}
	}

	private static final int MAX_TERM_VALUE = 10000;
}
