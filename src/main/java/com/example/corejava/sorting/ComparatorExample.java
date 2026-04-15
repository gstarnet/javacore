package com.example.corejava.sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparatorExample {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        List<Person> people = new ArrayList<>(List.of(
                new Person("Ana", "Sales", 30),
                new Person("Ben", "Engineering", 25),
                new Person("Cal", "Engineering", 35)
        ));

        people.sort(Comparator.comparing(Person::department).thenComparingInt(Person::age));
        System.out.println("Sorted by department then age: " + people);
    }

    private record Person(String name, String department, int age) {
    }
}
