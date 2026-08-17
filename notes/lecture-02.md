# Lecture 02 - Karel Programming Basics

## Course Content

### Commands and Program Structure

Basic Karel understands four commands:

- `move()` moves forward one corner.
- `turnLeft()` rotates 90 degrees left.
- `pickBeeper()` picks up a beeper from the current corner.
- `putBeeper()` places a beeper on the current corner.

Karel is case-sensitive, method calls end with semicolons, and execution begins in `run()`. A Karel program imports the library and extends `Karel` or `SuperKarel`. `SuperKarel` also provides `turnRight()` and `turnAround()`.

An algorithm is a sequence of steps for solving a problem. A program expresses an algorithm using valid language syntax.

### Methods and Control Flow

New private methods give meaningful names to reusable sequences of commands. Control structures determine how those commands run:

- A `for` loop repeats a known number of times.
- A `while` loop repeats while a condition remains true.
- An `if` statement performs an action only when a condition is true.
- `if/else` chooses between two actions.

Useful conditions include `frontIsClear()`, `beepersPresent()`, `beepersInBag()`, and direction checks. Most conditions also have an opposite form, such as `frontIsBlocked()`.

```java
import stanford.karel.*;

public class KarelPatterns extends SuperKarel {
    public void run() {
        while (frontIsClear()) {
            move();
        }

        if (beepersPresent()) {
            pickBeeper();
        } else {
            putBeeper();
        }
    }
}
```

The SteepleChase example combines loops, conditions, and helper methods. High-level names such as `jumpHurdle()` make the program easier for people to understand.

## My Takeaways

What stood out to me was how quickly four primitive commands become a larger vocabulary. Once `jumpHurdle()` or `turnRight()` has a good name and a reliable contract, I can reason at that level instead of repeatedly expanding it into turns and moves.

I also need to choose loops by meaning. A `for` loop says that I know how many repetitions are required; a `while` loop says that the world determines when to stop. That distinction makes the algorithm easier to read and usually prevents me from hard-coding distances that only work in one Karel world.
