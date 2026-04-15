package com.examples.corejava;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Execution(ExecutionMode.SAME_THREAD)
class ExampleRunnableTest {
    private static final List<ExampleCase> RUNNABLE_EXAMPLES = List.of(
            example("com.examples.corejava.algorithms.BacktrackingExample", "Valid parentheses"),
            example("com.examples.corejava.algorithms.BfsGridExample", "Reachable cells from top-left"),
            example("com.examples.corejava.algorithms.BinarySearchExample", "Binary search index: 3"),
            example("com.examples.corejava.algorithms.LinearScanExample", "Linear scan index: 1"),
            example("com.examples.corejava.algorithms.MergeIntervalsExample", "Merged intervals"),
            example("com.examples.corejava.algorithms.NestedLoopsExample", "Pair found"),
            example("com.examples.corejava.algorithms.RecursionExample", "Factorial 5: 120"),
            example("com.examples.corejava.algorithms.SlidingWindowExample", "Max sum of size 3: 9"),
            example("com.examples.corejava.algorithms.TopKFrequentExample", "Top 2 words"),
            example("com.examples.corejava.algorithms.TwoSumExample", "Two sum indexes: [0, 1]"),
            example("com.examples.corejava.algorithms.ValidParenthesesExample", "{[()]} is valid: true"),
            example("com.examples.corejava.collections.ArrayListVsLinkedListExample", "ArrayList fast random access", "LinkedList easy deque operations"),
            example("com.examples.corejava.collections.CollectionManipulationExample", "Read by index", "Filtered", "Transformed lengths"),
            example("com.examples.corejava.collections.CollectionsOverviewExample", "ArrayList", "HashMap lookup", "PriorityQueue smallest first"),
            example("com.examples.corejava.collections.ConcurrentHashMapExample", "ConcurrentHashMap atomic update"),
            example("com.examples.corejava.collections.ConversionExample", "List to Set", "Map view keys", "Reversed copy"),
            example("com.examples.corejava.collections.FrequencyCountExample", "Frequency count"),
            example("com.examples.corejava.collections.GroupingExample", "Grouped by first letter"),
            example("com.examples.corejava.collections.ListSetMapComparisonExample", "List allows duplicates", "Set keeps unique values", "Map stores key-value pairs"),
            example("com.examples.corejava.collections.MapExamples", "HashMap average O(1) lookup", "LinkedHashMap preserves insertion order", "TreeMap sorts keys"),
            example("com.examples.corejava.collections.PriorityQueueExample", "Min heap poll", "Max heap poll"),
            example("com.examples.corejava.collections.RemoveDuplicatesExample", "Unique any order", "Unique preserving order"),
            example("com.examples.corejava.collections.SafeRemovalExample", "After Iterator.remove", "After removeIf"),
            example("com.examples.corejava.collections.SetExamples", "HashSet unique values", "LinkedHashSet insertion order", "TreeSet sorted order"),
            example("com.examples.corejava.complexity.ConstantSpaceExample", "Sum: 20"),
            example("com.examples.corejava.complexity.ConstantTimeExample", "First name: Ada"),
            example("com.examples.corejava.complexity.LinearSpaceExample", "Doubled: [2, 4, 6]"),
            example("com.examples.corejava.complexity.LinearTimeExample", "Found 11"),
            example("com.examples.corejava.complexity.LogarithmicTimeExample", "Found at index 4"),
            example("com.examples.corejava.complexity.NLogNExample", "Sorted scores"),
            example("com.examples.corejava.complexity.PermutationExample", "Permutations"),
            example("com.examples.corejava.complexity.QuadraticTimeExample", "Ana meets Ana"),
            example("com.examples.corejava.complexity.SubsetExample", "Subsets"),
            example("com.examples.corejava.concurrency.AtomicMapOperationsExample", "Atomic map operations", "mutating the List value"),
            example("com.examples.corejava.concurrency.ConcurrentHashMapExample", "ConcurrentHashMap count: 2"),
            example("com.examples.corejava.concurrency.HashMapThreadSafetyExample", "Single-thread get-then-put", "can lose updates"),
            example("com.examples.corejava.concurrency.StartVsRunExample", "Calling run() directly", "Calling start()"),
            example("com.examples.corejava.concurrency.SynchronizedCounterExample", "Synchronized counter: 2000"),
            example("com.examples.corejava.concurrency.ThreadExample", "Runnable running on"),
            example("com.examples.corejava.exceptions.CheckedVsUncheckedExceptionExample", "Checked exception handled", "Unchecked exception handled"),
            example("com.examples.corejava.exceptions.FinalFinallyFinalizeExample", "final variable", "finally block", "finalize is obsolete"),
            example("com.examples.corejava.gc.GarbageCollectionExample", "eligible for GC", "System.gc() is only a request"),
            example("com.examples.corejava.hashing.CustomObjectHashExample", "Lookup custom key", "Multi-step map update result"),
            example("com.examples.corejava.hashing.EqualsHashCodeExample", "Users size with equals/hashCode: 1"),
            example("com.examples.corejava.hashing.HashMapExample", "Contains Ada", "Complement lookup found pair"),
            example("com.examples.corejava.oop.CompositionVsInheritanceExample", "car: engine started"),
            example("com.examples.corejava.oop.EncapsulationExample", "Balance: 100"),
            example("com.examples.corejava.oop.InheritancePolymorphismExample", "Dog says woof", "Cat says meow"),
            example("com.examples.corejava.oop.InterfaceVsAbstractExample", "Paid 25 USD"),
            example("com.examples.corejava.oop.LooseCouplingCohesionExample", "Email to Ada"),
            example("com.examples.corejava.oop.OverloadOverrideExample", "Overloaded int add", "Overridden greet"),
            example("com.examples.corejava.optional.OptionalExample", "Display name: ADA", "Fallback: Guest"),
            example("com.examples.corejava.sorting.ComparableExample", "Comparable by id"),
            example("com.examples.corejava.sorting.ComparableVsComparatorExample", "Natural order by title", "Custom order by year"),
            example("com.examples.corejava.sorting.ComparatorExample", "Sorted by department then age"),
            example("com.examples.corejava.sorting.PrimitiveVsObjectSortingExample", "Primitive ascending", "Boxed descending", "Integer.compare avoids overflow"),
            example("com.examples.corejava.sorting.SortingExamples", "Arrays.sort primitives ascending", "Collections.sort ascending", "Strings by length"),
            example("com.examples.corejava.streams.LambdaExample", "Sorted with lambda", "Sorted with method reference"),
            example("com.examples.corejava.streams.StreamsVsLoopsExample", "Loop result", "Stream result"),
            example("com.examples.corejava.strings.StringBuilderExample", "Built string"),
            example("com.examples.corejava.strings.StringImmutabilityExample", "Original unchanged", "New string")
    );

