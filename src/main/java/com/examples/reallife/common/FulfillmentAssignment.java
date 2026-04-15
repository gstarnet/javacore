package com.examples.reallife.common;

/**
 * One order item assigned to one warehouse.
 *
 * @param item item being fulfilled
 * @param warehouse warehouse chosen for that item
 */
public record FulfillmentAssignment(OrderItem item, Warehouse warehouse) {
}
