package com.examples.corejava.hashing;

import java.util.HashMap;
import java.util.Map;


/**
 * Demonstrates using a custom object as a {@code HashMap} key and notes multi-step update
 * risk.
 *
 * <p>Interview questions answered: Why are records convenient map keys? Why can separate
 * get-then-put logic lose updates under concurrency?</p>
 *
 * <p>Real-life use: inventory lookup by compound key and safe counter updates.</p>
 */
public class CustomObjectHashExample {
    private CustomObjectHashExample() {
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
        // 1. Use a record as a compound map key because records provide equals and hashCode.
        // 2. Look up inventory with a new key object that has the same field values.
        // 3. Show getOrDefault-style counting and point out why multi-step updates need care.
        Map<ProductKey, Integer> inventory = new HashMap<>();
        inventory.put(new ProductKey("book", "java-17"), 10);
        System.out.println("Lookup custom key: " + inventory.get(new ProductKey("book", "java-17")));

        Map<String, Integer> counts = new HashMap<>();
        String key = "java";
        counts.put(key, counts.getOrDefault(key, 0) + 1);
        System.out.println("Multi-step map update result: " + counts);
        // In concurrent code, get-then-put is not atomic. Prefer merge/compute or ConcurrentHashMap methods.
    }

    private record ProductKey(String category, String sku) {
    }
}
