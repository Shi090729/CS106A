/*
 * File: KarelDefendsDemocracy.java
 * --------------------------------
 * Karel checks every ballot rectangle. If its center is empty, Karel
 * removes all remaining beepers from the upper and lower squares.
 */

import stanford.karel.*;

public class KarelDefendsDemocracy extends SuperKarel {

    public void run() {
        while (frontIsClear()) {
            move();
            processBallot();
            move();
        }
    }

    /*
     * Precondition: Karel is in the center of a ballot rectangle,
     * facing east.
     * Postcondition: The ballot is processed, and Karel remains in
     * the center facing east.
     */
    private void processBallot() {
        if (noBeepersPresent()) {
            removeChad();
        }
    }

    /*
     * Precondition: Karel is in the empty center of a ballot rectangle,
     * facing east.
     * Postcondition: The upper and lower squares contain no beepers,
     * and Karel returns to the center facing east.
     */
    private void removeChad() {
        turnLeft();
        move();
        removeAllBeepers();

        turnAround();
        move();
        move();
        removeAllBeepers();

        turnAround();
        move();
        turnRight();
    }

    /* Removes every beeper from Karel's current corner. */
    private void removeAllBeepers() {
        while (beepersPresent()) {
            pickBeeper();
        }
    }
}
