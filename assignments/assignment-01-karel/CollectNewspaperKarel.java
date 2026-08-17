/*
 * File: CollectNewspaperKarel.java
 * --------------------------------
 * Karel walks to the door of its house, picks up the newspaper
 * represented by a beeper, and returns to its initial position and
 * direction in the upper-left corner of the house.
 */

import stanford.karel.*;

public class CollectNewspaperKarel extends SuperKarel {

    public void run() {
        moveToNewspaper();
        pickUpNewspaper();
        returnHome();
    }

    private void moveToNewspaper() {
        move();
        move();
        turnRight();
        move();
        turnLeft();
        move();
    }

    private void pickUpNewspaper() {
        pickBeeper();
    }

    private void returnHome() {
        turnAround();
        move();
        turnRight();
        move();
        turnLeft();
        move();
        move();
        turnAround();
    }
}
