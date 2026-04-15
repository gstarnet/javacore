package com.example.corejava.oop;


/**
 * Demonstrates an interface contract combined with an abstract base class for shared
 * state.
 *
 * <p>Interview questions answered: When do you use an interface? When does an abstract
 * class help share behavior or fields?</p>
 *
 * <p>Real-life use: payment, storage, or messaging implementations that share common data
 * but expose a common capability.</p>
 */
public class InterfaceVsAbstractExample {
    private InterfaceVsAbstractExample() {
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
        // 1. Program to the Payment interface so the caller depends on a capability.
        // 2. Use the abstract base class to hold shared currency state.
        // 3. Call pay through the interface to show abstraction in action.
        Payment payment = new CardPayment("USD");
        System.out.println(payment.pay(25));
        // Interface: capability contract. Abstract class: shared base state/behavior.
    }

    private interface Payment {
        String pay(int amount);
    }

    private abstract static class BasePayment {
        private final String currency;

        private BasePayment(String currency) {
            this.currency = currency;
        }

        protected String currency() {
            return currency;
        }
    }

    private static class CardPayment extends BasePayment implements Payment {
        private CardPayment(String currency) {
            super(currency);
        }

        @Override
        public String pay(int amount) {
            return "Paid " + amount + " " + currency();
        }
    }
}
