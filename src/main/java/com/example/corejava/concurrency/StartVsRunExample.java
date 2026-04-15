package com.example.corejava.concurrency;

public class StartVsRunExample {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
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
