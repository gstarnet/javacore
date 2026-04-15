package com.examples.corejava.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;


/**
 * Demonstrates finding top-k frequent values using a frequency map and heap.
 *
 * <p>Interview questions answered: Why combine {@code HashMap} counting with a
 * {@code PriorityQueue}? How does keeping heap size {@code k} control cost?</p>
 *
 * <p>Real-life use: top search terms, most common errors, or most active users.</p>
 */
public class TopKFrequentExample {
    private TopKFrequentExample() {
    }
    /**
     * Runs this example directly from the command line.
     *
     * @param args command-line arguments; ignored by this example
     */
    public static void main(String[] args) {
        run();
    }

    /**
     * Executes the example logic used by {@code DemoRunner} and tests.
     */
    public static void run() {
        // Walkthrough:
        // 1. Count each word first because the heap needs frequencies to compare items.
        // 2. Keep a min-heap of size k so the least useful candidate is easy to remove.
        // 3. After all words are processed, the heap contains the top-k frequent words.
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
