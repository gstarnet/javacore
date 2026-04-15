package com.example.corejava.algorithms;

import java.util.ArrayDeque;
import java.util.Map;


/**
 * Demonstrates stack usage for validating balanced brackets.
 *
 * <p>Interview questions answered: Why is last-in, first-out behavior useful? How do you
 * detect mismatched or unclosed delimiters?</p>
 *
 * <p>Real-life use: validating expressions, markup, query syntax, or configuration text.</p>
 */
public class ValidParenthesesExample {
    private ValidParenthesesExample() {
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
        // 1. Push opening brackets because they must be matched later in reverse order.
        // 2. When a closing bracket appears, compare it with the most recent opening bracket.
        // 3. A valid string ends with no mismatch and an empty stack.
        String input = "{[()]}";
        System.out.println(input + " is valid: " + isValid(input));
        // Time: O(n), Space: O(n)
    }

    private static boolean isValid(String input) {
        Map<Character, Character> pairs = Map.of(')', '(', ']', '[', '}', '{');
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (char ch : input.toCharArray()) {
            if (pairs.containsValue(ch)) {
                stack.push(ch);
            } else if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.pop() != pairs.get(ch)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
