package com.example.corejava.complexity;

public class LogarithmicTimeExample {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        int[] sorted = {2, 4, 6, 8, 10, 12, 14};
        int target = 10;
        int left = 0;
        int right = sorted.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (sorted[mid] == target) {
                System.out.println("Found at index " + mid);
                return;
            }
            if (sorted[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // Time: O(log n), because each step cuts the search area in half.
        // Space: O(1)
    }
}
