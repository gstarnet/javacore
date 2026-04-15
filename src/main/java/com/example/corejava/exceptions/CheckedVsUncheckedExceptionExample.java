package com.example.corejava.exceptions;

import java.io.IOException;

public class CheckedVsUncheckedExceptionExample {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
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
