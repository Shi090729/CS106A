# Lecture 13 - String Processing and the Caesar Cipher

## Course Content

### Scanning and classifying characters

The lecture continues the study of strings by treating a string as an indexed sequence of characters. A traversal visits positions from `0` through `str.length() - 1`, obtains each character with `charAt`, and updates a result. The `Character` class supplies tests and conversions such as `isUpperCase`, `isLowerCase`, `isLetter`, `toUpperCase`, and `toLowerCase`. These methods keep character classification separate from the loop that moves through the string.

The state maintained by the loop depends on the problem. A counting method keeps an integer, a search method may return an index as soon as a match is found, and a transformation constructs a new string. Because strings are immutable, none of these operations changes the original string object.

### Tokenizing text

`StringTokenizer` divides a string into pieces called tokens. With its default configuration, whitespace separates tokens. `hasMoreTokens()` checks whether another token remains, and `nextToken()` returns it while advancing the tokenizer. A custom delimiter string can be supplied when punctuation or another character should separate fields.

Tokenization is different from character-by-character traversal. The tokenizer owns traversal state, so every call to `nextToken()` consumes one complete token.

### Replacing one occurrence of a substring

The class develops a method that replaces the first occurrence of one string with another. `indexOf(original)` locates the match and returns `-1` if it is absent. The no-match case must be handled before any substring boundaries are calculated; in that case the unchanged source string can be returned.

When a match exists, the result is assembled from three regions: the prefix before the match, the replacement text, and the suffix after the matched text. The prefix ends at the match index, while the suffix begins at `index + original.length()`. This example reinforces that the ending index of `substring(start, end)` is excluded. The lecture's “Stanfordize” demonstration applies several first-occurrence replacements in sequence and assigns each returned string back to the working variable.

### Caesar cipher terminology and design

A Caesar cipher rotates the alphabet by an integer key. The original message is the plaintext and the transformed message is the ciphertext. Encryption is performed character by character. Alphabetic characters are shifted, letters near the end wrap back to the beginning, and nonletters can be copied without change.

The implementation uses top-down design. The main encryption method traverses the entire message, while a helper is responsible for translating one character. The helper must distinguish uppercase from lowercase so that each uses the correct alphabet base. Subtracting `'A'` or `'a'` converts a letter to a zero-based position; adding the key and reducing modulo 26 performs the wraparound; adding the base converts the position back to a character. Because Java's remainder can be negative, code that permits negative keys must normalize the shifted position before converting it back to a character. Decryption uses the same operation with the opposite shift.

## My Takeaways

The replacement example gave me a precise way to reason about a text edit: locate the match, identify the three regions, and construct a new string. Handling `indexOf(...) == -1` first also keeps invalid substring indexes out of the rest of the method.

The Caesar cipher showed how a familiar string problem can be decomposed into a traversal and a one-character transformation. The difficult part is not the loop but the boundary rules: uppercase versus lowercase, wraparound, negative shifts, and characters that should remain unchanged.
