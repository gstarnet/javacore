package com.examples.corejava.exceptions;

import java.io.IOException;


/**
 * Demonstrates checked and unchecked exception handling.
 *
 * <p>Interview questions answered: Which exceptions must be declared or caught? When is a
 * runtime exception appropriate?</p>
 *
 * <p>Real-life use: handling file or network failures while treating invalid programmer
 * input as unchecked failure.</p>
 */
public class CheckedVsUncheckedExceptionExample {
    private CheckedVsUncheckedExceptionExample() {
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
        // 1. Call a method that declares a checked IOException and handle it explicitly.
        // 2. Call parsing code that can throw an unchecked NumberFormatException.
        // 3. Compare the two flows to explain compile-time versus runtime exception handling.
        try {
            readConfiguration();
        } catch (IOException exception) {
            System.out.println("Checked exception handled: " + exception.getMessage());
        }

        try {
            parsePort("not-a-number");
        } catch (NumberFormatException exception) {
            System.out.println("Unchecked exception handled: " + exception.getMessage());
        }
    }

    private static void readConfiguration() throws IOException {
        throw new IOException("config file missing");
    }

    private static int parsePort(String text) {
        return Integer.parseInt(text);
    }
}
