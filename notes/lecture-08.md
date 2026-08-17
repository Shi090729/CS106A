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

The stack-frame explanation gave me a concrete picture of method calls. Each invocation receives its own parameters and local variables, so identical names in different methods are not shared boxes. If a primitive value needs to change in the caller, the method must return the new value and the caller must store it.

I also want to be more disciplined about instance variables. They are appropriate for information that must survive across callbacks or method calls, not simply for avoiding parameters. The fixed-seed technique is something I will reuse: deterministic randomness makes a failure repeatable, and only after fixing it should I test several ordinary random sequences.
