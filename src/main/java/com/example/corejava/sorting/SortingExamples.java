package com.example.corejava.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingExamples {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        int[] primitiveScores = {30, 10, 20};
        Arrays.sort(primitiveScores);
        System.out.println("Arrays.sort primitives ascending: " + Arrays.toString(primitiveScores));

        List<String> names = new ArrayList<>(List.of("Grace", "Ada", "Katherine"));
        Collections.sort(names);
        System.out.println("Collections.sort ascending: " + names);

        names.sort(Comparator.reverseOrder());
        System.out.println("List.sort descending: " + names);

        names.sort(Comparator.comparingInt(String::length));
        System.out.println("Strings by length: " + names);
        // Common interview trap: primitive arrays cannot use reverseOrder directly.
    }
}
