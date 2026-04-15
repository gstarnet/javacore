package com.example.corejava.sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


/**
 * Demonstrates custom ordering with {@code Comparator} and multiple fields.
 *
 * <p>Interview questions answered: How do you sort by one field then another? When should
 * sorting logic stay outside the domain object?</p>
 *
 * <p>Real-life use: sorting people by department and age, products by category and price,
 * or tickets by priority and date.</p>
 */
public class ComparatorExample {
    private ComparatorExample() {
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
        // 1. Create people with multiple fields so sorting can use business rules.
        // 2. First compare department, then compare age when departments match.
        // 3. Keep this custom order outside the record so other orderings remain possible.
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
