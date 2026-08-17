# Assignment 2 - Simple Java Programs

This project is based on Stanford's official `Assignment2` starter project. It contains six small Java programs:

- `Pyramid` draws a centered brick pyramid.
- `Target` draws three centered circles.
- `ProgramHierarchy` draws part of the ACM program hierarchy.
- `PythagoreanTheorem` calculates the hypotenuse of a right triangle.
- `FindRange` finds the smallest and largest entered integers.
- `Hailstone` prints a Hailstone sequence and its step count.

## What I Learned

I practiced using constants, nested loops, coordinate calculations, sentinel input, and helper methods. The graphics programs required careful centering instead of fixed positions. The console programs showed why input edge cases should be handled before the main loop.

## Running the Programs

Import this directory as an existing Eclipse project. The official `acm.jar` library is included and configured in `.classpath`. Run the required Java class as a Java application.

## Testing

All six programs compile with Java 8 and the supplied ACM library. I checked different graphics window sizes and tested the console calculations, including empty and single-value range input and several Hailstone starting values. Rendered outputs for the three graphics programs are saved in `screenshots/`.

One `FindRange` test used the values `11, 17, 42, 9, -3, 35, 0` and produced `-3` as the smallest and `42` as the largest. Starting `Hailstone` at `17` took 12 steps, while starting at `27` took 111 steps.

## Attribution

The Eclipse project files, `acm.jar`, starter comments, and source-file stubs come from Stanford Engineering Everywhere's official CS106A Assignment 2 starter package. The completed implementations are my assignment work.
