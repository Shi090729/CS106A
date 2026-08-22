# Lecture 14 - Computer Memory and Object Representation

## Course Content

### Bits, bytes, and units of storage

The lecture moves beneath Java syntax to explain how information is represented in memory. A bit is one binary digit, either zero or one. Eight bits form a byte. The lecture uses the traditional binary convention in which a kilobyte is 1,024 bytes, a megabyte is 1,024 kilobytes, and a gigabyte is 1,024 megabytes. In modern SI terminology, the corresponding binary units are kibibytes, mebibytes, and gibibytes. The finite number of bits used for a Java primitive explains why numeric types have bounded ranges.

Binary values are often written in hexadecimal because one hexadecimal digit represents four bits. The digits `0` through `9` are followed by `A` through `F`, representing decimal values ten through fifteen. Hexadecimal is particularly useful when writing memory addresses because it is much shorter than the equivalent sequence of binary digits.

### Addresses and the layout of memory

Memory can be pictured as a sequence of byte-sized cells, each with an address. An address identifies where a value begins, much as a street address identifies a house. Multi-byte values occupy several adjacent cells. The exact addresses used by a running Java program are normally hidden, but the address model explains what an object variable stores.

The lecture distinguishes the stack from the heap. Local variables and method-call information are represented on the stack. Objects created with `new` live on the heap. A primitive local variable contains its value directly, while an object variable contains a reference—the address-like value that leads to an object on the heap.

### Object references and aliasing

Declaring an object variable does not by itself create the object. The allocation occurs when `new` calls a constructor and reserves heap storage. Assigning one object variable to another copies the reference, not the object. The two variables then refer to the same heap object, a situation called aliasing. A mutation performed through either reference is visible through the other.

A reference may also be `null`, meaning that it does not lead to any object. Calling an instance method through a null reference throws a `NullPointerException` because there is no receiver on the heap. Drawing the local reference boxes and the heap objects separately makes this failure easier to understand than treating the variable as if it contained the object itself.

### Why the model matters

The memory model prepares for the next lecture's discussion of parameter passing and files. It explains why primitives and objects appear to behave differently when assigned or passed to methods, even though Java consistently copies the value stored in each variable. For an object variable, that stored value happens to be a reference.

## My Takeaways

The most important correction to my mental model is that an object variable is not the object. It is a reference that tells Java where the object lives. That distinction explains aliasing, null-reference errors, and why `new` is necessary.

The stack-and-heap diagrams are useful because they turn an invisible runtime behavior into something I can trace. When two variables point to the same box on the heap, I should expect mutations to be shared rather than assuming that assignment produced a copy.
