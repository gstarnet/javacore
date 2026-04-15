package com.examples.reallife.common;

import java.util.List;

/**
 * Customer order used by the real-life backend examples.
 *
 * <p>The order carries fulfillment constraints that mirror a real checkout flow:
 * maximum shipping cost and maximum shipping days.</p>
 *
 * @param orderId unique order identifier
 * @param customerTier customer segment such as STANDARD, GOLD, or VIP
 * @param items immutable list of requested items
 * @param maxShippingCostCents maximum shipping budget in cents
 * @param maxShipDays maximum acceptable delivery time
 */
public record CustomerOrder(
        String orderId,
        String customerTier,
        List<OrderItem> items,
        int maxShippingCostCents,
        int maxShipDays
) {
    /**
     * Creates a defensive copy so example code cannot accidentally mutate order items.
     */
    public CustomerOrder {
        items = List.copyOf(items);
    }
}
