package com.examples.reallife.common;

/**
 * Payment strategy used by object-oriented real-life examples.
 */
public interface PaymentMethod {
    /**
     * Charges the customer for an order total.
     *
     * @param orderId order identifier
     * @param amountCents amount to charge in cents
     * @return human-readable payment result for the console demo
     */
    String charge(String orderId, int amountCents);
}
