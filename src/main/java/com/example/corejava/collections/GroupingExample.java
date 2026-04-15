package com.example.corejava.collections;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingExample {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        List<String> names = List.of("Ada", "Alan", "Grace", "George");
        Map<Character, List<String>> byFirstLetter = names.stream()
                .collect(Collectors.groupingBy(name -> name.charAt(0)));
        System.out.println("Grouped by first letter: " + byFirstLetter);
    }
}
