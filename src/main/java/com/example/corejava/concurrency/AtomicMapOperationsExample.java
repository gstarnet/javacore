package com.example.corejava.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class AtomicMapOperationsExample {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        ConcurrentHashMap<String, List<String>> tagsByUser = new ConcurrentHashMap<>();
        tagsByUser.putIfAbsent("ada", new ArrayList<>());
        tagsByUser.computeIfAbsent("grace", key -> new ArrayList<>()).add("compiler");
        tagsByUser.compute("ada", (key, tags) -> {
            List<String> safeTags = tags == null ? new ArrayList<>() : tags;
            safeTags.add("math");
            return safeTags;
        });

        System.out.println("Atomic map operations: " + tagsByUser);
        System.out.println("Warning: mutating the List value itself still needs careful design.");
        // ConcurrentHashMap makes map operations atomic, not every operation on mutable values.
    }
}
