# Lecture 09 - Strings and Custom Classes

## Course Content

### Strings

A `String` stores text as a sequence of characters. String literals use double quotes, `+` concatenates text and values, and `readLine()` reads an entire line from the user.

```java
String name = readLine("Name: ");
String message = "Name: " + name;
```

### Designing a Class

A class normally has its own `.java` file with the same name. It contains methods and state, and it may extend another class. If no superclass is named, it ultimately inherits from `Object`.

Public members form the interface available to client code. Private members are implementation details used only inside the class. Most state should be private so outside code cannot change it without going through controlled methods.

A constructor initializes a new object. It has the same name as the class and no return type. A class may provide multiple constructors with different parameter lists. The `Incrementor` example stores a private counter and offers constructors with a default or supplied starting value.

When a parameter or local variable has the same name as an instance variable, it shadows the instance variable. `this.counter` explicitly refers to the receiving object's field, although distinct names are often clearer.

Primitive arguments are copied, but an object variable stores a reference. Passing an object copies that reference, so both caller and method can refer to the same object. Instance variables belong to individual objects; a `static` class variable is shared by every object of the class.

### Documentation and the Student Example

Javadoc comments begin with `/**` and can document parameters and return values. The Javadoc tool turns these comments into browsable HTML documentation.

The `Student` class combines these ideas: private fields store a name, ID, and units; public methods provide controlled access and updates; a constant stores the graduation requirement; and `toString()` returns a readable representation of the object.

## My Takeaways

- A class should protect its state and expose only the operations clients actually need.
- Constructors establish a valid starting state for every new object.
- Each instance has separate fields, while a static field is shared across the class.
- Object parameters can produce visible changes because copied references still point to the same object.
- Shadowing is legal but can make code harder to read, so clear parameter names are preferable.
- Javadoc makes a class usable without requiring clients to inspect its implementation.
- `toString()` provides a useful textual view of a custom object.
