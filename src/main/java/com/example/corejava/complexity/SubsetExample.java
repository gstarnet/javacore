package com.example.corejava.complexity;

import java.util.ArrayList;
import java.util.List;

public class SubsetExample {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        List<Integer> numbers = List.of(1, 2, 3);
        List<List<Integer>> subsets = new ArrayList<>();
        buildSubsets(numbers, 0, new ArrayList<>(), subsets);
        System.out.println("Subsets: " + subsets);
        // Time: O(2^n), because each number is either included or excluded.
        // Space: O(2^n) for storing every subset; O(n) recursion depth.
    }

    private static void buildSubsets(List<Integer> numbers, int index, List<Integer> current, List<List<Integer>> result) {
        if (index == numbers.size()) {
            result.add(new ArrayList<>(current));
            return;
        }
        buildSubsets(numbers, index + 1, current, result);
        current.add(numbers.get(index));
        buildSubsets(numbers, index + 1, current, result);
        current.remove(current.size() - 1);
    }
}
