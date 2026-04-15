package com.example.corejava.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ListSetMapComparisonExample {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        List<String> list = new ArrayList<>(List.of("java", "java", "sql"));
        Set<String> set = new HashSet<>(list);
        Map<String, Integer> map = new HashMap<>();
        map.put("java", 17);

        System.out.println("List allows duplicates and index access: " + list.get(1));
        System.out.println("Set keeps unique values: " + set);
        System.out.println("Map stores key-value pairs: " + map.get("java"));
    }
}
