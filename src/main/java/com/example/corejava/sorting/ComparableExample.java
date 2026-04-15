package com.example.corejava.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableExample {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
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
