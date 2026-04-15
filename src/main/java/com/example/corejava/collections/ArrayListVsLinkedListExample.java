package com.example.corejava.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListVsLinkedListExample {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        List<String> arrayList = new ArrayList<>(List.of("A", "B", "C"));
        LinkedList<String> linkedList = new LinkedList<>(List.of("A", "B", "C"));
        System.out.println("ArrayList fast random access: " + arrayList.get(2));
        linkedList.addFirst("Start");
        linkedList.addLast("End");
        System.out.println("LinkedList easy deque operations: " + linkedList);
        // Interview note: ArrayList is usually preferred unless you need deque-like operations.
    }
}
