package task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class BracketChecker {
    private static final String OPENING_BRACKETS = "{([";
    private static final String CLOSING_BRACKETS = "})]";

    public static void main(String[] args) {


        File file = new File("src/task2/input");
        if (!file.exists() || !file.isFile()) {
            System.out.println("Error: file not found or is not a file");
            return;
        }

        try (Scanner scanner = new Scanner(file)) {
            int lineNumber = 0;
            Stack<Character> stack = new Stack<>();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                ++lineNumber;
                for (int i = 0; i < line.length(); ++i) {
                    char c = line.charAt(i);
                    if (OPENING_BRACKETS.indexOf(c) != -1) {
                        stack.push(c);
                    } else if (CLOSING_BRACKETS.indexOf(c) != -1) {
                        if (stack.isEmpty()) {
                            printError(lineNumber, line, i);
                            return;
                        }
                        char lastOpeningBracket = stack.pop();
                        if (OPENING_BRACKETS.indexOf(lastOpeningBracket) != CLOSING_BRACKETS.indexOf(c)) {
                            printError(lineNumber, line, i);
                            return;
                        }
                    }
                }
            }

            if (stack.isEmpty()) {
                System.out.println("OK");
            } else {
                System.out.println("ERROR: unclosed brackets: " + stack);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: file not found");
        }
    }

    private static void printError(int lineNumber, String line, int column) {
        System.out.println(line);
        for (int i = 0; i < column; ++i) {
            System.out.print(" ");
        }
        System.out.println("^");
        System.out.println("ERROR in line " + lineNumber + ". '" + line.charAt(column) + "' found, but '" +
                OPENING_BRACKETS.charAt(CLOSING_BRACKETS.indexOf(line.charAt(column))) + "' expected.");    }
}