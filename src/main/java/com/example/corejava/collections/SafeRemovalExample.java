package com.example.corejava.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SafeRemovalExample {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
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
