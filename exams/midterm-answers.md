# Practice Midterm Answers

## 1. Karel the Robot

```java
import stanford.karel.SuperKarel;

public class InnerBorderKarel extends SuperKarel {

    public void run() {
        moveUpOneRow();
        for (int side = 0; side < 4; side++) {
            placeBorderSide();
            moveToNextSide();
        }
    }

    private void placeBorderSide() {
        move();
        while (frontIsClear()) {
            if (noBeepersPresent()) {
                putBeeper();
            }
            move();
        }
    }

    private void moveUpOneRow() {
        turnLeft();
        move();
        turnRight();
    }

    private void moveToNextSide() {
        turnRight();
        move();
        turnRight();
        move();
        turnRight();
    }
}
```

The beeper check prevents a second beeper from being placed at a corner. In a
3-by-3 world, every side reaches the same center square, so the result is one
beeper in the center.

## 2. Expressions, Methods, and Parameter Passing

### 2a. Expressions

- `5.0 / 4 - 4 / 5` evaluates to `1.25`. The first division is
  floating-point division, while `4 / 5` uses integer division and produces
  `0`.
- `7 < 9 - 5 && 3 % 0 == 3` evaluates to `false`. The left operand of `&&`
  is false, so Java short-circuits and does not evaluate `3 % 0`.
- `"B" + 8 + 4` evaluates to `"B84"` because concatenation proceeds from
  left to right.

### 2b. Output

```text
The 1st number is: 78
The 2nd number is: 73
```

## 3. Largest and Second-Largest Integers

```java
import acm.program.ConsoleProgram;

public class SecondLargest extends ConsoleProgram {

    private static final int SENTINEL = 0;

    public void run() {
        int largest = -1;
        int secondLargest = -1;

        while (true) {
            int value = readInt("? ");
            if (value == SENTINEL) {
                break;
            }

            if (value > largest) {
                secondLargest = largest;
                largest = value;
            } else if (value > secondLargest) {
                secondLargest = value;
            }
        }

        println("The largest value is " + largest);
        println("The second largest is " + secondLargest);
    }
}
```

If the maximum value is entered twice, the second copy does not satisfy
`value > largest`, but it does replace `secondLargest`. The two results are
therefore equal, as required.

## 4. Frogger Movement

```java
import acm.graphics.GImage;
import acm.program.GraphicsProgram;

import java.awt.event.MouseEvent;

public class SimpleFrogger extends GraphicsProgram {

    private static final int SQSIZE = 75;
    private static final int NCOLS = 7;
    private static final int NROWS = 3;

    public static final int APPLICATION_WIDTH = NCOLS * SQSIZE;
    public static final int APPLICATION_HEIGHT = NROWS * SQSIZE;

    private GImage frog;
    private double frogX;
    private double frogY;

    public void run() {
        frog = new GImage("frog.gif");
        frogX = (NCOLS / 2 + 0.5) * SQSIZE;
        frogY = (NROWS - 0.5) * SQSIZE;

        add(frog, frogX - frog.getWidth() / 2.0,
                frogY - frog.getHeight() / 2.0);
        addMouseListeners();
    }

    public void mouseClicked(MouseEvent event) {
        double horizontalDistance = event.getX() - frogX;
        double verticalDistance = event.getY() - frogY;

        if (Math.abs(horizontalDistance) > Math.abs(verticalDistance)) {
            if (horizontalDistance > 0) {
                moveFrog(SQSIZE, 0);
            } else {
                moveFrog(-SQSIZE, 0);
            }
        } else {
            if (verticalDistance > 0) {
                moveFrog(0, SQSIZE);
            } else {
                moveFrog(0, -SQSIZE);
            }
        }
    }

    private void moveFrog(double dx, double dy) {
        double newX = frogX + dx;
        double newY = frogY + dy;

        if (insideFroggerWorld(newX, newY)) {
            frogX = newX;
            frogY = newY;
            frog.move(dx, dy);
        }
    }

    private boolean insideFroggerWorld(double x, double y) {
        return x >= 0 && x <= NCOLS * SQSIZE
                && y >= 0 && y <= NROWS * SQSIZE;
    }
}
```

The frog starts in the center square of the bottom row. Each click selects the
axis with the greater distance from the frog's center, and the move is applied
only if the new center remains inside the grid.

## 5. Removing Doubled Letters

```java
private String removeDoubledLetters(String str) {
    String result = "";

    for (int index = 0; index < str.length(); index++) {
        char ch = str.charAt(index);
        if (index == 0 || ch != str.charAt(index - 1)) {
            result += ch;
        }
    }

    return result;
}
```

Each character is copied only if it is the first character or differs from the
character immediately before it. Thus, `tresidder` becomes `tresider`, and
`bookkeeper` becomes `bokeper`.
