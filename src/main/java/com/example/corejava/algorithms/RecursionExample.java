package com.example.corejava.algorithms;


/**
 * Demonstrates recursion with factorial and a clear base case.
 *
 * <p>Interview questions answered: What is a base case? Why does recursion use call stack
 * space? When can recursion be replaced with iteration?</p>
 *
 * <p>Real-life use: processing naturally nested structures such as folders, trees, or
 * expression nodes.</p>
 */
public class RecursionExample {
    private RecursionExample() {
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
        // 1. Call factorial with a small input so the recursive chain is easy to trace.
        // 2. The helper stops at the base case before the calls unwind.
        // 3. Each return multiplies the current number by the result of the smaller problem.
        System.out.println("Factorial 5: " + factorial(5));
        // Time: O(n), Space: O(n) because each recursive call uses stack space.
    }

    private static int factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}
