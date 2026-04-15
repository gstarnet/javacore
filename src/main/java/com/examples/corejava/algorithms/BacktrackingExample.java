package com.examples.corejava.algorithms;

import java.util.ArrayList;
import java.util.List;


/**
 * Demonstrates backtracking by generating valid parentheses combinations.
 *
 * <p>Interview questions answered: How do you choose, explore, and undo a decision? How
 * do constraints prune invalid branches?</p>
 *
 * <p>Real-life use: generating valid schedules, combinations, or search choices where
 * invalid partial solutions can be rejected early.</p>
 */
public class BacktrackingExample {
    private BacktrackingExample() {
    }
    /**
     * Runs this example directly from the command line.
     *
     * @param args command-line arguments; ignored by this example
     */
    public static void main(String[] args) {
        run();
    }

    /**
     * Executes the example logic used by {@code DemoRunner} and tests.
     */
    public static void run() {
        // Walkthrough:
        // 1. Start with an empty builder that represents the partial answer.
        // 2. Try adding an opening or closing parenthesis only when it keeps the string valid.
        // 3. Undo the last character after each recursive call so the next branch starts cleanly.
        List<String> result = new ArrayList<>();
        generateParentheses(2, 0, 0, new StringBuilder(), result);
        System.out.println("Valid parentheses: " + result);
        // Backtracking explores choices, then undoes the choice before trying the next one.
    }

    private static void generateParentheses(int pairs, int open, int close, StringBuilder current, List<String> result) {
        if (current.length() == pairs * 2) {
            result.add(current.toString());
            return;
        }
        if (open < pairs) {
            current.append('(');
            generateParentheses(pairs, open + 1, close, current, result);
            current.deleteCharAt(current.length() - 1);
        }
        if (close < open) {
            current.append(')');
            generateParentheses(pairs, open, close + 1, current, result);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
