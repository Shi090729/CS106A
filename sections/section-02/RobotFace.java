/*
 * File: RobotFace.java
 * --------------------
 * Draws a centered robot face using simple graphics objects.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class RobotFace extends GraphicsProgram {
	public void run() {
		double headX = (getWidth() - HEAD_WIDTH) / 2.0;
		double headY = (getHeight() - HEAD_HEIGHT) / 2.0;

		drawHead(headX, headY);
		drawEye(headX + HEAD_WIDTH / 4.0, headY + HEAD_HEIGHT / 4.0);
		drawEye(headX + 3 * HEAD_WIDTH / 4.0, headY + HEAD_HEIGHT / 4.0);
		drawMouth(headX, headY);
	}

	private void drawHead(double x, double y) {
		GRect head = new GRect(x, y, HEAD_WIDTH, HEAD_HEIGHT);
		head.setFilled(true);
		head.setColor(Color.BLACK);
		head.setFillColor(Color.GRAY);
		add(head);
	}

	private void drawEye(double centerX, double centerY) {
		double diameter = 2 * EYE_RADIUS;
		GOval eye = new GOval(centerX - EYE_RADIUS,
				centerY - EYE_RADIUS, diameter, diameter);
		eye.setFilled(true);
		eye.setColor(Color.YELLOW);
		add(eye);
	}

	private void drawMouth(double headX, double headY) {
		double x = headX + (HEAD_WIDTH - MOUTH_WIDTH) / 2.0;
		double y = headY + 3 * HEAD_HEIGHT / 4.0 - MOUTH_HEIGHT / 2.0;
		GRect mouth = new GRect(x, y, MOUTH_WIDTH, MOUTH_HEIGHT);
		mouth.setFilled(true);
		mouth.setColor(Color.WHITE);
		add(mouth);
	}

	private static final int HEAD_WIDTH = 100;
	private static final int HEAD_HEIGHT = 150;
	private static final int EYE_RADIUS = 10;
	private static final int MOUTH_WIDTH = 60;
	private static final int MOUTH_HEIGHT = 20;
}
