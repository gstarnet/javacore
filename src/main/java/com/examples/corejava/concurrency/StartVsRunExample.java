package com.examples.corejava.concurrency;


/**
 * Demonstrates the difference between calling {@code run()} and {@code start()}.
 *
 * <p>Interview questions answered: Why does {@code run()} stay on the current thread?
 * What does {@code start()} add?</p>
 *
 * <p>Real-life use: debugging code that appears concurrent but accidentally executes on
 * the caller thread.</p>
 */
public class StartVsRunExample {
    private StartVsRunExample() {
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
        // 1. Call run directly to show it behaves like a normal method call.
        // 2. Call start on a Thread to show execution moves to a worker thread.
        // 3. Join the worker so the printed comparison is reliable.
        Runnable task = () -> System.out.println("Executing on: " + Thread.currentThread().getName());

        System.out.print("Calling run() directly: ");
        task.run();

        System.out.print("Calling start(): ");
        Thread thread = new Thread(task, "worker-thread");
        thread.start();
        join(thread);
        // run() is a normal method call. start() creates a new call stack on another thread.
    }

    private static void join(Thread thread) {
        try {
            thread.join();
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
        }
    }
}
