package com.example.corejava.exceptions;

public class FinalFinallyFinalizeExample {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
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
