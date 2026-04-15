package com.examples.corejava.runner;

import com.examples.corejava.algorithms.BacktrackingExample;
import com.examples.corejava.algorithms.BfsGridExample;
import com.examples.corejava.algorithms.BinarySearchExample;
import com.examples.corejava.algorithms.LinearScanExample;
import com.examples.corejava.algorithms.MergeIntervalsExample;
import com.examples.corejava.algorithms.NestedLoopsExample;
import com.examples.corejava.algorithms.RecursionExample;
import com.examples.corejava.algorithms.SlidingWindowExample;
import com.examples.corejava.algorithms.TopKFrequentExample;
import com.examples.corejava.algorithms.TwoSumExample;
import com.examples.corejava.algorithms.ValidParenthesesExample;
import com.examples.corejava.collections.ArrayListVsLinkedListExample;
import com.examples.corejava.collections.CollectionManipulationExample;
import com.examples.corejava.collections.CollectionsOverviewExample;
import com.examples.corejava.collections.ConversionExample;
import com.examples.corejava.collections.FrequencyCountExample;
import com.examples.corejava.collections.GroupingExample;
import com.examples.corejava.collections.ListSetMapComparisonExample;
import com.examples.corejava.collections.MapExamples;
import com.examples.corejava.collections.PriorityQueueExample;
import com.examples.corejava.collections.RemoveDuplicatesExample;
import com.examples.corejava.collections.SafeRemovalExample;
import com.examples.corejava.collections.SetExamples;
import com.examples.corejava.complexity.ConstantSpaceExample;
import com.examples.corejava.complexity.ConstantTimeExample;
import com.examples.corejava.complexity.LinearSpaceExample;
import com.examples.corejava.complexity.LinearTimeExample;
import com.examples.corejava.complexity.LogarithmicTimeExample;
import com.examples.corejava.complexity.NLogNExample;
import com.examples.corejava.complexity.PermutationExample;
import com.examples.corejava.complexity.QuadraticTimeExample;
import com.examples.corejava.complexity.SubsetExample;
import com.examples.corejava.exceptions.CheckedVsUncheckedExceptionExample;
import com.examples.corejava.exceptions.FinalFinallyFinalizeExample;
import com.examples.corejava.gc.GarbageCollectionExample;
import com.examples.corejava.hashing.CustomObjectHashExample;
import com.examples.corejava.hashing.EqualsHashCodeExample;
import com.examples.corejava.hashing.HashMapExample;
import com.examples.corejava.oop.CompositionVsInheritanceExample;
import com.examples.corejava.oop.EncapsulationExample;
import com.examples.corejava.oop.InheritancePolymorphismExample;
import com.examples.corejava.oop.InterfaceVsAbstractExample;
import com.examples.corejava.oop.LooseCouplingCohesionExample;
import com.examples.corejava.oop.OverloadOverrideExample;
import com.examples.corejava.optional.OptionalExample;
import com.examples.corejava.sorting.ComparableExample;
import com.examples.corejava.sorting.ComparableVsComparatorExample;
import com.examples.corejava.sorting.ComparatorExample;
import com.examples.corejava.sorting.PrimitiveVsObjectSortingExample;
import com.examples.corejava.sorting.SortingExamples;
import com.examples.corejava.streams.LambdaExample;
import com.examples.corejava.streams.StreamsVsLoopsExample;
import com.examples.corejava.strings.StringBuilderExample;
import com.examples.corejava.strings.StringImmutabilityExample;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;


/**
 * Main entry point that runs all examples or a selected topic group from the command line.
 *
 * <p>Interview questions answered: How can small demos be organized behind one runner?
 * How are command-line arguments used to choose behavior?</p>
 *
 * <p>Real-life use: lightweight console launchers for training projects, diagnostics, or
 * developer utilities.</p>
 */
public class DemoRunner {
    private DemoRunner() {
    }
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
                demo("ConcurrentHashMap", com.examples.corejava.collections.ConcurrentHashMapExample::run),
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
                demo("Thread basics", com.examples.corejava.concurrency.ThreadExample::run),
                demo("start() vs run()", com.examples.corejava.concurrency.StartVsRunExample::run),
                demo("synchronized counter", com.examples.corejava.concurrency.SynchronizedCounterExample::run),
                demo("HashMap thread safety", com.examples.corejava.concurrency.HashMapThreadSafetyExample::run),
                demo("ConcurrentHashMap", com.examples.corejava.concurrency.ConcurrentHashMapExample::run),
                demo("Atomic map operations", com.examples.corejava.concurrency.AtomicMapOperationsExample::run)
        ));
        DEMOS.put("gc", List.of(
                demo("Garbage collection basics", GarbageCollectionExample::run)
        ));
    }

    /**
     * Runs all examples or a selected topic group from the command line.
     *
     * @param args optional topic name such as {@code all}, {@code strings}, or {@code help}
     */
    public static void main(String[] args) {
        // Walkthrough:
        // 1. Read the first command-line argument, or default to running every topic.
        // 2. Handle help and unknown topics before any demos execute.
        // 3. Run either all topic groups or the selected group with readable section headers.
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
