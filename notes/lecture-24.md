# Lecture 24 - Large Data Structures and Copying

## Course Content

### Modeling a larger problem

Lecture 24 asks how to design programs that manage more information than a single small example. A useful first step is to identify the nouns in the problem—profiles, cities, flights, scores, or messages—and decide which objects should represent them. Keys and identifiers make lookup possible, while collections organize the relationships between objects. The choice of `ArrayList`, `HashMap`, a set, or a custom class should follow the operations the program needs.

### Protecting representation invariants

The lecture returns to abstraction boundaries. A class should protect its representation and expose methods that preserve its invariants. If a client can directly replace an internal list or mutate a shared object without permission, the class loses control of its own state. A well-designed class makes valid operations easy and invalid states harder to create.

### Shallow and deep copying

Copying is another design decision. A shallow copy creates a new outer collection but leaves references to the same nested objects. A deep copy creates independent nested objects as well. If a program copies a social-network database, for example, the desired behavior depends on whether the profiles and friendship lists should remain connected or become a separate simulation.

### A data structure as a domain model

The broader lesson is that large data structures are not just larger arrays. They are a model of the domain. The representation determines which operations are simple, which are expensive, and which invariants must be maintained whenever data changes.

### The music-store design example

The FlyTunes example makes large-scale design concrete with an online music store. The nouns in the description suggest `Song`, `Album`, and store classes, while the required operations determine which fields and collections those classes need.

Collections support questions such as whether an item exists, how many items are stored, and how to traverse the catalog. The example shows why choosing classes comes before choosing individual methods: the data model should reflect the relationships in the problem, and the public operations should preserve those relationships as the store grows.

## My Takeaways

I want to ask “what must never become inconsistent?” before choosing a data structure. That invariant is more informative than starting with the container I happen to remember from the library.

The shallow/deep copy distinction is also a warning about ownership. Whenever two parts of a program can reach the same mutable object, I should decide whether that sharing is intentional and document it through the class interface.
For a new class, I would write down its identifiers, mutable fields, public operations, and the invariant each operation must preserve before writing the implementation.
