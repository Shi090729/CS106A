/*
 * File: NameSurferGraph.java
 * --------------------------
 * Draws the name-popularity graph and redraws it when resized.
 */

import acm.graphics.GCanvas;
import acm.graphics.GLabel;
import acm.graphics.GLine;

import java.awt.Color;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;
import java.util.List;

public class NameSurferGraph extends GCanvas
        implements NameSurferConstants, ComponentListener {

    private static final Color[] GRAPH_COLORS = {
        Color.BLACK, Color.RED, Color.BLUE, Color.MAGENTA
    };

    private final List<NameSurferEntry> entries;

    public NameSurferGraph() {
        entries = new ArrayList<NameSurferEntry>();
        addComponentListener(this);
    }

    public void clear() {
        entries.clear();
    }

    public void addEntry(NameSurferEntry entry) {
        if (entry != null) {
            entries.add(entry);
        }
    }

    public void update() {
        removeAll();
        drawGrid();

        for (int index = 0; index < entries.size(); index++) {
            Color color = GRAPH_COLORS[index % GRAPH_COLORS.length];
            drawEntry(entries.get(index), color);
        }
    }

    private void drawGrid() {
        double width = getWidth();
        double height = getHeight();

        add(new GLine(0, GRAPH_MARGIN_SIZE, width, GRAPH_MARGIN_SIZE));
        add(new GLine(0, height - GRAPH_MARGIN_SIZE,
                width, height - GRAPH_MARGIN_SIZE));

        for (int decade = 0; decade < NDECADES; decade++) {
            double x = getXForDecade(decade);
            add(new GLine(x, 0, x, height));

            String year = String.valueOf(START_DECADE + decade * 10);
            add(new GLabel(year, x + 2, height - 2));
        }
    }

    private void drawEntry(NameSurferEntry entry, Color color) {
        double previousX = 0;
        double previousY = 0;

        for (int decade = 0; decade < NDECADES; decade++) {
            int rank = entry.getRank(decade);
            double x = getXForDecade(decade);
            double y = getYForRank(rank);

            if (decade > 0) {
                GLine segment = new GLine(previousX, previousY, x, y);
                segment.setColor(color);
                add(segment);
            }

            String rankText = rank == 0 ? "*" : String.valueOf(rank);
            GLabel label = new GLabel(entry.getName() + " " + rankText,
                    x + 2, y - 2);
            label.setColor(color);
            add(label);

            previousX = x;
            previousY = y;
        }
    }

    private double getXForDecade(int decade) {
        return decade * getWidth() / (double) NDECADES;
    }

    private double getYForRank(int rank) {
        if (rank == 0) {
            return getHeight() - GRAPH_MARGIN_SIZE;
        }

        double graphHeight = getHeight() - 2.0 * GRAPH_MARGIN_SIZE;
        return GRAPH_MARGIN_SIZE + graphHeight * rank / MAX_RANK;
    }

    public void componentResized(ComponentEvent event) {
        update();
    }

    public void componentHidden(ComponentEvent event) {
    }

    public void componentMoved(ComponentEvent event) {
    }

    public void componentShown(ComponentEvent event) {
    }
}
