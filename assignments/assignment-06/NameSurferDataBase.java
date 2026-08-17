/*
 * File: NameSurferDataBase.java
 * -----------------------------
 * This class keeps track of the complete database of names.
 * The constructor reads in the database from a file, and
 * the only public method makes it possible to look up a
 * name and get back the corresponding NameSurferEntry.
 * Names are matched independent of case, so that "Eric"
 * and "ERIC" are the same names.
 */

public class NameSurferDataBase implements NameSurferConstants {
	private java.util.Map<String, NameSurferEntry> entries = new java.util.HashMap<String, NameSurferEntry>();

/* Constructor: NameSurferDataBase(filename) */
/**
 * Creates a new NameSurferDataBase and initializes it using the
 * data in the specified file.  The constructor throws an error
 * exception if the requested file does not exist or if an error
 * occurs as the file is being read.
 */
	public NameSurferDataBase(String filename) {
		try {
			java.util.Scanner sc = new java.util.Scanner(new java.io.File(filename));
			while (sc.hasNextLine()) {
				String line = sc.nextLine().trim();
				if (!line.isEmpty()) { NameSurferEntry e = new NameSurferEntry(line); entries.put(e.getName().toLowerCase(), e); }
			}
			sc.close();
		} catch (java.io.FileNotFoundException ex) { throw new acm.util.ErrorException("Unable to open " + filename); }
	}

/* Method: findEntry(name) */
/**
 * Returns the NameSurferEntry associated with this name, if one
 * exists.  If the name does not appear in the database, this
 * method returns null.
 */
	public NameSurferEntry findEntry(String name) {
		return name == null ? null : entries.get(name.toLowerCase());
	}
}
