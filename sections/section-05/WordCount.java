import acm.program.*;
import java.io.*;

public class WordCount extends ConsoleProgram {

    public void run() {
        BufferedReader reader = openFileReader("File: ");

        try {
            int[] counts = countFile(reader);
            reader.close();

            println("Lines = " + counts[0]);
            println("Words = " + counts[1]);
            println("Chars = " + counts[2]);
        } catch (IOException ex) {
            println("An I/O exception has occurred");
        }
    }

    private BufferedReader openFileReader(String prompt) {
        BufferedReader reader = null;

        while (reader == null) {
            String filename = readLine(prompt);
            try {
                reader = new BufferedReader(new FileReader(filename));
            } catch (IOException ex) {
                println("Can't open that file.");
            }
        }
        return reader;
    }

    private int[] countFile(BufferedReader reader) throws IOException {
        int lines = 0;
        int words = 0;
        int chars = 0;

        while (true) {
            String line = reader.readLine();
            if (line == null) {
                break;
            }

            lines++;
            words += countWords(line);
            chars += line.length();
        }

        return new int[] {lines, words, chars};
    }

    private int countWords(String line) {
        boolean inWord = false;
        int words = 0;

        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                if (!inWord) {
                    words++;
                }
                inWord = true;
            } else {
                inWord = false;
            }
        }

        return words;
    }
}
