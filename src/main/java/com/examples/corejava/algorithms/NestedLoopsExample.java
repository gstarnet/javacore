package com.examples.corejava.algorithms;

import java.util.List;


/**
 * Demonstrates nested loops by checking all unique pairs for a target sum.
 *
 * <p>Interview questions answered: Why is the brute force two-sum approach quadratic?
 * How can this motivate a {@code HashMap} optimization?</p>
 *
 * <p>Real-life use: pairwise comparison when input is small and clarity is more important
 * than optimization.</p>
 */
public class NestedLoopsExample {
    private NestedLoopsExample() {
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
        // 1. Use the outer loop to choose the first number in the pair.
        // 2. Start the inner loop at i + 1 so the same pair is not checked twice.
        // 3. Print pairs that hit the target and use the loops to explain O(n^2).
        List<Integer> nums = List.of(1, 2, 3, 4);
        int target = 5;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                if (nums.get(i) + nums.get(j) == target) {
                    System.out.println("Pair found: " + nums.get(i) + ", " + nums.get(j));
                }
            }
        }
        // Time: O(n^2), Space: O(1)
    }
}
