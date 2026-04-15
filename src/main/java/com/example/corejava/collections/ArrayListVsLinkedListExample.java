package com.example.corejava.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * Compares {@code ArrayList} random access with {@code LinkedList} deque operations.
 *
 * <p>Interview questions answered: Why is {@code ArrayList} usually preferred? When can
 * {@code LinkedList} be useful?</p>
 *
 * <p>Real-life use: picking a collection for indexed reads versus frequent head/tail
 * operations.</p>
 */
public class ArrayListVsLinkedListExample {
    private ArrayListVsLinkedListExample() {
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
        // 1. Use ArrayList for indexed access because array-backed lookup is fast.
        // 2. Use LinkedList-specific addFirst and addLast to show deque-style operations.
        // 3. Compare the examples as practical selection guidance, not as a blanket rule.
        List<String> arrayList = new ArrayList<>(List.of("A", "B", "C"));
        LinkedList<String> linkedList = new LinkedList<>(List.of("A", "B", "C"));
        System.out.println("ArrayList fast random access: " + arrayList.get(2));
        linkedList.addFirst("Start");
        linkedList.addLast("End");
        System.out.println("LinkedList easy deque operations: " + linkedList);
        // Interview note: ArrayList is usually preferred unless you need deque-like operations.
    }
}
