package com.example.corejava.complexity;

import java.util.List;


/**
 * Demonstrates constant time, {@code O(1)}, by reading a known index from a list.
 *
 * <p>Interview questions answered: What does constant time mean? Does a larger input
 * change the amount of work when direct access is available?</p>
 *
 * <p>Real-life use: reading a known cache slot, array position, or configuration value
 * where lookup cost should stay fixed.</p>
 */
public class ConstantTimeExample {
    private ConstantTimeExample() {
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
        // 1. Start with a tiny list so the direct index access is easy to see.
        // 2. Read index 0 immediately; no loop is needed, so input size does not change this work.
        // 3. Print the value and connect the operation to O(1) time and O(1) space.
        List<String> names = List.of("Ada", "Grace", "James");
        // Reading by index from an ArrayList-style list does not depend on list size.
        // Interview note: O(1) means the work stays constant as input grows.
        System.out.println("First name: " + names.get(0));
        // Expected output: First name: Ada
        // Time: O(1), Space: O(1)
    }
}
