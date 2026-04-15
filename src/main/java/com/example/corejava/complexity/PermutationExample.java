package com.example.corejava.complexity;

import java.util.ArrayList;
import java.util.List;

public class PermutationExample {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        List<String> result = new ArrayList<>();
        permute("", "ABC", result);
        System.out.println("Permutations: " + result);
        // Time: O(n!), because the number of arrangements grows factorially.
        // Space: O(n!) to store all permutations; O(n) recursion depth.
    }

    private static void permute(String prefix, String remaining, List<String> result) {
        if (remaining.isEmpty()) {
            result.add(prefix);
            return;
        }
        for (int i = 0; i < remaining.length(); i++) {
            permute(prefix + remaining.charAt(i), remaining.substring(0, i) + remaining.substring(i + 1), result);
        }
    }
}
