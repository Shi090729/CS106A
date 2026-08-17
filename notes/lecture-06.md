# Lecture 06 - Expressions and Control Statements

## Course Content

### Numeric Expressions

If both operands of `/` are integers, Java performs integer division and discards the remainder. If either operand is a `double`, the result uses real-number division. A cast temporarily treats a value as another type:

```java
double average = (double) (n1 + n2) / 2;
```

Parentheses are evaluated first, followed by multiplication, division, and remainder, then addition and subtraction. Compound assignments such as `+=`, `-=`, `*=`, and `/=` update an existing value; `++` and `--` change it by one.

Named constants improve readability and keep important values consistent:

```java
private static final double PI = 3.14159;
```

### Boolean Logic and Scope

Comparisons use `==`, `!=`, `<`, `<=`, `>`, and `>=`. Logical expressions combine conditions with `!`, `&&`, and `||`. Java uses short-circuit evaluation, so it stops once the result is known. This can safely guard an operation, as in `x != 0 && total / x > 5`.

A block is a group of statements inside braces. A local variable's scope extends from its declaration to the end of its enclosing block. Braces should normally be used even for a one-statement body because they make structure clearer and prevent editing mistakes.

### Decisions and Loops

`if`, `if/else`, and cascaded `else if` statements select behavior from Boolean conditions. A `switch` is another way to select among discrete integer cases, and `break` prevents execution from falling through into later cases.

A `for` loop contains initialization, a condition, and a step. Its condition is checked before every iteration. A `while` loop also checks before each iteration and is useful when repetition depends on a changing condition rather than a fixed count.

## My Takeaways

- The type of the operands determines how division is performed; the destination variable does not change that calculation.
- Parentheses make both the intended result and the code easier to understand.
- Constants replace unexplained numbers and provide one place to update a shared value.
- `=` assigns a value, while `==` tests equality.
- Short-circuit evaluation is useful for protecting operations that would otherwise be invalid.
- Scope explains when a variable exists and where it can be referenced.
- I should choose control structures according to the meaning of the problem, not just because several forms can produce the same result.
