package com.examples.corejava.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Demonstrates natural ordering with {@code Comparable}.
 *
 * <p>Interview questions answered: Where should default sort order live? Why is
 * {@code Integer.compare} safer than subtraction?</p>
 *
 * <p>Real-life use: giving domain objects a stable natural order, such as employee ID or
 * account number.</p>
 */
public class ComparableExample {
    private ComparableExample() {
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
        // 1. Create domain objects that know their natural ordering through Comparable.
        // 2. Call Collections.sort and let compareTo decide the order.
        // 3. Use Integer.compare inside compareTo to avoid overflow from subtraction.
        List<Employee> employees = new ArrayList<>(List.of(
                new Employee("Ada", 3),
                new Employee("Grace", 1)
        ));
        Collections.sort(employees);
        System.out.println("Comparable by id: " + employees);
    }

    private record Employee(String name, int id) implements Comparable<Employee> {
        @Override
        public int compareTo(Employee other) {
            return Integer.compare(this.id, other.id);
        }
    }
}
