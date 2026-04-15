package com.examples.corejava.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


/**
 * Demonstrates sorting plus a linear pass to merge overlapping intervals.
 *
 * <p>Interview questions answered: Why sort by start time first? How do you decide
 * whether to extend the last interval or start a new one?</p>
 *
 * <p>Real-life use: merging calendar events, booking windows, or maintenance periods.</p>
 */
public class MergeIntervalsExample {
    private MergeIntervalsExample() {
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
        // 1. Sort intervals by start time so overlaps become neighbors.
        // 2. Compare each interval with the last merged interval.
        // 3. Either append a new interval or extend the previous end boundary.
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}};
        System.out.println("Merged intervals: " + format(merge(intervals)));
        // Time: O(n log n) because of sorting, Space: O(n)
    }

    private static List<int[]> merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        List<int[]> merged = new ArrayList<>();
        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval);
            } else {
                int[] last = merged.get(merged.size() - 1);
                last[1] = Math.max(last[1], interval[1]);
            }
        }
        return merged;
    }

    private static String format(List<int[]> intervals) {
        List<String> parts = new ArrayList<>();
        for (int[] interval : intervals) {
            parts.add(Arrays.toString(interval));
        }
        return parts.toString();
    }
}
