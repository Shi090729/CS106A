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

- The placement of a loop's stopping test can remove duplicated code.
- `for` communicates counting, while `while` communicates repetition until a condition changes.
- Nested loops are a natural way to generate grids and other two-dimensional patterns.
- A method's signature describes what information goes in and what type of result comes back.
- Returning a value is different from printing it; the caller decides how to use the returned result.
- Each method has its own local variables, even when another method uses the same names.
- Good methods hide details behind a small, reusable interface.
