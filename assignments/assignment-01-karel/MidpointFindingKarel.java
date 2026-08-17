/*
 * File: MidpointFindingKarel.java
 * -------------------------------
 * Karel leaves exactly one beeper at the midpoint of 1st Street and
 * finishes on that beeper.
 */

import stanford.karel.*;

public class MidpointFindingKarel extends SuperKarel {

    public void run() {
        if (frontIsBlocked()) {
            putBeeper();
        } else {
            initializeMarkers();
            while (beepersPresent()) {
                shrinkCandidateInterval();
            }
            moveToMidpoint();
        }
    }

    /*
     * Places candidate markers at both ends of 1st Street and a control
     * marker at the southwest corner of 2nd Street.
     */
    private void initializeMarkers() {
        putBeeper();
        moveToWall();
        putBeeper();

        turnAround();
        moveToWall();
        turnRight();
        move();
        turnRight();
        putBeeper();
    }

    /*
     * Moves both endpoint markers one corner toward the center. The
     * control marker is restored only when another iteration is needed.
     */
    private void shrinkCandidateInterval() {
        pickBeeper();
        moveToWesternMarker();

        pickBeeper();
        move();
        if (beepersPresent()) {
            returnToControlCorner();
        } else {
            putBeeper();
            moveToEasternMarker();
            moveEasternMarkerInward();
        }
    }

    private void moveToWesternMarker() {
        turnRight();
        move();
        turnLeft();
        while (noBeepersPresent()) {
            move();
        }
    }

    private void moveToEasternMarker() {
        move();
        while (noBeepersPresent()) {
            move();
        }
    }

    private void moveEasternMarkerInward() {
        pickBeeper();
        turnAround();
        move();
        if (beepersPresent()) {
            returnToControlCorner();
        } else {
            putBeeper();
            returnToControlCorner();
            putBeeper();
        }
    }

    /* Returns to the southwest corner of 2nd Street facing east. */
    private void returnToControlCorner() {
        if (facingEast()) {
            turnAround();
        }
        while (frontIsClear()) {
            move();
        }
        turnRight();
        move();
        turnRight();
    }

    private void moveToMidpoint() {
        turnRight();
        move();
        turnLeft();
        while (noBeepersPresent()) {
            move();
        }
    }

    private void moveToWall() {
        while (frontIsClear()) {
            move();
        }
    }
}
