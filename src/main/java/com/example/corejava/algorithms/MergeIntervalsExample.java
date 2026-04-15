package com.example.corejava.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervalsExample {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}};
        System.out.println("Merged intervals: " + format(merge(intervals)));
        // Time: O(n log n) because of sorting, Space: O(n)
    }

    private static List<int[]> merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        List<int[]> merged = new ArrayList<>();
        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval);
            } else {
                int[] last = merged.get(merged.size() - 1);
                last[1] = Math.max(last[1], interval[1]);
            }
        }
        return merged;
    }

    private static String format(List<int[]> intervals) {
        List<String> parts = new ArrayList<>();
        for (int[] interval : intervals) {
            parts.add(Arrays.toString(interval));
        }
        return parts.toString();
    }
}
