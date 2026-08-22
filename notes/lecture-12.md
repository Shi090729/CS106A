# Lecture 12 - Characters and Strings

## Course Content

### Characters and Their Codes

Enumeration means processing every possible value or every item in a sequence. Computers represent characters with numeric codes. ASCII defines codes for a smaller character set, while Unicode supports characters from many writing systems.

Java's primitive `char` type stores one UTF-16 code unit and uses single quotes, such as `'A'`. This represents many common characters directly, while some Unicode characters require a pair of `char` values. A `String` is an object and uses double quotes. Because a `char` has a numeric code, values can be compared and used in simple arithmetic. The `Character` class also provides useful tests and conversions, such as checking whether a value is a letter or digit and converting its case.

Console input is read as a string. A program can obtain a character with `charAt`, after first checking that the entered string is not empty.

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

The distinction between a `char` and a string is small in appearance but important in Java: one is a primitive UTF-16 code unit written with single quotes, while the other is an immutable object with methods. Numeric codes make comparisons and arithmetic possible, but helper methods in `Character` are usually clearer when the goal is classification or case conversion.

For string algorithms, I want to write down the index range before coding. `charAt` is zero-based and the end of `substring` is excluded. Palindrome checking is a good example of using the problem structure: only half of the positions need comparison, and the method can return immediately after the first mismatch.
