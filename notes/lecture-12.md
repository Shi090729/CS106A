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

- The difference between `char` and `String` affects syntax and available operations.
- Zero-based indexing and the exclusive end of `substring` are common sources of off-by-one errors.
- Since strings are immutable, a transformation must save or return the new value.
- `equals` is the correct choice for string content comparison.
- A good string algorithm uses indexes deliberately and stops as soon as the answer is known.
