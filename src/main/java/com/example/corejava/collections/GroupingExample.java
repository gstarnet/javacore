package com.example.corejava.collections;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * Demonstrates grouping values with streams and {@code Collectors.groupingBy}.
 *
 * <p>Interview questions answered: How do you group records by a derived key? When is a
 * stream collector clearer than manual map logic?</p>
 *
 * <p>Real-life use: grouping orders by status, users by role, or names by first letter.</p>
 */
public class GroupingExample {
    private GroupingExample() {
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
        // 1. Start with names that share first letters so grouping is visible.
        // 2. Use groupingBy to create a map from first letter to matching names.
        // 3. Read the result as a small version of grouping database or report rows.
        List<String> names = List.of("Ada", "Alan", "Grace", "George");
        Map<Character, List<String>> byFirstLetter = names.stream()
                .collect(Collectors.groupingBy(name -> name.charAt(0)));
        System.out.println("Grouped by first letter: " + byFirstLetter);
    }
}
