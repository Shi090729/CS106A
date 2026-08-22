import acm.program.*;

public class StringProcessing extends ConsoleProgram {

    public void run() {
        while (true) {
            String digits = readLine("Enter a numeric string: ");
            if (digits.length() == 0) {
                break;
            }
            println(addCommasToNumericString(digits));
        }
    }

    private String addCommasToNumericString(String digits) {
        String result = "";
        int digitsInGroup = 0;

        for (int i = digits.length() - 1; i >= 0; i--) {
            result = digits.charAt(i) + result;
            digitsInGroup++;

            if (digitsInGroup % 3 == 0 && i > 0) {
                result = "," + result;
            }
        }
        return result;
    }

    public String removeAllOccurrences(String str, char ch) {
        String result = "";

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ch) {
                result += str.charAt(i);
            }
        }
        return result;
    }
}
