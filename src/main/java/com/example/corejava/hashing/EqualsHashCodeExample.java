package com.example.corejava.hashing;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class EqualsHashCodeExample {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
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
