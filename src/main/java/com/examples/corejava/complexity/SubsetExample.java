package com.examples.corejava.complexity;

import java.util.ArrayList;
import java.util.List;


/**
 * Demonstrates exponential time, {@code O(2^n)}, by generating all subsets.
 *
 * <p>Interview questions answered: Why does each include-or-exclude choice double the
 * search space? When is exhaustive generation acceptable?</p>
 *
 * <p>Real-life use: exploring small combinations such as feature flags, small menu
 * bundles, or permission sets.</p>
 */
public class SubsetExample {
    private SubsetExample() {
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
        // 1. Start with an empty result list that will collect every subset.
        // 2. For each number, recursively explore two choices: skip it or include it.
        // 3. Backtrack by removing the chosen number before returning to the previous decision.
        List<Integer> numbers = List.of(1, 2, 3);
        List<List<Integer>> subsets = new ArrayList<>();
        buildSubsets(numbers, 0, new ArrayList<>(), subsets);
        System.out.println("Subsets: " + subsets);
        // Time: O(2^n), because each number is either included or excluded.
        // Space: O(2^n) for storing every subset; O(n) recursion depth.
    }

    private static void buildSubsets(List<Integer> numbers, int index, List<Integer> current, List<List<Integer>> result) {
        if (index == numbers.size()) {
            result.add(new ArrayList<>(current));
            return;
        }
        buildSubsets(numbers, index + 1, current, result);
        current.add(numbers.get(index));
        buildSubsets(numbers, index + 1, current, result);
        current.remove(current.size() - 1);
    }
}
