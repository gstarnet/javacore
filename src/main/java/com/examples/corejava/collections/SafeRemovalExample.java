package com.examples.corejava.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * Demonstrates safe removal while iterating using {@code Iterator.remove()} and
 * {@code removeIf}.
 *
 * <p>Interview questions answered: Why can removing inside a for-each loop fail? What are
 * safe alternatives?</p>
 *
 * <p>Real-life use: cleaning invalid records, filtering expired sessions, or removing
 * disabled options.</p>
 */
public class SafeRemovalExample {
    private SafeRemovalExample() {
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
        // 1. Use an Iterator when removing while manually walking the list.
        // 2. Call iterator.remove instead of modifying the list directly inside the loop.
        // 3. Use removeIf for the common case where a predicate describes what to delete.
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() % 2 == 0) {
                iterator.remove();
            }
        }
        System.out.println("After Iterator.remove: " + numbers);

        numbers.removeIf(number -> number > 3);
        System.out.println("After removeIf: " + numbers);
        // Avoid removing directly from a for-each loop; it can throw ConcurrentModificationException.
    }
}
