# Section 9 Answers

## 1. Primitive Types and Objects

`name == "Q"` compares the references of two `String` objects rather than their
contents. A string read from the user is not necessarily the same object as the
string literal `"Q"`, even when both contain the same character. The comparison
should be written as:

```java
name.equals("Q")
```

In the second example, `ch == 'Q'` works because `char` is a primitive type.
For primitive values, `==` compares the stored values rather than object
references.
