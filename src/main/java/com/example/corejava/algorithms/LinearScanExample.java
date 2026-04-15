package com.example.corejava.algorithms;

import java.util.List;


/**
 * Demonstrates the linear scan pattern for finding a matching value.
 *
 * <p>Interview questions answered: What is the simplest search strategy? What are the
 * time and space costs when data is unsorted?</p>
 *
 * <p>Real-life use: validating a short list of form options or checking a small in-memory
 * collection.</p>
 */
public class LinearScanExample {
    private LinearScanExample() {
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
        // 1. Keep the target value separate from the list so the comparison is obvious.
        // 2. Walk through indexes one by one until the matching name is found.
        // 3. Store -1 as the default answer so the code also handles a missing target.
        List<String> names = List.of("Ada", "Grace", "Katherine");
        String target = "Grace";
        int foundIndex = -1;
        for (int i = 0; i < names.size(); i++) {
            if (names.get(i).equals(target)) {
                foundIndex = i;
                break;
            }
        }
        System.out.println("Linear scan index: " + foundIndex);
        // Time: O(n), Space: O(1)
    }
}