    @TestFactory
    Stream<DynamicTest> everyExampleMainMethodRunsAndPrintsExpectedStudyOutput() {
        return RUNNABLE_EXAMPLES.stream()
                .map(example -> DynamicTest.dynamicTest(example.className(), () -> {
                    String output = assertDoesNotThrow(() -> invokeMainAndCaptureOutput(example.className()));
                    for (String expectedSnippet : example.expectedSnippets()) {
                        assertTrue(output.contains(expectedSnippet),
                                () -> "Expected output from " + example.className() + " to contain: " + expectedSnippet);
                    }
                }));
    }

    private static ExampleCase example(String className, String... expectedSnippets) {
        return new ExampleCase(className, List.of(expectedSnippets));
    }

    private static String invokeMainAndCaptureOutput(String className) throws Exception {
        Class<?> exampleClass = Class.forName(className);
        Method main = exampleClass.getMethod("main", String[].class);
        PrintStream originalOut = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        try (PrintStream capture = new PrintStream(output, true, StandardCharsets.UTF_8)) {
            System.setOut(capture);
            main.invoke(null, (Object) new String[0]);
        } finally {
            System.setOut(originalOut);
        }

        return output.toString(StandardCharsets.UTF_8);
    }

    private record ExampleCase(String className, List<String> expectedSnippets) {
    }
}
