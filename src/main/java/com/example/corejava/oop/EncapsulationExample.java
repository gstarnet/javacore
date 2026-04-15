package com.example.corejava.oop;

public class EncapsulationExample {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        BankAccount account = new BankAccount("Ada");
        account.deposit(100);
        System.out.println("Balance: " + account.getBalance());
        // Encapsulation protects state by forcing changes through methods with rules.
    }

    private static class BankAccount {
        private final String owner;
        private int balance;

        private BankAccount(String owner) {
            this.owner = owner;
        }

        private void deposit(int amount) {
            if (amount <= 0) {
                throw new IllegalArgumentException("Amount must be positive");
            }
            balance += amount;
        }

        private int getBalance() {
            return balance;
        }
    }
}
