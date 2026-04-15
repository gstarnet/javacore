package com.example.corejava.collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicatesExample {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        List<String> names = List.of("Ada", "Grace", "Ada", "James");
        Set<String> uniqueAnyOrder = new HashSet<>(names);
        Set<String> uniqueOriginalOrder = new LinkedHashSet<>(names);
        System.out.println("Unique any order: " + uniqueAnyOrder);
        System.out.println("Unique preserving order: " + uniqueOriginalOrder);
    }
}
