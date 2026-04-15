package com.example.corejava.complexity;

import java.util.List;

public class ConstantTimeExample {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        List<String> names = List.of("Ada", "Grace", "James");
        // Reading by index from an ArrayList-style list does not depend on list size.
        // Interview note: O(1) means the work stays constant as input grows.
        System.out.println("First name: " + names.get(0));
        // Expected output: First name: Ada
        // Time: O(1), Space: O(1)
    }
}
