package com.examples.corejava.oop;


/**
 * Demonstrates composition by giving a car an engine instead of inheriting engine
 * behavior.
 *
 * <p>Interview questions answered: What does has-a mean? Why is composition often more
 * flexible than inheritance?</p>
 *
 * <p>Real-life use: services composed from repositories, clients, formatters, or other
 * focused collaborators.</p>
 */
public class CompositionVsInheritanceExample {
    private CompositionVsInheritanceExample() {
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
        // 1. Build an Engine separately from the Car that uses it.
        // 2. Pass the engine into the car so the car has an engine instead of becoming one.
        // 3. Delegate start behavior to the composed object.
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
