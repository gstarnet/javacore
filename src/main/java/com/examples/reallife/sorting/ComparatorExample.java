package com.examples.reallife.sorting;

import com.examples.reallife.common.ECommerceScenarios;

/**
 * Real-Life E-Commerce Example: Category Then Price Product Sorting.
 *
 * <p><strong>The problem:</strong> Backend services often need this pattern while processing carts, orders, inventory, payments, or shipping decisions. This example translates ComparatorExample into the e-commerce scenario "Category Then Price Product Sorting" so the interview concept is tied to production-style code.</p>
 *
 * <p><strong>Interview questions answered:</strong> Which backend problem does ComparatorExample help solve? What data structure or control-flow pattern makes the implementation practical? What tradeoff should be discussed in an interview?</p>
 *
 * <p><strong>Backend benefit:</strong> In a production e-commerce service, category then price product sorting keeps checkout, inventory, catalog, or fulfillment logic easier to reason about and cheaper to run under real traffic.</p>
 */
public final class ComparatorExample {
    private ComparatorExample() {
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
        ECommerceScenarios.run("ComparatorExample");
    }
}
