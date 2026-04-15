package com.example.corejava.hashing;

import java.util.HashMap;
import java.util.Map;

public class CustomObjectHashExample {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        Map<ProductKey, Integer> inventory = new HashMap<>();
        inventory.put(new ProductKey("book", "java-17"), 10);
        System.out.println("Lookup custom key: " + inventory.get(new ProductKey("book", "java-17")));

        Map<String, Integer> counts = new HashMap<>();
        String key = "java";
        counts.put(key, counts.getOrDefault(key, 0) + 1);
        System.out.println("Multi-step map update result: " + counts);
        // In concurrent code, get-then-put is not atomic. Prefer merge/compute or ConcurrentHashMap methods.
    }

    private record ProductKey(String category, String sku) {
    }
}
