/*
 * File: StoneMasonKarel.java
 * --------------------------
 * Karel repairs every column by placing beepers in all missing positions.
 */

import stanford.karel.*;

public class StoneMasonKarel extends SuperKarel {

    public void run() {
        repairColumn();
        while (frontIsClear()) {
            moveToNextColumn();
            repairColumn();
        }
    }

    private void repairColumn() {
        turnLeft();
        repairCurrentCorner();
        while (frontIsClear()) {
            move();
            repairCurrentCorner();
        }

        turnAround();
        while (frontIsClear()) {
            move();
        }
        turnLeft();
    }

    private void repairCurrentCorner() {
        if (noBeepersPresent()) {
            putBeeper();
        }
    }

    private void moveToNextColumn() {
        for (int i = 0; i < 4; i++) {
            move();
        }
    }
}
