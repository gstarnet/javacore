package com.example.corejava.sorting;

import java.util.Arrays;
import java.util.Comparator;

public class PrimitiveVsObjectSortingExample {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        int[] primitive = {3, 1, 2};
        Arrays.sort(primitive);
        System.out.println("Primitive ascending: " + Arrays.toString(primitive));

        Integer[] boxed = {3, 1, 2};
        Arrays.sort(boxed, Comparator.reverseOrder());
        System.out.println("Boxed descending: " + Arrays.toString(boxed));

        int a = Integer.MAX_VALUE;
        int b = -1;
        System.out.println("Integer.compare avoids overflow: " + Integer.compare(a, b));
        // Do not compare with a - b; subtraction can overflow and give the wrong sign.
    }
}
