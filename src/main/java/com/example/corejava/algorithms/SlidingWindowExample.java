package com.example.corejava.algorithms;

public class SlidingWindowExample {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
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
