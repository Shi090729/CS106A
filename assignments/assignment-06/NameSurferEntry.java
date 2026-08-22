/*
 * File: NameSurferEntry.java
 * --------------------------
 * Represents one name and its rank in each decade.
 */

import acm.util.ErrorException;

import java.util.StringTokenizer;

public class NameSurferEntry implements NameSurferConstants {

    private final String name;
    private final int[] ranks;

    public NameSurferEntry(String line) {
        StringTokenizer tokenizer = new StringTokenizer(line);
        if (!tokenizer.hasMoreTokens()) {
            throw new ErrorException("Empty name entry");
        }

        name = tokenizer.nextToken();
        ranks = new int[NDECADES];

        for (int decade = 0; decade < NDECADES; decade++) {
            if (!tokenizer.hasMoreTokens()) {
                throw new ErrorException("Missing rank for " + name);
            }
            ranks[decade] = Integer.parseInt(tokenizer.nextToken());
        }
    }

    public String getName() {
        return name;
    }

    public int getRank(int decade) {
        if (decade < 0 || decade >= NDECADES) {
            throw new ErrorException("Illegal decade index: " + decade);
        }
        return ranks[decade];
    }

    public String toString() {
        String result = name + " [";
        for (int decade = 0; decade < NDECADES; decade++) {
            if (decade > 0) {
                result += " ";
            }
            result += ranks[decade];
        }
        return result + "]";
    }
}
