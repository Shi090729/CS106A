# Lecture 10 - Graphics, Interfaces, and Animation

## Course Content

### Inheritance and Graphics Objects

A subclass constructor can call its superclass constructor with `super(...)`. The subclass should use public methods rather than directly accessing private superclass fields. This keeps the superclass responsible for its own data.

ACM graphics classes share the `GObject` superclass. This means code can treat a `GRect`, `GOval`, `GLabel`, or `GLine` as a `GObject`. A `GraphicsProgram` forwards many operations to its internal `GCanvas`. Important canvas operations include adding and removing objects, clearing the canvas, and using `getElementAt(x, y)` to find the frontmost object at a point. If no object is there, the result is `null`.

All graphics objects inherit common operations such as moving, changing location or color, checking whether they contain a point, controlling visibility, and changing their z-order.

### Interfaces

An interface describes a set of methods that a class agrees to provide. It is useful when classes share a capability without sharing the same inheritance path. For example, shapes that implement `GFillable` can be filled, while `GResizable` and `GScalable` describe objects whose size can be changed. A `GLabel` is a `GObject`, but it is not fillable.

### Animation and Geometry

Animation repeatedly updates an object's position and calls `pause(milliseconds)` so the movement can be seen. The bouncing-ball example stores the ball and its velocity, applies gravity, reverses the vertical velocity after a collision, and loses some energy after each bounce.

The position of a `GLabel` is based on the start of its baseline rather than its upper-left corner. Its width, ascent, and descent are needed for accurate centering.

A `GArc` is defined by an oval's bounding box, a starting angle, and a sweep angle. Positive sweeps move counterclockwise, while negative sweeps move clockwise. Filling an arc produces a pie-shaped wedge.

## My Takeaways

- Polymorphism lets one graphics algorithm work with many different `GObject` subclasses.
- `null` must be checked before using the result of `getElementAt`.
- Interfaces describe shared abilities more precisely than a superclass alone.
- Smooth animation is a repeated cycle of updating state, drawing movement, and pausing.
- Text and arc placement depend on their geometric definitions, not only on visible pixels.
