package com.example.corejava.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Demonstrates atomic map operations such as {@code putIfAbsent}, {@code computeIfAbsent},
 * and {@code compute}.
 *
 * <p>Interview questions answered: Which map operations combine check and update safely?
 * Why can mutable values still require careful design?</p>
 *
 * <p>Real-life use: initializing per-user state, counters, caches, or grouped values under
 * concurrency.</p>
 */
public class AtomicMapOperationsExample {
    private AtomicMapOperationsExample() {
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
        // 1. Use putIfAbsent when a key should be initialized only if missing.
        // 2. Use computeIfAbsent when creating a value is part of the lookup.
        // 3. Use compute when the replacement depends on the previous value.
        ConcurrentHashMap<String, List<String>> tagsByUser = new ConcurrentHashMap<>();
        tagsByUser.putIfAbsent("ada", new ArrayList<>());
        tagsByUser.computeIfAbsent("grace", key -> new ArrayList<>()).add("compiler");
        tagsByUser.compute("ada", (key, tags) -> {
            List<String> safeTags = tags == null ? new ArrayList<>() : tags;
            safeTags.add("math");
            return safeTags;
        });

        System.out.println("Atomic map operations: " + tagsByUser);
        System.out.println("Warning: mutating the List value itself still needs careful design.");
        // ConcurrentHashMap makes map operations atomic, not every operation on mutable values.
    }
}
