package com.examples.reallife.common;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mutable fulfillment plan used while exploring warehouse assignments.
 *
 * <p>The backtracking example mutates one plan while exploring choices, then uses
 * {@link #copy()} when a valid plan is found.</p>
 */
public final class FulfillmentPlan {
    private final List<FulfillmentAssignment> assignments = new ArrayList<>();
    private int estimatedCostCents;
    private int maxDays;

    /**
     * Creates an empty fulfillment plan.
     */
    public FulfillmentPlan() {
    }

    /**
     * Adds one item-to-warehouse choice to the current plan.
     *
     * @param item item being assigned
     * @param warehouse warehouse chosen to fulfill the item
     */
    public void add(OrderItem item, Warehouse warehouse) {
        assignments.add(new FulfillmentAssignment(item, warehouse));
        estimatedCostCents += warehouse.shippingCostCents(item);
        maxDays = Math.max(maxDays, warehouse.shippingDays());
    }

    /**
     * Removes the latest choice, which is the undo step in backtracking.
     */
    public void removeLast() {
        FulfillmentAssignment removed = assignments.remove(assignments.size() - 1);
        estimatedCostCents -= removed.warehouse().shippingCostCents(removed.item());
        maxDays = assignments.stream()
                .mapToInt(assignment -> assignment.warehouse().shippingDays())
                .max()
                .orElse(0);
    }

    /**
     * Returns the current estimated shipping cost in cents.
     *
     * @return current estimated shipping cost in cents
     */
    public int estimatedCostCents() {
        return estimatedCostCents;
    }

    /**
     * Returns the slowest shipping estimate in the current plan.
     *
     * @return maximum delivery days across current assignments
     */
    public int maxDays() {
        return maxDays;
    }

    /**
     * Returns an immutable snapshot of assignments.
     *
     * @return immutable snapshot of item-to-warehouse assignments
     */
    public List<FulfillmentAssignment> assignments() {
        return List.copyOf(assignments);
    }

    /**
     * Copies the current plan when a complete valid assignment is found.
     *
     * @return independent copy of this fulfillment plan
     */
    public FulfillmentPlan copy() {
        FulfillmentPlan copy = new FulfillmentPlan();
        for (FulfillmentAssignment assignment : assignments) {
            copy.add(assignment.item(), assignment.warehouse());
        }
        return copy;
    }

    @Override
    public String toString() {
        String route = assignments.stream()
                .map(assignment -> assignment.item().sku() + "->" + assignment.warehouse().code())
                .collect(Collectors.joining(", "));
        return "cost=$" + (estimatedCostCents / 100.0) + ", days=" + maxDays + ", " + route;
    }
}
