# Answers

## 3. Heap/Stack Diagram

The diagram is taken at the `return result` line after the loop has finished.

```text
Stack

run
    r      -> A

raiseToPower
    x      -> A
    n       = 3
    result -> E
    i       = 3

Heap

A: Rational(1, 2)  reachable through r and x
B: Rational(1, 1)  garbage
C: Rational(1, 2)  garbage
D: Rational(1, 4)  garbage
E: Rational(1, 8)  reachable through result
```

## 4. Mystery Trace

```text
witch: x = 1, y = 1
witch: x = 10, y = 0
witch: x = 101, y = 1
witch: x = 1011, y = 1
ghost: x = 13, y = 1011
```
