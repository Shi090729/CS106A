# Lecture 17 - Multidimensional Arrays and ArrayList

## Course Content

### Rows, columns, and jagged arrays

A multidimensional array in Java is an array whose elements are themselves arrays. For a matrix, the first index selects a row and the second selects a position within that row. Nested loops mirror that structure: the outer loop visits rows and the inner loop visits columns. Because the rows are separate arrays, Java can represent jagged structures in which different rows have different lengths.

A two-dimensional array is introduced as an array whose elements are arrays, which explains why each row can have its own length. Nested loops should use the current row's length for the inner bound. Treating every row as if it had the first row's size is a common source of errors in jagged data.

### ArrayList operations

The lecture then returns to `ArrayList`, which provides a resizable sequence. `add` appends an element, `get` reads an indexed element, `set` replaces an existing position, `remove` shifts later elements left, and `size` reports the current number of entries. The generic type tells the list what kind of objects it stores. Primitive values use wrapper classes, such as `ArrayList<Integer>`.

The list operations are discussed in terms of their effect on indexes. `add` at an index opens a position and shifts later elements right; `remove` closes a position and shifts them left; `set` changes a value without changing the list's size. Keeping those effects distinct helps when tracing a loop that modifies a list.

### Generic collection types

`ArrayList<E>` is a generic, or template, class. The type argument in angle brackets specifies the kind of object the list contains, as in `ArrayList<String>`. The compiler can then reject an incompatible insertion and return the declared element type from `get` without an explicit cast. Wrapper classes such as `Integer` allow primitive-looking values to participate in object-based collections.

### Matching representation to the task

The examples encourage choosing the representation that matches the problem. A matrix is convenient when row and column relationships matter; an `ArrayList` is better when the collection grows or shrinks during the computation. Both still require careful attention to indexes and to whether an operation changes the collection's size.

The comparison is not that one structure is universally better. Arrays are natural when the size and indexed layout are stable; `ArrayList` is more convenient when the number of entries changes. The representation should make the dominant operation readable.

### Images as two-dimensional arrays

The lecture applies two-dimensional arrays to image processing. A `GImage` can expose its pixels as a rectangular `int[][]`: the first index selects a row and the second selects a column. The array height is the number of rows, `pixels.length`, while the width comes from the length of a row, such as `pixels[0].length`.

Each integer pixel encodes red, green, and blue components. The ACM image utilities can extract those components and combine new ones. To create a grayscale image, the program traverses every row and column, computes a luminosity value from the red, green, and blue intensities, and writes a pixel whose three color components all use that luminosity. A new `GImage` is then constructed from the modified pixel array. This example connects nested loops to a visible transformation rather than treating a matrix as an abstract table of numbers.

## My Takeaways

The phrase “array of arrays” is more helpful to me than treating a two-dimensional array as a mysterious new type. It explains why `matrix.length` and `matrix[row].length` are two different questions.

I also like the way generics make the element type explicit. `ArrayList<String>` tells both the compiler and the reader what belongs in the collection, while wrapper classes make primitive values usable in object-based collections.
