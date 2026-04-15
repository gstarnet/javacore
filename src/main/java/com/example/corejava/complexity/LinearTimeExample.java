package com.example.corejava.complexity;

import java.util.List;

public class LinearTimeExample {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        List<Integer> numbers = List.of(3, 7, 11, 15);
        int target = 11;
        for (int number : numbers) {
            if (number == target) {
                System.out.println("Found " + target);
                break;
            }
        }
        // Time: O(n), because in the worst case we scan every element.
        // Space: O(1), because we use only a few variables.
    }
}
