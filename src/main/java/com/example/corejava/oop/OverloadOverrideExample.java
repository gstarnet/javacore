package com.example.corejava.oop;


/**
 * Demonstrates method overloading and method overriding side by side.
 *
 * <p>Interview questions answered: How does compile-time overload selection differ from
 * runtime overriding? Why do parameter lists matter?</p>
 *
 * <p>Real-life use: APIs with convenient input variants and subclasses that customize
 * behavior.</p>
 */
public class OverloadOverrideExample {
    private OverloadOverrideExample() {
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
        // 1. Call overloaded add methods with different parameter types.
        // 2. Store a subclass object in a base class reference.
        // 3. Call greet and let overriding choose the subclass behavior at runtime.
        Calculator calculator = new Calculator();
        System.out.println("Overloaded int add: " + calculator.add(2, 3));
        System.out.println("Overloaded double add: " + calculator.add(2.5, 3.5));

        Greeter greeter = new FriendlyGreeter();
        System.out.println("Overridden greet: " + greeter.greet());
        // Overloading is same method name, different parameters. Overriding changes subclass behavior.
    }

    private static class Calculator {
        private int add(int a, int b) {
            return a + b;
        }

        private double add(double a, double b) {
            return a + b;
        }
    }

    private static class Greeter {
        String greet() {
            return "Hello";
        }
    }

    private static class FriendlyGreeter extends Greeter {
        @Override
        String greet() {
            return "Hello, welcome";
        }
    }
}
