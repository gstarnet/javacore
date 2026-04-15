package com.example.corejava.oop;

import java.util.List;

public class InheritancePolymorphismExample {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
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
