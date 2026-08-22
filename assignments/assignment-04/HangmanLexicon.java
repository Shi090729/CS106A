import acm.util.ErrorException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HangmanLexicon {

    private static final String LEXICON_FILE = "HangmanLexicon.txt";

    private final List<String> words = new ArrayList<String>();

    public HangmanLexicon() {
        try {
            BufferedReader reader = new BufferedReader(
                    new FileReader(LEXICON_FILE));
            while (true) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }

                String word = line.trim();
                if (word.length() > 0) {
                    words.add(word.toUpperCase());
                }
            }
            reader.close();
        } catch (IOException exception) {
            throw new ErrorException(exception);
        }
    }

    public int getWordCount() {
        return words.size();
    }

    public String getWord(int index) {
        if (index < 0 || index >= words.size()) {
            throw new ErrorException("getWord: Illegal index");
        }
        return words.get(index);
    }
}
