package com.example.corejava.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentExample {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        List<String> words = List.of("java", "map", "java", "queue", "map", "java");
        System.out.println("Top 2 words: " + topK(words, 2));
        // Time: O(n log k), Space: O(n)
    }

    private static List<String> topK(List<String> words, int k) {
        Map<String, Integer> frequency = new HashMap<>();
        for (String word : words) {
            frequency.merge(word, 1, Integer::sum);
        }
        PriorityQueue<String> minHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(frequency.get(a), frequency.get(b))
        );
        for (String word : frequency.keySet()) {
            minHeap.offer(word);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return new ArrayList<>(minHeap);
    }
}
