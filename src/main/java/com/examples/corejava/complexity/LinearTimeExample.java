package com.examples.corejava.complexity;

import java.util.List;


/**
 * Demonstrates linear time, {@code O(n)}, with a simple scan through numbers.
 *
 * <p>Interview questions answered: Why is a single pass over input linear? What is the
 * worst case when the target is last or missing?</p>
 *
 * <p>Real-life use: searching a small unsorted list such as user-entered values before
 * choosing a more advanced data structure.</p>
 */
public class LinearTimeExample {
    private LinearTimeExample() {
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
        // 1. Set up a target value and scan the list from left to right.
        // 2. Check one element at a time because unsorted data gives us no shortcut.
        // 3. Stop as soon as the target is found, while still noting the worst case is O(n).
        List<Integer> numbers = List.of(3, 7, 11, 15);
        int target = 11;
        for (int number : numbers) {
            if (number == target) {
                System.out.println("Found " + target);
                break;
            }
        }
        // Time: O(n), because in the worst case we scan every element.
        // Space: O(1), because we use only a few variables.
    }
}
