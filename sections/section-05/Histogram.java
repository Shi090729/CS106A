import acm.program.*;
import acm.util.*;
import java.io.*;

public class Histogram extends ConsoleProgram {

    public void run() {
        int[] histogram = readScores(DATA_FILE);
        printHistogram(histogram);
    }

    private int[] readScores(String filename) {
        int[] histogram = new int[11];

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));

            while (true) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }

                int score = Integer.parseInt(line);
                if (score < 0 || score > 100) {
                    reader.close();
                    throw new ErrorException("That score is out of range");
                }

                histogram[score / 10]++;
            }

            reader.close();
        } catch (IOException ex) {
            throw new ErrorException(ex);
        }

        return histogram;
    }

    private void printHistogram(int[] histogram) {
        for (int range = 0; range < histogram.length; range++) {
            String label;

            if (range == 0) {
                label = "00-09";
            } else if (range == 10) {
                label = "  100";
            } else {
                label = (10 * range) + "-" + (10 * range + 9);
            }

            println(label + ": " + createStars(histogram[range]));
        }
    }

    private String createStars(int count) {
        String stars = "";

        for (int i = 0; i < count; i++) {
            stars += "*";
        }

        return stars;
    }

    private static final String DATA_FILE = "MidtermScores.txt";
}
