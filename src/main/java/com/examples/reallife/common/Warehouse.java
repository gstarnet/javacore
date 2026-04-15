package com.examples.reallife.common;

import java.util.HashMap;
import java.util.Map;

/**
 * Warehouse with inventory and simple shipping estimates.
 *
 * <p>Backtracking, BFS, map, and concurrency examples use this class to model
 * inventory availability and fulfillment constraints.</p>
 */
public final class Warehouse {
    private final String code;
    private final String region;
    private final Map<String, Integer> stockBySku;
    private final int baseShippingCostCents;
    private final int shippingDays;

    /**
     * Creates a warehouse from static inventory and shipping estimates.
     *
     * @param code short warehouse code
     * @param region geographic region
     * @param stockBySku available units by SKU
     * @param baseShippingCostCents base cost before quantity adjustments
     * @param shippingDays estimated delivery days
     */
    public Warehouse(String code, String region, Map<String, Integer> stockBySku,
                     int baseShippingCostCents, int shippingDays) {
        this.code = code;
        this.region = region;
        this.stockBySku = new HashMap<>(stockBySku);
        this.baseShippingCostCents = baseShippingCostCents;
        this.shippingDays = shippingDays;
    }

    /**
     * Returns the warehouse code used in printed fulfillment plans.
     *
     * @return short warehouse code
     */
    public String code() {
        return code;
    }

    /**
     * Returns the warehouse region.
     *
     * @return geographic warehouse region
     */
    public String region() {
        return region;
    }

    /**
     * Checks whether the warehouse has enough units for the requested item.
     *
     * @param item item requested by the customer
     * @return {@code true} when this warehouse has at least the requested quantity
     */
    public boolean hasStock(OrderItem item) {
        return stockBySku.getOrDefault(item.sku(), 0) >= item.quantity();
    }

    /**
     * Estimates shipping cost for this item from this warehouse.
     *
     * @param item item being shipped
     * @return estimated shipping cost in cents
     */
    public int shippingCostCents(OrderItem item) {
        return baseShippingCostCents + (item.quantity() * 75);
    }

    /**
     * Returns estimated delivery days.
     *
     * @return estimated delivery days from this warehouse
     */
    public int shippingDays() {
        return shippingDays;
    }

    @Override
    public String toString() {
        return code + "(" + region + ")";
    }
}
