# CS106A Practice Midterm Review

## Scope

The official practice midterm covers Karel, Java Chapters 1–9, and mouse listeners through the graphics chapters. Files and later topics are excluded. The exam is open book and open notes, but closed computer, so the most useful preparation is writing short solutions by hand and tracing code without running it.

## Worked answers

### 1. Karel inner border

Use four passes around the inset rectangle. On each pass, move into the first interior square, place a beeper only when none is already present, and continue until the wall. At a corner, reposition by turning right, moving one square, turning right, and moving to the next side. Checking `noBeepersPresent()` prevents duplicate corner beepers. The 3×3 case naturally leaves one beeper in the center.

### 2. Expressions and tracing

- `5.0 / 4 - 4 / 5` evaluates to `1.25 - 0`, so the result is `1.25`.
- `7 < 9 - 5 && 3 % 0 == 3` short-circuits after the left side is false; the division-by-zero expression is not evaluated, so the result is `false`.
- `"B" + 8 + 4` is string concatenation from left to right: `"B84"`.
- The `Mystery` trace prints `The 1st number is: 78` and `The 2nd number is: 73`.

### 3. Largest and second largest

Keep `largest` and `secondLargest` initialized below the allowed positive inputs. For every non-sentinel value, first compare it with `largest`; if larger, shift the old largest down. Otherwise compare it with `secondLargest`. This version follows the supplied practice solution for positive inputs. If repeated maximum values are meant to count as both largest and second largest, the comparison rule must be changed deliberately to allow equality; that convention should be stated before writing the method.

### 4. Frogger movement

Store the frog center `(fx, fy)`. On a click, compare `abs(mouseX - fx)` and `abs(mouseY - fy)` to choose the dominant direction. Attempt a one-square move in that direction and accept it only if the new center remains inside the grid. Move the image by the same delta as the center.

### 5. Removing doubled letters

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

## High-value checklist

- Karel preconditions, postconditions, loops, and decomposition
- integer versus real division; `%`; precedence; short-circuit `&&` and `||`
- parameter passing, local scope, and method return values
- object construction, references, visibility, and simple ACM graphics
- mouse event methods and coordinate calculations
- `String.length`, `charAt`, `substring`, `indexOf`, and immutable strings

## Timed practice plan

Do the official practice paper once in 90 minutes with no computer. Mark every place where you looked up syntax. Then redo only the missed problems from memory and compare with the official solution handout after finishing.
