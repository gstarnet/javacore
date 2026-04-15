package com.example.corejava;

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
            example("com.example.corejava.algorithms.BacktrackingExample", "Valid parentheses"),
            example("com.example.corejava.algorithms.BfsGridExample", "Reachable cells from top-left"),
            example("com.example.corejava.algorithms.BinarySearchExample", "Binary search index: 3"),
            example("com.example.corejava.algorithms.LinearScanExample", "Linear scan index: 1"),
            example("com.example.corejava.algorithms.MergeIntervalsExample", "Merged intervals"),
            example("com.example.corejava.algorithms.NestedLoopsExample", "Pair found"),
            example("com.example.corejava.algorithms.RecursionExample", "Factorial 5: 120"),
            example("com.example.corejava.algorithms.SlidingWindowExample", "Max sum of size 3: 9"),
            example("com.example.corejava.algorithms.TopKFrequentExample", "Top 2 words"),
            example("com.example.corejava.algorithms.TwoSumExample", "Two sum indexes: [0, 1]"),
            example("com.example.corejava.algorithms.ValidParenthesesExample", "{[()]} is valid: true"),
            example("com.example.corejava.collections.ArrayListVsLinkedListExample", "ArrayList fast random access", "LinkedList easy deque operations"),
            example("com.example.corejava.collections.CollectionManipulationExample", "Read by index", "Filtered", "Transformed lengths"),
            example("com.example.corejava.collections.CollectionsOverviewExample", "ArrayList", "HashMap lookup", "PriorityQueue smallest first"),
            example("com.example.corejava.collections.ConcurrentHashMapExample", "ConcurrentHashMap atomic update"),
            example("com.example.corejava.collections.ConversionExample", "List to Set", "Map view keys", "Reversed copy"),
            example("com.example.corejava.collections.FrequencyCountExample", "Frequency count"),
            example("com.example.corejava.collections.GroupingExample", "Grouped by first letter"),
            example("com.example.corejava.collections.ListSetMapComparisonExample", "List allows duplicates", "Set keeps unique values", "Map stores key-value pairs"),
            example("com.example.corejava.collections.MapExamples", "HashMap average O(1) lookup", "LinkedHashMap preserves insertion order", "TreeMap sorts keys"),
            example("com.example.corejava.collections.PriorityQueueExample", "Min heap poll", "Max heap poll"),
            example("com.example.corejava.collections.RemoveDuplicatesExample", "Unique any order", "Unique preserving order"),
            example("com.example.corejava.collections.SafeRemovalExample", "After Iterator.remove", "After removeIf"),
            example("com.example.corejava.collections.SetExamples", "HashSet unique values", "LinkedHashSet insertion order", "TreeSet sorted order"),
            example("com.example.corejava.complexity.ConstantSpaceExample", "Sum: 20"),
            example("com.example.corejava.complexity.ConstantTimeExample", "First name: Ada"),
            example("com.example.corejava.complexity.LinearSpaceExample", "Doubled: [2, 4, 6]"),
            example("com.example.corejava.complexity.LinearTimeExample", "Found 11"),
            example("com.example.corejava.complexity.LogarithmicTimeExample", "Found at index 4"),
            example("com.example.corejava.complexity.NLogNExample", "Sorted scores"),
            example("com.example.corejava.complexity.PermutationExample", "Permutations"),
            example("com.example.corejava.complexity.QuadraticTimeExample", "Ana meets Ana"),
            example("com.example.corejava.complexity.SubsetExample", "Subsets"),
            example("com.example.corejava.concurrency.AtomicMapOperationsExample", "Atomic map operations", "mutating the List value"),
            example("com.example.corejava.concurrency.ConcurrentHashMapExample", "ConcurrentHashMap count: 2"),
            example("com.example.corejava.concurrency.HashMapThreadSafetyExample", "Single-thread get-then-put", "can lose updates"),
            example("com.example.corejava.concurrency.StartVsRunExample", "Calling run() directly", "Calling start()"),
            example("com.example.corejava.concurrency.SynchronizedCounterExample", "Synchronized counter: 2000"),
            example("com.example.corejava.concurrency.ThreadExample", "Runnable running on"),
            example("com.example.corejava.exceptions.CheckedVsUncheckedExceptionExample", "Checked exception handled", "Unchecked exception handled"),
            example("com.example.corejava.exceptions.FinalFinallyFinalizeExample", "final variable", "finally block", "finalize is obsolete"),
            example("com.example.corejava.gc.GarbageCollectionExample", "eligible for GC", "System.gc() is only a request"),
            example("com.example.corejava.hashing.CustomObjectHashExample", "Lookup custom key", "Multi-step map update result"),
            example("com.example.corejava.hashing.EqualsHashCodeExample", "Users size with equals/hashCode: 1"),
            example("com.example.corejava.hashing.HashMapExample", "Contains Ada", "Complement lookup found pair"),
            example("com.example.corejava.oop.CompositionVsInheritanceExample", "car: engine started"),
            example("com.example.corejava.oop.EncapsulationExample", "Balance: 100"),
            example("com.example.corejava.oop.InheritancePolymorphismExample", "Dog says woof", "Cat says meow"),
            example("com.example.corejava.oop.InterfaceVsAbstractExample", "Paid 25 USD"),
            example("com.example.corejava.oop.LooseCouplingCohesionExample", "Email to Ada"),
            example("com.example.corejava.oop.OverloadOverrideExample", "Overloaded int add", "Overridden greet"),
            example("com.example.corejava.optional.OptionalExample", "Display name: ADA", "Fallback: Guest"),
            example("com.example.corejava.sorting.ComparableExample", "Comparable by id"),
            example("com.example.corejava.sorting.ComparableVsComparatorExample", "Natural order by title", "Custom order by year"),
            example("com.example.corejava.sorting.ComparatorExample", "Sorted by department then age"),
            example("com.example.corejava.sorting.PrimitiveVsObjectSortingExample", "Primitive ascending", "Boxed descending", "Integer.compare avoids overflow"),
            example("com.example.corejava.sorting.SortingExamples", "Arrays.sort primitives ascending", "Collections.sort ascending", "Strings by length"),
            example("com.example.corejava.streams.LambdaExample", "Sorted with lambda", "Sorted with method reference"),
            example("com.example.corejava.streams.StreamsVsLoopsExample", "Loop result", "Stream result"),
            example("com.example.corejava.strings.StringBuilderExample", "Built string"),
            example("com.example.corejava.strings.StringImmutabilityExample", "Original unchanged", "New string")
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
