# Lecture 28 - Course Review and Programming Methodology

## Course Content

### Graphics contest and final-exam scope

The final lecture begins with the graphics-contest winners and then turns to exam preparation. The final is open book and open notes but closed computer. Karel is not part of the final-exam coverage; the emphasis is on the Java material developed across the course. The practice final is intended to be attempted under realistic time constraints and then checked against its supplied solutions.

### Concrete review examples

One review problem traverses a `HashMap` through its key set and prints entries whose key equals the associated value. It combines the iterator pattern, map lookup, and string comparison with `equals`.

The TargetSeeker graphics example stores a moving seeker's position and a target position. A mouse click relocates the target, while repeated animation steps move the seeker toward it along the x and y axes. The example integrates instance variables, mouse events, graphics geometry, animation, and decomposition at the level expected for a final-exam program.

### A recurring problem-solving process

The course repeatedly uses the same development cycle: understand the specification, choose a representation, decompose the problem, implement one manageable part, observe the program's behavior, and revise the design. This pattern appears first in Karel and continues through graphics, strings, arrays, collections, interactors, and larger applications.

The representation determines what information the program stores and which operations are easy to express. Decomposition assigns responsibilities to methods and classes so that each part has a clear contract. Testing then checks whether those parts still work together at boundaries such as empty input, the final valid index, missing data, or an unexpected user action.

### Connecting the major course ideas

Control flow describes when work happens, while methods give that work a name and an interface. Objects combine state with behavior, and references explain how multiple variables or methods can reach the same object. Strings, arrays, `ArrayList`, and maps offer different ways to organize information; choosing among them depends on whether the program needs fixed indexing, resizing, sequential traversal, or lookup by key.

Graphics and interactors add another form of state. Instead of completing all work inside one sequential `run` method, an event-driven program initializes its components and responds when the user performs an action. The event handler changes the underlying model and then updates the visible representation. Larger projects rely on the same principle at a wider scale: each class should own a coherent part of the data or behavior.

### Reviewing a program as a design

A useful review asks more than whether the program produces the expected output once. It asks what assumptions the representation makes, which method preserves each invariant, how references are shared, and what happens at the boundaries. Tracing a method call or drawing the state of an array, list, map, or heap object can reveal whether the implementation matches the intended design.

An earlier assignment can also be reconsidered as if it were going to grow. A method that is acceptable in a small program may need a clearer contract; duplicated state may need one owner; a linear search may need a map when lookups become frequent. The goal is not to complicate every solution in advance, but to recognize which design decisions will matter when requirements change.

## My Takeaways

The strongest lesson for me is that programming is a cycle rather than a single act of typing: understand, design, implement, observe, and revise. A clean solution usually comes from making the problem smaller and the assumptions explicit.

I now see the individual Java topics as connected tools rather than separate chapters. Control flow organizes actions, methods organize reasoning, classes organize responsibilities, and data structures organize information. Testing checks whether those choices remain valid in cases I did not happen to use while writing the first version.

I would describe CS106A as practice in turning informal ideas into programs whose behavior and structure can be inspected. The next stage is to apply the same habits to larger problems where representation, testing, and communication matter even more.
