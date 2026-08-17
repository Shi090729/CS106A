# Lecture 05 - Variables, Objects, and Graphics

## Course Content

### Variables and Values

A variable has a name, a type, and a value. Its name must begin with a letter or underscore and cannot be a Java reserved word. Common types introduced in this lecture include `int` for whole-number counting, `double` for real values, `boolean` for `true` or `false`, and `char` for a single character.

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

- Choosing `int` or `double` should reflect whether a value represents a count or a measurable quantity.
- Assignment changes stored state, so `x = x + 1` is meaningful in programming.
- Object variables let me create several instances of the same class and control each one separately.
- Graphics coordinates differ from the usual mathematical coordinate system because y increases downward.
- If a graphics object does not appear, I should first check whether it was added to the canvas.
