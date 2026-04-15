package com.example.corejava.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * Demonstrates conversion between collection views and simple copy/reverse operations.
 *
 * <p>Interview questions answered: How do you convert a list to a set? What are map key
 * views? Why copy before reversing?</p>
 *
 * <p>Real-life use: producing unique values, exposing lookup keys, and creating safe
 * transformed copies.</p>
 */
public class ConversionExample {
    private ConversionExample() {
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
        // 1. Convert a list to a set to remove duplicates.
        // 2. Build a map from each unique value to a derived value.
        // 3. Copy before reversing so the original list remains available unchanged.
        List<String> list = new ArrayList<>(List.of("b", "a", "b"));
        Set<String> set = new HashSet<>(list);
        Map<String, Integer> lengths = new HashMap<>();
        for (String value : set) {
            lengths.put(value, value.length());
        }

        List<String> copy = new ArrayList<>(list);
        Collections.reverse(copy);

        System.out.println("List to Set: " + set);
        System.out.println("Map view keys: " + lengths.keySet());
        System.out.println("Reversed copy: " + copy);
        System.out.println("Max value: " + Collections.max(list));
        System.out.println("Min value: " + Collections.min(list));
    }
}
