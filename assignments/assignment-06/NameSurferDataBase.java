/*
 * File: NameSurferDataBase.java
 * -----------------------------
 * Stores the complete collection of name records.
 */

import acm.util.ErrorException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class NameSurferDataBase {

    private final Map<String, NameSurferEntry> entries;

    public NameSurferDataBase(String filename) {
        entries = new HashMap<String, NameSurferEntry>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            readEntries(reader);
            reader.close();
        } catch (IOException exception) {
            throw new ErrorException("Unable to read " + filename + ": "
                    + exception.getMessage());
        }
    }

    public NameSurferEntry findEntry(String name) {
        if (name == null) {
            return null;
        }
        return entries.get(name.toLowerCase());
    }

    private void readEntries(BufferedReader reader) throws IOException {
        while (true) {
            String line = reader.readLine();
            if (line == null) {
                break;
            }

            if (!line.trim().isEmpty()) {
                NameSurferEntry entry = new NameSurferEntry(line);
                entries.put(entry.getName().toLowerCase(), entry);
            }
        }
    }
}
