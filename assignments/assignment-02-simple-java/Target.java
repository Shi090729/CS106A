/*
 * File: Target.java
 * Name: Shi090729
 * Section Leader: Independent study
 * -----------------
 * This file is the starter file for the Target problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Target extends GraphicsProgram {
	public void run() {
		addCircle(OUTER_RADIUS, Color.RED);
		addCircle(MIDDLE_RADIUS, Color.WHITE);
		addCircle(INNER_RADIUS, Color.RED);
	}

	/* Adds a filled circle of the given radius at the window center. */
	private void addCircle(double radius, Color color) {
		double diameter = 2 * radius;
		double x = (getWidth() - diameter) / 2.0;
		double y = (getHeight() - diameter) / 2.0;
		GOval circle = new GOval(x, y, diameter, diameter);
		circle.setFilled(true);
		circle.setColor(color);
		add(circle);
	}

	private static final int PIXELS_PER_INCH = 72;
	private static final double OUTER_RADIUS = 1.0 * PIXELS_PER_INCH;
	private static final double MIDDLE_RADIUS = 0.65 * PIXELS_PER_INCH;
	private static final double INNER_RADIUS = 0.3 * PIXELS_PER_INCH;
}
