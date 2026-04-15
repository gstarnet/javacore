package com.example.corejava.strings;

public class StringImmutabilityExample {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        String original = "Java";
        String updated = original.concat(" 17");
        System.out.println("Original unchanged: " + original);
        System.out.println("New string: " + updated);
        // Immutability makes String safe to share and usable as a reliable Map key.
    }
}
