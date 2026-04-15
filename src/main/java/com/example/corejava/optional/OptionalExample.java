package com.example.corejava.optional;

import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        Optional<String> name = findNameById(1);
        String displayName = name.map(String::toUpperCase).orElse("UNKNOWN");
        System.out.println("Display name: " + displayName);

        Optional<String> missing = findNameById(99);
        System.out.println("Fallback: " + missing.orElse("Guest"));
        // Optional helps express that a result may be missing without returning null.
    }

    private static Optional<String> findNameById(int id) {
        if (id == 1) {
            return Optional.of("Ada");
        }
        return Optional.empty();
    }
}
