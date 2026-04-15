package com.examples.corejava.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


/**
 * Demonstrates lambda expressions and method references in sorting.
 *
 * <p>Interview questions answered: What is a lambda? When can a method reference make the
 * code clearer?</p>
 *
 * <p>Real-life use: passing small behaviors for sorting, filtering, callbacks, or event
 * handling.</p>
 */
public class LambdaExample {
    private LambdaExample() {
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
        // 1. Sort once with an inline lambda so the comparison logic is visible.
        // 2. Sort again with a method reference based comparator.
        // 3. Use both forms to show common Java 8+ functional syntax.
        List<String> names = new ArrayList<>(List.of("Grace", "Ada", "Katherine"));
        names.sort((left, right) -> Integer.compare(left.length(), right.length()));
        System.out.println("Sorted with lambda: " + names);

        names.sort(Comparator.comparing(String::toLowerCase));
        System.out.println("Sorted with method reference: " + names);
    }
}
