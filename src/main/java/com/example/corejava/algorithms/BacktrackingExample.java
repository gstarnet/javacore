package com.example.corejava.algorithms;

import java.util.ArrayList;
import java.util.List;

public class BacktrackingExample {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
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
