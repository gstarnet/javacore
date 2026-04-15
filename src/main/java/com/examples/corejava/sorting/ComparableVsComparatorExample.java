package com.examples.corejava.sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


/**
 * Compares natural ordering via {@code Comparable} with alternate ordering via
 * {@code Comparator}.
 *
 * <p>Interview questions answered: What is the difference between default and custom sort
 * order? Can one class have many comparators?</p>
 *
 * <p>Real-life use: books may naturally sort by title but reports may sort them by year.</p>
 */
public class ComparableVsComparatorExample {
    private ComparableVsComparatorExample() {
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
        // 1. Sort books once by their natural Comparable order.
        // 2. Sort the same books again with a Comparator for a different business view.
        // 3. Use the contrast to explain default order versus caller-selected order.
        List<Book> books = new ArrayList<>(List.of(
                new Book("Clean Code", 2008),
                new Book("Effective Java", 2018)
        ));

        books.sort(null);
        System.out.println("Natural order by title: " + books);

        books.sort(Comparator.comparingInt(Book::year));
        System.out.println("Custom order by year: " + books);
    }

    private record Book(String title, int year) implements Comparable<Book> {
        @Override
        public int compareTo(Book other) {
            return this.title.compareTo(other.title);
        }
    }
}
