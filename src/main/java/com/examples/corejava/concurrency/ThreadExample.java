package com.examples.corejava.concurrency;


/**
 * Demonstrates creating a {@code Thread} from a {@code Runnable}.
 *
 * <p>Interview questions answered: What is the difference between a task and a thread?
 * Why call {@code join} in a demo?</p>
 *
 * <p>Real-life use: understanding the foundation beneath executors, background jobs, and
 * asynchronous processing.</p>
 */
public class ThreadExample {
    private ThreadExample() {
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
        // 1. Create a Runnable that describes the work to do.
        // 2. Pass the Runnable to a Thread and start it on a separate call stack.
        // 3. Join the thread so the demo waits for the background output before finishing.
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
