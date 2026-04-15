package com.examples.reallife.common;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * Shared e-commerce scenario implementations for the real-life examples.
 *
 * <p>Each public example class delegates to this catalog with its original example
 * name. The catalog keeps the supporting backend data and algorithms in one place
 * while every wrapper class explains the interview concept in its own JavaDoc.</p>
 */
public final class ECommerceScenarios {
    private ECommerceScenarios() {
    }

    /**
     * Runs the e-commerce backend scenario mapped to a core Java example name.
     *
     * @param exampleName original core Java example class name
     */
    public static void run(String exampleName) {
        switch (exampleName) {
            case "BacktrackingExample" -> backtrackingFulfillment();
            case "BfsGridExample" -> bfsWarehouseReachability();
            case "BinarySearchExample", "LogarithmicTimeExample" -> binarySearchShippingTier();
            case "LinearScanExample", "LinearTimeExample" -> linearScanInventory();
            case "NestedLoopsExample", "QuadraticTimeExample" -> nestedLoopBundlePairs();
            case "RecursionExample" -> recursiveCategoryCount();
            case "SlidingWindowExample" -> slidingWindowRevenue();
            case "TopKFrequentExample", "PriorityQueueExample" -> topProductsWithHeap();
            case "TwoSumExample" -> twoSumPromotionPair();
            case "ValidParenthesesExample" -> validatePromotionExpression();
            case "MergeIntervalsExample" -> mergeDeliveryWindows();
            case "ConstantTimeExample" -> constantTimeSkuLookup();
            case "NLogNExample", "SortingExamples" -> sortOrdersByValue();
            case "SubsetExample" -> generatePromotionBundles();
            case "PermutationExample" -> testCheckoutStepOrders();
            case "ConstantSpaceExample" -> constantSpaceCartTotal();
            case "LinearSpaceExample" -> linearSpaceOrderDtos();
            case "CollectionsOverviewExample" -> collectionsOverview();
            case "ListSetMapComparisonExample" -> listSetMapComparison();
            case "ArrayListVsLinkedListExample" -> arrayListVsLinkedList();
            case "SetExamples" -> setExamples();
            case "MapExamples", "HashMapExample" -> mapExamples();
            case "ConcurrentHashMapExample" -> concurrentHashMapExample();
            case "CollectionManipulationExample" -> collectionManipulation();
            case "FrequencyCountExample" -> frequencyCount();
            case "RemoveDuplicatesExample" -> removeDuplicates();
            case "SafeRemovalExample" -> safeRemoval();
            case "GroupingExample" -> groupingAdjustments();
            case "ConversionExample" -> conversionExample();
            case "ComparableExample" -> comparableProductSort();
            case "ComparatorExample" -> comparatorOrderSort();
            case "ComparableVsComparatorExample" -> comparableVsComparator();
            case "PrimitiveVsObjectSortingExample" -> primitiveVsObjectSorting();
            case "EqualsHashCodeExample", "CustomObjectHashExample" -> customObjectHashing();
            case "StringImmutabilityExample" -> stringImmutability();
            case "StringBuilderExample" -> stringBuilderEmail();
            case "EncapsulationExample" -> encapsulatedCart();
            case "InheritancePolymorphismExample" -> paymentPolymorphism();
            case "InterfaceVsAbstractExample" -> paymentInterfaceExample();
            case "CompositionVsInheritanceExample" -> composedOrderService();
            case "OverloadOverrideExample" -> overloadOverridePricing();
            case "LooseCouplingCohesionExample" -> looseCoupledNotification();
            case "FinalFinallyFinalizeExample" -> finalFinallyFinalizeOrderFile();
            case "CheckedVsUncheckedExceptionExample" -> checkedVsUncheckedCheckout();
            case "StreamsVsLoopsExample" -> streamsVsLoopsOrders();
            case "LambdaExample" -> lambdaSortProducts();
            case "OptionalExample" -> optionalCustomerCoupon();
            case "ThreadExample" -> threadInventoryRefresh();
            case "StartVsRunExample" -> startVsRunFulfillmentJob();
            case "SynchronizedCounterExample" -> synchronizedOrderCounter();
            case "HashMapThreadSafetyExample" -> hashMapThreadSafetyRisk();
            case "AtomicMapOperationsExample" -> atomicMapOperations();
            case "GarbageCollectionExample" -> garbageCollectionCartSession();
            default -> throw new IllegalArgumentException("No real-life scenario for " + exampleName);
        }
    }

