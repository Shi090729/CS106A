# Lecture 23 - Searching, Sorting, and Efficiency

## Course Content

### Linear search

Lecture 23 studies two basic operations that appear in almost every program that manages data: searching and sorting. Linear search is the direct approach. Start at index zero, compare each element with the key, and return the matching index as soon as it is found. If the loop finishes, return `-1` to report that no element matched. The method works whether or not the data is sorted, but its work grows in proportion to the number of elements.

In the worst case, linear search examines all `N` entries, so its running time grows linearly with the input size. Binary search removes half of the remaining entries on each comparison, so the number of comparisons grows logarithmically.

### Binary search and invariants

Binary search uses more information. When the data is sorted, compare the key with the middle element and discard the half that cannot contain the answer. The low and high bounds describe the remaining interval. Every iteration must shrink that interval, and the loop invariant is that a possible match has not been discarded. A small error in an inclusive or exclusive bound can either miss a valid element or produce an infinite loop.

### Sorting and scale

Sorting arranges the data so that later operations can exploit order. The lecture compares simple methods such as selection-style sorting with the broader idea of efficiency. An algorithm that performs acceptably on ten elements may become unusable on thousands. Efficiency is not a replacement for correctness, but it is part of choosing a practical solution.

Selection sort repeatedly finds the smallest remaining value and swaps it into the next output position. Its nested search performs work proportional to `N²`. Radix sort takes a different approach: it distributes values into buckets according to one digit at a time. It illustrates that a faster algorithm can depend on additional structure in the data rather than only on comparisons.

## My Takeaways

Binary search is less about memorizing a code template than preserving a sentence that remains true after every iteration: the target, if present, is still inside the remaining interval. Writing that sentence down would help me repair most boundary mistakes.

I also found it useful to separate “what is the simplest correct algorithm?” from “what will scale?” Linear search is often the right first implementation. Once the data or usage pattern changes, the cost model tells me whether sorting or a different structure is justified.
For an unsorted list, linear search is immediately available. For repeated lookups, paying once to sort the data may make many later searches cheaper.
