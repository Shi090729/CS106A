# Lecture 26 - Standard Java, JAR Files, and Applets

## Course Content

### Moving beyond the ACM libraries

The ACM libraries simplify startup, graphics, and console interaction so the course can focus on programming methodology. Standard Java contains its own much larger library, documented through the Java API. Learning a new library means identifying the relevant class, reading its public methods and constructors, and writing a small test rather than trying to memorize the entire API.

### JAR files

A JAR file is an archive containing compiled `.class` files and optional resources. It allows a collection of classes to be distributed as one unit. A manifest can identify the class whose `main` method should start an executable JAR.

Creating a JAR does not change the program's Java code. It packages output that has already been compiled, and any external resources still need to be included or made available at the paths the program expects.

### Conventional Java applications

A standard Java application begins in:

```java
public static void main(String[] args) {
    // Program startup
}
```

The method is `static` because Java must be able to invoke it before an instance of the application class exists. It can then construct objects and call ordinary instance methods. The ACM framework hides this startup sequence and eventually invokes `run()` for course programs.

### Applets in the course's historical context

The lecture also shows how a Java program could be packaged as an applet and embedded in a web page. Applets were a common Java deployment mechanism when this course was recorded, but modern browsers no longer support the Java plug-in. The useful underlying distinction is between program logic and the environment responsible for starting and displaying it.

## My Takeaways

The teaching framework is a layer on top of Java rather than a separate language. Understanding `main` and the standard library makes it easier to transfer the same classes, methods, and data structures into an ordinary Java application.

JAR files solve a packaging problem, while APIs solve a discovery problem. Neither replaces the need to understand a class's public contract and the resources a program uses.
