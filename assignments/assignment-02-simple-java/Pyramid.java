/*
 * File: Pyramid.java
 * Name: Shi090729
 * Section Leader: Independent study
 * ------------------
 * This file is the starter file for the Pyramid problem.
 * It includes definitions of the constants that match the
 * sample run in the assignment, but you should make sure
 * that changing these values causes the generated display
 * to change accordingly.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Pyramid extends GraphicsProgram {

	/** Width of each brick in pixels */
	private static final int BRICK_WIDTH = 30;

	/** Height of each brick in pixels */
	private static final int BRICK_HEIGHT = 12;

/** Number of bricks in the base of the pyramid */
	private static final int BRICKS_IN_BASE = 14;

	public void run() {
		for (int row = 0; row < BRICKS_IN_BASE; row++) {
			drawRow(row);
		}
	}

	/* Draws one row, counting upward from the base as row zero. */
	private void drawRow(int row) {
		int bricksInRow = BRICKS_IN_BASE - row;
		double rowWidth = bricksInRow * BRICK_WIDTH;
		double startX = (getWidth() - rowWidth) / 2.0;
		double y = getHeight() - (row + 1) * BRICK_HEIGHT;

		for (int brick = 0; brick < bricksInRow; brick++) {
			double x = startX + brick * BRICK_WIDTH;
			add(new GRect(x, y, BRICK_WIDTH, BRICK_HEIGHT));
		}
	}
}
