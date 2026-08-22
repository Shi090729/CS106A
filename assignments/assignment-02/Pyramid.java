import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class Pyramid extends GraphicsProgram {

    private static final int BRICK_WIDTH = 30;
    private static final int BRICK_HEIGHT = 12;
    private static final int BRICKS_IN_BASE = 14;

    public void run() {
        for (int row = 0; row < BRICKS_IN_BASE; row++) {
            drawRow(row);
        }
    }

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
