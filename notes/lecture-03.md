# Lecture 03 - Decomposition and Program Design

## Course Content

### Common Logical Errors

An **infinite loop** occurs when a loop's condition never becomes false. For example, repeatedly turning left while `frontIsClear()` may never change whether the front is clear.

An **off-by-one error** occurs when a loop performs one too few or one too many operations. A row-filling loop stops when Karel reaches the final corner, so the last beeper must be placed after the loop:

```java
private void fillRow() {
    while (frontIsClear()) {
        putBeeper();
        move();
    }
    putBeeper();
}
```

These are logical errors: the program may be valid and runnable but still behave incorrectly.

### Comments and Method Contracts

Comments should explain the program's purpose and clarify decisions that are not obvious from the code. They should not repeat every statement.

A precondition describes what must be true before a method runs. A postcondition describes what the method guarantees afterward. These contracts make methods easier to use and debug without tracing every command.

### Top-Down Design

**Decomposition** divides a large problem into smaller tasks. **Stepwise refinement** starts with a high-level solution and repeatedly expands each unfinished task until every step can be expressed with available commands.

Each method should solve one conceptual problem and have a clear name. Short methods are acceptable when they provide useful abstraction.

The `DoubleBeepers` example begins with high-level tasks such as doubling a pile and moving it back. Each task is then refined into smaller operations. The `CleanUpKarel` example applies the same idea by separating whole-world traversal, row cleanup, and repositioning between rows.

Good decomposition improves readability and makes later changes less expensive. A program that merely works is not enough if its structure is difficult to understand or modify.

## My Takeaways

- I should check whether a loop changes the state used by its condition.
- I should test first and last positions explicitly to catch off-by-one errors.
- I should design from the problem level downward instead of immediately writing primitive commands.
- Clear method names, contracts, and focused responsibilities make code easier to debug and maintain.
