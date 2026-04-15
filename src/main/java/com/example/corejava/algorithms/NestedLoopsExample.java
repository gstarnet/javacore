package com.example.corejava.algorithms;

import java.util.List;

public class NestedLoopsExample {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        List<Integer> nums = List.of(1, 2, 3, 4);
        int target = 5;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                if (nums.get(i) + nums.get(j) == target) {
                    System.out.println("Pair found: " + nums.get(i) + ", " + nums.get(j));
                }
            }
        }
        // Time: O(n^2), Space: O(1)
    }
}
