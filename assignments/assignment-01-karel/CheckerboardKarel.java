/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * Karel draws a checkerboard using beepers. The program works for all
 * rectangular worlds, including worlds that are only one row or one
 * column wide.
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {

    public void run() {
        fillRowStartingWithBeeper();

        while (leftIsClear()) {
            fillNextRowFacingWest();
            if (rightIsClear()) {
                fillNextRowFacingEast();
            } else {
                turnAround();
            }
        }
    }

    private void fillNextRowFacingWest() {
        if (beepersPresent()) {
            moveUpFacingWest();
            fillRowStartingWithoutBeeper();
        } else {
            moveUpFacingWest();
            fillRowStartingWithBeeper();
        }
    }

    private void fillNextRowFacingEast() {
        if (beepersPresent()) {
            moveUpFacingEast();
            fillRowStartingWithoutBeeper();
        } else {
            moveUpFacingEast();
            fillRowStartingWithBeeper();
        }
    }

    private void fillRowStartingWithBeeper() {
        putBeeper();
        while (frontIsClear()) {
            move();
            if (frontIsClear()) {
                move();
                putBeeper();
            }
        }
    }

    private void fillRowStartingWithoutBeeper() {
        while (frontIsClear()) {
            move();
            putBeeper();
            if (frontIsClear()) {
                move();
            }
        }
    }

    private void moveUpFacingWest() {
        turnLeft();
        move();
        turnLeft();
    }

    private void moveUpFacingEast() {
        turnRight();
        move();
        turnRight();
    }
}
