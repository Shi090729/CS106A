# Lecture 07 - Loops and Methods

## Course Content

### Loop Patterns

A loop-and-a-half handles situations where input must be read before the stopping condition can be checked. It uses `while (true)` with one clear `break` point, avoiding duplicated input code. Multiple unrelated breaks should be avoided because they make the loop harder to reason about.

`for` and `while` loops can often express the same logic, but they communicate different intentions. A `for` loop is best for definite iteration when the number of repetitions is known. A `while` loop is better for indefinite iteration that continues until a condition changes.

The checkerboard example uses nested loops. One loop visits rows and another visits columns. The indices determine each square's coordinates, and `(row + column) % 2` determines whether it is filled. Different index variables are required when their scopes overlap.

### Defining Methods

A Java method specifies visibility, a return type, a name, and parameters:

```java
private int max(int first, int second) {
    if (first > second) {
        return first;
    }
    return second;
}
```

`run()` is public, while helper methods used only inside the class are normally private. `void` means a method returns no value. Parameters provide inputs, and `return` immediately ends the method and sends a value back to the caller. A Boolean-returning method is called a predicate method.

Methods support decomposition, reuse, and information hiding. The caller only needs to understand the method's contract, not its internal steps. Examples included converting feet to inches, finding a maximum, testing whether a number is odd, computing factorials, and returning a completed `GOval` object.

## My Takeaways

I liked the loop-and-a-half pattern because it solves a real structural problem: sometimes the program has to read a value before it can decide whether to continue. One well-placed `break` can be clearer than duplicating the input operation before and inside the loop.

Methods also changed from being named chunks of commands into actual interfaces with inputs and outputs. Returning a result keeps the method reusable; printing it would force one particular use. When I design a helper, I should ask what the caller needs to provide and what useful value or state change the helper promises in return.
