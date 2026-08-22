# Practice Final Answers

## 1. Short Answer

### 1a. Primitive and Object Parameters

Java passes every argument by value. For an `int`, the copied value is the
integer itself, so assigning to the parameter changes only the local copy. For
an object, the copied value is a reference to the same object. Mutating the
object through that copied reference is therefore visible after the method
returns, although assigning a different object to the parameter would still
change only the local copy of the reference.

### 1b. Array Trace

The final contents of `list` are:

```text
{50, 10, 10, 10, 10}
```

The forward loop overwrites each element before its original value can be
copied. A true right rotation would need to loop backward from the last index.

## 2. Graphics and Interactivity

```java
import acm.graphics.GCompound;
import acm.graphics.GLine;
import acm.program.GraphicsProgram;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JButton;

public class EtchASketch extends GraphicsProgram {

    private static final double CROSS_SIZE = 10;
    private static final double STEP_SIZE = 20;

    private GCompound cross;
    private double crossX;
    private double crossY;

    public void init() {
        add(new JButton("North"), SOUTH);
        add(new JButton("South"), SOUTH);
        add(new JButton("East"), SOUTH);
        add(new JButton("West"), SOUTH);

        crossX = getWidth() / 2.0;
        crossY = getHeight() / 2.0;
        double radius = CROSS_SIZE / 2.0;

        cross = new GCompound();
        cross.add(new GLine(-radius, -radius, radius, radius));
        cross.add(new GLine(-radius, radius, radius, -radius));
        add(cross, crossX, crossY);
        addActionListeners();
    }

    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();

        if (command.equals("North")) {
            moveCross(0, -STEP_SIZE);
        } else if (command.equals("South")) {
            moveCross(0, STEP_SIZE);
        } else if (command.equals("East")) {
            moveCross(STEP_SIZE, 0);
        } else if (command.equals("West")) {
            moveCross(-STEP_SIZE, 0);
        }
    }

    private void moveCross(double dx, double dy) {
        GLine path = new GLine(crossX, crossY,
                crossX + dx, crossY + dy);
        path.setColor(Color.RED);
        add(path);

        crossX += dx;
        crossY += dy;
        cross.move(dx, dy);
    }
}
```

## 3. Word Ladder Validation

```java
import acm.program.ConsoleProgram;

public class CheckWordLadder extends ConsoleProgram {

    private Lexicon lexicon = new Lexicon("english.dat");

    public void run() {
        println("Program to check a word ladder.");
        println("Enter a sequence of words ending with a blank line.");

        String previous = null;
        while (true) {
            String current = readLine();
            if (current.isEmpty()) {
                break;
            }

            if (isLegalLadderPair(previous, current)) {
                previous = current;
            } else {
                println("That word is not legal. Try again.");
            }
        }
    }

    private boolean isLegalLadderPair(String previous, String current) {
        if (!lexicon.isEnglishWord(current)) {
            return false;
        }
        if (previous == null) {
            return true;
        }
        if (previous.length() != current.length()) {
            return false;
        }
        return countCharacterDifferences(previous, current) == 1;
    }

    private int countCharacterDifferences(String first, String second) {
        int differences = 0;
        for (int index = 0; index < first.length(); index++) {
            if (first.charAt(index) != second.charAt(index)) {
                differences++;
            }
        }
        return differences;
    }
}
```

An invalid word does not replace `previous`, so the next entry is still checked
against the last valid word in the ladder.

## 4. Sudoku Upper-Left Corner

```java
private boolean checkUpperLeftCorner(int[][] matrix) {
    boolean[] alreadyUsed = new boolean[10];

    for (int row = 0; row < 3; row++) {
        for (int column = 0; column < 3; column++) {
            int digit = matrix[row][column];
            if (digit < 1 || digit > 9) {
                return false;
            }
            if (alreadyUsed[digit]) {
                return false;
            }
            alreadyUsed[digit] = true;
        }
    }

    return true;
}
```

Nine cells that are all in the range 1 through 9 and contain no duplicate must
contain every digit exactly once.

## 5. ArrayList Queue

```java
import java.util.ArrayList;

public class StringQueue implements MinimalStringQueue {

    private ArrayList<String> waitingLine;

    public StringQueue() {
        waitingLine = new ArrayList<String>();
    }

    public void add(String value) {
        waitingLine.add(value);
    }

    public String poll() {
        if (waitingLine.isEmpty()) {
            return null;
        }
        return waitingLine.remove(0);
    }

    public int size() {
        return waitingLine.size();
    }
}
```

New values are appended and polling removes index zero, which gives the queue
first-in, first-out behavior.

## 6. Googlewhack

```java
private boolean isGooglewhack(String firstWord, String secondWord) {
    String[] firstPages = googleSearch(firstWord);
    String[] secondPages = googleSearch(secondWord);
    int matches = 0;

    for (String page : firstPages) {
        if (findStringInArray(page, secondPages) != -1) {
            matches++;
            if (matches > 1) {
                return false;
            }
        }
    }

    return matches == 1;
}

private int findStringInArray(String target, String[] values) {
    for (int index = 0; index < values.length; index++) {
        if (target.equals(values[index])) {
            return index;
        }
    }
    return -1;
}
```

The pair is a Googlewhack only when the two search-result arrays contain
exactly one common URL.

## 7. Common Key/Value Pairs

```java
public int commonKeyValuePairs(HashMap<String, String> first,
        HashMap<String, String> second) {
    int count = 0;

    for (String key : first.keySet()) {
        if (second.containsKey(key)
                && first.get(key).equals(second.get(key))) {
            count++;
        }
    }

    return count;
}
```

`containsKey` distinguishes a missing key from a key that merely has no lookup
result, and `equals` compares the associated strings by content.
