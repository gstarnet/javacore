package com.example.corejava.collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CollectionManipulationExample {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
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
