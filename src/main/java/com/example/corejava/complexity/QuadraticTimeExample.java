package com.example.corejava.complexity;

import java.util.List;

public class QuadraticTimeExample {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        List<String> people = List.of("Ana", "Ben", "Cal");
        for (String first : people) {
            for (String second : people) {
                System.out.println(first + " meets " + second);
            }
        }
        // Time: O(n^2), because each element is paired with every element.
        // Space: O(1)
    }
}
