package com.examples.corejava.strings;


/**
 * Demonstrates {@code StringBuilder} for repeated string construction.
 *
 * <p>Interview questions answered: Why can repeated string concatenation be inefficient?
 * When is a mutable builder clearer and faster?</p>
 *
 * <p>Real-life use: building CSV rows, log messages, SQL fragments, or response text in a
 * loop.</p>
 */
public class StringBuilderExample {
    private StringBuilderExample() {
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
        // 1. Create one StringBuilder to reuse the same buffer.
        // 2. Append each piece inside the loop instead of creating many intermediate Strings.
        // 3. Convert the builder to a String at the end when the final text is needed.
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= 3; i++) {
            builder.append("item").append(i).append(" ");
        }
        System.out.println("Built string: " + builder.toString().trim());
        // Repeated String concatenation can create many temporary objects.
        // StringBuilder reuses one mutable buffer, which is better for loops.
    }
}
