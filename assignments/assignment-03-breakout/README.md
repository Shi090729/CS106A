# Assignment 3 - Breakout

This project implements the classic Breakout game using the official CS106A starter project and ACM graphics library.

## Game Play

- Move the mouse horizontally to control the paddle.
- The ball bounces from the side and top walls, the paddle, and the bricks.
- A brick disappears when the ball hits it.
- Missing the ball ends the current turn. The game allows three turns.
- The game ends immediately when all bricks are removed or after the third missed ball.

## What I Learned

This assignment brought together graphics, animation, mouse events, instance variables, and decomposition. The collision code also showed why an object with a visible size needs more than one test point.

## Build and Run

From this directory on Windows:

```powershell
javac -cp acm.jar Breakout.java
java -cp ".;acm.jar" Breakout
```

## Testing

The program was compiled with Eclipse Temurin JDK 8 and the supplied `acm.jar`. The following behavior was checked:

- ten centered rows of bricks with the required color pairs
- paddle movement and clamping at both window edges
- randomized horizontal launch direction
- ball reflection from the left, right, and top walls
- paddle collisions only while the ball is moving downward
- brick removal and the remaining-brick counter
- turn completion after the ball passes the bottom edge
- win and loss messages

A rendered view of the initial game board is saved in `screenshots/`. The starter project's `bounce.au` file is kept unchanged, although the basic version does not use the optional sound extension.

## Attribution

The Eclipse project files, `acm.jar`, `bounce.au`, constants, and source-file stub come from Stanford Engineering Everywhere's official CS106A Assignment 3 starter package. The completed Breakout implementation is my assignment work.
