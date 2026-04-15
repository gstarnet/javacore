package com.example.corejava.algorithms;

public class BinarySearchExample {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        int[] sorted = {1, 3, 5, 7, 9};
        System.out.println("Binary search index: " + binarySearch(sorted, 7));
        // Time: O(log n), Space: O(1)
    }

    private static int binarySearch(int[] sorted, int target) {
        int left = 0;
        int right = sorted.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (sorted[mid] == target) {
                return mid;
            }
            if (sorted[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
