package com.examples.corejava.strings;


/**
 * Demonstrates {@code String} immutability and concatenation creating a new value.
 *
 * <p>Interview questions answered: Why does the original string not change? Why is
 * immutability useful for sharing and map keys?</p>
 *
 * <p>Real-life use: safe text values in logs, configuration, request IDs, and cache keys.</p>
 */
public class StringImmutabilityExample {
    private StringImmutabilityExample() {
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
        // 1. Create one original String value.
        // 2. Call concat and store the returned value because Strings do not mutate in place.
        // 3. Print both references to prove the original text stayed unchanged.
        String original = "Java";
        String updated = original.concat(" 17");
        System.out.println("Original unchanged: " + original);
        System.out.println("New string: " + updated);
        // Immutability makes String safe to share and usable as a reliable Map key.
    }
}
