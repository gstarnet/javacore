package com.examples.corejava.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 * Demonstrates common Java sorting APIs for arrays and lists.
 *
 * <p>Interview questions answered: When do you use {@code Arrays.sort},
 * {@code Collections.sort}, or {@code List.sort}? How do ascending and descending sorts
 * differ?</p>
 *
 * <p>Real-life use: sorting reports, names, scores, and display data.</p>
 */
public class SortingExamples {
    private SortingExamples() {
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
        // 1. Sort primitive arrays with Arrays.sort because primitives do not accept comparators.
        // 2. Sort lists with Collections.sort or List.sort depending on style and comparator needs.
        // 3. Change the comparator to switch from natural order to reverse or length-based order.
        int[] primitiveScores = {30, 10, 20};
        Arrays.sort(primitiveScores);
        System.out.println("Arrays.sort primitives ascending: " + Arrays.toString(primitiveScores));

        List<String> names = new ArrayList<>(List.of("Grace", "Ada", "Katherine"));
        Collections.sort(names);
        System.out.println("Collections.sort ascending: " + names);

        names.sort(Comparator.reverseOrder());
        System.out.println("List.sort descending: " + names);

        names.sort(Comparator.comparingInt(String::length));
        System.out.println("Strings by length: " + names);
        // Common interview trap: primitive arrays cannot use reverseOrder directly.
    }
}
