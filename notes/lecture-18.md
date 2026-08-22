# Lecture 18 - Arrays, Lists, and Systematic Debugging

## Course Content

### Choosing between arrays and lists

Lecture 18 compares arrays and lists in terms of representation and use. Arrays provide fixed storage and direct indexed access. `ArrayList` grows as elements are added and offers convenient insertion and removal, although removing from the front requires later elements to shift. A two-dimensional array can also be viewed as a collection of rows, which is useful when each row has its own effective size.

The lecture revisits the cost of shifting elements. Removing the first item of an `ArrayList` is easy to write but requires the remaining items to move, whereas direct access in an array is constant-time once a valid index is known. These costs matter when the operation occurs inside a large loop.

### A disciplined debugging loop

The second theme is debugging. A good debugging process starts by reproducing the failure reliably, then reducing it to the smallest input that still fails. From that small case, the programmer can state an assumption, inspect the relevant variables, and test a focused change. Tracing loops and drawing array contents are often more effective than adding random print statements.

Debugging is presented as a process of forming and testing hypotheses. Reproduce the failure, reduce the input, inspect the state immediately before the wrong result, and change one thing at a time. A diagram of indexes or references often reveals an error that a long printout obscures.

### Using the Eclipse debugger

The Eclipse debugger can pause execution at a breakpoint and show the current call stack, local variables, parameters, and object fields. **Step Into** enters a called method, **Step Over** executes the call without entering it, and **Step Return** finishes the current method. Resume continues until the next breakpoint or program termination.

The debugger is most useful when guided by a hypothesis. A breakpoint should be placed near the first point where the state might become wrong, not added randomly throughout the program. Small boundary cases such as an empty collection, one element, duplicate values, or the final valid index make the observed state easier to interpret.

## My Takeaways

Debugging is not a personality trait or a lucky guess. It is a sequence of experiments. I should be able to explain what I expected to happen, what actually happened, and which observation distinguishes two possible causes.

The comparison between arrays and lists also reminded me that a data structure is part of an algorithm's design. I should decide whether fixed capacity, resizing, indexed access, or insertion is the dominant requirement before choosing one.
For a failing method, I would now write down a two- or three-element counterexample, trace every update on paper, and add one regression test after fixing it.