    private static List<Product> products() {
        return List.of(
                new Product("SKU-BOOK", "Java Interview Guide", "books", 4599),
                new Product("SKU-MOUSE", "Wireless Mouse", "electronics", 2599),
                new Product("SKU-BAG", "Laptop Bag", "accessories", 6499),
                new Product("SKU-KEY", "Mechanical Keyboard", "electronics", 8999),
                new Product("SKU-MUG", "Coffee Mug", "home", 1299)
        );
    }

    private static CustomerOrder order() {
        return new CustomerOrder("ORD-1001", "GOLD", List.of(
                new OrderItem("SKU-BOOK", 1),
                new OrderItem("SKU-MOUSE", 2),
                new OrderItem("SKU-BAG", 1)
        ), 1600, 3);
    }

    private static List<Warehouse> warehouses() {
        return List.of(
                new Warehouse("EAST", "New Jersey", Map.of("SKU-BOOK", 4, "SKU-MOUSE", 8, "SKU-BAG", 0), 350, 2),
                new Warehouse("MID", "Illinois", Map.of("SKU-BOOK", 2, "SKU-MOUSE", 2, "SKU-BAG", 3), 425, 3),
                new Warehouse("WEST", "Nevada", Map.of("SKU-BOOK", 0, "SKU-MOUSE", 9, "SKU-BAG", 5), 500, 4)
        );
    }

    private static List<InventoryAdjustment> adjustments() {
        return List.of(
                new InventoryAdjustment("SKU-BOOK", "EAST", 5),
                new InventoryAdjustment("SKU-MOUSE", "EAST", -1),
                new InventoryAdjustment("SKU-MOUSE", "WEST", 7),
                new InventoryAdjustment("SKU-BAG", "MID", 2)
        );
    }

    private static Map<String, Product> productBySku() {
        return products().stream().collect(Collectors.toMap(Product::sku, product -> product));
    }

    private static void printHeader(String title) {
        System.out.println("Real-life e-commerce example: " + title);
    }

    private static void backtrackingFulfillment() {
        printHeader("multi-warehouse order fulfillment with pruning");
        CustomerOrder order = order();
        List<FulfillmentPlan> plans = new ArrayList<>();
        backtrack(order, warehouses(), 0, new FulfillmentPlan(), plans);
        System.out.println("valid plans: " + plans.size());
        plans.forEach(plan -> System.out.println("  " + plan));
    }

    private static void backtrack(CustomerOrder order, List<Warehouse> warehouses, int itemIndex,
                                  FulfillmentPlan current, List<FulfillmentPlan> plans) {
        if (itemIndex == order.items().size()) {
            plans.add(current.copy());
            return;
        }
        OrderItem item = order.items().get(itemIndex);
        for (Warehouse warehouse : warehouses) {
            if (!warehouse.hasStock(item)) {
                continue;
            }
            int nextCost = current.estimatedCostCents() + warehouse.shippingCostCents(item);
            if (nextCost > order.maxShippingCostCents() || warehouse.shippingDays() > order.maxShipDays()) {
                continue;
            }
            current.add(item, warehouse);
            backtrack(order, warehouses, itemIndex + 1, current, plans);
            current.removeLast();
        }
    }

    private static void bfsWarehouseReachability() {
        printHeader("BFS over warehouse transfer lanes");
        Map<String, List<String>> lanes = Map.of(
                "EAST", List.of("MID"),
                "MID", List.of("EAST", "WEST"),
                "WEST", List.of("MID")
        );
        Queue<String> queue = new ArrayDeque<>(List.of("EAST"));
        Set<String> visited = new LinkedHashSet<>(List.of("EAST"));
        while (!queue.isEmpty()) {
            String warehouse = queue.poll();
            for (String next : lanes.getOrDefault(warehouse, List.of())) {
                if (visited.add(next)) {
                    queue.add(next);
                }
            }
        }
        System.out.println("warehouses reachable from EAST: " + visited);
    }

