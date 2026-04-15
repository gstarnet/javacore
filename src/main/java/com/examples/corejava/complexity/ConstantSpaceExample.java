package com.examples.corejava.complexity;

import java.util.List;


/**
 * Demonstrates constant extra space, {@code O(1)}, while summing values.
 *
 * <p>Interview questions answered: What is auxiliary space? Why does reusing one counter
 * avoid memory growth?</p>
 *
 * <p>Real-life use: computing totals, counters, or checksums without storing another copy
 * of the input.</p>
 */
public class ConstantSpaceExample {
    private ConstantSpaceExample() {
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
        // 1. Keep only one running total while reading the list.
        // 2. Add each value into the same variable instead of building another collection.
        // 3. The input grows, but the extra memory stays fixed.
        List<Integer> numbers = List.of(2, 4, 6, 8);
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        System.out.println("Sum: " + sum);
        // Space: O(1), because sum is one variable regardless of input size.
        // Time: O(n)
    }
}
