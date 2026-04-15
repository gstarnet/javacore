package com.example.corejava.collections;

import java.util.Collections;
import java.util.PriorityQueue;


/**
 * Demonstrates min-heap and max-heap behavior with {@code PriorityQueue}.
 *
 * <p>Interview questions answered: What does {@code poll()} return? How do you reverse
 * priority order?</p>
 *
 * <p>Real-life use: scheduling next jobs, finding top scores, or processing cheapest
 * tasks first.</p>
 */
public class PriorityQueueExample {
    private PriorityQueueExample() {
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
        // 1. Add unordered numbers to a natural-order priority queue.
        // 2. Poll from the min-heap to get the smallest value first.
        // 3. Create a reverse-order queue when the largest value should have priority.
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(30);
        minHeap.add(10);
        minHeap.add(20);

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.addAll(minHeap);

        System.out.println("Min heap poll: " + minHeap.poll());
        System.out.println("Max heap poll: " + maxHeap.poll());
        // add/poll are O(log n); peek is O(1).
    }
}
