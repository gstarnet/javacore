package com.example.corejava.complexity;

import java.util.ArrayList;
import java.util.List;


/**
 * Demonstrates factorial time, {@code O(n!)}, by generating all permutations.
 *
 * <p>Interview questions answered: Why do arrangements grow so quickly? Why are brute
 * force permutation approaches dangerous for larger inputs?</p>
 *
 * <p>Real-life use: tiny scheduling or ordering experiments where every possible order
 * must be inspected.</p>
 */
public class PermutationExample {
    private PermutationExample() {
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
        // 1. Start with an empty prefix and all characters still available.
        // 2. Choose each remaining character as the next position in the permutation.
        // 3. Continue until no characters remain, then store the completed arrangement.
        List<String> result = new ArrayList<>();
        permute("", "ABC", result);
        System.out.println("Permutations: " + result);
        // Time: O(n!), because the number of arrangements grows factorially.
        // Space: O(n!) to store all permutations; O(n) recursion depth.
    }

    private static void permute(String prefix, String remaining, List<String> result) {
        if (remaining.isEmpty()) {
            result.add(prefix);
            return;
        }
        for (int i = 0; i < remaining.length(); i++) {
            permute(prefix + remaining.charAt(i), remaining.substring(0, i) + remaining.substring(i + 1), result);
        }
    }
}
