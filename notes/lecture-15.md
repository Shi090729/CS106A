# Lecture 15 - Objects, Memory, Files, and Exceptions

## Course Content

### Reading stack and heap diagrams

Lecture 15 uses heap-and-stack diagrams to explain what Java variables actually hold. Primitive variables contain their values directly, while object variables contain references to objects stored on the heap. Assigning one object variable to another copies the reference, not the object. As a result, two variables can point to the same object, and a mutation through either reference is visible through the other.

The stack/heap drawings make a distinction that is easy to miss in source code. A declaration such as `Point p;` creates a local reference variable, but no `Point` object exists until `new Point(...)` allocates one on the heap. Two names can therefore lead to the same object, and a null reference has no object to receive a method call.

### Passing primitives and object references

The same model clarifies parameter passing. Java passes every argument by value. For a primitive, the copied value is the number or Boolean itself. For an object, the copied value is the reference. A method can therefore mutate the referenced object, but assigning a different object to the parameter does not change the caller's variable. Drawing the stack frame for each method call makes this distinction much easier to see.

The instructor emphasizes the precise Java rule: every argument is passed by value. For an object argument, the copied value is the reference itself. A method can mutate fields through that copied reference, but assigning a new object to the parameter only changes the parameter's local box.

### Files and exceptional cases

The lecture then connects these ideas to files. A program opens a file, reads its contents through a scanner or reader, processes the data, and closes the resource. File operations can fail for reasons outside the program's control, so Java uses exceptions to report problems such as a missing file. An exception is different from an ordinary return value because it interrupts the normal path until it is handled.

File processing extends the same idea of separating normal work from exceptional situations. A scanner can read tokens or lines only after the file has been opened successfully; the program must decide whether to catch an exception locally, report it to the user, or let a calling method handle it. Closing the file is part of the resource's lifecycle.

## My Takeaways

I used to describe object parameters as “passed by reference,” but the more precise explanation is that Java passes a copy of the reference. That wording explains both behaviors: object mutation persists, while reassigning the parameter does not affect the caller.

For file programs, the happy path is only half the design. I should also decide what the program will do when the file is missing, empty, or malformed. A clear error message is part of the program's behavior, not an afterthought.
