/*
 * File: Breakout.java
 * -------------------
 * Implements the classic Breakout game.
 */

import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;
import java.awt.Color;
import java.awt.event.MouseEvent;

public class Breakout extends GraphicsProgram {

    public static final int APPLICATION_WIDTH = 400;
    public static final int APPLICATION_HEIGHT = 600;

    private static final int WIDTH = APPLICATION_WIDTH;
    private static final int HEIGHT = APPLICATION_HEIGHT;

    private static final int PADDLE_WIDTH = 60;
    private static final int PADDLE_HEIGHT = 10;
    private static final int PADDLE_Y_OFFSET = 30;

    private static final int NBRICKS_PER_ROW = 10;
    private static final int NBRICK_ROWS = 10;
    private static final int BRICK_SEP = 4;
    private static final int BRICK_WIDTH =
            (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP)
                    / NBRICKS_PER_ROW;
    private static final int BRICK_HEIGHT = 8;

    private static final int BALL_RADIUS = 10;
    private static final int BRICK_Y_OFFSET = 70;
    private static final int NTURNS = 3;
    private static final double INITIAL_Y_VELOCITY = 3.0;
    private static final int ANIMATION_DELAY = 10;
    private static final int SERVE_DELAY = 500;

    public void run() {
        setUpGame();
        playGame();
    }

    private void setUpGame() {
        createBricks();
        createPaddle();
        addMouseListeners();
    }

    private void createBricks() {
        double rowWidth = NBRICKS_PER_ROW * BRICK_WIDTH
                + (NBRICKS_PER_ROW - 1) * BRICK_SEP;
        double startX = (getWidth() - rowWidth) / 2.0;

        for (int row = 0; row < NBRICK_ROWS; row++) {
            for (int col = 0; col < NBRICKS_PER_ROW; col++) {
                double x = startX + col * (BRICK_WIDTH + BRICK_SEP);
                double y = BRICK_Y_OFFSET + row * (BRICK_HEIGHT + BRICK_SEP);
                GRect brick = new GRect(x, y, BRICK_WIDTH, BRICK_HEIGHT);
                brick.setFilled(true);
                brick.setColor(getBrickColor(row));
                add(brick);
            }
        }
        bricksRemaining = NBRICK_ROWS * NBRICKS_PER_ROW;
    }

    private Color getBrickColor(int row) {
        switch (row / 2) {
            case 0:
                return Color.RED;
            case 1:
                return Color.ORANGE;
            case 2:
                return Color.YELLOW;
            case 3:
                return Color.GREEN;
            default:
                return Color.CYAN;
        }
    }

    private void createPaddle() {
        double x = (getWidth() - PADDLE_WIDTH) / 2.0;
        double y = getHeight() - PADDLE_Y_OFFSET - PADDLE_HEIGHT;
        paddle = new GRect(x, y, PADDLE_WIDTH, PADDLE_HEIGHT);
        paddle.setFilled(true);
        add(paddle);
    }

    public void mouseMoved(MouseEvent e) {
        double x = e.getX() - PADDLE_WIDTH / 2.0;
        x = Math.max(0, Math.min(x, getWidth() - PADDLE_WIDTH));
        paddle.setLocation(x, paddle.getY());
    }

    private void playGame() {
        int turnsUsed = 0;
        while (turnsUsed < NTURNS && bricksRemaining > 0) {
            createBall();
            pause(SERVE_DELAY);
            playTurn();
            remove(ball);
            turnsUsed++;
        }
        showResult(bricksRemaining == 0);
    }

    private void createBall() {
        double diameter = 2 * BALL_RADIUS;
        double x = (getWidth() - diameter) / 2.0;
        double y = (getHeight() - diameter) / 2.0;
        ball = new GOval(x, y, diameter, diameter);
        ball.setFilled(true);
        add(ball);

        vx = rgen.nextDouble(1.0, 3.0);
        if (rgen.nextBoolean()) {
            vx = -vx;
        }
        vy = INITIAL_Y_VELOCITY;
    }

    private void playTurn() {
        while (ball.getY() + 2 * BALL_RADIUS < getHeight()
                && bricksRemaining > 0) {
            ball.move(vx, vy);
            handleWallCollisions();
            handleObjectCollision();
            pause(ANIMATION_DELAY);
        }
    }

    private void handleWallCollisions() {
        double diameter = 2 * BALL_RADIUS;
        if (ball.getX() <= 0 && vx < 0) {
            ball.setLocation(0, ball.getY());
            vx = -vx;
        } else if (ball.getX() + diameter >= getWidth() && vx > 0) {
            ball.setLocation(getWidth() - diameter, ball.getY());
            vx = -vx;
        }

        if (ball.getY() <= 0 && vy < 0) {
            ball.setLocation(ball.getX(), 0);
            vy = -vy;
        }
    }

    private void handleObjectCollision() {
        GObject collider = getCollidingObject();
        if (collider == paddle) {
            if (vy > 0) {
                ball.setLocation(ball.getX(),
                        paddle.getY() - 2 * BALL_RADIUS - 1);
                vy = -vy;
            }
        } else if (collider != null) {
            remove(collider);
            bricksRemaining--;
            vy = -vy;
        }
    }

    private GObject getCollidingObject() {
        double x = ball.getX();
        double y = ball.getY();
        double diameter = 2 * BALL_RADIUS;
        GObject collider = getElementAt(x, y);
        if (collider == null) {
            collider = getElementAt(x + diameter, y);
        }
        if (collider == null) {
            collider = getElementAt(x, y + diameter);
        }
        if (collider == null) {
            collider = getElementAt(x + diameter, y + diameter);
        }
        return collider;
    }

    private void showResult(boolean won) {
        String message = won ? "You win!" : "Game over";
        GLabel label = new GLabel(message);
        label.setFont("SansSerif-bold-24");
        double x = (getWidth() - label.getWidth()) / 2.0;
        double y = (getHeight() + label.getAscent()) / 2.0;
        add(label, x, y);
    }

    private GRect paddle;
    private GOval ball;
    private double vx;
    private double vy;
    private int bricksRemaining;
    private final RandomGenerator rgen = RandomGenerator.getInstance();
}
