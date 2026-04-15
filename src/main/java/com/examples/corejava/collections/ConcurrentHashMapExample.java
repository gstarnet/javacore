package com.examples.corejava.collections;

import java.util.concurrent.ConcurrentHashMap;


/**
 * Demonstrates common {@code ConcurrentHashMap} operations in the collections package.
 *
 * <p>Interview questions answered: What operations are atomic? Why is get-then-put still
 * a design smell in concurrent code?</p>
 *
 * <p>Real-life use: shared counters, caches, and registry maps accessed by multiple
 * threads.</p>
 */
public class ConcurrentHashMapExample {
    private ConcurrentHashMapExample() {
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
        // 1. Start with a concurrent map so individual map operations are thread-safe.
        // 2. Use putIfAbsent to avoid overwriting an existing value.
        // 3. Use compute when the new value depends on the old value.
        ConcurrentHashMap<String, Integer> counts = new ConcurrentHashMap<>();
        counts.put("java", 1);
        counts.putIfAbsent("java", 99);
        counts.compute("java", (key, oldValue) -> oldValue == null ? 1 : oldValue + 1);
        System.out.println("ConcurrentHashMap atomic update: " + counts);
        // Individual operations are thread-safe, but a separate get-then-put sequence can still be risky.
    }
}
