# CS106A Practice Final Review

## Scope

The official practice final covers Java Chapters 1–13 and excludes Karel, the advanced threads lecture, and the standard-Java packaging lecture. The problems emphasize references, arrays, strings, graphics/events, collections, and decomposition.

## Worked answers

### 1. References and arrays

Object variables hold references, so a method can mutate the same object reached by the caller. Primitive arguments such as `int` are copied, so changing the parameter changes only the local copy. In the array rotation trace, the forward loop overwrites values as it goes: the final array is `{50, 10, 10, 10, 10}`. A correct right rotation must copy from the end toward index 1.

### 2. Etch-a-Sketch

Create a `GCompound` containing two diagonal `GLine` objects, place it at the canvas center, and keep its center in `(x, y)`. Button handlers translate the cross by 20 pixels and add a red line from the old center to the new center. The old coordinates must be saved before updating `x` and `y`.

### 3. Word ladder validation

The first word must be in the lexicon. Each later word must have the same length, be in the lexicon, and differ from its predecessor in exactly one position. A helper that counts character differences makes the predicate easy to test. A blank line terminates input; an illegal word should be rejected without replacing the previous valid word.

### 4. Sudoku corner check

Use a boolean array indexed by digit. Traverse only rows 0–2 and columns 0–2. Reject values outside 1–9 or a digit already marked. If all nine positions pass, the corner contains one copy of every digit.

### 5. ArrayList queue

```java
public class StringQueue implements MinimalStringQueue {
    private ArrayList<String> data = new ArrayList<String>();
    public void add(String s) { data.add(s); }
    public String poll() {
        if (data.isEmpty()) return null;
        return data.remove(0);
    }
    public int size() { return data.size(); }
}
```

### 6. Googlewhack

Search both words, count URLs appearing in both arrays, and return true only when the count is exactly one. Stop early once the count reaches two. URL comparison uses `String.equals`, not `==`.

### 7. Common map pairs

Iterate over `map1.keySet()`. For every key also present in `map2`, compare the two values with `.equals`; increment the count only when both key and value match.

## Final checklist

- aliasing versus copying, especially arrays and object fields
- array bounds, effective size, nested loops, and boolean marker arrays
- string immutability and character-by-character algorithms
- event handlers, `GCompound`, coordinates, and component layout
- `ArrayList`, `HashMap`, iterators, interfaces, and queue behavior
- writing helpers with clear preconditions and testing boundary cases

## Timed practice plan

Take the official practice final in three hours without a computer. Use the source solution text only after finishing. Keep an error log with four columns: concept, mistaken assumption, corrected rule, and a small test case. Compare with the official practice-final solution handout only after finishing.
