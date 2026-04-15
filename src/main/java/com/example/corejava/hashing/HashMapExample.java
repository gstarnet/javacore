package com.example.corejava.hashing;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Demonstrates core {@code HashMap} operations and complement lookup.
 *
 * <p>Interview questions answered: What do {@code put}, {@code get},
 * {@code containsKey}, and {@code getOrDefault} do? Why is lookup average {@code O(1)}?</p>
 *
 * <p>Real-life use: caches, indexes, score tables, and fast pair matching.</p>
 */
public class HashMapExample {
    private HashMapExample() {
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
        // 1. Put a few values into a HashMap and read them back by key.
        // 2. Use getOrDefault to handle a missing key without a separate null check.
        // 3. Then reuse the map idea for the complement lookup interview pattern.
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Ada", 95);
        scores.put("Grace", 98);
        System.out.println("Contains Ada: " + scores.containsKey("Ada"));
        System.out.println("Grace score: " + scores.get("Grace"));
        System.out.println("Missing score default: " + scores.getOrDefault("Linus", 0));

        List<Integer> nums = List.of(2, 7, 11);
        int target = 9;
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            int complement = target - nums.get(i);
            if (seen.containsKey(complement)) {
                System.out.println("Complement lookup found pair: " + complement + ", " + nums.get(i));
            }
            seen.put(nums.get(i), i);
        }
        // Average lookup/insert: O(1), assuming a healthy hash distribution.
    }
}
