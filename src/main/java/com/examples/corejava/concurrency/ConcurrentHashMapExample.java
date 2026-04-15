package com.examples.corejava.concurrency;

import java.util.concurrent.ConcurrentHashMap;


/**
 * Demonstrates a thread-safe map update using {@code ConcurrentHashMap.compute}.
 *
 * <p>Interview questions answered: What does {@code ConcurrentHashMap} protect? Why are
 * atomic map methods better than separate read and write operations?</p>
 *
 * <p>Real-life use: shared caches, counters, or registries updated by worker threads.</p>
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
        // 1. Use ConcurrentHashMap for safe internal map access across threads.
        // 2. Use compute so reading the old value and writing the new value happen as one map operation.
        // 3. Print the count to show the atomic update result.
        ConcurrentHashMap<String, Integer> counts = new ConcurrentHashMap<>();
        counts.put("java", 1);
        counts.compute("java", (key, oldValue) -> oldValue == null ? 1 : oldValue + 1);
        System.out.println("ConcurrentHashMap count: " + counts.get("java"));
        // ConcurrentHashMap protects its internal structure during concurrent access.
    }
}
