package com.example.corejava.runner;

import com.example.corejava.algorithms.BacktrackingExample;
import com.example.corejava.algorithms.BfsGridExample;
import com.example.corejava.algorithms.BinarySearchExample;
import com.example.corejava.algorithms.LinearScanExample;
import com.example.corejava.algorithms.MergeIntervalsExample;
import com.example.corejava.algorithms.NestedLoopsExample;
import com.example.corejava.algorithms.RecursionExample;
import com.example.corejava.algorithms.SlidingWindowExample;
import com.example.corejava.algorithms.TopKFrequentExample;
import com.example.corejava.algorithms.TwoSumExample;
import com.example.corejava.algorithms.ValidParenthesesExample;
import com.example.corejava.collections.ArrayListVsLinkedListExample;
import com.example.corejava.collections.CollectionManipulationExample;
import com.example.corejava.collections.CollectionsOverviewExample;
import com.example.corejava.collections.ConversionExample;
import com.example.corejava.collections.FrequencyCountExample;
import com.example.corejava.collections.GroupingExample;
import com.example.corejava.collections.ListSetMapComparisonExample;
import com.example.corejava.collections.MapExamples;
import com.example.corejava.collections.PriorityQueueExample;
import com.example.corejava.collections.RemoveDuplicatesExample;
import com.example.corejava.collections.SafeRemovalExample;
import com.example.corejava.collections.SetExamples;
import com.example.corejava.complexity.ConstantSpaceExample;
import com.example.corejava.complexity.ConstantTimeExample;
import com.example.corejava.complexity.LinearSpaceExample;
import com.example.corejava.complexity.LinearTimeExample;
import com.example.corejava.complexity.LogarithmicTimeExample;
import com.example.corejava.complexity.NLogNExample;
import com.example.corejava.complexity.PermutationExample;
import com.example.corejava.complexity.QuadraticTimeExample;
import com.example.corejava.complexity.SubsetExample;
import com.example.corejava.exceptions.CheckedVsUncheckedExceptionExample;
import com.example.corejava.exceptions.FinalFinallyFinalizeExample;
import com.example.corejava.gc.GarbageCollectionExample;
import com.example.corejava.hashing.CustomObjectHashExample;
import com.example.corejava.hashing.EqualsHashCodeExample;
import com.example.corejava.hashing.HashMapExample;
import com.example.corejava.oop.CompositionVsInheritanceExample;
import com.example.corejava.oop.EncapsulationExample;
import com.example.corejava.oop.InheritancePolymorphismExample;
import com.example.corejava.oop.InterfaceVsAbstractExample;
import com.example.corejava.oop.LooseCouplingCohesionExample;
import com.example.corejava.oop.OverloadOverrideExample;
import com.example.corejava.optional.OptionalExample;
import com.example.corejava.sorting.ComparableExample;
import com.example.corejava.sorting.ComparableVsComparatorExample;
import com.example.corejava.sorting.ComparatorExample;
import com.example.corejava.sorting.PrimitiveVsObjectSortingExample;
import com.example.corejava.sorting.SortingExamples;
import com.example.corejava.streams.LambdaExample;
import com.example.corejava.streams.StreamsVsLoopsExample;
import com.example.corejava.strings.StringBuilderExample;
import com.example.corejava.strings.StringImmutabilityExample;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class DemoRunner {
    private static final Map<String, List<Demo>> DEMOS = new LinkedHashMap<>();

    static {
        DEMOS.put("complexity", List.of(
                demo("O(1) time", ConstantTimeExample::run),
                demo("O(n) time", LinearTimeExample::run),
                demo("O(n^2) time", QuadraticTimeExample::run),
                demo("O(log n) time", LogarithmicTimeExample::run),
                demo("O(n log n) time", NLogNExample::run),
                demo("O(2^n) subsets", SubsetExample::run),
                demo("O(n!) permutations", PermutationExample::run),
                demo("O(1) space", ConstantSpaceExample::run),
                demo("O(n) space", LinearSpaceExample::run)
        ));
        DEMOS.put("algorithms", List.of(
                demo("Linear scan", LinearScanExample::run),
                demo("Nested loops", NestedLoopsExample::run),
                demo("Binary search", BinarySearchExample::run),
                demo("Recursion", RecursionExample::run),
                demo("Backtracking", BacktrackingExample::run),
                demo("Two sum", TwoSumExample::run),
                demo("Sliding window", SlidingWindowExample::run),
                demo("Valid parentheses", ValidParenthesesExample::run),
                demo("BFS grid", BfsGridExample::run),
                demo("Top K frequent", TopKFrequentExample::run),
                demo("Merge intervals", MergeIntervalsExample::run)
        ));
        DEMOS.put("collections", List.of(
                demo("Collections overview", CollectionsOverviewExample::run),
                demo("List vs Set vs Map", ListSetMapComparisonExample::run),
                demo("ArrayList vs LinkedList", ArrayListVsLinkedListExample::run),
                demo("Set examples", SetExamples::run),
                demo("Map examples", MapExamples::run),
                demo("PriorityQueue", PriorityQueueExample::run),
                demo("ConcurrentHashMap", com.example.corejava.collections.ConcurrentHashMapExample::run),
                demo("Manipulation", CollectionManipulationExample::run),
                demo("Frequency count", FrequencyCountExample::run),
                demo("Remove duplicates", RemoveDuplicatesExample::run),
                demo("Safe removal", SafeRemovalExample::run),
                demo("Grouping", GroupingExample::run),
                demo("Conversions", ConversionExample::run)
        ));
        DEMOS.put("sorting", List.of(
                demo("Sorting examples", SortingExamples::run),
                demo("Comparable", ComparableExample::run),
                demo("Comparator", ComparatorExample::run),
                demo("Comparable vs Comparator", ComparableVsComparatorExample::run),
                demo("Primitive vs object sorting", PrimitiveVsObjectSortingExample::run)
        ));
        DEMOS.put("hashing", List.of(
                demo("HashMap basics", HashMapExample::run),
                demo("equals and hashCode", EqualsHashCodeExample::run),
                demo("Custom object hashing", CustomObjectHashExample::run)
        ));
        DEMOS.put("strings", List.of(
                demo("String immutability", StringImmutabilityExample::run),
                demo("StringBuilder", StringBuilderExample::run)
        ));
        DEMOS.put("oop", List.of(
                demo("Encapsulation", EncapsulationExample::run),
                demo("Inheritance and polymorphism", InheritancePolymorphismExample::run),
                demo("Interface vs abstract class", InterfaceVsAbstractExample::run),
                demo("Composition vs inheritance", CompositionVsInheritanceExample::run),
                demo("Overloading vs overriding", OverloadOverrideExample::run),
                demo("Loose coupling and cohesion", LooseCouplingCohesionExample::run)
        ));
        DEMOS.put("exceptions", List.of(
                demo("final, finally, finalize", FinalFinallyFinalizeExample::run),
                demo("Checked vs unchecked exceptions", CheckedVsUncheckedExceptionExample::run)
        ));
        DEMOS.put("streams", List.of(
                demo("Streams vs loops", StreamsVsLoopsExample::run),
                demo("Lambdas", LambdaExample::run)
        ));
        DEMOS.put("optional", List.of(
                demo("Optional basics", OptionalExample::run)
        ));
        DEMOS.put("concurrency", List.of(
                demo("Thread basics", com.example.corejava.concurrency.ThreadExample::run),
                demo("start() vs run()", com.example.corejava.concurrency.StartVsRunExample::run),
                demo("synchronized counter", com.example.corejava.concurrency.SynchronizedCounterExample::run),
                demo("HashMap thread safety", com.example.corejava.concurrency.HashMapThreadSafetyExample::run),
                demo("ConcurrentHashMap", com.example.corejava.concurrency.ConcurrentHashMapExample::run),
                demo("Atomic map operations", com.example.corejava.concurrency.AtomicMapOperationsExample::run)
        ));
        DEMOS.put("gc", List.of(
                demo("Garbage collection basics", GarbageCollectionExample::run)
        ));
    }

    public static void main(String[] args) {
        String topic = args.length == 0 ? "all" : args[0].toLowerCase(Locale.ROOT);
        if ("help".equals(topic)) {
            printHelp();
            return;
        }
        if ("all".equals(topic)) {
            DEMOS.keySet().forEach(DemoRunner::runTopic);
            return;
        }
        if (!DEMOS.containsKey(topic)) {
            System.out.println("Unknown topic: " + topic);
            printHelp();
            return;
        }
        runTopic(topic);
    }

    private static void runTopic(String topic) {
        System.out.println();
        System.out.println("==================================================");
        System.out.println("Topic: " + topic);
        System.out.println("==================================================");
        for (Demo demo : DEMOS.get(topic)) {
            System.out.println();
            System.out.println("-- " + demo.name() + " --");
            demo.action().run();
        }
    }

    private static void printHelp() {
        System.out.println("Usage: mvn exec:java -Dexec.args=\"<topic>\"");
        System.out.println("Use 'all' or one of: " + DEMOS.keySet());
    }

    private static Demo demo(String name, Runnable action) {
        return new Demo(name, action);
    }

    private record Demo(String name, Runnable action) {
    }
}
