package com.example.corejava.streams;

import java.util.ArrayList;
import java.util.List;


/**
 * Demonstrates the same filtering and mapping logic with loops and streams.
 *
 * <p>Interview questions answered: Are streams always better than loops? How do
 * {@code filter} and {@code map} translate from imperative code?</p>
 *
 * <p>Real-life use: transforming collections for reports, API responses, or validation
 * output.</p>
 */
public class StreamsVsLoopsExample {
    private StreamsVsLoopsExample() {
    }
    /**
     * Runs this example directly from the command line.
     *
     * @param args command-line arguments; ignored by this example
     */
    public static void main(String[] args) {
        run();
    }

    /**
     * Executes the example logic used by {@code DemoRunner} and tests.
     */
    public static void run() {
        // Walkthrough:
        // 1. Solve the same task with a classic loop first so every step is visible.
        // 2. Solve it again with a stream pipeline using filter and map.
        // 3. Compare the outputs to show that style changed, not the result.
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
