package com.example.corejava.algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumExample {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
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
