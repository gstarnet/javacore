package com.example.corejava.complexity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NLogNExample {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        List<Integer> scores = new ArrayList<>(List.of(40, 10, 30, 20));
        Collections.sort(scores);
        System.out.println("Sorted scores: " + scores);
        // Typical comparison sorting is O(n log n).
        // Space depends on the sorting implementation; for this study example, focus on time.
    }
}
