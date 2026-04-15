package com.example.corejava.collections;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Demonstrates frequency counting with a {@code Map} and {@code merge}.
 *
 * <p>Interview questions answered: How do you count repeated values cleanly? What are
 * the time and space costs?</p>
 *
 * <p>Real-life use: counting words, event types, product purchases, or error codes.</p>
 */
public class FrequencyCountExample {
    private FrequencyCountExample() {
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
        // 1. Start with repeated words so counting has something to do.
        // 2. For each word, merge one more occurrence into the map.
        // 3. The final map shows each unique word and how many times it appeared.
        List<String> words = List.of("java", "map", "java", "list");
        Map<String, Integer> counts = new HashMap<>();
        for (String word : words) {
            counts.merge(word, 1, Integer::sum);
        }
        System.out.println("Frequency count: " + counts);
        // Time: O(n), Space: O(k) where k is the number of unique words.
    }
}
