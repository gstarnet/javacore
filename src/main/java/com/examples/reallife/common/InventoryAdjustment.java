package com.examples.reallife.common;

/**
 * Inventory event used by stream, grouping, and concurrency examples.
 *
 * @param sku product SKU being adjusted
 * @param warehouseCode warehouse where the adjustment happened
 * @param delta positive or negative inventory change
 */
public record InventoryAdjustment(String sku, String warehouseCode, int delta) {
}
