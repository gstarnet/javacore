package com.example.corejava.sorting;

import java.util.Arrays;
import java.util.Comparator;


/**
 * Demonstrates sorting primitive arrays versus boxed object arrays.
 *
 * <p>Interview questions answered: Why can primitive arrays not use comparator-based
 * descending sort directly? Why is {@code Integer.compare} overflow-safe?</p>
 *
 * <p>Real-life use: choosing between memory-efficient primitive arrays and flexible object
 * arrays when sorting.</p>
 */
public class PrimitiveVsObjectSortingExample {
    private PrimitiveVsObjectSortingExample() {
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
        // 1. Sort an int array directly for efficient ascending primitive sorting.
        // 2. Use Integer[] when a Comparator is needed for descending order.
        // 3. Compare large numbers with Integer.compare so overflow cannot flip the answer.
        int[] primitive = {3, 1, 2};
        Arrays.sort(primitive);
        System.out.println("Primitive ascending: " + Arrays.toString(primitive));

        Integer[] boxed = {3, 1, 2};
        Arrays.sort(boxed, Comparator.reverseOrder());
        System.out.println("Boxed descending: " + Arrays.toString(boxed));

        int a = Integer.MAX_VALUE;
        int b = -1;
        System.out.println("Integer.compare avoids overflow: " + Integer.compare(a, b));
        // Do not compare with a - b; subtraction can overflow and give the wrong sign.
    }
}
