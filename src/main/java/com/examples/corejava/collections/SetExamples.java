package com.examples.corejava.collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;


/**
 * Demonstrates {@code HashSet}, {@code LinkedHashSet}, and {@code TreeSet} behavior.
 *
 * <p>Interview questions answered: Which set is unordered, insertion ordered, or sorted?
 * How do uniqueness and ordering trade off?</p>
 *
 * <p>Real-life use: unique IDs, stable tag display order, or sorted category names.</p>
 */
public class SetExamples {
    private SetExamples() {
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
        // 1. Create a HashSet when uniqueness matters more than order.
        // 2. Use LinkedHashSet when first-seen order should be preserved.
        // 3. Use TreeSet when unique values should also be sorted.
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
