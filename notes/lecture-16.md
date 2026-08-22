# Lecture 16 - Arrays and Indexed Data

## Course Content

### Declaring and initializing arrays

This lecture introduces arrays as a way to store many values of the same type under one variable name. An array is ordered and homogeneous: every element has a numbered position, and every position stores the same declared type. The declaration specifies the element type, while `new` creates the array with a fixed length. Java initializes the elements automatically, using values such as `0`, `false`, or `null` depending on the type.

The lecture introduces the array declaration and the allocation expression separately. The type says what each slot will hold, while the length in `new int[length]` determines the fixed storage. Default values are useful, but they can also hide the difference between an entry that was never filled and an entry whose real value happens to be zero.

### Indexes and traversal bounds

Indexes begin at zero, so an array of length five has valid indexes from 0 through 4. This makes the usual traversal pattern `for (int i = 0; i < array.length; i++)`. Using `<=` would attempt to access one position beyond the array. The lecture also shows that arrays are objects: an array variable stores a reference, arrays can be passed to methods, and changes to their elements remain visible to the caller.

The zero-based convention is connected to the address calculation used by the machine: the first element is at an offset of zero from the beginning of the array. The standard `< array.length` loop is therefore not just stylistic. It expresses exactly the set of valid offsets and avoids the extra access created by `<=`.

### Capacity versus effective size

A fixed array sometimes has more capacity than currently used. In that case, the program needs an effective-size variable in addition to `array.length`. The physical length describes how much storage exists; the effective size describes how many entries are meaningful. This distinction appears in examples that collect scores or other inputs without knowing in advance how many will be entered.

The effective-size pattern appears whenever input arrives incrementally. Inserting an element may require shifting later entries to make a gap; deleting one requires shifting them back and decrementing the logical size. The array length does not change during either operation.

### Initializers and an introduction to ArrayList

An array initializer such as `int[] values = {10, 20, 30};` creates and fills an array in one expression. Its length is determined by the number of listed values.

The lecture also introduces `ArrayList` as a collection whose effective size changes automatically. Unlike an array, it uses methods such as `add`, `get`, and `size` rather than bracket indexing and a public `length` field. The following lecture develops this comparison in more detail.

## My Takeaways

Arrays make repetitive data manageable, but they also make boundaries much more important. I want to get into the habit of writing the valid index range before writing a loop, especially when shifting or inserting elements.

The effective-size idea was also useful. An array does not know which entries my program considers “filled.” That meaning belongs to the program's representation, so the size variable and the array have to be updated together.
