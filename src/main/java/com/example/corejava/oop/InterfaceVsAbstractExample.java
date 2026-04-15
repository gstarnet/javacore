package com.example.corejava.oop;

public class InterfaceVsAbstractExample {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
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
