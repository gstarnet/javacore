package com.example.corejava.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

public class CollectionsOverviewExample {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        List<String> arrayList = new ArrayList<>(List.of("A", "B"));
        List<String> linkedList = new LinkedList<>(List.of("first", "second"));
        Set<String> hashSet = new HashSet<>(Set.of("red", "blue"));
        Set<String> linkedHashSet = new LinkedHashSet<>(List.of("one", "two", "one"));
        Set<Integer> treeSet = new TreeSet<>(Set.of(3, 1, 2));
        Map<String, Integer> hashMap = new HashMap<>(Map.of("java", 17));
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>(Map.of("first", 1, "second", 2));
        Map<String, Integer> treeMap = new TreeMap<>(Map.of("b", 2, "a", 1));
        PriorityQueue<Integer> queue = new PriorityQueue<>(List.of(5, 1, 3));
        ConcurrentHashMap<String, Integer> concurrentMap = new ConcurrentHashMap<>();
        concurrentMap.put("safeCount", 1);

        System.out.println("ArrayList: " + arrayList);
        System.out.println("LinkedList: " + linkedList);
        System.out.println("HashSet removes duplicates: " + hashSet);
        System.out.println("LinkedHashSet keeps insertion order: " + linkedHashSet);
        System.out.println("TreeSet sorts: " + treeSet);
        System.out.println("HashMap lookup: " + hashMap.get("java"));
        System.out.println("LinkedHashMap order: " + linkedHashMap);
        System.out.println("TreeMap key order: " + treeMap);
        System.out.println("PriorityQueue smallest first: " + queue.poll());
        System.out.println("ConcurrentHashMap: " + concurrentMap);
    }
}
