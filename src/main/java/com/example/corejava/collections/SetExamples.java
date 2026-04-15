package com.example.corejava.collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetExamples {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        Set<String> hashSet = new HashSet<>(Set.of("banana", "apple", "pear"));
        Set<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("banana");
        linkedHashSet.add("apple");
        linkedHashSet.add("banana");
        Set<String> treeSet = new TreeSet<>(hashSet);

        System.out.println("HashSet unique values: " + hashSet);
        System.out.println("LinkedHashSet insertion order: " + linkedHashSet);
        System.out.println("TreeSet sorted order: " + treeSet);
        // HashSet average add/contains: O(1). TreeSet add/contains: O(log n).
    }
}
