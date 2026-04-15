package com.example.corejava.algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * Demonstrates the complement lookup pattern for the classic two-sum problem.
 *
 * <p>Interview questions answered: How does a {@code HashMap} reduce nested-loop search
 * from quadratic to linear time? What must be stored while scanning?</p>
 *
 * <p>Real-life use: matching payments, inventory quantities, or pairs of values that must
 * reach a target.</p>
 */
public class TwoSumExample {
    private TwoSumExample() {
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
        // 1. Read each number once and ask which earlier number would complete the target.
        // 2. Look for that complement in the map before storing the current number.
        // 3. Return the saved index and current index as soon as the pair is found.
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println("Two sum indexes: " + Arrays.toString(twoSum(nums, target)));
        // Time: O(n), Space: O(n)
    }

    private static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexByValue = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int needed = target - nums[i];
            if (indexByValue.containsKey(needed)) {
                return new int[]{indexByValue.get(needed), i};
            }
            indexByValue.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
