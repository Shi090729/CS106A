# Lecture 08 - Information Hiding and Randomness

## Course Content

### Methods and Parameter Passing

Information hiding lets a method act like a black box. A caller should be able to use a clear method interface without understanding its implementation. This also allows the implementation to change without affecting client code.

For primitive values such as `int` and `double`, Java passes a copy into a method. Each call creates a new stack frame containing its parameters and local variables. Changing a copied parameter does not change the caller's variable, so a computed result must be returned and assigned if the caller needs it.

```java
private int addFive(int value) {
    return value + 5;
}

x = addFive(x);
```

### Local and Instance Variables

A local variable belongs to one method and disappears when that method finishes. An instance variable is declared inside the class but outside its methods. It exists for the lifetime of an object and can store state shared across that object's method calls. Each object receives its own copy of each instance variable.

Inside a method, code can refer to its local variables, its parameters, and the object's instance variables. A value needed only for one calculation should remain local; a value that represents lasting object state belongs in an instance variable.

### Pseudorandom Values

The ACM `RandomGenerator` is obtained with `RandomGenerator.getInstance()` and is often stored as an instance variable. It provides random integers, doubles, Booleans, and colors. The `RollDice` example repeatedly generates die rolls until reaching the maximum possible total.

Computer-generated values are pseudorandom: they come from a deterministic sequence. Calling `setSeed()` reproduces the same sequence, which is useful when debugging a failure involving randomness. The fixed seed should normally be removed after testing.

## My Takeaways

- A well-designed method exposes what it does while hiding how it does it.
- Primitive arguments are copied, so modifying a parameter does not modify the caller's variable.
- Stack frames explain why local variables with identical names remain independent across method calls.
- Instance variables should represent persistent object state, not temporary calculations.
- A fixed random seed turns an inconsistent bug into a reproducible test case.
- Randomness should be tested with several sequences after deterministic debugging is complete.
