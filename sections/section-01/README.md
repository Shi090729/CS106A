# Section 1 - Karel Defends Democracy

In this exercise, Karel checks a row of ballot rectangles. If the center square is empty, Karel removes all beepers from the upper and lower squares. If the center contains a beeper, Karel leaves that rectangle unchanged.

## My Approach

Karel moves through the ballot from left to right and checks each center square. I separated the solution into methods for processing one ballot, removing the chad, and clearing all beepers from one corner.

## What I Learned

This problem helped me practice stepwise refinement. Breaking the task into small methods made the movement easier to understand and reduced the chance of missing a square. After finishing the program, I compared it with the official solution and found that both used the same main algorithm, although the method decomposition was slightly different.

The program compiles successfully with the course `karel.jar` library.
