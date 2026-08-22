import acm.program.ConsoleProgram;
import java.util.HashMap;
import java.util.Map;

public class NameCounts extends ConsoleProgram {

    public void run() {
        Map<String, Integer> nameCounts = readNames();
        printNameCounts(nameCounts);
    }

    private Map<String, Integer> readNames() {
        Map<String, Integer> nameCounts = new HashMap<String, Integer>();

        while (true) {
            String name = readLine("Enter name: ");
            if (name.length() == 0) {
                break;
            }

            Integer count = nameCounts.get(name);
            if (count == null) {
                nameCounts.put(name, 1);
            } else {
                nameCounts.put(name, count + 1);
            }
        }

        return nameCounts;
    }

    private void printNameCounts(Map<String, Integer> nameCounts) {
        for (String name : nameCounts.keySet()) {
            println("Entry [" + name + "] has count " + nameCounts.get(name));
        }
    }
}
