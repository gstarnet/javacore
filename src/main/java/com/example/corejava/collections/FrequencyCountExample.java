package com.example.corejava.collections;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencyCountExample {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        List<String> words = List.of("java", "map", "java", "list");
        Map<String, Integer> counts = new HashMap<>();
        for (String word : words) {
            counts.merge(word, 1, Integer::sum);
        }
        System.out.println("Frequency count: " + counts);
        // Time: O(n), Space: O(k) where k is the number of unique words.
    }
}
