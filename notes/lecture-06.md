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

The integer-division example corrected an assumption I had: assigning the result to a `double` does not retroactively change how the expression was evaluated. At least one operand must already be a real value, or I need an explicit cast.

Short-circuit evaluation is more than an optimization. It lets the left condition protect the right one, as in checking that a divisor is nonzero before dividing. I also want to use braces and named constants even when Java would allow a shorter version. Those choices make later edits safer and give unexplained numbers a purpose instead of leaving them as accidental facts in the code.
