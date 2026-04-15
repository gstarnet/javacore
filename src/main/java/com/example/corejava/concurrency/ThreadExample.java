package com.example.corejava.concurrency;

public class ThreadExample {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        Thread thread = new Thread(() -> System.out.println("Runnable running on: " + Thread.currentThread().getName()));
        thread.start();
        join(thread);
        // Runnable separates the task from the Thread that executes it.
    }

    private static void join(Thread thread) {
        try {
            thread.join();
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
        }
    }
}
