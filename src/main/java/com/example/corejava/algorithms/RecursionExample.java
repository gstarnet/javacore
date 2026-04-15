package com.example.corejava.algorithms;

public class RecursionExample {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
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
