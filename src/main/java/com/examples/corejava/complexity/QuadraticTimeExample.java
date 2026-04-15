package com.examples.corejava.complexity;

import java.util.List;


/**
 * Demonstrates quadratic time, {@code O(n^2)}, with nested loops over the same input.
 *
 * <p>Interview questions answered: Why do nested loops often multiply work? How many
 * pairs are produced when every item is compared with every other item?</p>
 *
 * <p>Real-life use: comparing every pair of records, such as duplicate detection before
 * replacing it with hashing or sorting.</p>
 */
public class QuadraticTimeExample {
    private QuadraticTimeExample() {
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
        // 1. Use one loop to pick the first person in a possible pair.
        // 2. Use a second loop to pair that person with every other person.
        // 3. Notice that every added input item creates another full pass of work.
        List<String> people = List.of("Ana", "Ben", "Cal");
        for (String first : people) {
            for (String second : people) {
                System.out.println(first + " meets " + second);
            }
        }
        // Time: O(n^2), because each element is paired with every element.
        // Space: O(1)
    }
}
