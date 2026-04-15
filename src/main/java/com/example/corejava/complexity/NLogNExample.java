package com.example.corejava.complexity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Demonstrates {@code O(n log n)} work with comparison-based sorting.
 *
 * <p>Interview questions answered: Why is sorting commonly described as {@code n log n}?
 * When is sorting a practical preprocessing step before searching or merging?</p>
 *
 * <p>Real-life use: ordering reports, preparing records for merge logic, or ranking
 * results before display.</p>
 */
public class NLogNExample {
    private NLogNExample() {
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
        // 1. Copy sample scores into a mutable list because sorting changes element order.
        // 2. Call the standard library sort instead of hand-writing sorting code.
        // 3. Use the result to discuss why comparison sorting is usually O(n log n).
        List<Integer> scores = new ArrayList<>(List.of(40, 10, 30, 20));
        Collections.sort(scores);
        System.out.println("Sorted scores: " + scores);
        // Typical comparison sorting is O(n log n).
        // Space depends on the sorting implementation; for this study example, focus on time.
    }
}