    private static void binarySearchShippingTier() {
        printHeader("binary search shipping tier by cart total");
        int[] thresholds = {2500, 5000, 10000, 20000};
        int cartTotal = 8999;
        int index = Arrays.binarySearch(thresholds, cartTotal);
        int insertionPoint = index >= 0 ? index : -index - 1;
        System.out.println("cart total $" + (cartTotal / 100.0) + " belongs before tier index " + insertionPoint);
    }

    private static void linearScanInventory() {
        printHeader("linear scan to find first warehouse with stock");
        OrderItem item = new OrderItem("SKU-BAG", 1);
        warehouses().stream()
                .filter(warehouse -> warehouse.hasStock(item))
                .findFirst()
                .ifPresent(warehouse -> System.out.println("first warehouse with bag stock: " + warehouse));
    }

    private static void nestedLoopBundlePairs() {
        printHeader("nested loop product bundle pair search");
        int budget = 11000;
        List<Product> products = products();
        for (int i = 0; i < products.size(); i++) {
            for (int j = i + 1; j < products.size(); j++) {
                int total = products.get(i).priceCents() + products.get(j).priceCents();
                if (total <= budget) {
                    System.out.println("bundle candidate: " + products.get(i).sku() + " + " + products.get(j).sku());
                }
            }
        }
    }

    private static void recursiveCategoryCount() {
        printHeader("recursive category tree count");
        Category root = new Category("store", List.of(
                new Category("electronics", List.of(new Category("keyboards"), new Category("mice"))),
                new Category("books")
        ));
        System.out.println("category nodes: " + countCategories(root));
    }

    private static int countCategories(Category category) {
        int count = 1;
        for (Category child : category.children()) {
            count += countCategories(child);
        }
        return count;
    }

    private record Category(String name, List<Category> children) {
        private Category(String name) {
            this(name, List.of());
        }
    }

    private static void slidingWindowRevenue() {
        printHeader("sliding window peak revenue over three minutes");
        int[] minuteRevenue = {1200, 1800, 900, 2200, 1700};
        int window = 3;
        int sum = 0;
        for (int i = 0; i < window; i++) {
            sum += minuteRevenue[i];
        }
        int best = sum;
        for (int right = window; right < minuteRevenue.length; right++) {
            sum += minuteRevenue[right] - minuteRevenue[right - window];
            best = Math.max(best, sum);
        }
        System.out.println("best 3-minute revenue: $" + (best / 100.0));
    }

    private static void topProductsWithHeap() {
        printHeader("top purchased products with a priority queue");
        Map<String, Integer> counts = Map.of("SKU-BOOK", 9, "SKU-MOUSE", 14, "SKU-BAG", 4, "SKU-MUG", 8);
        PriorityQueue<String> heap = new PriorityQueue<>(Comparator.comparingInt(counts::get));
        for (String sku : counts.keySet()) {
            heap.offer(sku);
            if (heap.size() > 2) {
                heap.poll();
            }
        }
        System.out.println("top two SKUs: " + heap);
    }

    private static void twoSumPromotionPair() {
        printHeader("two-sum promotion pair under coupon target");
        int target = 11098;
        Map<Integer, String> skuByPrice = new HashMap<>();
        for (Product product : products()) {
            int needed = target - product.priceCents();
            if (skuByPrice.containsKey(needed)) {
                System.out.println("coupon pair: " + skuByPrice.get(needed) + " + " + product.sku());
                return;
            }
            skuByPrice.put(product.priceCents(), product.sku());
        }
    }

