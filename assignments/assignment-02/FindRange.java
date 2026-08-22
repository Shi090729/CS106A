import acm.program.ConsoleProgram;

public class FindRange extends ConsoleProgram {

    private static final int SENTINEL = 0;

    public void run() {
        println("This program finds the largest and smallest numbers.");
        int value = readInt("? ");

        if (value == SENTINEL) {
            println("No values were entered.");
            return;
        }

        int smallest = value;
        int largest = value;
        while (true) {
            value = readInt("? ");
            if (value == SENTINEL) {
                break;
            }
            smallest = Math.min(smallest, value);
            largest = Math.max(largest, value);
        }

        println("smallest: " + smallest);
        println("largest: " + largest);
    }
}
