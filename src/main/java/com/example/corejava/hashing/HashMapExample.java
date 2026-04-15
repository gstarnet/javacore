package com.example.corejava.hashing;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Ada", 95);
        scores.put("Grace", 98);
        System.out.println("Contains Ada: " + scores.containsKey("Ada"));
        System.out.println("Grace score: " + scores.get("Grace"));
        System.out.println("Missing score default: " + scores.getOrDefault("Linus", 0));

        List<Integer> nums = List.of(2, 7, 11);
        int target = 9;
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            int complement = target - nums.get(i);
            if (seen.containsKey(complement)) {
                System.out.println("Complement lookup found pair: " + complement + ", " + nums.get(i));
            }
            seen.put(nums.get(i), i);
        }
        // Average lookup/insert: O(1), assuming a healthy hash distribution.
    }
}
