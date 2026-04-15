package com.example.corejava.oop;

public class OverloadOverrideExample {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
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
