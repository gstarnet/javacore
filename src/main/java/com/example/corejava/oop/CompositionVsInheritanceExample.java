package com.example.corejava.oop;

public class CompositionVsInheritanceExample {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        Car car = new Car(new Engine());
        System.out.println(car.start());
        // Composition means Car has an Engine. Prefer it when you only need to reuse behavior.
    }

    private static class Engine {
        private String start() {
            return "engine started";
        }
    }

    private static class Car {
        private final Engine engine;

        private Car(Engine engine) {
            this.engine = engine;
        }

        private String start() {
            return "car: " + engine.start();
        }
    }
}
