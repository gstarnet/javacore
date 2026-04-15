package com.examples.reallife.common;

/**
 * Item requested by a customer order.
 *
 * <p>The examples keep this intentionally small: a SKU and quantity are enough to
 * demonstrate fulfillment, inventory checks, hashing, and collection processing.</p>
 *
 * @param sku product SKU requested by the customer
 * @param quantity number of units requested
 */
public record OrderItem(String sku, int quantity) {
}
