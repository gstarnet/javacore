package com.examples.reallife.common;

/**
 * Wallet payment implementation for OOP and polymorphism examples.
 */
public final class WalletPayment implements PaymentMethod {
    /**
     * Creates a wallet payment strategy.
     */
    public WalletPayment() {
    }

    @Override
    public String charge(String orderId, int amountCents) {
        return "charged wallet for order " + orderId + ": $" + (amountCents / 100.0);
    }
}
