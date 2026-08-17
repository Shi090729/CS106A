/*
 * File: RandomCircles.java
 * ------------------------
 * Draws ten randomly sized, positioned, and colored circles.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

public class RandomCircles extends GraphicsProgram {
	public void run() {
		for (int i = 0; i < NUMBER_OF_CIRCLES; i++) {
			double radius = rgen.nextDouble(MIN_RADIUS, MAX_RADIUS);
			double diameter = 2 * radius;
			double x = rgen.nextDouble(0, getWidth() - diameter);
			double y = rgen.nextDouble(0, getHeight() - diameter);

			GOval circle = new GOval(x, y, diameter, diameter);
			circle.setFilled(true);
			circle.setColor(rgen.nextColor());
			add(circle);
		}
	}

	private static final int NUMBER_OF_CIRCLES = 10;
	private static final double MIN_RADIUS = 5;
	private static final double MAX_RADIUS = 50;

	private RandomGenerator rgen = RandomGenerator.getInstance();
}
