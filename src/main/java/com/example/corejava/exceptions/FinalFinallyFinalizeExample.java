package com.example.corejava.exceptions;


/**
 * Demonstrates the difference between {@code final}, {@code finally}, and obsolete
 * {@code finalize}.
 *
 * <p>Interview questions answered: Which keyword prevents reassignment? Which block runs
 * cleanup? Why should {@code finalize} be avoided?</p>
 *
 * <p>Real-life use: writing safer constants, predictable cleanup, and modern resource
 * management.</p>
 */
public class FinalFinallyFinalizeExample {
    private FinalFinallyFinalizeExample() {
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
        // 1. Use final to show a value that should not be reassigned.
        // 2. Use finally to show cleanup code that runs after the try block.
        // 3. Mention finalize only as legacy knowledge so modern cleanup choices are clear.
        final int maxRetries = 3;
        System.out.println("final variable cannot be reassigned: " + maxRetries);

        try {
            System.out.println("try block runs business logic");
        } finally {
            System.out.println("finally block runs cleanup logic");
        }

        System.out.println("finalize is obsolete; use try-with-resources or cleaners for cleanup.");
        // finalize existed for GC-time cleanup, but it is deprecated and unreliable for modern Java.
    }
}
