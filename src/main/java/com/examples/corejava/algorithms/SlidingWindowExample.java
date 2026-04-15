package com.examples.corejava.algorithms;


/**
 * Demonstrates a fixed-size sliding window for maximum subarray sum.
 *
 * <p>Interview questions answered: How can you reuse previous work instead of recomputing
 * each window? When does sliding window apply?</p>
 *
 * <p>Real-life use: rolling metrics such as page views, sales totals, or sensor readings
 * over a fixed interval.</p>
 */
public class SlidingWindowExample {
    private SlidingWindowExample() {
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
        // 1. Build the first window by summing the first k values.
        // 2. Slide one step at a time by adding the new right value and removing the old left value.
        // 3. Track the best sum seen without recomputing every window from scratch.
        int[] nums = {2, 1, 5, 1, 3, 2};
        int k = 3;
        System.out.println("Max sum of size " + k + ": " + maxWindowSum(nums, k));
        // Time: O(n), Space: O(1)
    }

    private static int maxWindowSum(int[] nums, int k) {
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }
        int best = windowSum;
        for (int right = k; right < nums.length; right++) {
            windowSum += nums[right] - nums[right - k];
            best = Math.max(best, windowSum);
        }
        return best;
    }
}
