package com.examples.corejava.oop;


/**
 * Demonstrates encapsulation by protecting account state behind methods.
 *
 * <p>Interview questions answered: Why keep fields private? How do methods enforce valid
 * state changes?</p>
 *
 * <p>Real-life use: bank accounts, inventory counts, or any model where invalid updates
 * must be rejected.</p>
 */
public class EncapsulationExample {
    private EncapsulationExample() {
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
        // 1. Create an account whose balance cannot be changed directly from outside.
        // 2. Call deposit so validation rules run before state changes.
        // 3. Read the balance through a method instead of exposing the field.
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
