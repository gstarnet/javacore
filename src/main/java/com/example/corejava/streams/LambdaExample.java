package com.example.corejava.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LambdaExample {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        List<String> names = new ArrayList<>(List.of("Grace", "Ada", "Katherine"));
        names.sort((left, right) -> Integer.compare(left.length(), right.length()));
        System.out.println("Sorted with lambda: " + names);

        names.sort(Comparator.comparing(String::toLowerCase));
        System.out.println("Sorted with method reference: " + names);
    }
}
