package com.example.corejava.collections;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        ConcurrentHashMap<String, Integer> counts = new ConcurrentHashMap<>();
        counts.put("java", 1);
        counts.putIfAbsent("java", 99);
        counts.compute("java", (key, oldValue) -> oldValue == null ? 1 : oldValue + 1);
        System.out.println("ConcurrentHashMap atomic update: " + counts);
        // Individual operations are thread-safe, but a separate get-then-put sequence can still be risky.
    }
}
