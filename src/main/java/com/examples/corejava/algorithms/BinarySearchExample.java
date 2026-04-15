package com.examples.corejava.algorithms;


/**
 * Demonstrates iterative binary search on a sorted integer array.
 *
 * <p>Interview questions answered: How do you avoid midpoint overflow? Why does binary
 * search return {@code -1} when a target is absent?</p>
 *
 * <p>Real-life use: locating IDs, thresholds, or timestamps in sorted data.</p>
 */
public class BinarySearchExample {
    private BinarySearchExample() {
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
        // 1. Use sorted input because binary search depends on ordering.
        // 2. Move the left or right boundary after comparing with the middle value.
        // 3. Return the index when found, or -1 when the search area is empty.
        int[] sorted = {1, 3, 5, 7, 9};
        System.out.println("Binary search index: " + binarySearch(sorted, 7));
        // Time: O(log n), Space: O(1)
    }

    private static int binarySearch(int[] sorted, int target) {
        int left = 0;
        int right = sorted.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (sorted[mid] == target) {
                return mid;
            }
            if (sorted[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
