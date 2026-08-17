/*
 * File: CollectNewspaperKarel.java
 * --------------------------------
 * Karel collects the newspaper outside the house and returns to the
 * original position and direction.
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
