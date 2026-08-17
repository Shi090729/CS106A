# Practice Midterm - My Answers

These are my written answers to the official practice midterm. They are independent study work, not an official Stanford answer key.

## 1. Karel Inner Border

```java
public void run() {
    moveUpOneRow();
    for (int i = 0; i < 4; i++) {
        placeBorderSide();
        moveToNextSide();
    }
}

private void placeBorderSide() {
    move();
    while (frontIsClear()) {
        if (noBeepersPresent()) putBeeper();
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
```

The no-beeper test prevents duplicate beepers at corners. In a 3-by-3 world, the inset border is the single center square.

## 2. Expressions and Tracing

- `5.0 / 4 - 4 / 5` is `1.25`, because the first division is real division and the second is integer division with result `0`.
- `7 < 9 - 5 && 3 % 0 == 3` is `false`. The left side is false, so `&&` short-circuits before the invalid remainder expression is evaluated.
- `"B" + 8 + 4` is `"B84"`, because concatenation proceeds left to right after the string is encountered.
- The `Mystery` trace prints `The 1st number is: 78` and `The 2nd number is: 73`.

## 3. Largest and Second Largest

Use a sentinel-controlled loop. For each positive input, replace `largest` and shift its old value into `secondLargest` when necessary. Otherwise, update `secondLargest` if the value is larger than it. The supplied practice solution uses strict comparisons and initializes both variables below the allowed input range. If duplicate maximum values are intended to count as the top two values, the specification must explicitly allow equality.

## 4. Frogger Movement

Store the frog's center and compare the horizontal and vertical distances from the click. Move one square in the direction with the larger distance. Before changing either the center or the image, check that the new center remains inside the board. Update the stored center and call `frog.move(dx, dy)` only after that check succeeds.

## 5. Removing Doubled Letters

```java
private String removeDoubledLetters(String str) {
    String result = "";
    for (int i = 0; i < str.length(); i++) {
        if (i == 0 || str.charAt(i) != str.charAt(i - 1)) {
            result += str.charAt(i);
        }
    }
    return result;
}
```

The first character is always copied. Every later character is copied only when it differs from the immediately preceding character.
