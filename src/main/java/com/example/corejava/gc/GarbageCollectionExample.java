package com.example.corejava.gc;

import java.util.ArrayList;
import java.util.List;

public class GarbageCollectionExample {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
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
