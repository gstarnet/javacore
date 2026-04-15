package com.example.corejava.algorithms;

import java.util.List;

public class LinearScanExample {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        List<String> names = List.of("Ada", "Grace", "Katherine");
        String target = "Grace";
        int foundIndex = -1;
        for (int i = 0; i < names.size(); i++) {
            if (names.get(i).equals(target)) {
                foundIndex = i;
                break;
            }
        }
        System.out.println("Linear scan index: " + foundIndex);
        // Time: O(n), Space: O(1)
    }
}
