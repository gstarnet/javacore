package com.examples.reallife.runner;

import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Console runner for the e-commerce backend examples under {@code com.examples.reallife}.
 *
 * <p>The runner mirrors the core {@code DemoRunner}: run every real-life example, or run
 * one topic such as {@code algorithms}, {@code collections}, or {@code concurrency}.</p>
 */
public final class RealLifeDemoRunner {
    private static final Map<String, List<String>> EXAMPLES = new LinkedHashMap<>();

    static {
        EXAMPLES.put("complexity", List.of(
                "com.examples.reallife.complexity.ConstantTimeExample",
                "com.examples.reallife.complexity.LinearTimeExample",
                "com.examples.reallife.complexity.QuadraticTimeExample",
                "com.examples.reallife.complexity.LogarithmicTimeExample",
                "com.examples.reallife.complexity.NLogNExample",
                "com.examples.reallife.complexity.SubsetExample",
                "com.examples.reallife.complexity.PermutationExample",
                "com.examples.reallife.complexity.ConstantSpaceExample",
                "com.examples.reallife.complexity.LinearSpaceExample"
        ));
        EXAMPLES.put("algorithms", List.of(
                "com.examples.reallife.algorithms.LinearScanExample",
                "com.examples.reallife.algorithms.NestedLoopsExample",
                "com.examples.reallife.algorithms.BinarySearchExample",
                "com.examples.reallife.algorithms.RecursionExample",
                "com.examples.reallife.algorithms.BacktrackingExample",
                "com.examples.reallife.algorithms.TwoSumExample",
                "com.examples.reallife.algorithms.SlidingWindowExample",
                "com.examples.reallife.algorithms.ValidParenthesesExample",
                "com.examples.reallife.algorithms.BfsGridExample",
                "com.examples.reallife.algorithms.TopKFrequentExample",
                "com.examples.reallife.algorithms.MergeIntervalsExample"
        ));
        EXAMPLES.put("collections", List.of(
                "com.examples.reallife.collections.CollectionsOverviewExample",
                "com.examples.reallife.collections.ListSetMapComparisonExample",
                "com.examples.reallife.collections.ArrayListVsLinkedListExample",
                "com.examples.reallife.collections.SetExamples",
                "com.examples.reallife.collections.MapExamples",
                "com.examples.reallife.collections.PriorityQueueExample",
                "com.examples.reallife.collections.ConcurrentHashMapExample",
                "com.examples.reallife.collections.CollectionManipulationExample",
                "com.examples.reallife.collections.FrequencyCountExample",
                "com.examples.reallife.collections.RemoveDuplicatesExample",
                "com.examples.reallife.collections.SafeRemovalExample",
                "com.examples.reallife.collections.GroupingExample",
                "com.examples.reallife.collections.ConversionExample"
        ));
        EXAMPLES.put("sorting", List.of(
                "com.examples.reallife.sorting.SortingExamples",
                "com.examples.reallife.sorting.ComparableExample",
                "com.examples.reallife.sorting.ComparatorExample",
                "com.examples.reallife.sorting.ComparableVsComparatorExample",
                "com.examples.reallife.sorting.PrimitiveVsObjectSortingExample"
        ));
        EXAMPLES.put("hashing", List.of(
                "com.examples.reallife.hashing.HashMapExample",
                "com.examples.reallife.hashing.EqualsHashCodeExample",
                "com.examples.reallife.hashing.CustomObjectHashExample"
        ));
        EXAMPLES.put("strings", List.of(
                "com.examples.reallife.strings.StringImmutabilityExample",
                "com.examples.reallife.strings.StringBuilderExample"
        ));
        EXAMPLES.put("oop", List.of(
                "com.examples.reallife.oop.EncapsulationExample",
                "com.examples.reallife.oop.InheritancePolymorphismExample",
                "com.examples.reallife.oop.InterfaceVsAbstractExample",
                "com.examples.reallife.oop.CompositionVsInheritanceExample",
                "com.examples.reallife.oop.OverloadOverrideExample",
                "com.examples.reallife.oop.LooseCouplingCohesionExample"
        ));
        EXAMPLES.put("exceptions", List.of(
                "com.examples.reallife.exceptions.FinalFinallyFinalizeExample",
                "com.examples.reallife.exceptions.CheckedVsUncheckedExceptionExample"
        ));
        EXAMPLES.put("streams", List.of(
                "com.examples.reallife.streams.StreamsVsLoopsExample",
                "com.examples.reallife.streams.LambdaExample"
        ));
        EXAMPLES.put("optional", List.of("com.examples.reallife.optional.OptionalExample"));
        EXAMPLES.put("concurrency", List.of(
                "com.examples.reallife.concurrency.ThreadExample",
                "com.examples.reallife.concurrency.StartVsRunExample",
                "com.examples.reallife.concurrency.SynchronizedCounterExample",
                "com.examples.reallife.concurrency.HashMapThreadSafetyExample",
                "com.examples.reallife.concurrency.ConcurrentHashMapExample",
                "com.examples.reallife.concurrency.AtomicMapOperationsExample"
        ));
        EXAMPLES.put("gc", List.of("com.examples.reallife.gc.GarbageCollectionExample"));
    }

    private RealLifeDemoRunner() {
    }

    /**
     * Runs all real-life examples or one selected topic.
     *
     * @param args optional topic name such as {@code all}, {@code algorithms}, or {@code help}
     */
    public static void main(String[] args) {
        String topic = args.length == 0 ? "all" : args[0].toLowerCase(Locale.ROOT);
        if ("help".equals(topic)) {
            printHelp();
            return;
        }
        if ("all".equals(topic)) {
            EXAMPLES.keySet().forEach(RealLifeDemoRunner::runTopic);
            return;
        }
        if (!EXAMPLES.containsKey(topic)) {
            System.out.println("Unknown real-life topic: " + topic);
            printHelp();
            return;
        }
        runTopic(topic);
    }

    private static void runTopic(String topic) {
        System.out.println();
        System.out.println("==================================================");
        System.out.println("Real-life topic: " + topic);
        System.out.println("==================================================");
        for (String className : EXAMPLES.get(topic)) {
            System.out.println();
            System.out.println("-- " + className.substring(className.lastIndexOf('.') + 1) + " --");
            invokeRun(className);
        }
    }

    private static void invokeRun(String className) {
        try {
            Class<?> exampleClass = Class.forName(className);
            Method run = exampleClass.getMethod("run");
            run.invoke(null);
        } catch (ReflectiveOperationException exception) {
            throw new IllegalStateException("Unable to run " + className, exception);
        }
    }

    private static void printHelp() {
        System.out.println("Usage: java com.examples.reallife.runner.RealLifeDemoRunner <topic>");
        System.out.println("Use 'all' or one of: " + EXAMPLES.keySet());
    }
}
