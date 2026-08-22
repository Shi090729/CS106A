# Lecture 05 - Variables, Objects, and Graphics

## Course Content

### Variables and Values

A variable has a name, a type, and a value. A Java identifier can begin with a letter, underscore, or dollar sign, although ordinary variable names conventionally begin with a letter. Later characters may also be digits, and a reserved word cannot be used as an identifier. The main primitive types used here are `int` for whole-number counting and `double` for values that may contain a fractional part. Later lectures introduce `boolean` and `char` in more detail.

Variables should normally be initialized before use:

```java
int count = 3;
double price = 5.2;
count = count + 1;
```

The equals sign is assignment, not a mathematical equality. Java first evaluates the expression on the right and stores the result in the variable on the left. A local variable declared inside a method is available only within that method.

### Objects as Variable Values

A class name can also be used as a type. The `new` keyword creates an object, and the resulting reference can be stored in a variable. A method call names the receiving object, followed by a dot and the message sent to it.

```java
GLabel label = new GLabel("Hello", 100, 75);
label.setColor(Color.RED);
add(label);
```

### Graphics and Expressions

The graphics origin is at the upper-left corner. The x-coordinate increases to the right, while the y-coordinate increases downward. `GRect` uses an upper-left position plus width and height. `GOval` is defined by its bounding rectangle, and `GLine` uses two endpoints. Rectangles and ovals can be filled and may have separate outline and fill colors.

The `FunGraphics` example creates multiple graphic objects and demonstrates a common mistake: constructing an object without calling `add()` leaves it invisible.

Expressions combine variables, constants, method results, and operators. Java uses `+`, `-`, `*`, `/`, and `%`; `%` gives the remainder for integer calculations.

## My Takeaways

Variables make more sense when I think of the type as part of the meaning, not just a compiler requirement. A count naturally suggests `int`; a measurement that can contain fractions suggests `double`; a graphics variable identifies a particular object that can later receive messages.

The coordinate system is one detail I expect to trip over: moving “down” increases y, which is opposite to the graphs I learned in mathematics. My first debugging checklist for a missing shape will be simple: was it created, was it added, and are its coordinates actually inside the canvas?
