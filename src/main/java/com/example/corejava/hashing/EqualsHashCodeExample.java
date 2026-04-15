package com.example.corejava.hashing;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


/**
 * Demonstrates why {@code equals} and {@code hashCode} matter for hashed collections.
 *
 * <p>Interview questions answered: Why must equal objects have equal hash codes? How does
 * {@code HashSet} decide that two custom objects are duplicates?</p>
 *
 * <p>Real-life use: de-duplicating users, orders, or domain keys in sets and maps.</p>
 */
public class EqualsHashCodeExample {
    private EqualsHashCodeExample() {
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
        // 1. Create two separate objects that represent the same logical user.
        // 2. Add both to a HashSet so equals and hashCode decide uniqueness.
        // 3. The final size proves the set treats them as duplicates.
        Set<User> users = new HashSet<>();
        users.add(new User(1, "Ada"));
        users.add(new User(1, "Ada"));
        System.out.println("Users size with equals/hashCode: " + users.size());
        // HashSet uses hashCode to find a bucket and equals to confirm equality.
    }

    private static final class User {
        private final int id;
        private final String name;

        private User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof User user)) {
                return false;
            }
            return id == user.id && Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
    }
}
