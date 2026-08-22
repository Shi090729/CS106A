import acm.graphics.GLabel;
import acm.graphics.GLine;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class ProgramHierarchy extends GraphicsProgram {

    private static final int BOX_WIDTH = 150;
    private static final int BOX_HEIGHT = 50;
    private static final int HORIZONTAL_GAP = 25;
    private static final int VERTICAL_GAP = 75;

    public void run() {
        double figureWidth = 3 * BOX_WIDTH + 2 * HORIZONTAL_GAP;
        double figureHeight = 2 * BOX_HEIGHT + VERTICAL_GAP;
        double left = (getWidth() - figureWidth) / 2.0;
        double top = (getHeight() - figureHeight) / 2.0;
        double childY = top + BOX_HEIGHT + VERTICAL_GAP;
        double parentX = (getWidth() - BOX_WIDTH) / 2.0;

        double graphicsX = left;
        double consoleX = left + BOX_WIDTH + HORIZONTAL_GAP;
        double dialogX = left + 2 * (BOX_WIDTH + HORIZONTAL_GAP);

        drawConnection(parentX, top, graphicsX, childY);
        drawConnection(parentX, top, consoleX, childY);
        drawConnection(parentX, top, dialogX, childY);

        drawClassBox("Program", parentX, top);
        drawClassBox("GraphicsProgram", graphicsX, childY);
        drawClassBox("ConsoleProgram", consoleX, childY);
        drawClassBox("DialogProgram", dialogX, childY);
    }

    private void drawClassBox(String text, double x, double y) {
        add(new GRect(x, y, BOX_WIDTH, BOX_HEIGHT));
        GLabel label = new GLabel(text);
        double labelX = x + (BOX_WIDTH - label.getWidth()) / 2.0;
        double labelY = y + (BOX_HEIGHT + label.getAscent()) / 2.0;
        add(label, labelX, labelY);
    }

    private void drawConnection(double parentX, double parentY,
            double childX, double childY) {
        double startX = parentX + BOX_WIDTH / 2.0;
        double startY = parentY + BOX_HEIGHT;
        double endX = childX + BOX_WIDTH / 2.0;
        add(new GLine(startX, startY, endX, childY));
    }
}
