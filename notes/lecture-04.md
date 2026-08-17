# Lecture 04 - Introduction to Java

## Course Content

### From Source Code to Execution

Computer science is broader than programming: it studies problem solving with computational methods. Programming is the way a solution is expressed so that a computer can carry it out.

A computer ultimately executes machine instructions, while programmers write source code in a high-level language. Java compiles source files into platform-independent bytecode stored in `.class` files. The Java Virtual Machine then runs that bytecode on a particular computer. This extra layer allows the same compiled Java program to run on different operating systems.

### Classes, Objects, and Inheritance

Java is object-oriented. A class combines behavior and data and acts as a template. An object is a particular instance of a class. Classes can form an inheritance hierarchy: a subclass receives the behavior of its superclass and may add more specialized behavior. `SuperKarel extends Karel` was an early example of this idea.

The ACM library provides several program classes, including `ConsoleProgram` for text interaction and `GraphicsProgram` for drawing. A program defines a class, extends the appropriate program type, and begins executing in `run()`.

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

- The JVM explains why Java code can be compiled once and run on different systems.
- A class is a definition, while an object is an actual instance created from it.
- Inheritance lets a new class reuse existing behavior instead of rebuilding everything.
- Karel's class structure, imports, and `run()` method were preparation for regular Java programs.
- Creating a graphics object and adding it to the canvas are separate steps.
