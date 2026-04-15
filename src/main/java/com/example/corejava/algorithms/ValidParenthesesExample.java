package com.example.corejava.algorithms;

import java.util.ArrayDeque;
import java.util.Map;

public class ValidParenthesesExample {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
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
