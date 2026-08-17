# Section 03 - Parameters, Random Numbers, and Graphics

## Written Questions

### True or False

1. **True.** A local variable named `i` belongs to the method where it is declared. A variable with the same name in the caller has a separate scope.
2. **True.** Parameter names are local to the called method. Arguments are matched by their positions, not by having the same variable names.

### Hogwarts Trace

```text
snitch: x = 4004, y = 1001
quaffle: x = 2003, y = 1, z = 1001
bludger: x = 1001, y = 2001, z = 2003
```

## Programs

- `Hogwarts.java` contains the tracing example from the handout.
- `RandomCircles.java` draws ten circles with random radii, positions, and colors. Some circles may be partly or completely hidden behind circles drawn later, so fewer than ten may be visible.
- `DrawLines.java` uses mouse events to draw lines with a rubber-banding effect.

The three programs compile with the course ACM library. `Hogwarts` produces the trace shown above. The graphics programs were checked for valid circle boundaries, changing random output, mouse tracking, and independent completed lines.

Rendered examples of both graphics programs are saved in `screenshots/`.
