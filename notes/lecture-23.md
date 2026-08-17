# Lecture 23 - Searching, Sorting, and Efficiency

## Course Content

### Linear search

Lecture 23 studies two basic operations that appear in almost every program that manages data: searching and sorting. Linear search is the direct approach. Start at index zero, compare each element with the key, and return the matching index as soon as it is found. If the loop finishes, return `-1` to report that no element matched. The method works whether or not the data is sorted, but its work grows in proportion to the number of elements.

Linear search is the baseline algorithm because it requires no preparation. It examines entries in order and can stop as soon as the key is found. Returning `-1` for failure gives callers a simple way to distinguish a valid index from no match.

### Binary search and invariants

Binary search uses more information. When the data is sorted, compare the key with the middle element and discard the half that cannot contain the answer. The low and high bounds describe the remaining interval. Every iteration must shrink that interval, and the loop invariant is that a possible match has not been discarded. A small error in an inclusive or exclusive bound can either miss a valid element or produce an infinite loop.

Binary search relies on sorted data and on a carefully maintained interval. `low` and `high` describe the only region that can still contain the key; after comparing with the middle element, one half is discarded. The inclusive-bound version and the half-open version both work, but their updates must not be mixed.

### Sorting and scale

Sorting arranges the data so that later operations can exploit order. The lecture compares simple methods such as selection-style sorting with the broader idea of efficiency. An algorithm that performs acceptably on ten elements may become unusable on thousands. Efficiency is not a replacement for correctness, but it is part of choosing a practical solution.

Sorting is considered not just as a code exercise but as preparation for later work. Selection-style methods are easy to trace, while more sophisticated algorithms reduce the work on large inputs. The central question is how the running time changes as the data grows.

## My Takeaways

Binary search is less about memorizing a code template than preserving a sentence that remains true after every iteration: the target, if present, is still inside the remaining interval. Writing that sentence down would help me repair most boundary mistakes.

I also found it useful to separate “what is the simplest correct algorithm?” from “what will scale?” Linear search is often the right first implementation. Once the data or usage pattern changes, the cost model tells me whether sorting or a different structure is justified.


For an unsorted list, linear search is immediately available. For repeated lookups, paying once to sort the data may make many later searches cheaper.
