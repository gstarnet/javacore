package com.example.corejava.collections;

import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
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
