package com.examples.corejava.oop;

import java.util.List;


/**
 * Demonstrates inheritance and polymorphism with animals sharing a common base type.
 *
 * <p>Interview questions answered: What does method overriding do? How can one reference
 * type call different subclass behavior?</p>
 *
 * <p>Real-life use: processing different payment, notification, or parser implementations
 * through one common contract.</p>
 */
public class InheritancePolymorphismExample {
    private InheritancePolymorphismExample() {
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
        // 1. Store different animal subclasses in a list of the base type.
        // 2. Call the same method on each item without checking its concrete class.
        // 3. Let runtime dispatch choose the correct overridden implementation.
        List<Animal> animals = List.of(new Dog(), new Cat());
        for (Animal animal : animals) {
            System.out.println(animal.speak());
        }
        // Polymorphism lets one Animal reference call the correct subclass behavior.
    }

    private abstract static class Animal {
        abstract String speak();
    }

    private static class Dog extends Animal {
        @Override
        String speak() {
            return "Dog says woof";
        }
    }

    private static class Cat extends Animal {
        @Override
        String speak() {
            return "Cat says meow";
        }
    }
}