    private static void validatePromotionExpression() {
        printHeader("stack validation of promotion rule brackets");
        String rule = "(tier == GOLD && (cartTotal > 5000))";
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (char ch : rule.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty()) {
                    System.out.println("promotion rule valid: false");
                    return;
                }
                stack.pop();
            }
        }
        System.out.println("promotion rule valid: " + stack.isEmpty());
    }

    private static void mergeDeliveryWindows() {
        printHeader("merge overlapping delivery promise windows");
        int[][] windows = {{9, 12}, {11, 14}, {16, 18}};
        Arrays.sort(windows, Comparator.comparingInt(window -> window[0]));
        List<int[]> merged = new ArrayList<>();
        for (int[] window : windows) {
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < window[0]) {
                merged.add(window);
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], window[1]);
            }
        }
        System.out.println("merged windows: " + merged.stream().map(Arrays::toString).toList());
    }

    private static void constantTimeSkuLookup() {
        printHeader("constant-time SKU lookup by map key");
        Product product = productBySku().get("SKU-MOUSE");
        System.out.println("lookup result: " + product.name());
    }

    private static void sortOrdersByValue() {
        printHeader("n log n sort of order totals");
        List<Integer> totals = new ArrayList<>(List.of(4599, 11098, 8999, 1299));
        totals.sort(Integer::compareTo);
        System.out.println("sorted order totals: " + totals);
    }

    private static void generatePromotionBundles() {
        printHeader("generate small promotion SKU subsets");
        List<String> skus = List.of("SKU-BOOK", "SKU-MOUSE", "SKU-MUG");
        List<List<String>> bundles = new ArrayList<>();
        buildSubsets(skus, 0, new ArrayList<>(), bundles);
        System.out.println("promotion bundles: " + bundles);
    }

    private static void buildSubsets(List<String> skus, int index, List<String> current, List<List<String>> bundles) {
        if (index == skus.size()) {
            bundles.add(new ArrayList<>(current));
            return;
        }
        buildSubsets(skus, index + 1, current, bundles);
        current.add(skus.get(index));
        buildSubsets(skus, index + 1, current, bundles);
        current.remove(current.size() - 1);
    }

    private static void testCheckoutStepOrders() {
        printHeader("permutations of checkout validation step order");
        List<String> result = new ArrayList<>();
        permute("", "ABC", result);
        System.out.println("step order permutations: " + result);
    }

    private static void permute(String prefix, String remaining, List<String> result) {
        if (remaining.isEmpty()) {
            result.add(prefix);
            return;
        }
        for (int i = 0; i < remaining.length(); i++) {
            permute(prefix + remaining.charAt(i), remaining.substring(0, i) + remaining.substring(i + 1), result);
        }
    }

    private static void constantSpaceCartTotal() {
        printHeader("constant-space cart total calculation");
        int total = 0;
        Map<String, Product> catalog = productBySku();
        for (OrderItem item : order().items()) {
            total += catalog.get(item.sku()).priceCents() * item.quantity();
        }
        System.out.println("cart total: $" + (total / 100.0));
    }

    private static void linearSpaceOrderDtos() {
        printHeader("linear-space DTO creation for API response");
        List<String> dtoLines = order().items().stream()
                .map(item -> item.sku() + " x " + item.quantity())
                .toList();
        System.out.println("order DTO lines: " + dtoLines);
    }

    private static void collectionsOverview() {
        printHeader("collections used by an order service");
        List<OrderItem> items = order().items();
        Set<String> uniqueSkus = items.stream().map(OrderItem::sku).collect(Collectors.toSet());
        Map<String, Product> catalog = productBySku();
        Queue<String> shipmentQueue = new LinkedList<>(List.of(order().orderId()));
        System.out.println("items=" + items.size() + ", uniqueSkus=" + uniqueSkus + ", catalogSize=" + catalog.size() + ", nextShipment=" + shipmentQueue.poll());
    }

    private static void listSetMapComparison() {
        printHeader("List vs Set vs Map in cart handling");
        List<String> scannedSkus = List.of("SKU-MOUSE", "SKU-MOUSE", "SKU-BAG");
        Set<String> uniqueSkus = new LinkedHashSet<>(scannedSkus);
        Map<String, Product> catalog = productBySku();
        System.out.println("list=" + scannedSkus + ", set=" + uniqueSkus + ", map lookup=" + catalog.get("SKU-BAG").name());
    }

    private static void arrayListVsLinkedList() {
        printHeader("ArrayList search results and LinkedList work queue");
        List<Product> searchResults = new ArrayList<>(products());
        LinkedList<String> workQueue = new LinkedList<>(List.of("pick", "pack"));
        workQueue.addFirst("fraud-check");
        System.out.println("third result=" + searchResults.get(2).sku() + ", workflow=" + workQueue);
    }

    private static void setExamples() {
        printHeader("sets for duplicate request IDs and sorted SKU display");
        Set<String> seenRequests = new HashSet<>(List.of("REQ-1", "REQ-1", "REQ-2"));
        Set<String> sortedSkus = new TreeSet<>(productBySku().keySet());
        System.out.println("unique requests=" + seenRequests + ", sorted SKUs=" + sortedSkus);
    }

    private static void mapExamples() {
        printHeader("maps for catalog lookup and stable response order");
        Map<String, Product> hashMap = productBySku();
        Map<String, Product> linked = new LinkedHashMap<>();
        linked.put("featured", hashMap.get("SKU-BOOK"));
        linked.put("recommended", hashMap.get("SKU-MOUSE"));
        Map<String, Product> sorted = new TreeMap<>(hashMap);
        System.out.println("lookup=" + hashMap.get("SKU-BOOK").name() + ", ordered=" + linked.keySet() + ", sorted=" + sorted.keySet());
    }

    private static void concurrentHashMapExample() {
        printHeader("ConcurrentHashMap for shared inventory counters");
        ConcurrentHashMap<String, Integer> inventory = new ConcurrentHashMap<>();
        inventory.putIfAbsent("SKU-BOOK", 0);
        inventory.compute("SKU-BOOK", (sku, old) -> old == null ? 1 : old + 5);
        System.out.println("inventory snapshot: " + inventory);
    }

    private static void collectionManipulation() {
        printHeader("collection manipulation in an order admin screen");
        List<String> statuses = new ArrayList<>(List.of("NEW", "PAID", "PACKED"));
        statuses.add("SHIPPED");
        statuses.set(0, "VALIDATED");
        statuses.remove("PACKED");
        statuses.sort(String::compareTo);
        System.out.println("visible statuses: " + statuses);
    }

    private static void frequencyCount() {
        printHeader("frequency count of purchased SKUs");
        Map<String, Integer> counts = new HashMap<>();
        for (String sku : List.of("SKU-BOOK", "SKU-MOUSE", "SKU-MOUSE")) {
            counts.merge(sku, 1, Integer::sum);
        }
        System.out.println("purchase frequency: " + counts);
    }

    private static void removeDuplicates() {
        printHeader("remove duplicate imported coupon codes");
        List<String> codes = List.of("SAVE10", "SHIPFREE", "SAVE10");
        System.out.println("unique preserving order: " + new LinkedHashSet<>(codes));
    }

    private static void safeRemoval() {
        printHeader("safe removal of expired cart reservations");
        List<String> reservations = new ArrayList<>(List.of("active-1", "expired-2", "active-3"));
        reservations.removeIf(value -> value.startsWith("expired"));
        System.out.println("remaining reservations: " + reservations);
    }

    private static void groupingAdjustments() {
        printHeader("group inventory adjustments by warehouse");
        Map<String, List<InventoryAdjustment>> byWarehouse = adjustments().stream()
                .collect(Collectors.groupingBy(InventoryAdjustment::warehouseCode));
        System.out.println("adjustments by warehouse: " + byWarehouse.keySet());
    }

    private static void conversionExample() {
        printHeader("convert cart lines to unique SKU set and map views");
        List<String> skus = order().items().stream().map(OrderItem::sku).toList();
        Set<String> unique = new HashSet<>(skus);
        System.out.println("unique SKUs=" + unique + ", catalog keys=" + productBySku().keySet());
    }

    private static void comparableProductSort() {
        printHeader("Comparable-style sort by SKU");
        List<Product> sorted = new ArrayList<>(products());
        sorted.sort(Comparator.comparing(Product::sku));
        System.out.println("products by SKU: " + sorted.stream().map(Product::sku).toList());
    }

    private static void comparatorOrderSort() {
        printHeader("Comparator sort by category then price");
        List<Product> sorted = new ArrayList<>(products());
        sorted.sort(Comparator.comparing(Product::category).thenComparingInt(Product::priceCents));
        System.out.println("category-price order: " + sorted.stream().map(Product::sku).toList());
    }

    private static void comparableVsComparator() {
        printHeader("natural SKU order versus business price order");
        List<Product> sorted = new ArrayList<>(products());
        sorted.sort(Comparator.comparing(Product::sku));
        String naturalFirst = sorted.get(0).sku();
        sorted.sort(Comparator.comparingInt(Product::priceCents));
        System.out.println("first by SKU=" + naturalFirst + ", cheapest=" + sorted.get(0).sku());
    }

    private static void primitiveVsObjectSorting() {
        printHeader("primitive price sorting versus boxed descending sort");
        int[] primitivePrices = {4599, 2599, 8999};
        Arrays.sort(primitivePrices);
        Integer[] boxedPrices = {4599, 2599, 8999};
        Arrays.sort(boxedPrices, Comparator.reverseOrder());
        System.out.println("ascending=" + Arrays.toString(primitivePrices) + ", descending=" + Arrays.toString(boxedPrices));
    }

    private static void customObjectHashing() {
        printHeader("custom object hashing for compound inventory key");
        record InventoryKey(String sku, String warehouseCode) {
        }
        Map<InventoryKey, Integer> inventory = new HashMap<>();
        inventory.put(new InventoryKey("SKU-BOOK", "EAST"), 4);
        System.out.println("lookup with equivalent key: " + inventory.get(new InventoryKey("SKU-BOOK", "EAST")));
    }

    private static void stringImmutability() {
        printHeader("immutable order status strings");
        String status = "PAID";
        String display = status.concat(" - ready to pack");
        System.out.println("stored status=" + status + ", display status=" + display);
    }

    private static void stringBuilderEmail() {
        printHeader("StringBuilder for shipment email body");
        StringBuilder body = new StringBuilder("Items shipped: ");
        for (OrderItem item : order().items()) {
            body.append(item.sku()).append(' ');
        }
        System.out.println(body.toString().trim());
    }

    private static void encapsulatedCart() {
        printHeader("encapsulated cart total update");
        Cart cart = new Cart();
        cart.add(4599);
        cart.add(2599);
        System.out.println("cart total cents: " + cart.totalCents());
    }

    private static final class Cart {
        private int totalCents;

        private void add(int priceCents) {
            if (priceCents <= 0) {
                throw new IllegalArgumentException("price must be positive");
            }
            totalCents += priceCents;
        }

        private int totalCents() {
            return totalCents;
        }
    }

    private static void paymentPolymorphism() {
        printHeader("polymorphic payment methods");
        List<PaymentMethod> methods = List.of(new CreditCardPayment(), new WalletPayment());
        methods.forEach(method -> System.out.println(method.charge("ORD-1001", 4599)));
    }

    private static void paymentInterfaceExample() {
        printHeader("interface-based payment dependency");
        PaymentMethod payment = new CreditCardPayment();
        System.out.println(payment.charge(order().orderId(), 4599));
    }

    private static void composedOrderService() {
        printHeader("composition in order service");
        OrderService service = new OrderService(new CreditCardPayment());
        System.out.println(service.checkout(order(), 4599));
    }

    private record OrderService(PaymentMethod paymentMethod) {
        private String checkout(CustomerOrder order, int amountCents) {
            return paymentMethod.charge(order.orderId(), amountCents);
        }
    }

    private static void overloadOverridePricing() {
        printHeader("overloaded pricing and overridden payment behavior");
        Pricing pricing = new Pricing();
        PaymentMethod payment = new WalletPayment();
        System.out.println("unit=" + pricing.total(2599) + ", qty=" + pricing.total(2599, 2) + ", " + payment.charge("ORD-1001", 5198));
    }

    private static final class Pricing {
        private int total(int priceCents) {
            return priceCents;
        }

        private int total(int priceCents, int quantity) {
            return priceCents * quantity;
        }
    }

    private static void looseCoupledNotification() {
        printHeader("loose-coupled shipment notification");
        Notifier notifier = message -> "sent notification: " + message;
        System.out.println(notifier.send("ORD-1001 shipped"));
    }

    private interface Notifier {
        String send(String message);
    }

    private static void finalFinallyFinalizeOrderFile() {
        printHeader("final order ID and finally cleanup");
        final String orderId = "ORD-1001";
        try {
            System.out.println("writing audit record for " + orderId);
        } finally {
            System.out.println("closed audit writer for " + orderId);
        }
    }

    private static void checkedVsUncheckedCheckout() {
        printHeader("checked inventory failure versus unchecked bad quantity");
        try {
            requireStock(new OrderItem("SKU-MISSING", 1));
        } catch (Exception exception) {
            System.out.println("checked-style handling: " + exception.getMessage());
        }
        try {
            validateQuantity(-1);
        } catch (IllegalArgumentException exception) {
            System.out.println("unchecked handling: " + exception.getMessage());
        }
    }

    private static void requireStock(OrderItem item) throws Exception {
        throw new Exception("no stock for " + item.sku());
    }

    private static void validateQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("quantity must be positive");
        }
    }

    private static void streamsVsLoopsOrders() {
        printHeader("loops versus streams for expensive cart lines");
        List<String> loop = new ArrayList<>();
        for (Product product : products()) {
            if (product.priceCents() > 4000) {
                loop.add(product.sku());
            }
        }
        List<String> stream = products().stream().filter(product -> product.priceCents() > 4000).map(Product::sku).toList();
        System.out.println("loop=" + loop + ", stream=" + stream);
    }

    private static void lambdaSortProducts() {
        printHeader("lambda sort for merchandised product list");
        List<Product> sorted = new ArrayList<>(products());
        sorted.sort((left, right) -> Integer.compare(left.priceCents(), right.priceCents()));
        System.out.println("sorted by lambda: " + sorted.stream().map(Product::sku).toList());
    }

    private static void optionalCustomerCoupon() {
        printHeader("Optional coupon lookup");
        Optional<String> coupon = findCouponForTier(order().customerTier());
        System.out.println("coupon applied: " + coupon.orElse("NONE"));
    }

    private static Optional<String> findCouponForTier(String tier) {
        return "GOLD".equals(tier) ? Optional.of("GOLD10") : Optional.empty();
    }

    private static void threadInventoryRefresh() {
        printHeader("background inventory refresh thread");
        Thread thread = new Thread(() -> System.out.println("refreshing cache on " + Thread.currentThread().getName()));
        thread.start();
        join(thread);
    }

    private static void startVsRunFulfillmentJob() {
        printHeader("start versus run for fulfillment job");
        Runnable job = () -> System.out.println("job thread: " + Thread.currentThread().getName());
        job.run();
        Thread thread = new Thread(job, "fulfillment-worker");
        thread.start();
        join(thread);
    }

    private static void synchronizedOrderCounter() {
        printHeader("synchronized order counter");
        SynchronizedCounter counter = new SynchronizedCounter();
        Thread one = new Thread(() -> increment(counter));
        Thread two = new Thread(() -> increment(counter));
        one.start();
        two.start();
        join(one);
        join(two);
        System.out.println("processed orders: " + counter.value());
    }

    private static void increment(SynchronizedCounter counter) {
        for (int i = 0; i < 100; i++) {
            counter.increment();
        }
    }

    private static final class SynchronizedCounter {
        private int value;

        private synchronized void increment() {
            value++;
        }

        private synchronized int value() {
            return value;
        }
    }

    private static void hashMapThreadSafetyRisk() {
        printHeader("HashMap get-then-put lost update risk");
        Map<String, Integer> counts = new HashMap<>();
        counts.put("SKU-BOOK", 1);
        counts.put("SKU-BOOK", counts.get("SKU-BOOK") + 1);
        System.out.println("single-thread result=" + counts + "; concurrent code should not use plain get-then-put");
    }

    private static void atomicMapOperations() {
        printHeader("atomic ConcurrentHashMap operations for inventory buckets");
        ConcurrentHashMap<String, AtomicInteger> buckets = new ConcurrentHashMap<>();
        buckets.computeIfAbsent("SKU-BOOK", sku -> new AtomicInteger()).addAndGet(5);
        buckets.computeIfAbsent("SKU-BOOK", sku -> new AtomicInteger()).decrementAndGet();
        System.out.println("atomic bucket count: " + buckets.get("SKU-BOOK"));
    }

    private static void garbageCollectionCartSession() {
        printHeader("cart session becomes unreachable after checkout");
        CartSession session = new CartSession("SESSION-1", new ArrayList<>(order().items()));
        System.out.println("active session: " + session.sessionId());
        session = null;
        System.gc();
        System.out.println("checkout finished; abandoned session object is now eligible for GC");
    }

    private record CartSession(String sessionId, List<OrderItem> items) {
    }

    private static void join(Thread thread) {
        try {
            thread.join();
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
        }
    }
}
