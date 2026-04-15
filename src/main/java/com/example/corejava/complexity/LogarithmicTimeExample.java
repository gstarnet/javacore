package com.example.corejava.complexity;


/**
 * Demonstrates logarithmic time, {@code O(log n)}, using binary search.
 *
 * <p>Interview questions answered: Why must binary search use sorted data? How does
 * halving the search area reduce work?</p>
 *
 * <p>Real-life use: fast lookup in sorted IDs, sorted timestamps, or ordered ranges.</p>
 */
public class LogarithmicTimeExample {
    private LogarithmicTimeExample() {
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
        // 1. Keep left and right boundaries around the current search area.
        // 2. Check the middle value and discard the half that cannot contain the target.
        // 3. Repeat until the target is found or the boundaries cross.
        int[] sorted = {2, 4, 6, 8, 10, 12, 14};
        int target = 10;
        int left = 0;
        int right = sorted.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (sorted[mid] == target) {
                System.out.println("Found at index " + mid);
                return;
            }
            if (sorted[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // Time: O(log n), because each step cuts the search area in half.
        // Space: O(1)
    }
}
