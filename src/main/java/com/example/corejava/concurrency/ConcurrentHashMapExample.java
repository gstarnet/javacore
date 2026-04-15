package com.example.corejava.concurrency;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        ConcurrentHashMap<String, Integer> counts = new ConcurrentHashMap<>();
        counts.put("java", 1);
        counts.compute("java", (key, oldValue) -> oldValue == null ? 1 : oldValue + 1);
        System.out.println("ConcurrentHashMap count: " + counts.get("java"));
        // ConcurrentHashMap protects its internal structure during concurrent access.
    }
}
