# Lecture 25 - Social Networks and Shared Data

## Course Content

### Profiles, friendships, and the database

Lecture 25 develops the FacePamphlet-style social network as an example of object-oriented data modeling. A profile has a unique name, optional status and image information, and a collection of friends. The database maps names to profiles so lookup is direct. Adding a friendship is not just a single list operation: the relationship is intended to be reciprocal, so both profiles must be updated. Deleting a profile also requires cleaning that name out of every remaining friend list.

### Operations that preserve invariants

These rules illustrate why methods should own invariants. If every caller manually updates both sides of a friendship, one missed update can leave the database inconsistent. A database method can coordinate the change, while the profile class can prevent duplicate friends and provide a controlled iterator over its list.

### Shared state and race conditions

The lecture also introduces the idea of independent execution paths and shared data. When multiple activities can operate at overlapping times, a sequence of updates may be interleaved with another sequence. A race condition occurs when the result depends on that timing. Shared mutable state therefore needs a clear owner, synchronization, or another coordination strategy. The safest design minimizes shared state and keeps any critical update small.

### Runnable and Thread

A class that implements `Runnable` supplies a public `run()` method describing one activity. Passing that object to a `Thread` and calling `start()` creates a new thread of execution; directly calling `run()` would only execute the method on the current thread. Multiple threads can share references to the same objects, which is why unsynchronized read-modify-write sequences can produce race conditions.

## My Takeaways

The social-network example made invariants feel tangible: “friendship is reciprocal” is a rule I can test after every operation. It is much better than discovering an inconsistent profile only when the canvas displays it.

I also see why concurrency is difficult even before writing threads. The hard part is not starting another execution path; it is deciding what data may be shared and which combined operations must appear indivisible.
Can a user add themselves? What happens if the friend name does not exist? If a profile is deleted, which other objects still contain its name? These edge cases expose whether the model really owns its rules.
