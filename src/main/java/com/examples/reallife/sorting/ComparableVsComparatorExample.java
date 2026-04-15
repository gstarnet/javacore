package com.examples.reallife.sorting;

import com.examples.reallife.common.ECommerceScenarios;

/**
 * Real-Life E-Commerce Example: Natural SKU Order Versus Business Price Order.
 *
 * <p><strong>The problem:</strong> Backend services often need this pattern while processing carts, orders, inventory, payments, or shipping decisions. This example translates ComparableVsComparatorExample into the e-commerce scenario "Natural SKU Order Versus Business Price Order" so the interview concept is tied to production-style code.</p>
 *
 * <p><strong>Interview questions answered:</strong> Which backend problem does ComparableVsComparatorExample help solve? What data structure or control-flow pattern makes the implementation practical? What tradeoff should be discussed in an interview?</p>
 *
 * <p><strong>Backend benefit:</strong> In a production e-commerce service, natural sku order versus business price order keeps checkout, inventory, catalog, or fulfillment logic easier to reason about and cheaper to run under real traffic.</p>
 */
public final class ComparableVsComparatorExample {
    private ComparableVsComparatorExample() {
    }

    /**
     * Runs this real-life e-commerce example directly from the command line.
     *
     * @param args command-line arguments; ignored by this example
     */
    public static void main(String[] args) {
        run();
    }

    /**
     * Executes the backend-oriented scenario for the matching core Java example.
     */
    public static void run() {
        // Walkthrough:
        // 1. Start from a realistic e-commerce data set: orders, products, warehouses, or events.
        // 2. Apply the same Java/interview concept demonstrated by the matching core example.
        // 3. Print the backend outcome so the pattern is easy to connect to production code.
        ECommerceScenarios.run("ComparableVsComparatorExample");
    }
}
