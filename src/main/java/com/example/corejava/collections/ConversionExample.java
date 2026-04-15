package com.example.corejava.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ConversionExample {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
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
