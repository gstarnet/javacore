package com.examples.corejava.complexity;

import java.util.ArrayList;
import java.util.List;


/**
 * Demonstrates linear extra space, {@code O(n)}, by creating a transformed list.
 *
 * <p>Interview questions answered: When does memory grow with input size? What tradeoff
 * is made when returning a new collection instead of modifying in place?</p>
 *
 * <p>Real-life use: preparing derived data for display or API responses while preserving
 * the original input.</p>
 */
public class LinearSpaceExample {
    private LinearSpaceExample() {
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
        // 1. Create a new output list to keep the original list unchanged.
        // 2. Visit each input value once and append its doubled value to the output.
        // 3. Because the output has one value per input value, extra space grows linearly.
        List<Integer> numbers = List.of(1, 2, 3);
        List<Integer> doubled = new ArrayList<>();
        for (int number : numbers) {
            doubled.add(number * 2);
        }
        System.out.println("Doubled: " + doubled);
        // Space: O(n), because the new list grows with the input.
        // Time: O(n)
    }
}
