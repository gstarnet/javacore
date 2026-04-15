package com.example.corejava.streams;

import java.util.ArrayList;
import java.util.List;

public class StreamsVsLoopsExample {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        List<Integer> loopResult = new ArrayList<>();
        for (int number : numbers) {
            if (number % 2 == 0) {
                loopResult.add(number * number);
            }
        }

        List<Integer> streamResult = numbers.stream()
                .filter(number -> number % 2 == 0)
                .map(number -> number * number)
                .toList();

        System.out.println("Loop result: " + loopResult);
        System.out.println("Stream result: " + streamResult);
    }
}
