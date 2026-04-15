package com.examples.corejava.optional;

import java.util.Optional;


/**
 * Demonstrates basic {@code Optional} usage for a value that may be missing.
 *
 * <p>Interview questions answered: Why return {@code Optional} instead of {@code null}?
 * How do {@code map} and {@code orElse} express fallback logic?</p>
 *
 * <p>Real-life use: lookup methods where a user, configuration value, or database row may
 * not exist.</p>
 */
public class OptionalExample {
    private OptionalExample() {
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
        // 1. Call a lookup method that may or may not find a name.
        // 2. Use map to transform the present value without manually checking for null.
        // 3. Use orElse to provide a readable fallback when the Optional is empty.
        Optional<String> name = findNameById(1);
        String displayName = name.map(String::toUpperCase).orElse("UNKNOWN");
        System.out.println("Display name: " + displayName);

        Optional<String> missing = findNameById(99);
        System.out.println("Fallback: " + missing.orElse("Guest"));
        // Optional helps express that a result may be missing without returning null.
    }

    private static Optional<String> findNameById(int id) {
        if (id == 1) {
            return Optional.of("Ada");
        }
        return Optional.empty();
    }
}
