package com.example.corejava.complexity;

import java.util.List;

public class ConstantSpaceExample {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        List<Integer> numbers = List.of(2, 4, 6, 8);
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        System.out.println("Sum: " + sum);
        // Space: O(1), because sum is one variable regardless of input size.
        // Time: O(n)
    }
}
