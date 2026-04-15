package com.example.corejava.collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


/**
 * Demonstrates practical collection manipulation: add, read, update, remove, sort,
 * filter, and transform.
 *
 * <p>Interview questions answered: How do common list operations work? When are streams
 * readable for filtering and mapping?</p>
 *
 * <p>Real-life use: preparing display lists, normalizing user input, and transforming API
 * response data.</p>
 */
public class CollectionManipulationExample {
    private CollectionManipulationExample() {
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
        // 1. Build a mutable list so add, update, remove, and sort operations are visible.
        // 2. Use normal list methods for direct manipulation and streams for filter/map examples.
        // 3. Print each stage so a beginner can connect the method call to the changed data.
        List<String> names = new ArrayList<>();
        names.add("Ada");
        names.add("Grace");
        names.add("James");
        System.out.println("Read by index: " + names.get(0));

        names.set(2, "Katherine");
        names.remove("Grace");
        names.add("Barbara");
        names.sort(Comparator.naturalOrder());
        System.out.println("Sorted names: " + names);

        List<String> filtered = names.stream()
                .filter(name -> name.length() > 3)
                .toList();
        List<Integer> lengths = names.stream()
                .map(String::length)
                .toList();
        System.out.println("Filtered: " + filtered);
        System.out.println("Transformed lengths: " + lengths);
    }
}
