# Lecture 19 - Interfaces, Collections, HashMap, and Iterators

## Course Content

### Interfaces as contracts

This lecture revisits interfaces as contracts. An interface specifies the operations a client may rely on without exposing how a class stores its data. A class can implement multiple interfaces, and a method can accept an interface type so the caller is free to choose a compatible implementation. This is the same abstraction idea used by graphics interfaces such as `GFillable`, now applied to the Java Collections Framework.

The collection interfaces make the abstraction principle concrete. Code that needs list behavior can use `List` rather than committing itself to `ArrayList`; the implementation can then change without rewriting the client algorithm.

### Maps and key-based lookup

`ArrayList` implements the `List` interface, while maps and sets provide other collection behaviors. A `HashMap<K,V>` stores associations between keys and values. `put` creates or replaces an association, `get` looks up a value, `containsKey` tests for a key, and `remove` deletes an association. The key represents identity for the lookup, so choosing a stable and meaningful key is part of the program design.

### Iterator state and equality

Iterators provide sequential access without requiring the client to know the internal representation. The standard pattern is `while (it.hasNext()) { String item = it.next(); ... }`. Iterator state is part of the traversal: each call to `next` advances it. The lecture also reinforces that collections compare logical values using methods such as `equals`, not object identity with `==`.

## My Takeaways

I am starting to see interfaces as a way to postpone a representation decision. If my algorithm only needs “add,” “find,” or “iterate,” I can write against the smaller contract and keep the implementation replaceable.

`HashMap` also changes how I think about lookup. Instead of repeatedly scanning a list for a name, I can make the name a key and express the operation directly. The tradeoff is that the key must be chosen carefully and the map does not provide a meaningful numeric order by itself.
An iterator is not a reusable list cursor. Once it advances, the next call observes a different element; if I need a second traversal, I should request a new iterator.
