package com.example.corejava.collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapExamples {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
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
