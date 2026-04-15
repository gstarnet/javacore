package com.example.corejava.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * Compares {@code List}, {@code Set}, and {@code Map} with small examples.
 *
 * <p>Interview questions answered: Which collection allows duplicates? Which provides
 * key-value lookup? Which is best for uniqueness?</p>
 *
 * <p>Real-life use: choosing between ordered results, unique tags, and lookup tables.</p>
 */
public class ListSetMapComparisonExample {
    private ListSetMapComparisonExample() {
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
        // 1. Put duplicate values in a list to show that lists preserve repeated elements.
        // 2. Create a set from the same data to show automatic uniqueness.
        // 3. Use a map when a value must be retrieved by a key.
        List<String> list = new ArrayList<>(List.of("java", "java", "sql"));
        Set<String> set = new HashSet<>(list);
        Map<String, Integer> map = new HashMap<>();
        map.put("java", 17);

        System.out.println("List allows duplicates and index access: " + list.get(1));
        System.out.println("Set keeps unique values: " + set);
        System.out.println("Map stores key-value pairs: " + map.get("java"));
    }
}
