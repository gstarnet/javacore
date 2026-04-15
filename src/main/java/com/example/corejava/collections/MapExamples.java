package com.example.corejava.collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;


/**
 * Demonstrates {@code HashMap}, {@code LinkedHashMap}, and {@code TreeMap} behavior.
 *
 * <p>Interview questions answered: Which map is fastest on average? Which preserves
 * insertion order? Which sorts keys?</p>
 *
 * <p>Real-life use: caches, predictable response ordering, and sorted lookup views.</p>
 */
public class MapExamples {
    private MapExamples() {
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
        // 1. Put the same key-value pairs into maps with different ordering behavior.
        // 2. Read from HashMap to show normal key lookup.
        // 3. Print LinkedHashMap and TreeMap to compare insertion order with sorted key order.
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("b", 2);
        hashMap.put("a", 1);

        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("b", 2);
        linkedHashMap.put("a", 1);

        Map<String, Integer> treeMap = new TreeMap<>(hashMap);

        System.out.println("HashMap average O(1) lookup: " + hashMap.get("a"));
        System.out.println("LinkedHashMap preserves insertion order: " + linkedHashMap);
        System.out.println("TreeMap sorts keys: " + treeMap);
    }
}
