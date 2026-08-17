# Lecture 12 - Characters and Strings

## Course Content

### Characters and Their Codes

Enumeration means processing every possible value or every item in a sequence. Computers represent characters with numeric codes. ASCII defines codes for a smaller character set, while Unicode supports characters from many writing systems.

Java's primitive `char` type stores one character and uses single quotes, such as `'A'`. A `String` is an object and uses double quotes. Because a character has a numeric code, characters can be compared and used in simple arithmetic. The `Character` class also provides useful tests and conversions, such as checking whether a character is a letter or digit and converting its case.

### Working with Strings

A string is an immutable sequence of characters. Methods do not change the original string; they either return information or create a new string. Common operations include:

- `length()` for the number of characters
- `charAt(index)` for one zero-based character
- `substring(start, end)` for a range that includes `start` but excludes `end`
- `indexOf(...)` for a search, returning `-1` when there is no match
- `toUpperCase()` and `toLowerCase()` for converted copies

String content should be compared with `equals`, `equalsIgnoreCase`, or `compareTo`. Using `==` checks whether two variables refer to the same object, not whether their text is equal.

String algorithms often loop over character positions and build a result. A reverse-string method visits the source characters and constructs a new string in reverse order. A palindrome test compares matching characters from the two ends. It only needs to inspect half of the string and can immediately return `false` when a pair does not match.

## My Takeaways

The distinction between a character and a string is small in appearance but important in Java: one is a primitive value written with single quotes, while the other is an immutable object with methods. Character codes make comparisons and arithmetic possible, but helper methods in `Character` are usually clearer when the goal is classification or case conversion.

For string algorithms, I want to write down the index range before coding. `charAt` is zero-based and the end of `substring` is excluded. Palindrome checking is a good example of using the problem structure: only half of the positions need comparison, and the method can return immediately after the first mismatch.
