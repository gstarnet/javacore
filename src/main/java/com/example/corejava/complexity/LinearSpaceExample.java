package com.example.corejava.complexity;

import java.util.ArrayList;
import java.util.List;

public class LinearSpaceExample {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        List<Integer> numbers = List.of(1, 2, 3);
        List<Integer> doubled = new ArrayList<>();
        for (int number : numbers) {
            doubled.add(number * 2);
        }
        System.out.println("Doubled: " + doubled);
        // Space: O(n), because the new list grows with the input.
        // Time: O(n)
    }
}
