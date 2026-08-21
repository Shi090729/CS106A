# Practice Final - My Answers

## 1. References and Arrays

Primitive arguments are copied values, so assigning to an `int` parameter changes only the method's local variable. An object argument is also passed by value, but the copied value is a reference to the same object; mutations through that reference are therefore visible to the caller.

For the array rotation, the original array is `{10, 20, 30, 40, 50}`. The forward loop overwrites each later position with the value immediately before it, producing `{50, 10, 10, 10, 10}` after the saved last value is assigned to index zero. To perform a true right rotation, the loop must run from the last index down to index one.

## 2. Etch-a-Sketch

Create a `GCompound` containing two diagonal `GLine` objects and add it at the canvas center. Add four buttons in the `SOUTH` region and register an action listener. Keep the cross center in `x` and `y`. For each command, save the old coordinates, calculate the direction's 20-pixel delta, add a red line from the old center to the new center, update `x` and `y`, and move the compound by the same delta. Compare action commands with `equals`.

## 3. Word Ladder Validation

Read words until a blank line. Each entered word must be in the lexicon. The first word has no predecessor, so it is valid once the lexicon check passes. Every later word must have the same length as the previous word and differ in exactly one character position. If a word is illegal, print an error and keep the previous valid word instead of replacing it.

```java
private int differences(String a, String b) {
    int count = 0;
    for (int i = 0; i < a.length(); i++) {
        if (a.charAt(i) != b.charAt(i)) count++;
    }
    return count;
}
```

## 4. Sudoku Corner Check

Use `boolean[] used = new boolean[10]`. Visit rows `0` through `2` and columns `0` through `2`. Reject a value below 1 or above 9, and reject a digit already marked in `used`. Mark each accepted digit. If all nine cells pass, return `true`.

## 5. ArrayList Queue

```java
private ArrayList<String> data = new ArrayList<String>();

public void add(String value) {
    data.add(value);
}

public String poll() {
    if (data.isEmpty()) return null;
    return data.remove(0);
}

public int size() {
    return data.size();
}
```

The first inserted element is removed first, so this implements FIFO behavior.

## 6. Googlewhack

Search for both words and count the URLs that occur in both result arrays. Return `true` only when the count is exactly one. Compare URLs with `equals`, not `==`, and return `false` as soon as a second common URL is found.

## 7. Common Key/Value Pairs

Iterate over `map1.keySet()`. For each key, first test `map2.containsKey(key)`. If it exists in both maps, compare `map1.get(key)` and `map2.get(key)` with `equals`; increment the count only when both the key and its associated value match.
