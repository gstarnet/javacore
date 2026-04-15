package com.example.corejava.collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


/**
 * Demonstrates duplicate removal with {@code HashSet} and order-preserving
 * {@code LinkedHashSet}.
 *
 * <p>Interview questions answered: How do you remove duplicates? How do you preserve the
 * first-seen order?</p>
 *
 * <p>Real-life use: unique email lists, tags, or imported IDs while keeping display order.</p>
 */
public class RemoveDuplicatesExample {
    private RemoveDuplicatesExample() {
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
        // 1. Start with a list that intentionally contains a repeated value.
        // 2. Use HashSet when order is not important.
        // 3. Use LinkedHashSet when duplicates should disappear but original order should remain.
        List<String> names = List.of("Ada", "Grace", "Ada", "James");
        Set<String> uniqueAnyOrder = new HashSet<>(names);
        Set<String> uniqueOriginalOrder = new LinkedHashSet<>(names);
        System.out.println("Unique any order: " + uniqueAnyOrder);
        System.out.println("Unique preserving order: " + uniqueOriginalOrder);
    }
}
