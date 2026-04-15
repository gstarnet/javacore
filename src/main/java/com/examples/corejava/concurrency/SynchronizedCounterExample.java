package com.examples.corejava.concurrency;


/**
 * Demonstrates using {@code synchronized} to protect shared mutable state.
 *
 * <p>Interview questions answered: Why is increment not automatically atomic? How does a
 * synchronized method prevent lost updates?</p>
 *
 * <p>Real-life use: protecting counters, balances, or other mutable values shared by
 * multiple threads.</p>
 */
public class SynchronizedCounterExample {
    private SynchronizedCounterExample() {
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
        // 1. Create one shared counter and two threads that both update it.
        // 2. Use synchronized methods so only one thread changes the counter at a time.
        // 3. Join both threads before reading the final value.
        Counter counter = new Counter();
        Thread first = new Thread(() -> incrementMany(counter));
        Thread second = new Thread(() -> incrementMany(counter));
        first.start();
        second.start();
        join(first);
        join(second);
        System.out.println("Synchronized counter: " + counter.value());
    }

    private static void incrementMany(Counter counter) {
        for (int i = 0; i < 1_000; i++) {
            counter.increment();
        }
    }

    private static void join(Thread thread) {
        try {
            thread.join();
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
        }
    }

    private static class Counter {
        private int value;

        private synchronized void increment() {
            value++;
        }

        private synchronized int value() {
            return value;
        }
    }
}
