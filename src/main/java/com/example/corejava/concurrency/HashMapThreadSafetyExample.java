package com.example.corejava.concurrency;

import java.util.HashMap;
import java.util.Map;

public class HashMapThreadSafetyExample {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        Map<String, Integer> counts = new HashMap<>();
        counts.put("java", 0);

        int current = counts.get("java");
        counts.put("java", current + 1);
        System.out.println("Single-thread get-then-put: " + counts);
        System.out.println("In multiple threads, HashMap plus get-then-put can lose updates.");
        // HashMap is not designed for concurrent writes. Use synchronization or ConcurrentHashMap.
    }
}
