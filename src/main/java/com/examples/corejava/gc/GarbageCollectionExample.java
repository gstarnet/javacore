package com.examples.corejava.gc;

import java.util.ArrayList;
import java.util.List;


/**
 * Demonstrates garbage collection concepts in plain English: reachability, eligibility,
 * and {@code System.gc()} as a request.
 *
 * <p>Interview questions answered: When is an object eligible for collection? Can code
 * force garbage collection?</p>
 *
 * <p>Real-life use: reducing memory pressure by dropping references and avoiding needless
 * object creation in hot paths.</p>
 */
public class GarbageCollectionExample {
    private GarbageCollectionExample() {
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
        // 1. Create one reachable object and one temporary object.
        // 2. Drop the temporary reference so that object becomes eligible for garbage collection.
        // 3. Call System.gc as a request and explain that the JVM decides when collection happens.
        Person reachable = new Person("Ada");
        Person soonUnreachable = new Person("Temporary");
        System.out.println("Reachable object: " + reachable.name());

        soonUnreachable = null;
        System.out.println("Temporary object is now eligible for GC because no reference points to it.");

        System.gc();
        System.out.println("System.gc() is only a request, not a command.");

        List<String> names = new ArrayList<>();
        names.add("Grace");
        names.add("Katherine");
        System.out.println("Reuse collections when practical: " + names);
        // Avoid unnecessary object creation in hot paths, but do not sacrifice clarity without evidence.
    }

    private record Person(String name) {
    }
}
