package com.examples.reallife.common;

/**
 * Credit card payment implementation for OOP and polymorphism examples.
 */
public final class CreditCardPayment implements PaymentMethod {
    /**
     * Creates a credit card payment strategy.
     */
    public CreditCardPayment() {
    }

    @Override
    public String charge(String orderId, int amountCents) {
        return "charged card for order " + orderId + ": $" + (amountCents / 100.0);
    }
}
