import acm.program.*;
import java.util.*;

public class UniqueNames extends ConsoleProgram {

    public void run() {
        ArrayList<String> names = new ArrayList<String>();

        while (true) {
            String name = readLine("Enter name: ");
            if (name.length() == 0) {
                break;
            }

            addIfUnique(names, name);
        }

        println("Unique name list contains:");
        printList(names);
    }

    private void addIfUnique(ArrayList<String> names, String name) {
        if (!names.contains(name)) {
            names.add(name);
        }
    }

    private void printList(ArrayList<String> names) {
        for (String name : names) {
            println(name);
        }
    }
}
