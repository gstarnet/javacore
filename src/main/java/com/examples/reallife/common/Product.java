package com.examples.reallife.common;

/**
 * Product sold by the e-commerce platform.
 *
 * <p>Examples use this record when demonstrating catalog lookup, sorting, hashing,
 * filtering, and order calculations.</p>
 *
 * @param sku stable stock keeping unit used as the product key
 * @param name customer-facing product name
 * @param category merchandising category
 * @param priceCents price stored as cents to avoid floating point money errors
 */
public record Product(String sku, String name, String category, int priceCents) {
}
