package com.example.corejava.strings;

public class StringBuilderExample {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= 3; i++) {
            builder.append("item").append(i).append(" ");
        }
        System.out.println("Built string: " + builder.toString().trim());
        // Repeated String concatenation can create many temporary objects.
        // StringBuilder reuses one mutable buffer, which is better for loops.
    }
}
