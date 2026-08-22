# Lecture 04 - Introduction to Java

## Course Content

### From Source Code to Execution

Computer science is broader than programming: it studies problem solving with computational methods. Programming is the way a solution is expressed so that a computer can carry it out.

A computer ultimately executes machine instructions, while programmers write source code in a high-level language. Java compiles source files into platform-independent bytecode stored in `.class` files. The Java Virtual Machine then runs that bytecode on a particular computer. This extra layer allows the same compiled Java program to run on different operating systems.

### Classes, Objects, and Inheritance

Java is object-oriented. A class combines behavior and data and acts as a template. An object is a particular instance of a class. Classes can form an inheritance hierarchy: a subclass receives the behavior of its superclass and may add more specialized behavior. `SuperKarel extends Karel` was an early example of this idea.

The ACM library provides several program classes, including `ConsoleProgram` for text interaction and `GraphicsProgram` for drawing. A program defines a class, extends the appropriate program type, and begins executing in `run()`.

`ConsoleProgram` supplies methods such as `println()` and `readLine()` for console interaction. `GraphicsProgram` instead supplies a canvas on which graphical objects can be added.

```java
import acm.graphics.*;
import acm.program.*;

public class HelloProgram extends GraphicsProgram {
    public void run() {
        add(new GLabel("Hello, world", 100, 75));
    }
}
```

Graphics use a collage model: objects such as `GLabel`, `GRect`, `GOval`, and `GLine` are created and then added to a canvas. A stored object can receive method calls such as `setFont()` or `setColor()` before or after it is displayed.

## My Takeaways

The transition from Karel to Java is not as abrupt as it first appears. Imports, classes, inheritance, and `run()` were already present; the difference is that the Java libraries give the program a much larger collection of objects to work with.

I found the source-code → bytecode → JVM path especially helpful because it explains Java's portability without treating “write once, run anywhere” as a slogan. On the graphics side, I need to keep construction and display separate in my mind: creating a `GLabel` gives me an object, but the object does not become visible until it is added to the canvas.
