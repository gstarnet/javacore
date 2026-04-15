package com.example.corejava.concurrency;

public class SynchronizedCounterExample {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
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
