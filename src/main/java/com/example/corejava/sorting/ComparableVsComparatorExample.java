package com.example.corejava.sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparableVsComparatorExample {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
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
