package com.example.corejava.concurrency;

import java.util.HashMap;
import java.util.Map;


/**
 * Demonstrates why {@code HashMap} and get-then-put logic are unsafe for concurrent
 * writes.
 *
 * <p>Interview questions answered: Is {@code HashMap} thread-safe? Why can multi-step map
 * logic lose updates?</p>
 *
 * <p>Real-life use: recognizing when shared caches or counters need synchronization or a
 * concurrent collection.</p>
 */
public class HashMapThreadSafetyExample {
    private HashMapThreadSafetyExample() {
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
        // 1. Show a get-then-put update that appears fine in one thread.
        // 2. Explain that two threads can read the same old value before either writes back.
        // 3. Use the example as a warning to prefer synchronization or concurrent map operations.
        Map<String, Integer> counts = new HashMap<>();
        counts.put("java", 0);

        int current = counts.get("java");
        counts.put("java", current + 1);
        System.out.println("Single-thread get-then-put: " + counts);
        System.out.println("In multiple threads, HashMap plus get-then-put can lose updates.");
        // HashMap is not designed for concurrent writes. Use synchronization or ConcurrentHashMap.
    }
}
